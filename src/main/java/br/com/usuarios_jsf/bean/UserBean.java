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
	
    private List<Usuario> usuarios;
    
    @Inject
    private UsuarioService usuarioService;
   
    
    @PostConstruct
    public void init() {
    	usuarios = usuarioService.list();
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public void excluir(Usuario u) {
    	usuarioService.remover(u);
    	usuarios = usuarioService.list();
    }
    
    public String sair() {
    	
    	return "";
    }
    
}
