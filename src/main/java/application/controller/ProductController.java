package application.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import application.model.Product;
import application.repository.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createProduct(@RequestBody Map<String, Object> productMap){
		Product product = new Product((Integer)productMap.get("id"), 
				productMap.get("product").toString(),
				productMap.get("imageurl").toString(),
				productMap.get("price").toString());
	    
	    Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Product created successfully");
	    response.put("book", productRepository.save(product));
	    return response;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	  public Map<String, Object> getAllProducts(){
		LOG.info("Application is invoked!");
	    List<Product> products = productRepository.findAll();
	    Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("totalProducts", products.size());
	    response.put("products", products);
	    return response;
	  }
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{productId}")
	  public Map<String, String> deleteProduct(@PathVariable("productId") Integer productId){
		productRepository.delete(productId);
	    Map<String, String> response = new HashMap<String, String>();
	    response.put("message", "Product deleted successfully");
	    return response;
	  }
}