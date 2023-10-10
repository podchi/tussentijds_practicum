package be.ucll.oefening_2_tussentijds_practicum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "be.ucll.oefening_2_tussentijds_practicum")
public class FilmApplication {

	public static void main(String[] args) {

		SpringApplication.run(FilmApplication.class, args);

	}

}
