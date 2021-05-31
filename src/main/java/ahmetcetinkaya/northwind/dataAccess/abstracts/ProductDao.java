package ahmetcetinkaya.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ahmetcetinkaya.northwind.entities.concretes.Product;
import ahmetcetinkaya.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {
	List<Product> findAllByCategoryIn(List<Integer> categories);

	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> findAllByNameAndCategory(String productName, int categoryId);

	List<Product> findAllByProductNameContains(String productName);

	List<Product> findAllByProductNameOrCategory_CategoryId(String productName, int categoryId);

	List<Product> findAllByProductNameStartsWith(String productName);

	@Query("Select new ahmetcetinkaya.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> findAllProductWithCategoryDetails();

	Product findByProductName(String productName);

	Product findByProductNameAndCategory_CategoryId(String productName, int categoryId);
}
