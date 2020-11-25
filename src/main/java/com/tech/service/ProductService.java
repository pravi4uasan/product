package com.tech.service;

import com.tech.models.ProductResponseVO;

public interface ProductService {

	public ProductResponseVO getProductDetailsById(String productId);
}
