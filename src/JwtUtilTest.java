import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JwtUtilTest {
    @Test
    public void testValidToken() {
        String username = "Abubakar";
        String email = "anuuman2@example.com";

        String token = JwtUtil.generateToken(username, email);

        String verification = JwtUtil.verifyToken(token);

        assertEquals("verification pass", verification, "Valid token verification should pass");
    }

    @Test
    public void testInvalidToken() {
        String invalidToken = "invalid.token.abc123";

        String verification = JwtUtil.verifyToken(invalidToken);

        assertEquals("verification fails", verification, "Invalid token verification should fail");
    }
}
