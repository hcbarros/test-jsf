package br.com.usuarios_jsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.usuarios_jsf.model.Telefone;
import br.com.usuarios_jsf.model.Usuario;
import br.com.usuarios_jsf.service.UsuarioService;

@Named 
@RequestScoped
public class Update {

	private static Usuario usuario = new Usuario();
	private static List<Telefone> telefones = new ArrayList<>();
	private UIComponent mybutton;
	
    @Inject
    private UsuarioService usuarioService;
    
    
    public Usuario getUsuario() {
    	return usuario;
    }
  
    public List<Telefone> getTelefones() {
    	return telefones;
    }
    
    public void setTelefones(List<Telefone> telefones) {
    	this.telefones = telefones;
    }
    
    public UIComponent getMybutton() {
        return mybutton;
    }
	
	public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }
    
    public void setValues(Usuario usuario) {
    	this.usuario = usuario;
    	this.telefones = usuario.getTelefones();
    }
    
    public void excluirNumero(Telefone t) {
    	telefones.remove(t);
    }
    
    public String editar() {
    	
    	FacesContext context = FacesContext.getCurrentInstance();
    	
    	Usuario u = usuarioService.getUsuario(usuario.getId());
    		
    	if(!u.getEmail().equals(usuario.getEmail())) {
    			
    		u = usuarioService.consultarPorEmail(usuario);
    		
    		if(u != null) {
    			context.addMessage(mybutton.getClientId(context), 
    	                 new FacesMessage("","O email informado já existe!"));
    	        return "emailExistente";
    		}
    	}
    	
    	usuario.setTelefones(telefones);
    	
    	usuarioService.atualizar(usuario);
    	
    	return "atualizado";
    }
    
}
