package Brewery.demo.Beer;

import Brewery.demo.Brewery.Brewery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BeerService {
    private final BeerRepository beerRepository;

    @Autowired
    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public List<Beer> getBeer(){
        return beerRepository.findAll();
    }

    public Optional<Beer> getBeerById(Long beerId) {
        return beerRepository.findById(beerId);
    }

    public void addNewBeer(Beer beer) {
        Optional<Beer> beerOptional = beerRepository.findBeerByName(beer.getName());
        if (beerOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        beerRepository.save(beer);
    }

    public void deleteBeer(Long beerId) {
        boolean exists = beerRepository.existsById(beerId);
        if (!exists) {
            throw new IllegalStateException("beer with id " + beerId + " does not exist");
        }
        beerRepository.deleteById(beerId);
    }



    @Transactional
    public void updateBeer(Long beerId, String name, Integer alcoholPercent) {
        Beer beer = beerRepository.findById(beerId)
                .orElseThrow(() -> new IllegalStateException("beer with id " + beerId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(beer.getName(), name)) {
            Optional<Beer> beerOptional = beerRepository.findBeerByName(name);
            if (beerOptional.isPresent()) {
                throw new IllegalStateException("name taken");
            }
            beer.setName(name);
        }

        if (alcoholPercent != null && !Objects.equals(beer.getAlcoholPercent(), alcoholPercent)) {
            beer.setAlcoholPercent(alcoholPercent);
        }
    }

}


