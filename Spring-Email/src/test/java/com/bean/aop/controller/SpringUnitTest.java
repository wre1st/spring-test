package com.bean.aop.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.bean.aop.service.EmailService;

//@WebMvcTest(EmailController.class)
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes= {SpringEmailApplication.class})
//@TestPropertySource(
//		  locations = "classpath:application.properties")
@RunWith(SpringRunner.class)
@WebMvcTest(EmailController.class)
//@ContextConfiguration(locations = {"classpath:application.properties" })
@TestPropertySource(
locations = "classpath:application.properties")
public class SpringUnitTest {

	@MockBean
	EmailService emailService;

	@MockBean
	EmailController emailController;

	@Test
	public void unitTest() {
		String response=emailController.send();
		assertEquals("Successful", response);
	}

}
