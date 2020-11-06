package com.latam.application.personal.service.impl;

import com.latam.application.personal.RestErrorHandler;
import com.latam.application.personal.controller.PersonsController;

import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.latam.application.personal.model.PersonDTO;
import com.latam.application.personal.model.PoemDTO;

import com.latam.application.personal.service.PersonService;
import com.latam.application.personal.util.Util;
import org.springframework.web.util.UriComponentsBuilder;

import static org.slf4j.LoggerFactory.getLogger;


@Service
public class PersonServiceImpl implements PersonService {

	// Logger
	private static final Logger logger = getLogger(PersonsController.class);
	private static final String POEMSEPATH = "https://www.poemist.com/api/v1/randompoems";

	private RestTemplate restTemplate;

	@Autowired
	public PersonServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.errorHandler(new RestErrorHandler()).build();
	}

	@Override
	public PersonDTO getPerson(String name, String lastName, String birthday) {
		// TODO Auto-generated method stub

		PoemDTO[] poems = null;
		PoemDTO poem = null;
		
		String poemContent = "";
		int age = 0;
		long daysToBirthday = 0;
		Boolean isBirthday = false;
		String firstName = name.split(" ")[0];
		String firstlastName = lastName.split(" ")[0];

		age = Util.getAge(birthday);
		isBirthday = Util.isBirthday(birthday);
		daysToBirthday = Util.getDaysToBirthday(birthday);

		if (isBirthday) {
			try {
				poems = getPoems();
				poem = new PoemDTO();

				poem = poems[Util.getRandom()];
				poemContent = poem.getContent();
			} catch (ArrayIndexOutOfBoundsException e) {

				logger.error("error", e);
			}
		}

		PersonDTO personDTO = new PersonDTO();
		personDTO.setName(firstName);
		personDTO.setLastName(firstlastName);
		personDTO.setBirthday(Util.strToDate(birthday, "dd-MM-yyyy"));
		personDTO.setIsBirthday(isBirthday);
		personDTO.setDaysTobirthday(daysToBirthday);
		personDTO.setAge(age);
		personDTO.setPoem(poemContent);

		return personDTO;
	}

	@Override
	public PoemDTO[] getPoems() {
		PoemDTO[] poems = null;

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(POEMSEPATH);
		poems = restTemplate.getForObject(builder.toUriString(), PoemDTO[].class);

		return poems;
	}

}
