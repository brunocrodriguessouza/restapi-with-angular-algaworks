package com.algaworks.algamoneyapi.repository.expense;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.algamoneyapi.model.Expense;
import com.algaworks.algamoneyapi.repository.filter.ExpenseFilter;

public interface ExpenseRepositoryQuery {

	public Page<Expense> filter(ExpenseFilter expenseFilter, Pageable pageable);

}
