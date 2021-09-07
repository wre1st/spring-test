package com.bean.aop.mock;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bean.aop.SpringEmailApplication;
import com.bean.aop.controller.EmailController;
import com.bean.aop.impl.EmailServiceImpl;
import com.bean.aop.model.Person;
import com.bean.aop.service.EmailService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {SpringEmailApplication.class})
public class SpringMockTest2 {

	@Mock
	EmailService emailService;
	
//	@InjectMocks
//	EmailServiceImpl businessImpl;

	@Autowired
	EmailServiceImpl businessImpl;

	/*
	 * @Autowired Properties properties;
	 * 
	 * @Value("${email}") String email;
	 */
	
 
    
	
	
	@Test
	public void sendingEmail1() {
	 	emailService = mock(EmailService.class);
//		Object obj = when(emailService.sendEmail()).getMock();
	//	System.out.println(obj);
		  businessImpl = new EmailServiceImpl();
		int result = businessImpl.send();
		
		assertEquals(1, result);
	}

	@Autowired
	EmailServiceImpl email;
	
	@Test
	public void sendingEmail2() {
		int j=email.send();
		assertEquals(1, j);
	}

	
	@Autowired
	EmailController controller;
	
	@Test
	public void testingController() {
		assertEquals("Successful", controller.send());
	}
	
	@Test
	public void savePerson() {
		Person p=new Person();
		p.setContact("03132294732");
		p.setEmail("tahirhussain5678@gmail.com");
		p.setId(23);
		p.setName("Rashid");
		
		assertEquals("Successful", controller.send());
	}
	
	@Test
	public void contextTest() {
		
	}
/*	@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		DataService emailService = mock(DataService.class);
		when(emailService.retrieveAllData()).thenReturn(new int[] { 15 });
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(emailService);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(15, result);
	}
*/
}
