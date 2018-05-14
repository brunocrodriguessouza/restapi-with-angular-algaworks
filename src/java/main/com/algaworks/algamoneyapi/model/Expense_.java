package com.algaworks.algamoneyapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Expense.class)
public abstract class Expense_ {

	public static volatile SingularAttribute<Expense, String> note;
	public static volatile SingularAttribute<Expense, LocalDate> dueDate;
	public static volatile SingularAttribute<Expense, String> description;
	public static volatile SingularAttribute<Expense, Long> id;
	public static volatile SingularAttribute<Expense, LocalDate> paymentDate;
	public static volatile SingularAttribute<Expense, ExpenseType> type;
	public static volatile SingularAttribute<Expense, Category> category;
	public static volatile SingularAttribute<Expense, BigDecimal> value;
	public static volatile SingularAttribute<Expense, People> people;

}

