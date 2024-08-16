package com.codeprophet.scm2.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "Username is required!")
    @Size(min = 3, message = "Minimum 3 character is required!")
    private String userName;

    @NotBlank(message = "Email is required!")
    @Email(message = "Invalid email address!")
    private String userEmail;

    @NotBlank(message = "Password is required!")
    @Size(min = 6, message = "Minimum 6 character long!")
    private  String password;

    @NotBlank(message = "Phone number is required")
    @Size(min = 11, max = 14, message = "11 - 14 digit number required!")
    private String phoneNumber;

    @NotBlank(message = "About is required!")
    private String about;

}
