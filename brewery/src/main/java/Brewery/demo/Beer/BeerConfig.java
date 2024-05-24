package Brewery.demo.Beer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeerConfig {
    @Bean
    CommandLineRunner commandLineRunner1(BeerRepository repository){
        return args -> {
            Beer nikis = new Beer("nikis beer", 5);
            Beer stefans = new Beer("stefans beer", 6);
            repository.saveAll(List.of(nikis, stefans));
        };
    }

}
