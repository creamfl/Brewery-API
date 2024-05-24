package Brewery.demo.Brewery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BreweryConfig {

    @Bean
    CommandLineRunner commandLineRunner(BreweryRepository repository){
        return args -> {
            Brewery nikis = new Brewery(
                    "nikis brewery",
                    "Gevgelija",
                    1992
            );

            Brewery stefans = new Brewery(
                    "stefans brewery",
                    "Bitola",
                    2000
            );

            repository.saveAll(
                    List.of(nikis, stefans)
            );
        };
    }
}
