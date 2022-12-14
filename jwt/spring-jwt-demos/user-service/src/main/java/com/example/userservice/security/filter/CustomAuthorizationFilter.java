package com.example.userservice.security.filter;

import com.example.userservice.dto.Error;
import com.example.userservice.security.token.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
@RequiredArgsConstructor
public class CustomAuthorizationFilter extends OncePerRequestFilter {

    private final JWTVerifier tokenVerifier;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final List<String> allowedApis = List.of("/api/auth/login", "/api/auth/token/refresh","/api/auth/register");
        if (!allowedApis.contains(request.getServletPath())) {
            try {
                final String authorizationHeader = request.getHeader(AUTHORIZATION);
                if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                    final String token = authorizationHeader.substring("Bearer ".length());
                    tokenVerifier.verifyToken(token);
                }
            }catch (Exception e){
              //  Error error= new Error(e.getMessage(), Instant.now());
                response.setContentType(APPLICATION_JSON_VALUE);
                response.setStatus(FORBIDDEN.value());
                new ObjectMapper().writeValue(response.getOutputStream(), Collections.singletonMap("error_message", e.getMessage()));
            }
        }
        filterChain.doFilter(request, response);
    }
}
