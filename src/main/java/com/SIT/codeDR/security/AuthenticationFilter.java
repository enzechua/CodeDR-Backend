//package com.SIT.codeDR.security;
//
//import com.SIT.codeDR.models.User;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.xml.bind.DatatypeConverter;
//import java.io.IOException;
//import java.security.Key;
//import java.util.ArrayList;
//import java.util.Date;
//
//import io.jsonwebtoken.security.Keys;
//
//import static com.SIT.codeDR.security.SecurityConstants.*;
//
//public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    private AuthenticationManager authenticationManager;
//
//    public  AuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest req,
//                                                HttpServletResponse resp) throws AuthenticationException {
//        try {
//            User user = new ObjectMapper().readValue(req.getInputStream(), User.class);
//
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(user.getUsername(),
//                            user.getPassword(), new ArrayList<>())
//            );
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse resp, FilterChain chain,
//                                            Authentication auth) throws IOException, ServletException {
//        Date exp = new Date(System.currentTimeMillis() * EXPIRATION_TIME);
//        byte [] keyBytes = SECRET.getBytes();
//        Key key = Keys.hmacShaKeyFor(keyBytes);
//        Claims claims = Jwts.claims().setSubject(((User) auth.getPrincipal()).getUsername());
//        String token = Jwts.builder()
//                .setClaims(claims)
//                .signWith(key, SignatureAlgorithm.HS512)
//                .setExpiration(exp)
//                .compact();
//        resp.getWriter().write(token);
//        resp.getWriter().flush();
////        resp.addHeader("token", token);
//
//
////        byte [] secretKey = SECRET.getBytes();
////        JWTClaimsSet claims = new JWTClaimsSet().Builder()
////                .claim("name", "peter")
////                .claim("role", "2")
////                .build();
////        Payload payload = new Payload(claims.toJSONObject());
////        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
////        JWSObject jwsObject = new JWSObject(header, payload);
////        new DirectEncrypter(secretKey);
//    }
//}
