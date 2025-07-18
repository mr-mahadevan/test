package com.sago.payment.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for user registration requests.
 * Contains user details with validation constraints.
 */
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    private static final int USERNAME_MIN_LENGTH = 4;
    private static final int USERNAME_MAX_LENGTH = 50;
    private static final int PASSWORD_MIN_LENGTH = 8;
    private static final int PASSWORD_MAX_LENGTH = 20;
    private static final int MOBILE_NUMBER_LENGTH = 10;
    private static final String MOBILE_NUMBER_PATTERN = "^[0-9]*$";

    @NotNull(message = "Username is required")
    @Size(min = USERNAME_MIN_LENGTH, max = USERNAME_MAX_LENGTH,
            message = "Username must be between {min} and {max} characters")
    private String username;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Password is required")
    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH,
            message = "Password must be between {min} and {max} characters")
    private String password;

    @NotNull(message = "Mobile number is required")
    @Size(min = MOBILE_NUMBER_LENGTH, max = MOBILE_NUMBER_LENGTH,
            message = "Mobile number must be exactly {max} digits")
    @Pattern(regexp = MOBILE_NUMBER_PATTERN,
            message = "Mobile number must contain only digits")
    private String mobileNumber;
}