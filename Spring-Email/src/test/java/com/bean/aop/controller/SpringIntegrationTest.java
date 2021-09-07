package com.bean.aop.controller;
 

import org.junit.jupiter.api.Test;
 
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

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
 
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//@TestPropertySource(
//		  locations = "classpath:application.properties")
public class SpringIntegrationTest {

	
	
	@Test
	void runIt() {
		/*
		 * MvcResult mvcResult=null; RequestBuilder
		 * rqBuilder=MockMvcRequestBuilders.get("/send"); try {
		 * 
		 * mvcResult=mockMvc.perform(rqBuilder).andReturn(); String
		 * response=mvcResult.getResponse().getContentAsString();
		 * 
		 * assertEquals("Successful",response); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
	}
 
	    @LocalServerPort
	    private int port;

	    TestRestTemplate restTemplate = new TestRestTemplate();

	    HttpHeaders headers = new HttpHeaders();
	    @Test
	    public void testCreateStudent() throws Exception {
	    	
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

	        ResponseEntity<String> response = restTemplate.exchange(
	          createURLWithPort("/send"), HttpMethod.GET, entity, String.class);

	        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

//	        assertTrue(actual.contains("/send"));
	    }    

	    @Test
	    public void testRetrieveStudent() throws Exception {
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

	        ResponseEntity<String> response = restTemplate.exchange(
	          createURLWithPort("/students/1"), HttpMethod.GET, entity, String.class);

	        String expected = "{\"id\":1,\"name\":\"Rajesh Bhojwani\",\"description\":\"Class 10\"}";

	        JSONAssert.assertEquals(expected, response.getBody(), false);
	    }

	    private String createURLWithPort(String uri) {
	        return "http://localhost:" + 8084 + uri;
	    }
	    
}