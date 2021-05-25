package br.com.usuarios_jsf.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.usuarios_jsf.model.Usuario;
import br.com.usuarios_jsf.service.UsuarioService;

import javax.inject.Inject;

@Named 
@RequestScoped
public class UserBean {
	
    
	private List<Usuario> usuarios;
    
    @Inject
    private UsuarioService usuarioService;
    
    private ExternalContext externalContext;
    
    
    @PostConstruct
    public void init() {
    	
    	externalContext = FacesContext.getCurrentInstance()
				   					  		.getExternalContext();
    	verificarUsuario();
    	
    	usuarios = usuarioService.list();
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public void excluir(Usuario u) {
    	usuarioService.remover(u);
    	usuarios = usuarioService.list();
    }
    
    public void verificarUsuario() {
    	
    	Object u = externalContext.getSessionMap().get("usuariologado");
    	if(u == null) redirect();
    }
    
    public void sair() {
    	externalContext.getSessionMap().put("usuariologado", null);
    	externalContext.invalidateSession();
    	redirect();
    }
    
    public void redirect() {
    	try {
			externalContext.redirect("/login.xhtml");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
    }
    
}
