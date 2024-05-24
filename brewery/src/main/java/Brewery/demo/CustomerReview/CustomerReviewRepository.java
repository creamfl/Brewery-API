package Brewery.demo.CustomerReview;

import Brewery.demo.Beer.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerReviewRepository extends JpaRepository<CustomerReview, Long> {
}
