package com.bean.aop.repository;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.bean.aop.model.Person;

@RunWith(SpringRunner.class)
@DataJpaTest
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class EmailRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmailRepository employeeRepository;

    
    @Test
    public void test1() {
    	
    	Person person=new Person();
    	person.setName("Ali Ahmed");
    	entityManager.persist(person);
    	entityManager.flush();
    
    	Person person2=employeeRepository.findByName("Ali Ahmed");
    	assertEquals(person2.getName(),person);
    }

}