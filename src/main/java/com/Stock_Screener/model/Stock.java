package com.Stock_Screener.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Name is mandatory")
        @Size(max = 100, message = "Name must be less than or equal to 100 characters")
        private String name;


        @NotEmpty(message = "symbol is mandatory")
        @Size(min = 2, message = "Symbol must be greater than or equal to 2 characters")
        private String symbol;


        @NotNull(message = "Price is mandatory")
        @Min(value = 0, message = "Price must be greater than or equal to 0")
        private double price;

    }


