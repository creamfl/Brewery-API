package Brewery.demo.CustomerReview;

import Brewery.demo.Brewery.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/customerReview")
public class CustomerReviewController {

    private final CustomerReviewService customerReviewService;

    @Autowired
    public CustomerReviewController(CustomerReviewService customerReviewService) {
        this.customerReviewService = customerReviewService;
    }

    @GetMapping
    public List<CustomerReview> getCustomerReviews(){
        return customerReviewService.getCustomerReviews();
    }

    @GetMapping(path = "{reviewId}")
    public CustomerReview getCustomerReviewById(@PathVariable("reviewId") Long reviewId) {
        return customerReviewService.getCustomerReviewById(reviewId)
                .orElseThrow(() -> new IllegalStateException("Customer review with id " + reviewId + " does not exist"));
    }

    @PostMapping
    public void addBreweryReview(@RequestBody CustomerReview review, @RequestParam Long breweryId){
        customerReviewService.addBreweryReview(review, breweryId);
    }

    @PutMapping("/{reviewId}")
    public void updateBreweryReview(@PathVariable Long reviewId, @RequestBody CustomerReview updatedReview, @RequestParam Long breweryId) {
        customerReviewService.updateBreweryReview(reviewId, updatedReview, breweryId);
    }

    @DeleteMapping("/{reviewId}")
    public void deleteBreweryReview(@PathVariable Long reviewId) {
        customerReviewService.deleteBreweryReview(reviewId);
    }
}
