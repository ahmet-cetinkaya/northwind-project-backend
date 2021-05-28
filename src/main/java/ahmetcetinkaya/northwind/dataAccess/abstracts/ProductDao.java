package ahmetcetinkaya.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ahmetcetinkaya.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	List<Product> findAllByCategoryIn(List<Integer> categories);

	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> findAllByNameAndCategory(String productName, int categoryId);

	List<Product> findAllByProductNameContains(String productName);

	List<Product> findAllByProductNameOrCategory_CategoryId(String productName, int categoryId);

	List<Product> findAllByProductNameStartsWith(String productName);

	Product findByProductName(String productName);

	Product findByProductNameAndCategory_CategoryId(String productName, int categoryId);
}
