package application.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import application.model.Product;
import application.model.ProductSpec;
import application.repository.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(method = RequestMethod.POST, 
			        produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			        consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			        headers = {"content-type=application/json","content-type=application/xml"})
	@ApiOperation(value = "Create Product Service", notes = "Creates a product. SLA:500")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Product created Successfully"),
			@ApiResponse(code = 400, message = "Invalid Input Provided"),
			@ApiResponse(code = 404, message = "Error") })
	public ResponseEntity<?> createProduct(@RequestBody Product product){
		Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Product created successfully");
	    response.put("product", productRepository.save(product));
	    return ResponseEntity.ok(response);
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
	
	@RequestMapping(method = RequestMethod.POST, value = "/getProductByCriteria")
	  public Map<String, Object> getProductByCriteria(@RequestBody Product product){
		LOG.info("Application is invoked!");
	    Product result = productRepository.findAll(new ProductSpec(product));
	    Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("product", result);
	    return response;
	  }
	
	@RequestMapping(method = RequestMethod.POST, value = "/getAllProductByCriteria")
	  public Map<String, Object> getAllProductByCriteria(@RequestBody Product product){
		LOG.info("Application is invoked!");
	    List<Product> result = productRepository.findAll(new ProductSpec(product), new org.springframework.data.domain.Sort(Direction.ASC, "id"));
	    Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("product", result);
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