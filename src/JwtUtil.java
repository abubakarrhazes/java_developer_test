import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class JwtUtil {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateToken(String username, String email) {
        return Jwts.builder()
                .setSubject(username)
                .claim("email", email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour
                .signWith(key)
                .compact();
    }

    public static String verifyToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token);
            return "verification pass";
        } catch (JwtException e) {
            return "verification fails";
        }
    }

    public static void main(String[] args) {
        String username,email;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter UserName Here");
        username = input.nextLine();
        System.out.println("Enter Email Here");
        email = input.nextLine();
        String token = generateToken(username, email);
        System.out.println("Generated Token: " + token);

        String verification = verifyToken(token);
        System.out.println("Verification: " + verification);
    }
}
