package com.covid.project.registration;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginRequest {
    private final String password;
    private final String email;
}
