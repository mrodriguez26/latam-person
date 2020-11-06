package com.latam.application.personal.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PoetDTO  implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1668596363872115466L;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("url")
	private String url;
}
