package com.latam.application.personal.controller;

import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.latam.application.personal.model.PersonDTO;
import com.latam.application.personal.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/person")
public class PersonsController {

	// Logger
	private static final Logger logger = getLogger(PersonsController.class);

	/**
	 * Constructor for PersonsController
	 * 
	 */
	@Autowired
	public PersonsController() {
		// Do nothing because of X and Y.
	}

	@Autowired
	private PersonService personService;

	/**
	 * Get method that get person information
	 * 
	 * @param name
	 *            unique
	 * @param lastName
	 *            unique
	 * @param birthday
	 *            unique
	 * @return PersonDTO
	 * 
	 */
	@GetMapping("/{name}/{lastName}/{birthday}")
	public ResponseEntity<PersonDTO> getPerson(@PathVariable("name") String name,
			@PathVariable("lastName") String lastName, @PathVariable("birthday") String birthday) {
		logger.debug("Entering method 'getPerson'");
		return new ResponseEntity<>(personService.getPerson(HtmlUtils.htmlEscape(name), HtmlUtils.htmlEscape(lastName),
				HtmlUtils.htmlEscape(birthday)), HttpStatus.OK);
	}
}
