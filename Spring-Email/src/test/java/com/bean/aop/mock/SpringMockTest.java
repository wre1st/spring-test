package com.bean.aop.mock;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.bean.aop.SpringEmailApplication;
import com.bean.aop.impl.EmailServiceImpl;
import com.bean.aop.service.EmailService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {SpringEmailApplication.class})
public class SpringMockTest {

	@Mock
	EmailService emailService;
	
	@InjectMocks
	EmailServiceImpl businessImpl;

	@Test
	public void contextTest() {
		
	}
	
	@Test
	public void testFindTheGreatestFromAllData() {
		emailService = mock(EmailService.class);
//		Object obj = when(emailService.sendEmail()).getMock();
	//	System.out.println(obj);
		  businessImpl = new EmailServiceImpl();
		int result = businessImpl.sendEmail();
		assertEquals("Successful", result);
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
