
package br.com.usuarios_jsf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NamedQueries(
        {
            @NamedQuery(
                    name = "Usuario.RecuperarPorEmailESenha",
                    query = "SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha"
            )
        }
)

@Entity
@Access(AccessType.FIELD)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;

	@NotNull(message = "O nome não deve ser nulo!")
	@NotBlank(message = "O nome não deve estar em branco!")
	@Size(max = 100, message = "O nome deve possuir no máximo 100 caracteres!")
	private String nome;
	
	private String email;
	
	private String senha;
	
	@OneToMany(mappedBy = "usuario", 
            cascade = CascadeType.ALL, 
            fetch=FetchType.EAGER, orphanRemoval = true)
    private List<Telefone> telefones;
	
	
	public Usuario() {
		this.telefones = new ArrayList<>();
	}

	public Usuario(String nome, String email, String senha, List<Telefone> telefones) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefones = telefones;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	
}
