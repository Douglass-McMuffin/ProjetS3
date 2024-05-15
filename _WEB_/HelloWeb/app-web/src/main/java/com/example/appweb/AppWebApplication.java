// Ref : https://start.spring.io/

/* Commandes :
mvn clean package
docker build -t appweb .
docker run -p 8080:8080 appweb &

docker stop [id]
*/

package com.example.appweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class AppWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppWebApplication.class, args);
	}

}

@Controller
class MyController {
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "Hello, Web!");
		return "index";
	}
}
