//package com.SIT.codeDR.security;
//
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.security.Key;
//import java.text.ParseException;
//import java.util.ArrayList;
//
//import static com.SIT.codeDR.security.SecurityConstants.HEADER_NAME;
//import static com.SIT.codeDR.security.SecurityConstants.SECRET;
//
//public class AuthorizationFilter extends BasicAuthenticationFilter {
//
//    public AuthorizationFilter(AuthenticationManager authManager) {
//        super(authManager);
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain chain) throws IOException, ServletException {
//        String header = request.getHeader(HEADER_NAME);
//
//        if (header == null) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        UsernamePasswordAuthenticationToken authentication = authenticate(request);
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        chain.doFilter(request, response);
//    }
//
//    private UsernamePasswordAuthenticationToken authenticate(HttpServletRequest request) {
//        String token = request.getHeader(HEADER_NAME);
//        if (token != null) {
////            byte [] keyBytes = Decoders.BASE64.decode(SECRET);
//            Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
//            Claims user = Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(token)
//                    .getBody();
//
//            if (user != null) {
//                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//            }else{
//                return  null;
//            }
//
//        }
//        return null;
//    }
//}