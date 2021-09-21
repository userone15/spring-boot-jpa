package application.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Product;

/**
 * @author SENTHILKUMAR S
 *
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findAll(Specification<Product> carSpec);
	
	List<Product> findAll(Specification<Product> car, Sort dir);
}
