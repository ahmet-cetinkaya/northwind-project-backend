package ahmetcetinkaya.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
