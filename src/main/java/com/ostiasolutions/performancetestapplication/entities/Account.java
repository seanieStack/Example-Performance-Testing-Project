package com.ostiasolutions.performancetestapplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1L, message = "Account number must be at least 10 digits.")
    private long accountNumber;

    @NotBlank(message = "First name is required.")
    @Size(max = 50, message = "First name can't exceed 50 characters.")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    @Size(max = 50, message = "Last name can't exceed 50 characters.")
    private String lastName;

    @Size(max = 5, message = "Title can't exceed 5 characters.")
    private String title;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email format.")
    private String email;

    @NotBlank(message = "Address is required.")
    @Size(max = 100, message = "Address can't exceed 100 characters.")
    private String address;

    @NotBlank(message = "City is required.")
    @Size(max = 50, message = "City can't exceed 50 characters.")
    private String city;

    @NotBlank(message = "Country is required.")
    @Size(max = 50, message = "Country can't exceed 50 characters.")
    private String country;

    @NotNull(message = "Phone number is required.")
    @Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s./0-9]*$", message = "Invalid phone number.")
    private String phoneNumber;

    @NotBlank(message = "Occupation is required.")
    @Size(max = 50, message = "Occupation can't exceed 50 characters.")
    private String occupation;

    @Pattern(regexp = "MALE|FEMALE|OTHER|UNSPECIFIED", message = "Gender must be MALE, FEMALE, OTHER, or UNSPECIFIED.")
    private String gender;

    @NotNull(message = "Birth date is required.")
    @Past(message = "Birth date must be in the past.")
    private LocalDate birthDate;

    @Size(max = 20, message = "Bank branch code can't exceed 20 characters.")
    private String branchCode;

    @PositiveOrZero(message = "Balance must be zero or positive.")
    private BigDecimal balance;

    @Positive(message = "Credit limit must be positive.")
    private BigDecimal creditLimit;

    @NotBlank(message = "Account type is required.")
    @Pattern(regexp = "SAVINGS|CHECKING|LOAN|CREDIT", message = "Account type must be SAVINGS, CHECKING, LOAN, or CREDIT.")
    private String accountType;

    private boolean isActive;

    private String currency;

    @Min(value = 1, message = "Minimum monthly transaction limit must be at least 1.")
    @Max(value = 100, message = "Maximum monthly transaction limit cannot exceed 100.")
    private Integer monthlyTransactionLimit;

    private boolean overdraftEnabled;
}
