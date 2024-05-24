package Brewery.demo.TastingNote;

import Brewery.demo.Beer.Beer;
import Brewery.demo.Beer.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.List;

@Configuration
public class TastingNoteConfig {

    @Bean
    CommandLineRunner commandLineRunner2(TastingNoteRepository tastingNoteRepository, BeerRepository beerRepository) {
        return args -> {
            Beer beer1 = beerRepository.findById(1L)
                    .orElseThrow(() -> new IllegalStateException("Beer with id 1 not found"));
            Beer beer2 = beerRepository.findById(2L)
                    .orElseThrow(() -> new IllegalStateException("Beer with id 2 not found"));

            TastingNote nikisReview = new TastingNote("good beer", beer1);
            TastingNote stefansReview = new TastingNote("excellent", beer2);

            tastingNoteRepository.saveAll(List.of(nikisReview, stefansReview));
        };
    }
}
