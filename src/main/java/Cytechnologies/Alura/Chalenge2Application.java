package Cytechnologies.Alura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Cytechnologies.Principal.Principal;

@SpringBootApplication
public class Chalenge2Application implements CommandLineRunner{
	private static final String URL_BASE_API = "http://gutendex.com/books/";
	
	public static void main(String[] args) {
		SpringApplication.run(Chalenge2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(URL_BASE_API);
	}

}
