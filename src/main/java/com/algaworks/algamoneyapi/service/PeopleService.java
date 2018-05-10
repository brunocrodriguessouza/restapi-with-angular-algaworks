package com.algaworks.algamoneyapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.model.People;
import com.algaworks.algamoneyapi.repository.PeopleRepository;

@Service
public class PeopleService {

	@Autowired
	private PeopleRepository peopleRepository;

	public People update(Long id, People people) {
		People savedPeople = peopleRepository.findOne(id);
		if (savedPeople == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(people, savedPeople, "id");
		return peopleRepository.save(savedPeople);
	}

}
