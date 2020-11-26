package com.tech.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data

public class ProductResponseVO {

	private String id;
	private String model_number;
	private String name;
	private String product_type;
	private boolean recommendationsEnabled;

	private String productId;
	private Double avgReviewScore;
	private int numberOfReviews;

	@JsonProperty("meta_data")
	private MetaData metaData;

	@JsonProperty("product_description")
	private ProductDescription productDescription;

	@JsonProperty("pricing_information")
	private PricingInformation pricingInformation;

}
