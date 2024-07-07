import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {

    // Regex Patterns Declaration
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$");

    //Creating Method For Validating The User Input

    public static Map<String, String> validate(String username, String email, String password, LocalDate dob) {
        Map<String, String> errors = new HashMap<>();

        // Username validation
        if (username == null || username.length() < 4) {
            errors.put("Username", "not empty, min 4 characters");
        }

        // Email validation
        if (email == null || email.isEmpty() || !EMAIL_PATTERN.matcher(email).matches()) {
            errors.put("Email", "not empty, valid email address");
        }

        // Password validation
        if (password == null || password.isEmpty() || !PASSWORD_PATTERN.matcher(password).matches()) {
            errors.put("Password", "not empty, strong password with at least 1 upper case, 1 special character, 1 number and must be minimum of 8 characters");
        }

        // Date of Birth validation
        if (dob == null || Period.between(dob, LocalDate.now()).getYears() < 16) {
            errors.put("Date of Birth", "not empty, should be 16 years or greater");
        }

        return errors;
    }

    public static void main(String [] args){
        //Creating Input Variables
        String username,email,password;
        LocalDate dob = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter UserName Here");
        username = input.nextLine();
        System.out.println("Enter Email Here");
        email = input.nextLine();
        System.out.println("Enter Your Password");
        password = input.nextLine();

        //Checking For Validation Here
        Map<String, String> errors = validate(username, email, password, null);

        if (errors.isEmpty()) {
            System.out.println("All validations passed");
        } else {
            errors.forEach((field, error) -> System.out.println(field + ": " + error));
        }

    }
}
