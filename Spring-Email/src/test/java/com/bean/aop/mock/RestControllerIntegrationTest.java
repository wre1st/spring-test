package com.bean.aop.mock;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.bean.aop.SpringEmailApplication;
import com.bean.aop.repository.EmailRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.MOCK,
  classes = SpringEmailApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application.properties")
public class RestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    Properties properties;
    
    @Test
    public void test() {
//    	mockMvc.perform( get("/send").contentType(MediaType.ALL)).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.ALL))
    	String i="";
    	try {
    		
    		
		MvcResult result=	mockMvc.perform(get("/send")
				      .contentType(MediaType.ALL)).andReturn();
		 i=result.getResponse().getContentAsString();
		
		
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	assertEquals("Successful",i);
    
    }
    // write test cases here


    @Test
    public void setUp() {
    	InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void test2() {
//    	mockMvc.perform( get("/send").contentType(MediaType.ALL)).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.ALL))
    	String i="";
    	try {
    		
    		
		MvcResult result=	mockMvc.perform(get("/sendEmail")
				      .contentType(MediaType.ALL)).andReturn();
		 i=result.getResponse().getContentAsString();
		
		
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	assertEquals("Successful",i);
    
    }
}