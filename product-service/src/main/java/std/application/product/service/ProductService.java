package std.application.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import std.application.product.dto.ProductRequest;
import std.application.product.dto.ProductResponse;
import std.application.product.model.Product;
import std.application.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;

	public List<ProductResponse> getAllProducts() {
		List<Product> products = productRepository.findAll();

		return products.stream().map(product -> mapToProductResponse(product)).collect(Collectors.toList());
	}

	public ProductResponse getProductById(final String id) {
		final Product product = productRepository.findById(id).orElseThrow();

		return mapToProductResponse(product);
	}

	public void createProduct(ProductRequest productRequest) {
		Product product = Product.builder().name(productRequest.getName()).description(productRequest.getDescription())
				.price(productRequest.getPrice()).build();

		productRepository.save(product);
		log.info("Product {} is saved", product.getId());
	}

	public void createProducts(List<ProductRequest> productRequests) {
		List<Product> products = productRequests.stream()
				.map(productRequest -> Product.builder().name(productRequest.getName())
						.description(productRequest.getDescription()).price(productRequest.getPrice()).build())
				.collect(Collectors.toList());

		productRepository.saveAll(products);
	}

	private ProductResponse mapToProductResponse(final Product product) {
		return ProductResponse.builder().id(product.getId()).name(product.getName())
				.description(product.getDescription()).price(product.getPrice()).build();
	}
}
