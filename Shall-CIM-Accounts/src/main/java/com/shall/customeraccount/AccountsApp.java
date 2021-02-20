package com.shall.customeraccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.shall.customeraccount.model.Customer;
import com.shall.customeraccount.service.GenericService;

@SpringBootApplication
public class AccountsApp implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger("JCG");

	// @Autowired
	// private CustomerService service;

	@Autowired
	private GenericService<Customer, Long> customerService;

	public static void main(String[] args) {
		SpringApplication.run(AccountsApp.class, args);
	}

	@Override
	public void run(String... strings) {

		//Customer person = customerService
		//		.save(new Customer(1L, "Mohamed", "El-Shall", "mohamed.s.elshall2011@gmail.com", "dubai"));
		//LOG.info("Customer created in DB : {}", person);
		//person.setFirstName("lol");
		//customerService.update(person);
		//LOG.info("Customer edited in DB  : {}", person);
	}
	
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
            }
        };
    }
}
