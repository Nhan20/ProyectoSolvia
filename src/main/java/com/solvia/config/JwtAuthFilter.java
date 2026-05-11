/**
 * 
 */
package com.solvia.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import javax.crypto.SecretKey;

public class JwtAuthFilter extends OncePerRequestFilter {

	private final String SECRET_KEY = "solvia_jwt_secret_key_2026_super_segura_con_muchos_caracteres_123456789";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authHeader = request.getHeader("Authorization");

		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}

		String token = authHeader.substring(7);

		try {

			SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

			Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();

			String email = claims.getSubject();
			String role = claims.get("role", String.class);

			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(email, null,
					List.of(new SimpleGrantedAuthority(role)));

			SecurityContextHolder.getContext().setAuthentication(auth);

		} catch (Exception e) {
			e.printStackTrace();
		}

		filterChain.doFilter(request, response);
	}
}