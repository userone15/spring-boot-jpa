package application.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class ProductSpecLlist implements Specification<Product> {

	Product filter;
	
	ProductSpecLlist(Product filter){
		this.filter=filter;
	}
	
	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		List<Predicate> criteria = new ArrayList<Predicate>();
		
		if (filter.getProduct() != null) {
			criteria.add(cb.equal(root.get("product"), filter.getProduct()));
		}
		
		if (filter.getImageurl() != null) {
			criteria.add(cb.equal(root.get("imageurl"), filter.getImageurl()));
		}
		
		if (filter.getPrice() != null) {
			criteria.add(cb.equal(root.get("price"), filter.getPrice()));
		}
		
		Predicate pred = null;

		if (criteria.size() == 1) {
			pred = criteria.get(0);
		} else if (criteria.size() > 1) {
			pred = cb.and(criteria.toArray(new Predicate[0]));
		}
		return pred;
	}

}
