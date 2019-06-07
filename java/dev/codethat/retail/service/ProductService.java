/**
 * 
 */
package dev.codethat.retail.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.codethat.retail.adapter.RedSkyServiceAdapter;
import dev.codethat.retail.bean.Product;
import dev.codethat.retail.bean.ProductRequest;
import dev.codethat.retail.bean.ProductResponse;
import dev.codethat.retail.bean.RedSkyProductResponse;
import dev.codethat.retail.dao.ProductRepository;

/**
 * @author Bharath
 *
 */
@Service
public class ProductService implements ServiceI<ProductRequest, ProductResponse> {

	@Autowired
	private RedSkyServiceAdapter serviceAdapter;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductResponse get(ProductRequest request) {
		ProductResponse response = new ProductResponse();
		response.setId(request.getId());
		// get name
		RedSkyProductResponse redSkyProductResponse = serviceAdapter.get(request.getId());
		// set name
		if (redSkyProductResponse != null)
			response.setName(redSkyProductResponse.getName());
		// get price
		Optional<Product> product = productRepository.findById(request.getId());
		// set price
		if (product.isPresent())
			response.setCurrentPrice(product.get().getCurrentPrice());
		return response;
	}

	@Override
	public boolean update(ProductRequest request) {
		Product product = new Product();
		product.setId(request.getId());
		product.setCurrentPrice(request.getCurrentPrice());
		productRepository.save(product);
		return true;
	}

}
