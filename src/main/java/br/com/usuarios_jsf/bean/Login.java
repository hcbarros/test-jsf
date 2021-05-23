package br.com.usuarios_jsf.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.usuarios_jsf.model.Telefone;
import br.com.usuarios_jsf.model.Usuario;
import br.com.usuarios_jsf.service.UsuarioService;

@Named 
@RequestScoped
public class Login {

	@Inject
    private UsuarioService usuarioService;
	
	private Usuario usuario = new Usuario();
	private String email = "";
	private String senha = "";
	private UIComponent mybutton;
	
	@PostConstruct
    public void init() {
		List<Usuario> usuarios = usuarioService.list();
    	if(usuarios.size() == 0) carreagarDados();    	
    }

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String fazerLogin() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		List<Usuario> list = usuarioService.consultarPorEmail(usuario);
		
		if(!list.isEmpty() && list.get(0).getSenha().equals(usuario.getSenha())) 
			return "usuarioEncontrado";
		
		context.addMessage(mybutton.getClientId(context), 
                 new FacesMessage("","Login ou senha invalidos!"));
        return "usuarioInexistente";
	}
	
	public UIComponent getMybutton() {
        return mybutton;
    }
	
	public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
        this.email = email;
    }
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
        this.senha = senha;
    }
	
	
	public void carreagarDados() {
    	
		List<Telefone> fones = new ArrayList<>();
    	Telefone t1 = new Telefone(81, "975621486", "celular");
    	Telefone t2 = new Telefone(81, "993845625", "celular");
    	Telefone t3 = new Telefone(81, "23758461", "fixo");
    	fones.addAll(Arrays.asList(t1,t2,t3));
    	
		Usuario u1 = new Usuario("Rosa Alexandrino", "rosaalexandrino@gmail.com", "hBuxA23", fones);
		t1.setUsuario(u1);
		t2.setUsuario(u1);
		t3.setUsuario(u1);
		
		usuarioService.persistir(u1);
		
//___________________________________________________________________________________________________________		
		
		
		Telefone t4 = new Telefone(81, "984756321", "celular");
    	Telefone t5 = new Telefone(81, "975624215", "celular");
    	Telefone t6 = new Telefone(81, "31025645", "fixo");
    	fones.clear();
    	fones.addAll(Arrays.asList(t4,t5,t6));
    	
		Usuario u2 = new Usuario("Igor Moraes", "igormoraes@gmail.com", "LbyI20", fones);
		t4.setUsuario(u2);
		t5.setUsuario(u2);
		t6.setUsuario(u2);
		
		usuarioService.persistir(u2);
		
//_______________________________________________________________________________________________________________
		
		
		Telefone t7 = new Telefone(81, "987097010", "celular");
    	Telefone t8 = new Telefone(81, "978542618", "celular");
    	Telefone t9 = new Telefone(81, "21023655", "fixo");
    	fones.clear();
    	fones.addAll(Arrays.asList(t7,t8,t9));
    	
		Usuario u3 = new Usuario("Joana Mendonça", "joanamendonca@gmail.com", "aopHMXX9", fones);
		t7.setUsuario(u3);
		t8.setUsuario(u3);
		t9.setUsuario(u3);	
		
		usuarioService.persistir(u3);
		
//_____________________________________________________________________________________________________________
		
		
		Telefone t10 = new Telefone(87, "996457243", "celular");
    	Telefone t11 = new Telefone(87, "30152642", "fixo");
    	fones.clear();
    	fones.addAll(Arrays.asList(t10,t11));
    	
		Usuario u4 = new Usuario("Mario Jorge", "mariojorge@outlook.com", "2pKbVjpe", fones);
		t10.setUsuario(u4);
		t11.setUsuario(u4);
		
		usuarioService.persistir(u4);
		
//__________________________________________________________________________________________________________
		
		
		Telefone t12 = new Telefone(87, "996457215", "celular");
    	Telefone t13 = new Telefone(87, "30152642", "fixo");
    	fones.clear();
    	fones.addAll(Arrays.asList(t12,t13));
    	
		Usuario u5 = new Usuario("Maicon Rodrigues", "maiconrodrigues@bol.com.br", "MYJZf8gQ", fones);
		t12.setUsuario(u5);
		t13.setUsuario(u5);
		
		usuarioService.persistir(u5);
		
//__________________________________________________________________________________________________________
		
		
		Telefone t14 = new Telefone(81, "985641324", "celular");
    	Telefone t15 = new Telefone(81, "32025215", "fixo");
    	fones.clear();
    	fones.addAll(Arrays.asList(t14,t15));
    	
		Usuario u6 = new Usuario("Joice Santos", "joicesantos@hotmail.com", "oB6LE1eF", fones);
		t14.setUsuario(u6);
		t15.setUsuario(u6);
		
		usuarioService.persistir(u6);
		
//__________________________________________________________________________________________________________
		
		
		Telefone t16 = new Telefone(81, "99648122", "celular");
    	fones.clear();
    	fones.add(t16);
    	
		Usuario u7 = new Usuario("Maria Aparecida", "mariaaparecida@live.com", "oPpP2rZN", fones);
		t16.setUsuario(u7);
		
		usuarioService.persistir(u7);
		
//__________________________________________________________________________________________________________	
		
		
		Usuario u8 = new Usuario("Fernando Bezerra", "fernandotads@uol.com.br", "j8NsFXNS", null);		
		usuarioService.persistir(u8);
		
//__________________________________________________________________________________________________________				
		
		
		Usuario u9 = new Usuario("Alana Arruda", "alanaarruda@yahoo.com.br", "u5mrl9KL", null);		
		usuarioService.persistir(u9);
		
//__________________________________________________________________________________________________________
		
		
		Usuario u10 = new Usuario("Marcos Lima", "marcoslima@yahoo.com", "hdm1IwmZ", null);		
		usuarioService.persistir(u10);
		
//__________________________________________________________________________________________________________
		
	
		Usuario u11 = new Usuario("Igor Ribas", "igorribas@live.com", "gHaiID", null);		
		usuarioService.persistir(u11);
		
//__________________________________________________________________________________________________________
		
		
		Usuario u12 = new Usuario("Cássia Batista", "cassiabatista@uol.com.br", "PmLLNS", null);		
		usuarioService.persistir(u12);
		
//__________________________________________________________________________________________________________
		
		
		Usuario u13 = new Usuario("Gustavo Garcia", "gustavogarcia@yahoo.com.br", "NamSDN", null);		
		usuarioService.persistir(u13);
		
//__________________________________________________________________________________________________________	
		
		
		Usuario u14 = new Usuario("Bruno Machado", "brunomachado@yahoo.com", "Uiab90", null);		
		usuarioService.persistir(u14);
		
//__________________________________________________________________________________________________________				
		
		
		Usuario u15 = new Usuario("Marcos Medeiros", "marcosmedeiros@yahoo.com.br", "A976snsj", null);		
		usuarioService.persistir(u15);
		
//__________________________________________________________________________________________________________				
		
		
		Usuario u16 = new Usuario("Nayara Pinheiro", "nayarapinheiro@yahoo.com", "654JhG", null);		
		usuarioService.persistir(u16);
		
//__________________________________________________________________________________________________________					
	
		
	}
    
}
