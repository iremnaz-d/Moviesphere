package starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"starter"})
public class MoviesphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesphereApplication.class, args);
	}

}
