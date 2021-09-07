package com.bean.aop.controller;


 
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//@SpringBootTest(classes=SpringEmailApplication.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@AutoConfigureMockMvc
//@TestPropertySource(
//		  locations = "classpath:application.properties")
//@ContextConfiguration(classes= {SpringEmailApplication.class,EmailController.class, EmailServiceImpl.class, EmailService.class})
//@SpringBootTest
//@WebMvcTest(EmailController.class)
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes=SpringEmailApplication.class)



/*@RunWith(SpringRunner.class)
@WebMvcTest(EmailController.class)
@TestPropertySource(
locations = "classpath:application.properties")
@SpringBootTest
*/

/*@RunWith(SpringRunner.class)
@ContextConfiguration(classes=SpringEmailApplication.class)
@WebMvcTest(EmailController.class)
@DataJpaTest
*/
//
//@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest(
//		  classes = SpringEmailApplication.class)
//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//@TestPropertySource(
//		  locations = "classpath:application.properties")
public class SpringIntegrationTest2 {

	
	@MockBean
	MockMvc mockMvc;
	
	@Test
	void runIt() {
		
		  MvcResult mvcResult=null; RequestBuilder
		  rqBuilder=MockMvcRequestBuilders.get("/send"); try {
		  
		  mvcResult=mockMvc.perform(rqBuilder).andReturn(); String
		  response=mvcResult.getResponse().getContentAsString();
		  
//		  assertEquals("Successful",response); 
		  } catch (Exception e) {
		  e.printStackTrace(); }
		 
	}
 
	
	    
}