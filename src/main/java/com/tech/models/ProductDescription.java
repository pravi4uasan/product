package com.tech.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDescription {
	
	private String title;
	private String subtitle;
	private String text;

}
