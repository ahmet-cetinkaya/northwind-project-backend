package ahmetcetinkaya.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.northwind.business.abstracts.ProductService;
import ahmetcetinkaya.northwind.core.utilities.results.DataResult;
import ahmetcetinkaya.northwind.core.utilities.results.Result;
import ahmetcetinkaya.northwind.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.northwind.core.utilities.results.SuccessResult;
import ahmetcetinkaya.northwind.dataAccess.abstracts.ProductDao;
import ahmetcetinkaya.northwind.entities.concretes.Product;
import ahmetcetinkaya.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {
	private final ProductDao productDao;

	@Autowired
	public ProductManager(final ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Result add(final Product product) {
		productDao.save(product);
		return new SuccessResult("Ürün eklendi.");
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(productDao.findAll());
	}

	@Override
	public DataResult<List<Product>> getAll(final int pageNo, final int pageSize) {
		final PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);

		return new SuccessDataResult<List<Product>>(productDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Product>> getAllByCategoryIdIn(final List<Integer> categoryId) {
		return new SuccessDataResult<List<Product>>(productDao.findAllByCategoryIn(categoryId));
	}

	@Override
	public DataResult<List<Product>> getAllByNameAndCategory(final String productName, final int categoryId) {
		return new SuccessDataResult<List<Product>>(productDao.findAllByNameAndCategory(productName, categoryId));
	}

	@Override
	public DataResult<List<Product>> getAllByProductNameContains(final String productName) {
		return new SuccessDataResult<List<Product>>(productDao.findAllByProductNameContains(productName));
	}

	@Override
	public DataResult<List<Product>> getAllByProductNameOrCategoryId(final String productName, final int categoryId) {
		return new SuccessDataResult<List<Product>>(
				productDao.findAllByProductNameOrCategory_CategoryId(productName, categoryId));
	}

	@Override
	public DataResult<List<Product>> getAllByProductNameStartsWith(final String productName) {
		return new SuccessDataResult<List<Product>>(productDao.findAllByProductNameStartsWith(productName));
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getAllProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(productDao.findAllProductWithCategoryDetails());

	}

	@Override
	public DataResult<List<Product>> getAllSorted(final String direction, final String propertyNames) {
		final Sort sort = Sort.by(direction.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
				propertyNames.split(","));
		return new SuccessDataResult<List<Product>>(productDao.findAll(sort));
	}

	@Override
	public DataResult<Product> getByProductName(final String productName) {
		return new SuccessDataResult<Product>(productDao.findByProductName(productName));
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(final String productName, final int categoryId) {
		return new SuccessDataResult<Product>(
				productDao.findByProductNameAndCategory_CategoryId(productName, categoryId));
	}

}
