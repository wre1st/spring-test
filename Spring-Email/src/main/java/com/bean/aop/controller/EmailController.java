package com.bean.aop.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.aop.model.Person;
import com.bean.aop.proxy.PersonJ;
import com.bean.aop.service.EmailService;


@RestController
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@Value("${email}")
	String email;

	@Value("${to.email}")
	String toEmail;


	@Value("${subject}")
	String subject;

	@Value("${body}")
	String body;
	
	@Value("${contact}")
	String contact;
	
	@Value("${name}")
	String name;

	@Value("${id}")
	String id;

	
	@RequestMapping("/send")
	public String send() {
		String response="Unsuccessful";
		System.out.println(id);
		int i=emailService.send();
		Person person=new Person();
		person.setContact(contact);
		person.setEmail( email);
		person.setName(name);
		person.setId(Integer.parseInt(id));
//		emailService.save(person);
		System.out.println(person);
		emailService.save(person);
		if(i>0)
			response="Successful";
		
		return response;
	}


	
	@RequestMapping("/sendEmail")
	public String sendEmail() {
		String response="Unsuccessful";
		System.out.println(id);
		int i=emailService.sendEmail();
		Person person=new Person();
		person.setContact(contact);
		person.setEmail( email);
		person.setName(name);
		person.setId(Integer.parseInt(id));
//		emailService.save(person);
		System.out.println(person);
		emailService.save(person);
		if(i>0)
			response="Successful";
		
		return response;
	}
}