package com.bean.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.aop.model.Person;

@Repository
public interface EmailRepository  extends JpaRepository<Person, Integer> {

	Person findByName(String name);
//	void insert(Person person);
//	void update(Person person);
}