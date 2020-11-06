package com.latam.application.personal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PoemDTO  implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2069816604615058066L;
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("content")
	private String content;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("poet")
	private PoetDTO poet;

}
