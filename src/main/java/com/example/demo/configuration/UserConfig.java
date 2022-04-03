package com.example.demo.configuration;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User mary = new User(
                    "Mary5",
                    "Syreieva",
                    LocalDate.of(1993, Month.APRIL, 7)
            );

            User alex = new User(
                    "Wowconroy",
                    "Shostak",
                    LocalDate.of(1992, Month.JANUARY, 18)
            );

            repository.saveAll(
                    List.of(mary, alex)
            );
        };
    }
}
