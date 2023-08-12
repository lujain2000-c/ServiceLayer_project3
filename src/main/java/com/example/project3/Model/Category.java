package com.example.project3.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    @NotEmpty(message = "you should enter name")
    private String id;
    @NotEmpty(message = "you should enter name")
    @Size(min = 4, max = 20, message = " name is too short")
    private String name;
}
