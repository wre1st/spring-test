package com.bean.aop.mock;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bean.aop.impl.EmailServiceImpl;
import com.bean.aop.model.Person;
import com.bean.aop.repository.EmailRepository;
import com.bean.aop.service.EmailService;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringUnitTest2 {

    @Before
    public void setUp( ) {
    	
        Person person = new Person();
        person.setName("Tahir");
        Mockito.when(emailRepository.findByName(person.getName()))
          .thenReturn(person);
    
    } 

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
 
        @Bean
        public EmailService employeeService() {
            return new EmailServiceImpl();
        }
    }
 
    
    @Autowired
    private EmailService emailService;

    @MockBean
    private EmailRepository emailRepository;
    
    
    @Test
    public void test1() {
    	int i=emailService.send();
    	assertEquals(1,i);
    }
    
}