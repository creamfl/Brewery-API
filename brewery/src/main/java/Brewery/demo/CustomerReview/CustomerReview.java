package Brewery.demo.CustomerReview;


import Brewery.demo.Brewery.*;
import jakarta.persistence.*;

@Entity
@Table
public class CustomerReview {
    @Id
    @SequenceGenerator(
            name = "customerReview_sequence",
            sequenceName = "customerReview_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customerReview_sequence"
    )
    private Long id;
    @ManyToOne // Establishing many-to-one relationship with Brewery
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;
    private String customerName;
    private String review;

    public CustomerReview() {
    }

    public CustomerReview(Long id, Brewery brewery, String customerName, String review) {
        this.id = id;
        this.brewery = brewery;
        this.customerName = customerName;
        this.review = review;
    }

    public CustomerReview(Brewery brewery, String customerName, String review) {
        this.brewery = brewery;
        this.customerName = customerName;
        this.review = review;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
