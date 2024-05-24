package Brewery.demo.CustomerReview;

import Brewery.demo.Beer.Beer;
import Brewery.demo.Beer.BeerRepository;
import Brewery.demo.Brewery.Brewery;
import Brewery.demo.Brewery.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerReviewService {
    private final CustomerReviewRepository customerReviewRepository;
    private final BreweryRepository breweryRepository;

    @Autowired
    public CustomerReviewService(CustomerReviewRepository customerReviewRepository,  BreweryRepository breweryRepository) {
        this.customerReviewRepository = customerReviewRepository;
        this.breweryRepository = breweryRepository;
    }

    public List<CustomerReview> getCustomerReviews(){
        return customerReviewRepository.findAll();
    }

    public Optional<CustomerReview> getCustomerReviewById(Long reviewId) {
        return customerReviewRepository.findById(reviewId);
    }

    public void addBreweryReview(CustomerReview review, Long breweryId) {
        // Find the brewery that will match the brewery id
        Brewery brewery = breweryRepository.findById(breweryId)
                .orElseThrow(() -> new IllegalStateException("Brewery with id " + breweryId + " does not exist"));

        // Set the brewery for the review
        review.setBrewery(brewery);

        // Save the review
        customerReviewRepository.save(review);
    }

    public void deleteBreweryReview(Long reviewId) {
        // Check if the customer review exists
        boolean exists = customerReviewRepository.existsById(reviewId);
        if (!exists) {
            throw new IllegalStateException("Customer review with id " + reviewId + " does not exist");
        }

        // If the customer review exists, delete it
        customerReviewRepository.deleteById(reviewId);
    }


    public void updateBreweryReview(Long reviewId, CustomerReview updatedReview, Long breweryId) {
        // Get the existing customer review by ID
        CustomerReview existingReview = customerReviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalStateException("Customer review with id " + reviewId + " does not exist"));

        // Update the brewery ID for the customer review
        Brewery brewery = breweryRepository.findById(breweryId)
                .orElseThrow(() -> new IllegalStateException("Brewery with id " + breweryId + " does not exist"));
        existingReview.setBrewery(brewery);

        // Update other fields of the customer review if needed
        existingReview.setCustomerName(updatedReview.getCustomerName());
        existingReview.setReview(updatedReview.getReview());

        // Save the updated customer review
        customerReviewRepository.save(existingReview);
    }
}
