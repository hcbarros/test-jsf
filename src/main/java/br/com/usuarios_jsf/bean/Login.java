package br.com.usuarios_jsf.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.usuarios_jsf.bean.servlet.VerifyRecaptcha;
import br.com.usuarios_jsf.loader.Loader;
import br.com.usuarios_jsf.model.Usuario;
import br.com.usuarios_jsf.service.UsuarioService;


@Named 
@RequestScoped
public class Login {

	@Inject
    private UsuarioService usuarioService;
	
	private Usuario usuario = new Usuario();
	private UIComponent mybutton;
	private ExternalContext externalContext;
	
	@PostConstruct
    public void init() {
		
		List<Usuario> usuarios = usuarioService.list();
    	if(usuarios.isEmpty()) Loader.load(usuarioService);    	
    	
    	externalContext = FacesContext.getCurrentInstance()
    									   .getExternalContext();
    	
    	externalContext.getSessionMap()
    				   .put("usuariologado", null);
    }

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String fazerLogin() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		String gRecaptchaResponse = context.
				getExternalContext().getRequestParameterMap().get("g-recaptcha-response");
		boolean verify = false;
		
		try {
			verify = VerifyRecaptcha.verify(gRecaptchaResponse);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		if(!verify) {
			context.addMessage(mybutton.getClientId(context), 
	                 new FacesMessage("","Selecione o captcha!"));
	        return "usuarioInexistente";
		}
		
		Usuario u = usuarioService.consultarPorEmailESenha(usuario);
		
		if(u != null) {
			
			externalContext.getSessionMap().put("usuariologado", u);
			return "usuarioEncontrado";
		}
		
		context.addMessage(mybutton.getClientId(context), 
                 new FacesMessage("","Login ou senha inválidos!"));
        return "usuarioInexistente";
	}
	
	
	public UIComponent getMybutton() {
        return mybutton;
    }
	
	public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }
	
    
}
