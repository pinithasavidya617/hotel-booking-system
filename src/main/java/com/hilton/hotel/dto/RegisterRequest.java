package com.hilton.hotel.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank(message = "First Name is required")
    @Size(min = 2,max = 50,message = "First name has to between 2-50 characters")
    private  String firstName;

    @NotBlank(message = "First Name is required")
    @Size(min = 2,max = 50,message = "First name has to between 2-50 characters")
    private  String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
//    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number should be between 10-15 digits")
    private String phoneNo;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;


}