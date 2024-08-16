package com.codeprophet.scm2.forms;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    private String userName;
    private String userEmail;
    private String phoneNumber;
    private  String password;
    private String about;

}
