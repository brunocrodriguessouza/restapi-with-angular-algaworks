package com.algaworks.algamoneyapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.model.Expense;
import com.algaworks.algamoneyapi.model.People;
import com.algaworks.algamoneyapi.repository.ExpenseRepository;
import com.algaworks.algamoneyapi.repository.PeopleRepository;
import com.algaworks.algamoneyapi.service.exception.PeopleNonExistentOrInactiveException;

@Service
public class ExpenseService {

	@Autowired
	private PeopleRepository peopleRepository;

	@Autowired
	private ExpenseRepository expenseRepository;

	public Expense save(Expense expense) {
		People people = peopleRepository.findOne(expense.getPeople().getId());
		if (people == null || people.isInactive()) {
			throw new PeopleNonExistentOrInactiveException();
		}
		return expenseRepository.save(expense);
	}

	public Expense update(Long id, Expense expense) {
		Expense savedExpense = expenseRepository.findOne(id);
		if (savedExpense == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(expense, savedExpense, "id");
		return expenseRepository.save(savedExpense);
	}

}
