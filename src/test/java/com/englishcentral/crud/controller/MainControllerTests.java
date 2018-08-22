package com.englishcentral.crud.controller;

import com.englishcentral.crud.CrudApplication;
import com.englishcentral.crud.model.Product;
import com.englishcentral.crud.payload.ProductRequest;
import com.englishcentral.crud.repository.ProductRepository;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrudApplication.class,
	webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MainControllerTests {
	@Autowired
	private ProductRepository productRepository;

	private static final String API_ROOT
		= "http://localhost:8888/api/products";

	private ProductRequest createRandomProductRequest() {
		ProductRequest request = new ProductRequest();
		request.setName(RandomStringUtils.randomAlphabetic(10));
		request.setDescription(RandomStringUtils.randomAlphanumeric(20));
		request.setPrice(Math.random());
		return request;
	}

	private Long createProductId() {
		Product product = new Product();
		product.setName(RandomStringUtils.randomAlphabetic(10));
		product.setDescription(RandomStringUtils.randomAlphanumeric(20));
		product.setPrice(Math.random());
		Product result = productRepository.save(product);
		return result.getId();
	}

	@Test
	public void whenCreateProduct_ThenCreated() {
		ProductRequest request = createRandomProductRequest();
		RestAssured.given()
			.body(request).header("Content-Type", "application/json")
			.when().post(API_ROOT)
			.then().assertThat().statusCode(201);
	}

	@Test
	public void whenGetProducts_ThenOK() {
		RestAssured.get(API_ROOT)
				.then().assertThat().statusCode(200);
	}

	@Test
	public void whenGetProductByID_ThenOK() {
		RestAssured.get(API_ROOT + "/" + createProductId())
				.then().assertThat().statusCode(200);
	}

	@Test
	public void whenUpdateProduct_ThenOK() {
		ProductRequest request = createRandomProductRequest();
		RestAssured.given()
			.body(request).header("Content-Type", "application/json")
			.when().put(API_ROOT + "/" + createProductId())
			.then().assertThat().statusCode(200);
	}

	@Test
	public void whenDeleteProduct_ThenOK() {
		RestAssured.given()
			.when().delete(API_ROOT + "/" + createProductId())
			.then().assertThat().statusCode(200);
	}
}
