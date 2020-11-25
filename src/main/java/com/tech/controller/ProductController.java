package com.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tech.models.ProductResponseVO;
import com.tech.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping(value = "/product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductResponseVO> getProductDetailsById(@PathVariable(name = "productId") String productId)  {
        log.info("Getting product details");

        try{
        	ProductResponseVO productResponseVO = productService.getProductDetailsById(productId);
            return ResponseEntity.ok().body(productResponseVO);
        }catch(Exception e){
            log.error(e.getMessage());
           
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
