package net.jpa.jpademo.repository;

import net.jpa.jpademo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByNameContains(String kw);
    @Query("select p from Product p where p.name like %:mc% and p.price>:p")
    public List<Product> search(@Param("mc") String kw, @Param("p") double price);
}
