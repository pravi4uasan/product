package com.tech;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class ProductApplicationTest {
	@Test
	void contextLoads() {
	}
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	@SneakyThrows
	public void testProductReview() {
		MvcResult result=mvc.perform(
				MockMvcRequestBuilders.get("/product/BB5476")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		int status=result.getResponse().getStatus();
		log.info("testProductReview response code>>"+status);
		assert(200 == status);
	}
	
	@Test
	@SneakyThrows
	public void testProductReview2() {
		MvcResult result=mvc.perform(
				MockMvcRequestBuilders.get("/product/BB54761")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		int status=result.getResponse().getStatus();
		log.info("testProductReview response code>>"+status);
		assert(404 == status);
	}
	

}
