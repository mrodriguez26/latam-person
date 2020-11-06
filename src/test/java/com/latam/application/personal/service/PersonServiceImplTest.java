package com.latam.application.personal.service;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.latam.application.personal.controller.PersonsController;
import com.latam.application.personal.model.PersonDTO;
import com.latam.application.personal.model.PoemDTO;
import com.latam.application.personal.model.PoetDTO;
import com.latam.application.personal.service.impl.PersonServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PersonServiceImplTest {

	@Mock
	private RestTemplateBuilder restTemplateBuilder;
	
	@Mock
	private ResponseErrorHandler errorHandler;

	@InjectMocks
	private PersonServiceImpl personServiceImpl = new PersonServiceImpl(new RestTemplateBuilder());
	
	@Mock
	private RestTemplate restTemplate;
	
	 @Test
	    public void getPerson() {
		 
		 PoemDTO[] poems = new PoemDTO[2];
		 
		 PoetDTO poet0 = new PoetDTO();
		 PoetDTO poet1 = new PoetDTO();
		 
		 poet0.setName("Pablo Coello");
		 poet0.setUrl("http://www.pablocoello.com");
		 
		 poet0.setName("Mario Puzzo");
		 poet0.setUrl("http://www.mariopuzzo.com");
		 
		 PoemDTO poems0 = new PoemDTO();
		 poems0.setTitle("Love");
		 poems0.setContent("this is content");
		 poems0.setUrl("http://someweb.com");
		 poems0.setPoet(poet0);
		 
		 PoemDTO poems1 = new PoemDTO();
		 poems0.setTitle("Crime");
		 poems0.setContent("content");
		 poems0.setUrl("http://someweb.com");
		 poems0.setPoet(poet1);
		  		
		 poems[0] = poems0;	
		 poems[1] = poems1;
		 
		 PoemDTO poem = new PoemDTO();
		 
		 
		 PersonServiceImpl a = Mockito.mock(PersonServiceImpl.class);
	     PersonDTO response = personServiceImpl.getPerson("marco antonio","rodriguez garcia","01-11-1982");
			Mockito.when(a.getPerson("marco antonio","rodriguez garcia","01-11-1982")).thenReturn(response);
			assertNotNull("Return execution ", response);
	   
	    }
	 
 
	 @Test
	    public void getPersonIsBirthday() {
		 
		 PoemDTO[] poems = new PoemDTO[2];
		 
		 PoetDTO poet0 = new PoetDTO();
		 PoetDTO poet1 = new PoetDTO();
		 
		 poet0.setName("Pablo Coello");
		 poet0.setUrl("http://www.pablocoello.com");
		 
		 poet0.setName("Mario Puzzo");
		 poet0.setUrl("http://www.mariopuzzo.com");
		 
		 PoemDTO poems0 = new PoemDTO();
		 poems0.setTitle("Love");
		 poems0.setContent("this is content");
		 poems0.setUrl("http://someweb.com");
		 poems0.setPoet(poet0);
		 
		 PoemDTO poems1 = new PoemDTO();
		 poems0.setTitle("Crime");
		 poems0.setContent("content");
		 poems0.setUrl("http://someweb.com");
		 poems0.setPoet(poet1);
		  		
		 poems[0] = poems0;	
		 poems[1] = poems1;
		 
		 PoemDTO poem = new PoemDTO();
		 
		 
		 PersonDTO dto = new PersonDTO();
	    // Mockito.when(personServiceImpl.getPerson("marco antonio","rodriguez garcia","05-11-1982")).thenReturn(dto);
	     
		 PersonServiceImpl a = Mockito.mock(PersonServiceImpl.class);
	     PersonDTO response = personServiceImpl.getPerson("marco antonio","rodriguez garcia","06-11-1982");
			Mockito.when(a.getPerson("marco antonio","rodriguez garcia","06-11-1982")).thenReturn(response);
			assertNotNull("Return execution ", response);
	   
	    }
	 
	 
}
