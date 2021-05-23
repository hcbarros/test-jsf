package br.com.usuarios_jsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.usuarios_jsf.model.Telefone;
import br.com.usuarios_jsf.model.Usuario;
import br.com.usuarios_jsf.service.TelefoneService;
import br.com.usuarios_jsf.service.UsuarioService;

import javax.inject.Inject;

@Named 
@RequestScoped
public class UserBean {
	
	private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;
    private String find = "";
    
    private List<Telefone> telefones;
    
    @Inject
    private UsuarioService usuarioService;
   
    
    @PostConstruct
    public void init() {
    	usuarios = usuarioService.list();
    	if(usuarios.size() == 0) load();
    	usuarios = usuarioService.list();
    	
        telefones = usuarios.get(0).getTelefones();
    }
    
    public void submit() {
        usuarioService.persistir(usuario);
        usuarios = usuarioService.list();
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public List<Telefone> getTelefones() {
        return telefones;
    }
    
    public String getFind() {
    	return find;
    }
    
    public void load() {
    	
    	Telefone telefone = new Telefone(81, "958455215", "celular");
    	List<Telefone> tel = new ArrayList<>();
    	tel.add(telefone);
		Usuario u = new Usuario("dasdas", "dasda@dadsa.com", "sendasha", tel);
		telefone.setUsuario(u);
		
		usuarioService.persistir(u);
	}

}
