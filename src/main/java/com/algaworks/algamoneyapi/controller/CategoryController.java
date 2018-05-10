package com.algaworks.algamoneyapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoneyapi.event.ResourceCreatedEvent;
import com.algaworks.algamoneyapi.model.Category;
import com.algaworks.algamoneyapi.repository.CategoryRepository;
import com.algaworks.algamoneyapi.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@GetMapping("/{id}")
	public Category getById(@PathVariable Long id) {
		return categoryRepository.findOne(id);
	}

	@PostMapping
	public ResponseEntity<Category> insertCategory(@Valid @RequestBody Category category,
			HttpServletResponse response) {
		Category savedCategory = categoryRepository.save(category);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedCategory.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		categoryRepository.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> update(@PathVariable Long id, @Valid @RequestBody Category category) {
		Category savedCategory = categoryService.update(id, category);
		return ResponseEntity.ok(savedCategory);
	}
}
