package com.example.project3.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {

    @NotEmpty(message = "you should enter id")
    private String id;
    @NotEmpty(message = "you should enter product id")
    private String productid;
    @NotEmpty(message = "you should enter merchant id")
    private String merchantid;
    @NotNull(message = "you should enter stock")
    @Min(10)
    private  Integer stock;
}
