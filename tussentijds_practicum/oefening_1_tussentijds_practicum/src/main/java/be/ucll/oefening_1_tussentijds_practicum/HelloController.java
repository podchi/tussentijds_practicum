package be.ucll.oefening_1_tussentijds_practicum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@SpringBootApplication
@RestController
public class HelloController {

	public static void main(String[] args) {
		SpringApplication.run(HelloController.class, args);
	}


	@GetMapping("/hello")
	public String sayHello(
			@RequestParam(required = false) String name,
			@RequestParam(required = false, defaultValue = "en") String language) {
		if (name == null) {
			return "Hello World!";
		} else {
			if (language.equals("nl")) {
				return "Dag " + name + "!";
			} else {
				return "Hello " + name + "!";
			}
		}
	}

}
