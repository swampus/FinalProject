package model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;


public class UpdateProduct {

        @NotBlank
        private String name;

        private String description;

        @DecimalMin(value = "0.00")
        private Long price;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}



