/**
 * 
 */
package dev.codethat.retail.controller;

import static dev.codethat.retail.MyRetailServiceConstants.PATH_VARIABLE_ID;
import static dev.codethat.retail.MyRetailServiceConstants.PRODUCT_PATH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.codethat.retail.bean.ProductRequest;
import dev.codethat.retail.bean.ProductResponse;
import dev.codethat.retail.service.ProductService;

/**
 * @author Bharath
 *
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping(value = PRODUCT_PATH + PATH_VARIABLE_ID, method = RequestMethod.GET)
	public ProductResponse get(@PathVariable String id) {
		ProductRequest request = new ProductRequest();
		request.setId(id);
		return service.get(request);
	}

	@RequestMapping(value = PRODUCT_PATH, method = RequestMethod.PUT)
	public boolean update(@RequestBody ProductRequest request) {
		request.setId(request.getId());
		boolean updated = service.update(request);
		return updated;
	}

}
