package br.com.usuarios_jsf.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-05-24T23:37:03.674-0300")
@StaticMetamodel(Telefone.class)
public class Telefone_ {
	public static volatile SingularAttribute<Telefone, Long> id;
	public static volatile SingularAttribute<Telefone, Integer> ddd;
	public static volatile SingularAttribute<Telefone, String> numero;
	public static volatile SingularAttribute<Telefone, String> tipo;
	public static volatile SingularAttribute<Telefone, Usuario> usuario;
}
