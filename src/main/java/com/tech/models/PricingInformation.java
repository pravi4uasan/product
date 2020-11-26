package com.tech.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PricingInformation {
	
	private Double standard_price;
	private Double sale_price;
	private Double standard_price_no_vat;
	private Double sale_price_no_vat;
	private String discount_text;
	private Double currentPrice;
	

}
