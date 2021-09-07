package com.bean.aop.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bean.aop.model.Person;
import com.bean.aop.repository.EmailRepository;
import com.bean.aop.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

//	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	Properties properties;

	@Autowired
	EmailRepository emailRepository;

	@Override
	public Integer sendEmail() {
		Integer i = 0;
		System.out.println(properties.containsKey("email"));
		System.out.println(properties.getProperty("email") + "\n" + properties.getProperty("to.email") + " "
				+ properties.getProperty("subject") + " " + properties.getProperty("body"));
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(properties.getProperty("email"), properties.getProperty("to.email"));
			msg.setSubject(properties.getProperty("subject"));
			msg.setText(properties.getProperty("body"));
			javaMailSender.send(msg);
			i = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Value("${email}")
	String email;

	@Value("${to.email}")
	String toEmail;

	@Value("${subject}")
	String subject;

	@Value("${body}")
	String body;

	@Override
	public Integer send() {
		Integer i = 0;
//		System.out.println(properties.containsKey("email"));
//		System.out.println(properties.getProperty("email")+"\n"+properties.getProperty("to.email")+" "+properties.getProperty("subject")+" "+properties.getProperty("body"));
		 // Get the default Session object.

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(properties.get("email"));
	    
		Session session = Session.getDefaultInstance(properties);

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(email));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

	         // Set Subject: header field
	         message.setSubject(subject);

	         // Now set the actual message
	         message.setText(body);

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      i=1;
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	      
		
		return i;
	
	}

//	@Override
//	public void update(Person person) {
//		emailRepository.update(person);
//	}

	@Override
	public List<Person> findAll() {
		return emailRepository.findAll();
	}

	@Override
	public List<Person> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Person> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Person> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Person> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Person> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Person getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getById(Integer id) {
		return emailRepository.getById(id);
	}

	@Override
	public <S extends Person> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Person> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Person> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Person> S save(S entity) {
		return emailRepository.save(entity);
	}

	@Override
	public Optional<Person> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Person entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Person> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Person> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Person> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Person> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Person> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Person findByName(String name) {
		return emailRepository.findByName(name);
	}

}
