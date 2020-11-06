package com.latam.application.personal.controller;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.latam.application.personal.model.PersonDTO;
import com.latam.application.personal.service.PersonService;
import com.latam.application.personal.controller.PersonsController;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PersonsControllerTest {

	@InjectMocks
	private PersonsController personsController;

	@Mock
	private PersonService personService;

	PersonDTO request;

	@Before
	public void init() {
		request = new PersonDTO();
	}

	@Test
	public void getPerson() {
		PersonsController a = Mockito.mock(PersonsController.class);
		ResponseEntity<PersonDTO> response = personsController.getPerson(Mockito.anyString(), Mockito.anyString(),
				Mockito.anyString());
		Mockito.when(a.getPerson(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(response);
		assertNotNull("Return execution ", response);

	}
}
