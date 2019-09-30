package com.example.BookStore;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.BookStore.domain.Book;
import com.example.BookStore.domain.BookReposity;
import com.example.BookStore.domain.Category;
import com.example.BookStore.domain.CategoryRepository;
import com.example.BookStore.domain.User;
import com.example.BookStore.domain.UserRepository;

import ch.qos.logback.classic.Logger;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger Log = (Logger) LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstore(BookReposity repository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
// Your code...add some demo data to db
			Log.info("save books");
			categoryRepository.save(new Category("IT"));
			categoryRepository.save(new Category("Business"));
			categoryRepository.save(new Category("Law"));
			
			repository.save(new Book("Raamattu", "Jeesus", "100", "1234567", "100.00", categoryRepository.findByName("IT").get(0)));
			repository.save(new Book("Raamattu", "Jeesus", "100", "1234567", "100.00", categoryRepository.findByName("IT").get(0)));
		
			userRepository.save(new User("user", "$2a$10$8/sQok/tDJ68jVAG.NeSBuEavvLgp52f50DOA1GgdVxi28VRl8Tda", "USER"));
			userRepository.save(new User("admin", "$2a$10$du9ny05nJLv3D2b8pKfAke4Y9tqvyLoITYzOW.Ln2MaqgBiLdA17S", "ADMIN"));
		};
	}
}