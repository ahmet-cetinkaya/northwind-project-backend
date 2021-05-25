package ahmetcetinkaya.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;

	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "units_in_stock")
	private short unitsInStock;

	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;

	public Product() {
	}

	public Product(final int id, final int categoryId, final String productName, final double unitPrice,
			final short unitsInStock, final String quantityPerUnit) {
		this.id = id;
		this.categoryId = categoryId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.quantityPerUnit = quantityPerUnit;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public int getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public short getUnitsInStock() {
		return unitsInStock;
	}

	public void setCategoryId(final int categoryId) {
		this.categoryId = categoryId;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setProductName(final String productName) {
		this.productName = productName;
	}

	public void setQuantityPerUnit(final String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public void setUnitPrice(final double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setUnitsInStock(final short unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
}