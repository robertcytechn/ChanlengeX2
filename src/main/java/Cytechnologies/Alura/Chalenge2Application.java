package Cytechnologies.Alura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Chalenge2Application implements CommandLineRunner{
	@Autowired
	JdbcTemplate JdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(Chalenge2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT * FROM test";
        List<Map<String, Object>> rows = JdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            System.out.println(row);
        }
	}

}
