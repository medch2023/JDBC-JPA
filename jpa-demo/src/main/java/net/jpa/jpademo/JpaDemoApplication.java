package net.jpa.jpademo;

import net.jpa.jpademo.entities.Product;
import net.jpa.jpademo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	//ingection des dependence ingecte moi dans cette variable un objet dune classe qui impplemete cette interface ProductRepository
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null,"hp",8000,32));
		productRepository.save(new Product(null,"dell",9000,32));
		productRepository.save(new Product(null,"mac",10000,32));
		productRepository.save(new Product(null,"lenovo",10000,32));


		/**List<Product> products = productRepository.findAll();
		products.forEach(p->{
			System.out.println(p.getName());
			System.out.println(p.getPrice());
			System.out.println(p.getQuantity());
			System.out.println("*******************");
		});**/

		List<Product> products = productRepository.findByNameContains("m");
		products.forEach(p->{
			System.out.println(p.getName());
			System.out.println(p.getPrice());
			System.out.println(p.getQuantity());
			System.out.println("*******************");
		});

	}
}
