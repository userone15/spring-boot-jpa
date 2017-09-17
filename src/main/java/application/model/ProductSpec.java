package application.model;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class ProductSpec implements Specification<Product> {

	private Product filter;

	public ProductSpec(Product filter) {
		super();
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		Predicate p = cb.disjunction();

		if (filter.getProduct() != null) {
			p.getExpressions().add(cb.equal(root.get("product"), filter.getProduct()));
		}
		
		if (filter.getImageurl() != null) {
			p.getExpressions().add(cb.equal(root.get("imageurl"), filter.getImageurl()));
		}
		
		if (filter.getPrice() != null) {
			p.getExpressions().add(cb.equal(root.get("price"), filter.getPrice()));
		}
			
		return p;
	}

}
