package std.application.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import std.application.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
