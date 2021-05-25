package ahmetcetinkaya.northwind.business.abstracts;

import java.util.List;

import ahmetcetinkaya.northwind.core.utilities.results.DataResult;
import ahmetcetinkaya.northwind.entities.concretes.Product;

public interface ProductService {

	DataResult<List<Product>> getAll();
}
