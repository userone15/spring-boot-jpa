/**
 * 
 */
package application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author SENTHILKUMAR S
 *
 */
@Entity
@Table(name = "product")
public class Product {
	
	public Product(){
		
	}
	
	public Product(Integer id, String product, String imageurl, String price) {
		this.id = id;
		this.product = product;
		this.imageurl = imageurl;
		this.price = price;
	}

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "product")
	private String product;
	
	@Column(name = "imageurl")
	private String imageurl;
	
	@Column(name = "price")
	private String price;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
