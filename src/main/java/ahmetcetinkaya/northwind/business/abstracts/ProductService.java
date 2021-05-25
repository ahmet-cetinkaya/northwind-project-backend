package ahmetcetinkaya.northwind.business.abstracts;

import java.util.List;

import ahmetcetinkaya.northwind.core.utilities.results.DataResult;
import ahmetcetinkaya.northwind.core.utilities.results.Result;
import ahmetcetinkaya.northwind.entities.concretes.Product;

public interface ProductService {
	Result add(Product product);

	DataResult<List<Product>> getAll();
}
