package com.tech.models;

import lombok.Data;

@Data
public class ProductDetailsVO {
   private String id;
   private String model_number;
   private String name;
   private String product_type;
   private boolean recommendationsEnabled;
}
