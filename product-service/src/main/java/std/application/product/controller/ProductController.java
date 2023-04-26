package std.application.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import std.application.product.dto.ProductRequest;
import std.application.product.dto.ProductResponse;
import std.application.product.service.ProductService;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductResponse getProduct(@PathVariable final String id) {
		return productService.getProductById(id);
	}

	@PostMapping(value = "/multiple")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProducts(@RequestBody List<ProductRequest> products) {

		productService.createProducts(products);

	}

	@PostMapping(value = "/")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductRequest product) {

		productService.createProduct(product);

	}
}
