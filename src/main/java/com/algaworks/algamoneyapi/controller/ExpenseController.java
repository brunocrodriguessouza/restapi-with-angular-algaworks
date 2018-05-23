package com.algaworks.algamoneyapi.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoneyapi.event.ResourceCreatedEvent;
import com.algaworks.algamoneyapi.exceptionhandler.AlgamoneyExceptionHandler.Error;
import com.algaworks.algamoneyapi.model.Expense;
import com.algaworks.algamoneyapi.repository.ExpenseRepository;
import com.algaworks.algamoneyapi.repository.filter.ExpenseFilter;
import com.algaworks.algamoneyapi.service.ExpenseService;
import com.algaworks.algamoneyapi.service.exception.PeopleNonExistentOrInactiveException;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	private ExpenseService expenseService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private MessageSource messageSource;

	@GetMapping
	public Page<Expense> getAll(ExpenseFilter expenseFilter, Pageable pageable) {
		return expenseRepository.filter(expenseFilter, pageable);
	}

	@GetMapping("/{id}")
	public Expense getById(@PathVariable Long id) {
		return expenseRepository.findOne(id);
	}

	@PostMapping
	public ResponseEntity<Expense> InsertExpense(@Valid @RequestBody Expense expense, HttpServletResponse response) {
		Expense savedExpense = expenseService.save(expense);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedExpense.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedExpense);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		expenseRepository.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Expense> update(@PathVariable Long id, @Valid @RequestBody Expense expense) {
		Expense savedExpense = expenseService.update(id, expense);
		return ResponseEntity.ok(savedExpense);
	}

	@ExceptionHandler({ PeopleNonExistentOrInactiveException.class })
	public ResponseEntity<Object> handlePeopleNonExistentOrInactiveException(PeopleNonExistentOrInactiveException ex) {
		String userMessage = messageSource.getMessage("people.non-existent-or-inactive", null,
				LocaleContextHolder.getLocale());
		String developerMessage = ex.toString();
		List<Error> errors = Arrays.asList(new Error(userMessage, developerMessage));
		return ResponseEntity.badRequest().body(errors);
	}
}
