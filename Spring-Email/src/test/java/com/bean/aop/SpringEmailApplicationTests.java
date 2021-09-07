package com.bean.aop;

//import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
//@TestPropertySource(
//		  locations = "classpath:application.properties")
//@ContextConfiguration(classes= {SpringEmailApplication.class,EmailController.class, EmailServiceImpl.class, EmailService.class})
@SpringBootTest
class SpringEmailApplicationTests {

 
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void contextLoads() {
		MvcResult mvcResult=null;
		RequestBuilder rqBuilder=MockMvcRequestBuilders.get("/send");
		try {
			mvcResult=mockMvc.perform(rqBuilder).andReturn();
			String response=mvcResult.getResponse().getContentAsString();
			
//					assertEquals("Successful",response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void test() {
		
	}
 
}
