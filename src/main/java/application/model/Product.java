/**
 * 
 */
package application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author SENTHILKUMAR S
 *
 */
@XmlRootElement(name = "product")
@Entity
@Table(name = "product")
@JsonPropertyOrder({"id", "product", "imageurl", "price"})
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
	@XmlElement
	private int id;
	
	@XmlElement
	@Column(name = "product")
	private String product;
	
	@XmlElement
	@Column(name = "imageurl")
	private String imageurl;
	
	@XmlElement
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
