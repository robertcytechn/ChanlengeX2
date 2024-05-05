package Cytechnologies.Alura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chalenge2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Chalenge2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
	}

}
