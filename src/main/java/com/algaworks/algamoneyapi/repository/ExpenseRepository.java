package com.algaworks.algamoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algamoneyapi.model.Expense;
import com.algaworks.algamoneyapi.repository.expense.ExpenseRepositoryQuery;

public interface ExpenseRepository extends JpaRepository<Expense, Long>, ExpenseRepositoryQuery {

}
