package ahmetcetinkaya.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
