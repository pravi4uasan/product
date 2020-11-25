package com.tech.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tech.models.ProductDetailsVO;
import com.tech.models.ProductResponseVO;
import com.tech.models.ReviewResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductServiceImpl implements ProductService{
	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.review.url}")
	private String reviewURL;

	@Value("${api.adidas.url}")
	private String adidasURL;



	public ProductResponseVO getProductDetailsById(String productId) {
		log.info("START getProductDetailsById");
		log.info("START getProductDetailsById adidasURL >>"+adidasURL);
		ProductResponseVO productResponseVO=new ProductResponseVO();
		ReviewResponse reviewResponse=new ReviewResponse();
		ProductDetailsVO productDetailsVO=new ProductDetailsVO();

		try {

			reviewResponse=restTemplate.getForObject(reviewURL+productId, ReviewResponse.class);


			log.info("reviewResponse>>"+reviewResponse);
			if(null!=reviewResponse) {
				productResponseVO.setId(reviewResponse.getProductId());
				productResponseVO.setProductId(reviewResponse.getProductId());
				productResponseVO.setNumberOfReviews(reviewResponse.getNumberOfReviews());
				productResponseVO.setAvgReviewScore(reviewResponse.getAvgReviewScore());
			}

			productDetailsVO=restTemplate.getForObject(adidasURL+productId, ProductDetailsVO.class);
			log.info("productDetailsVO >>"+productDetailsVO);
			if(null!=productDetailsVO) {
				productResponseVO.setModel_number(productDetailsVO.getModel_number()); 
				productResponseVO.setName(productDetailsVO.getName());
				productResponseVO.setProduct_type(productDetailsVO.getProduct_type());
				productResponseVO.setRecommendationsEnabled(productDetailsVO.isRecommendationsEnabled());
			}
		}catch(Exception e) {
			log.error("Error while service api call :", e);
		}



		log.info("END getProductDetailsById");
		return productResponseVO;
	}



}
