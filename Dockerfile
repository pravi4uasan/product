FROM java:8

EXPOSE 8090

ADD target/product-0.0.1-SNAPSHOT.jar product.jar

ENTRYPOINT ["java ","jar","product.jar"]