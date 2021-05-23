package br.com.usuarios_jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.usuarios_jsf.model.Telefone;
import br.com.usuarios_jsf.model.Usuario;
import br.com.usuarios_jsf.service.UsuarioService;

@Named 
@RequestScoped
public class Update {

	private static Usuario usuario;
	private static String email;
	private static List<Telefone> telefones;
	private UIComponent mybutton;
	
    @Inject
    private UsuarioService usuarioService;
    
   
    public Usuario getUsuario() {
    	return usuario;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public List<Telefone> getTelefones() {
    	return telefones;
    }
    
    public UIComponent getMybutton() {
        return mybutton;
    }
	
	public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }
    
    public void setValues(Usuario usuario) {
    	this.usuario = usuario;
    	telefones = usuario.getTelefones();
    	email = usuario.getEmail();
    }
    
    public void excluirNumero(Telefone t) {
    	telefones.remove(t);
    }
    
    public String editar() {
    	
    	usuario.setTelefones(telefones);
    	
    	return "";
    }
    
}
