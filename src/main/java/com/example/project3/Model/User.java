package com.example.project3.Model;

import jakarta.validation.constraints.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@AllArgsConstructor
public class User {

    @NotEmpty(message = "you should enter your id")
    private String id;
    @NotEmpty(message = "you should enter your name")
    @Size(min = 6, message = "name is too short")
    private String username;
    @NotEmpty(message = "you should enter your password")
    @Size(min = 6, message = " length should be more than 5")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$", message = "the length of password should be more than 5, capital letter and small letter")
    //Password must contain at least one digit [0-9].
    //Password must contain at least one lowercase Latin character [a-z].
    //Password must contain at least one uppercase Latin character [A-Z].
    //Password must contain at least one special character like ! @ # & ( ).
    // ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$
    private String password;
    @NotEmpty(message = "you should enter your email")
    @Email(message = "invalid email")
    private String email;
    @NotEmpty(message = "you should enter your role")
    private String role;
    @NotNull(message = "you should enter your balance ")
    @Positive(message = "balance should be more than 0")
    private Double balance;

}
