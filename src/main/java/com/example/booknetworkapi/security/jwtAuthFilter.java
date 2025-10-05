package com.example.booknetworkapi.security;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.net.http.HttpHeaders;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
public class jwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    public jwtAuthFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override

    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
            )throws ServletException,IOException {
        if (request.getServletPath().contains("/api/v1/auth")) {
            filterChain.doFilter(request, response);
            return;
        }
        final String authorizationHeader = request.getHeader(AUTHORIZATION);
        final String jwt;
        final String userEmail;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
             filterChain.doFilter(request, response);
             return;
        }
        jwt=authorizationHeader.substring(7);
        userEmail=jwtService.extractUsername(jwt);


    }


}
