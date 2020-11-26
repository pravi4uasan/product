package com.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tech.models.ProductDetailsVO;
import com.tech.models.ProductResponseVO;
import com.tech.models.ReviewResponse;

import lombok.extern.slf4j.Slf4j;

@Service
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
		try {

			reviewResponse=restTemplate.getForObject(reviewURL+productId, ReviewResponse.class);


			log.info("reviewResponse>>"+reviewResponse);
			if(null!=reviewResponse) {
				productResponseVO.setId(reviewResponse.getProductId());
				productResponseVO.setProductId(reviewResponse.getProductId());
				productResponseVO.setNumberOfReviews(reviewResponse.getNumberOfReviews());
				productResponseVO.setAvgReviewScore(reviewResponse.getAvgReviewScore());
			}

			//productDetailsVO=restTemplate.getForObject("http://www.adidas.co.uk/api/products/BB5476", ProductDetailsVO.class);
			RestTemplate restTemplateAdidas=new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:83.0) Gecko/20100101");
			HttpEntity entity = new HttpEntity(headers);
			ResponseEntity<ProductDetailsVO> response = restTemplateAdidas.exchange(
					adidasURL+productId, HttpMethod.GET, entity, ProductDetailsVO.class);
			
			log.info("response.getStatusCode() >>"+response.getStatusCode());
			log.info("body >>"+response.getBody());
			
			
			//log.info("productDetailsVO >>"+productDetailsVO);
			if(HttpStatus.OK.equals(response.getStatusCode()) && null!=response.getBody()) {
				productResponseVO.setModel_number(response.getBody().getModel_number()); 
				productResponseVO.setName(response.getBody().getName());
				productResponseVO.setProduct_type(response.getBody().getProduct_type());
				productResponseVO.setRecommendationsEnabled(response.getBody().isRecommendationsEnabled());
				
				productResponseVO.setMetaData(response.getBody().getMetaData());
				productResponseVO.setProductDescription(response.getBody().getProductDescription());
				productResponseVO.setPricingInformation(response.getBody().getPricingInformation());
				
			}
		}catch(Exception e) {
			log.error("Error while service api call :", e);
		}



		log.info("END getProductDetailsById");
		return productResponseVO;
	}



}
