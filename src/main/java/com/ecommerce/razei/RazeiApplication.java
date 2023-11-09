package com.ecommerce.razei;

import com.ecommerce.razei.models.Product;
import com.ecommerce.razei.models.RazeiUser;
import com.ecommerce.razei.services.ProductService;
import com.ecommerce.razei.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class RazeiApplication {
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(RazeiApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProductService productService, UserService userService) {

		return (args) -> {

			RazeiUser razeiUserOne = new RazeiUser("lmaestre", "lmaestre@gmail.com", passwordEncoder.encode("1234"));

			Product cadena = new Product( "DIAMANTE", "CL-001", 8, 1, "CADENA", "Material: oro chino");
			Product anillo = new Product( "CORONA", "AAJ-001", 5, 1, "ANILLO", "Material: oro chino");
			Product pulsera = new Product( "DIAMANTE DORADO", "PA-001", 6, 70, "PULSERA", "Material: oro chino");
			Product zarcillo = new Product( "BLING", "AA-001", 3, 10, "ZARCILLO", "Material: oro chino");
			Product tobillera = new Product( "STARLINE", "TS-001", 3.5, 1,"TOBILLERA",  "Material: acero");
			Product gancho = new Product( "MEREDITH", "G-001", 2.5, 10, "GANCHOS", "Color dorado con perlas");

			productService.saveProduct(cadena);
			productService.saveProduct(anillo);
			productService.saveProduct(pulsera);
			productService.saveProduct(zarcillo);
			productService.saveProduct(tobillera);
			productService.saveProduct(gancho);

			userService.saveUser(razeiUserOne);

		};

	}
}
