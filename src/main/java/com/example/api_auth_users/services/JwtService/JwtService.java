package com.example.api_auth_users.services.JwtService;

import com.example.api_auth_users.DTO.TokenResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class JwtService implements IJwtService{

    private final String secretToken;

    public JwtService(@Value("${jwt.secret}") String secretToken) {
        this.secretToken = secretToken;
    }

    @Override
    public TokenResponse generateToken(Long userId) {
        Date expirationDate = new Date(Long.MAX_VALUE);

        String token = Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, this.secretToken)
                .compact();

        return TokenResponse.builder().accessToken(token).build();
    }

    @Override
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(this.secretToken)
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    @Override
    public boolean isExpired(String token) {
        try {
            return getClaims(token).getExpiration().before(new Date());
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public Integer extractUserId(String token) {
        Claims claims = getClaims(token);
        String userId = claims.getSubject();
        return Integer.parseInt(userId);
    }
}
