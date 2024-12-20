package com.shopme.admin.user;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
    @Test
    public void testEncoderPassword(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "12345678";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println(encodedPassword);
        boolean matches = passwordEncoder.matches(rawPassword,encodedPassword);
        System.out.println(matches);
    }
}
