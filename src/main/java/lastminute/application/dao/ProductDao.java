package lastminute.application.dao;

import lastminute.application.costants.ProductType;

public class ProductDao {

	boolean useTax = false;
	
	String type;
	int quantity = 1;
	String description;
	double price;
	boolean imported = false;

	public void setUseTax(boolean useTax) {
		this.useTax = useTax;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public boolean getUseTax(){
		return useTax;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isImported() {
		return imported;
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}	
	
}
