package ahmetcetinkaya.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.northwind.business.abstracts.ProductService;
import ahmetcetinkaya.northwind.dataAccess.abstracts.ProductDao;
import ahmetcetinkaya.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {
	private final ProductDao productDao;

	@Autowired
	public ProductManager(final ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(productDao.findAll(), "Data Listelendi.");
	}

}
