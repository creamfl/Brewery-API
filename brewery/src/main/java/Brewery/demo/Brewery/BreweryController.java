package Brewery.demo.Brewery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/brewery")
public class BreweryController {

    private final BreweryService breweryService;

    @Autowired
    public BreweryController(BreweryService breweryService) {
        this.breweryService = breweryService;
    }

    @GetMapping
    public List<Brewery> getBrewery(){
        return breweryService.getBrewery();
    }

    @GetMapping(path = "{breweryId}")
    public Brewery getBreweryById(@PathVariable("breweryId") Long breweryId) {
        return breweryService.getBreweryById(breweryId)
                .orElseThrow(() -> new IllegalStateException("brewery with id " + breweryId + " does not exist"));
    }


    @PostMapping
    public void registerNewBrewery(@RequestBody Brewery brewery){
        breweryService.addNewBrewery(brewery);
    }

    @DeleteMapping(path = "{breweryId}")
    public void deleteBrewery(@PathVariable("breweryId") Long breweryId ){
        breweryService.deleteBrewery(breweryId);
    }

    @PutMapping(path = "{breweryId}")
    public void updateBrewery(
            @PathVariable("breweryId") Long breweryId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String location){
        breweryService.updateBrewery(breweryId, name, location);
    }

}
