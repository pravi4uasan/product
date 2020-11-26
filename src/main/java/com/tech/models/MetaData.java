package com.tech.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetaData {
	
	private String canonical;
	private String description;
	private String keywords;
	private String page_title;
	private String site_name;

}
