package br.com.usuarios_jsf.service;

import javax.ejb.Stateless;
import javax.validation.executable.ValidateOnExecution;

import br.com.usuarios_jsf.model.Telefone;
import br.com.usuarios_jsf.model.Usuario;

import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import static javax.persistence.PersistenceContextType.TRANSACTION;

import java.util.List;


@Stateless
@ValidateOnExecution(type = ExecutableType.ALL)
public class UsuarioService {

	@PersistenceContext
    private EntityManager entityManager;
	
	
	public Usuario atualizar(@Valid Usuario usuario) {
         Usuario u = entityManager.merge(usuario);
         entityManager.flush();
         return u;
    }
	
	
	public void persistir(@Valid Usuario usuario) {
         entityManager.persist(usuario);
    }
	
	public List<Usuario> consultarPorEmail(Usuario u) {
		TypedQuery<Usuario> query
        			= entityManager.createNamedQuery(
        					"Usuario.RecuperarPorEmail", Usuario.class);
					query.setParameter("email", u.getEmail());
					query.setParameter("senha", u.getSenha());
		return query.getResultList();
	}
	
	
	public void remover(@Valid Usuario usuario){
		 usuario = entityManager.merge(usuario);
            entityManager.remove(usuario);
            entityManager.flush();
    }
	
	public Usuario getUsuario(Long id) {
		return entityManager.find(Usuario.class, id);
	}
	
	public List<Usuario> list() {
        return entityManager
            .createQuery("SELECT u FROM Usuario u", Usuario.class)
            .getResultList();
    }

}


