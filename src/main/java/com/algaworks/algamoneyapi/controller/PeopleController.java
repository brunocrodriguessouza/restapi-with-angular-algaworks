package com.algaworks.algamoneyapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoneyapi.event.ResourceCreatedEvent;
import com.algaworks.algamoneyapi.model.People;
import com.algaworks.algamoneyapi.repository.PeopleRepository;

@RestController
@RequestMapping("/people")
public class PeopleController {

	@Autowired
	private PeopleRepository peopleRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<People> getAll() {
		return peopleRepository.findAll();
	}

	@GetMapping("/{id}")
	public People getById(@PathVariable Long id) {
		return peopleRepository.findOne(id);
	}

	@PostMapping
	public ResponseEntity<People> InsertPeople(@Valid @RequestBody People people, HttpServletResponse response) {
		People savedPeople = peopleRepository.save(people);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedPeople.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPeople);
	}
}
