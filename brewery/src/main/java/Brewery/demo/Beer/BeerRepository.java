package Brewery.demo.Beer;

import Brewery.demo.Brewery.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
    @Query("SELECT b FROM Beer b WHERE b.name=?1")
    Optional<Beer> findBeerByName(String name);

}
