package br.com.usuarios_jsf.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;

import br.com.usuarios_jsf.model.Telefone;

@Stateless
@ValidateOnExecution(type = ExecutableType.ALL)
public class TelefoneService {

	@PersistenceContext
    private EntityManager entityManager;
	
	
	public Telefone atualizar(@Valid Telefone telefone) {
		 Telefone u = entityManager.merge(telefone);
         entityManager.flush();
         return telefone;
    }
	
	
	public void persistir(@Valid Telefone telefone) {
         entityManager.persist(telefone);
    }
	
	
	public void remover(@Valid Telefone telefone){
		telefone = entityManager.merge(telefone);
            entityManager.remove(telefone);
            entityManager.flush();
    }
	
	public List<Telefone> list() {
        return entityManager
            .createQuery("SELECT t FROM Telefone t", Telefone.class)
            .getResultList();
    }

}


