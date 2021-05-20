package br.com.usuarios_jsf.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_TELEFONE")
@Access(AccessType.FIELD)
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	private Integer ddd;
	
	@Pattern(regexp = "[0-9]")
	@Size(min = 8, max = 9, message = "O telefone deve possuir 8 ou 9 números!")
	private String numero;
	
	@NotNull(message = "O tipo de telefone não deve ser nulo!")
	@NotBlank(message = "O tipo de telefone não deve estar em branco!")
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
    private Usuario usuario;
	
	
	public Telefone() {
		
	}

	public Telefone(Integer ddd, String numero, String tipo, Usuario usuario) {
		
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
		this.usuario = usuario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getDdd() {
		return ddd;
	}


	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
