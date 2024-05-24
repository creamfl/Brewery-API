package Brewery.demo.Brewery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BreweryRepository extends JpaRepository<Brewery, Long> {

     @Query("SELECT b FROM Brewery b WHERE b.name=?1")
    Optional<Brewery> findBreweryByName(String name);

    Optional<Brewery> findBreweryByLocation(String location);
}
