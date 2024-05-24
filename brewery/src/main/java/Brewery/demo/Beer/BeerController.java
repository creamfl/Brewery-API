package Brewery.demo.Beer;

import Brewery.demo.Brewery.Brewery;
import Brewery.demo.Brewery.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/beer")
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping
    public List<Beer> getBeer() {
        return beerService.getBeer();
    }

    @GetMapping(path = "{beerId}")
    public Beer getBeerById(@PathVariable("beerId") Long beerId) {
        return beerService.getBeerById(beerId)
                .orElseThrow(() -> new IllegalStateException("beer with id " + beerId + " does not exist"));
    }

    @PostMapping
    public void registerNewBeer(@RequestBody Beer beer) {
        beerService.addNewBeer(beer);
    }

    @DeleteMapping(path = "{beerId}")
    public void deleteBeer(@PathVariable("beerId") Long beerId) {
        beerService.deleteBeer(beerId);
    }

    @PutMapping(path = "{beerId}")
    public void updateBeer(
            @PathVariable("beerId") Long beerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer alcoholPercent) {
        beerService.updateBeer(beerId, name, alcoholPercent);
    }
}
