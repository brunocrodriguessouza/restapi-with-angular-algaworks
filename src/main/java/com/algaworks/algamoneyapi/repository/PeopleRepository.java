package com.algaworks.algamoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algamoneyapi.model.People;

public interface PeopleRepository extends JpaRepository<People, Long>{

}
