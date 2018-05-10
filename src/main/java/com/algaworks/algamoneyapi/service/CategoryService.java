package com.algaworks.algamoneyapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.model.Category;
import com.algaworks.algamoneyapi.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public Category update(Long id, Category category) {
		Category savedCategory = categoryRepository.findOne(id);
		if (savedCategory == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(category, savedCategory, "id");
		return categoryRepository.save(savedCategory);
	}

}
