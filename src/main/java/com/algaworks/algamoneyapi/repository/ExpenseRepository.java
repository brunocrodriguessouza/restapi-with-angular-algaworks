package com.algaworks.algamoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algamoneyapi.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
