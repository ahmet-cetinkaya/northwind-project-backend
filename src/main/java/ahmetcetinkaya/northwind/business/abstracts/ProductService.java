package ahmetcetinkaya.northwind.business.abstracts;

import java.util.List;

import ahmetcetinkaya.northwind.entities.concretes.Product;

public interface ProductService {
	List<Product> getAll();

}
