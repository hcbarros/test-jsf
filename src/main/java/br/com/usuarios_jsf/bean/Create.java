package br.com.usuarios_jsf.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.usuarios_jsf.model.Telefone;
import br.com.usuarios_jsf.model.Usuario;
import br.com.usuarios_jsf.service.UsuarioService;

@Named 
@ApplicationScoped
public class Create {

	private Usuario usuario;
	private List<Telefone> telefones;
	private String ddd;
	private String numero;
	private String tipo;
	private FacesContext context = FacesContext.getCurrentInstance();
	private UIComponent mybutton;
	
    @Inject
    private UsuarioService usuarioService;
    
    
    public void init() {
    	usuario = new Usuario();
    	telefones = new ArrayList<>();
    	ddd = "";
    	numero = "";
    	tipo = "";
    }
    
    public Usuario getUsuario() {
    	return usuario;
    }
  
    public List<Telefone> getTelefones() {
    	return telefones;
    }
    
    public void setTelefones(List<Telefone> telefones) {
    	this.telefones = telefones;
    }
    
    public String getDdd() {
    	return ddd;
    }
    
    public void setDdd(String ddd) {
    	this.ddd = ddd;
    }
    
    public String getNumero() {
    	return numero;
    }
    
    public void setNumero(String numero) {
    	this.numero = numero;
    }
    
    public String getTipo() {
    	return tipo;
    }
    
    public void setTipo(String tipo) {
    	this.tipo = tipo;
    }
    
    public UIComponent getMybutton() {
        return mybutton;
    }
	
	public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }
    
	
	public void addTelefone() {
		
		if(ddd == null || ddd.length() < 2 ) {
			PrimeFaces.current().executeScript("alert('O DDD deve ser um numero de 2 dígitos!')");
			return;
		}
		
		if(numero == null || numero.length() < 8 )  {
			PrimeFaces.current().executeScript("alert('O telefone deve ser um número de 8 ou 9 dígitos!')");
			return;
		}
		
		telefones.add(new Telefone(Integer.parseInt(ddd), numero, tipo));
		
		ddd = "";
		numero = "";
		tipo = "";
	}
 
	
	public void excluirTelefone(Telefone t) {
		telefones.remove(t);
	}
	
    public String criar() {
    	
    	Usuario u = usuarioService.consultarPorEmail(usuario);

    	if(u != null) {
    		context.addMessage(mybutton.getClientId(context), 
    	            new FacesMessage("","O email informado já existe!"));
    	    return "emailExistente";
    	}
    	
    	usuario.setTelefones(telefones);
    	
    	for(Telefone t: telefones) {
    		t.setUsuario(usuario);
    	}
    	
    	usuarioService.persistir(usuario);;
    	
    	return "criado";
    }
    
}
