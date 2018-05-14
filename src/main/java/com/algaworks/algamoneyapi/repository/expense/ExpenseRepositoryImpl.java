package com.algaworks.algamoneyapi.repository.expense;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.algaworks.algamoneyapi.model.Expense;
import com.algaworks.algamoneyapi.repository.filter.ExpenseFilter;

public class ExpenseRepositoryImpl implements ExpenseRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Expense> filter(ExpenseFilter expenseFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Expense> criteria = builder.createQuery(Expense.class);
		Root<Expense> root = criteria.from(Expense.class);

		Predicate[] predicates = createRestrictions(expenseFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Expense> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] createRestrictions(ExpenseFilter expenseFilter, CriteriaBuilder builder, Root<Expense> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(expenseFilter.getDescription())) {
			predicates.add(builder.like(builder.lower(root.get("description")),
					"%" + expenseFilter.getDescription().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(expenseFilter.getDueDateFrom())) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("dueDate"), expenseFilter.getDueDateFrom()));
		}

		if (!StringUtils.isEmpty(expenseFilter.getDueDateUntil())) {
			predicates.add(builder.lessThanOrEqualTo(root.get("dueDate"), expenseFilter.getDueDateUntil()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
