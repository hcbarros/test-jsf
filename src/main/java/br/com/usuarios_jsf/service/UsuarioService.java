package br.com.usuarios_jsf.service;

import javax.ejb.Stateless;
import javax.validation.executable.ValidateOnExecution;

import br.com.usuarios_jsf.model.Usuario;

import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static javax.persistence.PersistenceContextType.TRANSACTION;

import java.util.List;


@Stateless(name = "ejb/UsuarioService")
@ValidateOnExecution(type = ExecutableType.ALL)
public class UsuarioService {

	@PersistenceContext
    private EntityManager entityManager;
	
	
	public void atualizar(@Valid Usuario usuario) {
         entityManager.merge(usuario);
         entityManager.flush();
    }
	
	
	public void persistir(@Valid Usuario usuario) {
         entityManager.persist(usuario);
    }
	
	
	public void remover(@Valid Usuario usuario){
		 usuario = entityManager.merge(usuario);
            entityManager.remove(usuario);
            entityManager.flush();
    }

	public List<Usuario> list() {
        return entityManager
            .createQuery("SELECT u FROM Usuario u", Usuario.class)
            .getResultList();
    }

}


