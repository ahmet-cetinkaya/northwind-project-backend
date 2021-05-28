package ahmetcetinkaya.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ahmetcetinkaya.northwind.business.abstracts.ProductService;
import ahmetcetinkaya.northwind.core.utilities.results.DataResult;
import ahmetcetinkaya.northwind.core.utilities.results.Result;
import ahmetcetinkaya.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	private final ProductService productService;

	@Autowired
	public ProductsController(final ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody final Product product) {
		return productService.add(product);
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {
		return productService.getAll();
	}

	@GetMapping("/getallbypage")
	public DataResult<List<Product>> getAll(@RequestParam final int pageNo, @RequestParam final int pageSize) {
		return productService.getAll(pageNo, pageSize);
	}

	@GetMapping("/getallbyproductnamecontains")
	public DataResult<List<Product>> getAllByProductNameContains(@RequestParam final String productName) {
		return productService.getAllByProductNameContains(productName);
	}

	@GetMapping("/getallsorted")
	public DataResult<List<Product>> getAllSorted(@RequestParam final String direction,
			@RequestParam final String propertyNames) {
		return productService.getAllSorted(direction, propertyNames);
	}

	@GetMapping("/getbyproductname")
	public DataResult<Product> getByProductName(@RequestParam final String productName) {
		return productService.getByProductName(productName);
	}

	@GetMapping("/getbyproductnameandcategoryid")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam final String productName,
			@RequestParam final int categoryId) {
		return productService.getByProductNameAndCategoryId(productName, categoryId);
	}

}
