package com.ecommerce.razei.security.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbjEyMzQ1Njc4IiwibmFtZSI6InJhemVpYXBwbGljYXRpb24ifQ.qrr5LP6WbTFd9UHJMg4_Oa7xxUbGWGI1oFbtx51mfjM";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDs = 600L; //TIEMPO DE VALIDEZ

    public static String createToke(String username, String email){
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDs * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        //extra.put("mail", email);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expirationDate)
                .addClaims(extra)// para agregar mas data
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try{
            Claims claims = Jwts.parserBuilder()//proceso inverso a la creacion de token
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String username = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
        }catch(JwtException e){ //cuando no se ha podido crear el token
            return null;
        }
    }

}
