package com.algaworks.algamoneyapi.repository.expense;

import java.util.List;

import com.algaworks.algamoneyapi.model.Expense;
import com.algaworks.algamoneyapi.repository.filter.ExpenseFilter;

public interface ExpenseRepositoryQuery {

	public List<Expense> filter(ExpenseFilter expenseFilter);

}
