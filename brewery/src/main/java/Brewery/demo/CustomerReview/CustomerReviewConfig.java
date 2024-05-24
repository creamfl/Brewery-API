package Brewery.demo.CustomerReview;

import Brewery.demo.Brewery.Brewery;
import Brewery.demo.Brewery.BreweryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerReviewConfig {

    BreweryRepository breweryRepository;

    @Bean
    CommandLineRunner commandLineRunner4(CustomerReviewRepository customerReviewRepository, BreweryRepository breweryRepository) {
        return args -> {
            Brewery brewery1 = breweryRepository.findById(1L)
                    .orElseThrow(() -> new IllegalStateException("Brewery with id 1 not found"));
            Brewery brewery2 = breweryRepository.findById(2L)
                    .orElseThrow(() -> new IllegalStateException("Brewery with id 2 not found"));

            CustomerReview nikiReview = new CustomerReview(brewery1, "stojce","Great brewery!");
            CustomerReview stefanReview = new CustomerReview(brewery2, "zdravko","Awesome place!");

            customerReviewRepository.saveAll(List.of(nikiReview, stefanReview));
        };
    }
}
