package com.shopping.users;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;




import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
	
	public static final String JWT_KEY = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";
	public static final String JWT_HEADER = "Authorization";
	public static final int JWT_EXPIRATION_TIME=604800000;
	    
	public String generateToken(Authentication authentication){
    String username = authentication.getName();
    Date currentDate = new Date();
    Date expireDate = new Date(currentDate.getTime() + JWT_EXPIRATION_TIME);

    SecretKey key = Keys.hmacShaKeyFor(JWT_KEY.getBytes(StandardCharsets.UTF_8));
    
    return  Jwts.builder().setIssuer("Online Shopping").setSubject("JWT Token")
            .claim("username", username)
            .claim("authorities", populateAuthorities(authentication.getAuthorities()))
            .setIssuedAt(currentDate)
            .setExpiration(expireDate)
            .signWith(key).compact();
}



public String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
    Set<String> authoritiesSet = new HashSet<>();
    for (GrantedAuthority authority : collection) {
        authoritiesSet.add(authority.getAuthority());
    }
    return String.join(",", authoritiesSet);
}

}
