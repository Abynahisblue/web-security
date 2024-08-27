package com.security.web_security.httpRequest;

import com.security.web_security.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {
    private User user;
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

}
