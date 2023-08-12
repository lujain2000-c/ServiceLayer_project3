package com.example.project3.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.logging.log4j.message.Message;

@Data
@AllArgsConstructor
public class Product {
    @NotEmpty(message = "you should enter product id")
    private String id;
    @NotEmpty(message = "you should enter product name")
    @Size(min = 4, max = 20, message = "product name is too short")
    private String name;
    @NotNull(message = "you should enter the product price ")
    @Positive(message = "price should be more than 0")
    private Double price;
    @NotEmpty(message = "you should enter the product category id")
    private String categoryID;
}
