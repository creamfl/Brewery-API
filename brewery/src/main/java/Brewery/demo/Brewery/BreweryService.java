package Brewery.demo.Brewery;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BreweryService {
    private final BreweryRepository breweryRepository;

    @Autowired
    public BreweryService(BreweryRepository breweryRepository) {
        this.breweryRepository = breweryRepository;
    }

    public List<Brewery> getBrewery(){
       return breweryRepository.findAll();
    }

    public Optional<Brewery> getBreweryById(Long breweryId) {
        return breweryRepository.findById(breweryId);
    }

    public void addNewBrewery(Brewery brewery) {
        Optional<Brewery> breweryOptional = breweryRepository.findBreweryByName(brewery.getName());
        if(breweryOptional.isPresent()){
            throw new IllegalStateException("name taken");
        }
        breweryRepository.save(brewery);
    }

    public void deleteBrewery(Long breweryId) {
        breweryRepository.findById(breweryId);
        boolean exists = breweryRepository.existsById(breweryId);
        if (!exists){
            throw new IllegalStateException("brewery with id " + breweryId + " does not exist");
        }
        breweryRepository.deleteById(breweryId);
    }

    @Transactional
    public void updateBrewery(Long breweryId, String name, String location) {
        Brewery brewery = breweryRepository.findById(breweryId)
                .orElseThrow(() -> new IllegalStateException("brewery with id " + breweryId + " does not exist"));
        if (name != null && name.length() > 0 && !Objects.equals(brewery.getName(), name)){
            brewery.setName(name);
        }

        if (location != null && location.length() > 0 && !Objects.equals(brewery.getLocation(), location)) {
            Optional<Brewery> breweryOptional = breweryRepository.findBreweryByLocation(location);

            if(breweryOptional.isPresent()) {
                throw new IllegalStateException("location taken");
            }
            brewery.setLocation(location);
        }

    }
}
