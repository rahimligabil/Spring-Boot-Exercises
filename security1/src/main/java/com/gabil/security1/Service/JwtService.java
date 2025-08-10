package com.gabil.security1.Service;

import java.security.Key;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Data;

@Data
@Service
public class JwtService {

	private static final String SECRET_KEY = "6A3B8C5F7189E0D12F9B2C3D4E6F7A8B";


	public String extractUsername(String token) {
		return extractClaim(token,Claims::getSubject);
	}
	
	
	public Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
	}

	private Key getSigningKey() {
		byte[] key = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(key);
	}
	
	public <T> T extractClaim(String token, Function<Claims,T> claimResolver) {
		Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);
	}

}
