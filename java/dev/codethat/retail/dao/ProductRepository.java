/**
 * 
 */
package dev.codethat.retail.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.codethat.retail.bean.Product;

/**
 * @author Bharath
 *
 */
public interface ProductRepository extends CrudRepository<Product, String> {
	
	@SuppressWarnings("unchecked")
	Product save(Product product);

	Optional<Product> findById(String primaryKey);
	
}
