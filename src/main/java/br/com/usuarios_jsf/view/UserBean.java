package br.com.usuarios_jsf.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.usuarios_jsf.model.Usuario;
import br.com.usuarios_jsf.service.UsuarioService;

import javax.inject.Inject;

@Named 
@RequestScoped
public class UserBean {
	
	private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;

    @Inject
    private UsuarioService service;
    
    @PostConstruct
    public void init() {
        usuarios = service.list();
    }
    
    public void submit() {
        service.persistir(usuario);
        usuarios = service.list();
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

}
