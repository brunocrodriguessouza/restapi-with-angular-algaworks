package com.algaworks.algamoneyapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.model.Expense;
import com.algaworks.algamoneyapi.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

	public Expense update(Long id, Expense expense) {
		Expense savedExpense = expenseRepository.findOne(id);
		if (savedExpense == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(expense, savedExpense, "id");
		return expenseRepository.save(savedExpense);
	}
}
