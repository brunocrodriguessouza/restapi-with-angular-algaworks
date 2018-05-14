package com.algaworks.algamoneyapi.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(People.class)
public abstract class People_ {

	public static volatile SingularAttribute<People, Address> address;
	public static volatile SingularAttribute<People, String> name;
	public static volatile SingularAttribute<People, Boolean> active;
	public static volatile SingularAttribute<People, Long> id;

}

