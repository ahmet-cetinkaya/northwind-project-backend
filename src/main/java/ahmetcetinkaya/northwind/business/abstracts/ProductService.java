package ahmetcetinkaya.northwind.business.abstracts;

import java.util.List;

import ahmetcetinkaya.northwind.core.utilities.results.DataResult;
import ahmetcetinkaya.northwind.core.utilities.results.Result;
import ahmetcetinkaya.northwind.entities.concretes.Product;

public interface ProductService {
	Result add(Product product);

	DataResult<List<Product>> getAll();

	DataResult<List<Product>> getAll(int pageNo, int pageSize);

	DataResult<List<Product>> getAllByCategoryIdIn(List<Integer> categoryId);

	DataResult<List<Product>> getAllByNameAndCategory(String productName, int categoryId);

	DataResult<List<Product>> getAllByProductNameContains(String productName);

	DataResult<List<Product>> getAllByProductNameOrCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getAllByProductNameStartsWith(String productName);

	DataResult<List<Product>> getAllSorted(String direction, String propertyNames);

	DataResult<Product> getByProductName(String productName);

	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
}
