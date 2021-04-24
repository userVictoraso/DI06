import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class PasswordCheckerTest {
    private final PasswordChecker passwordChecker = new PasswordChecker();

    @BeforeAll
    static void init(){
        System.out.println("@BeforeAll se ejecuta una sola vez al inicio de la clase");
    }

    @BeforeEach
    public void initEach(){
        System.out.println("@BeforeEach se ejecuta antes de cada test");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("@AfterEach se ejecuta después de cada test");
    }

    @AfterAll
    static void finish(){
        System.out.println("@AfterAll se ejecuta una sola vez al final de la clase");
    }

    /**WEAK PASSWORD**/
    /** Checking weak password with strings less than 4 chars**/
    @Test
    public void weakPasswordLessThan4Chars() {
        boolean actual = passwordChecker.checkWeakPassword("Vic");
        assertFalse(actual);
    }
    /**Checking weak password with strings equals to 4 chars**/
    @Test
    public void weakPasswordEqualsTo4Chars() {
        boolean actual = passwordChecker.checkWeakPassword("Vict");
        assertTrue(actual);
    }
    /**Checking weak password with strings greater than 4 chars**/
    @Test
    public void weakPasswordGreaterThan4Chars() {
        boolean actual = passwordChecker.checkWeakPassword("Victor");
        assertTrue(actual);
    }

    /**MEDIUM PASSWORD**/
    /**Checking medium password with strings less than 5 chars**/
    @Test
    public void mediumPasswordLessThan5Chars() {
        boolean actual = passwordChecker.checkMediumPassword("Vict");
        assertFalse(actual);
    }

    /**Checking medium password with strings equals to 5 chars**/
    @Test
    public void mediumPasswordEqualsTo5Chars() {
        boolean actual = passwordChecker.checkWeakPassword("Victo");
        assertTrue(actual);
    }

    /**Checking medium password with strings greater than 5 chars**/
    @Test
    public void mediumPasswordGreaterThan5Chars() {
        boolean actual = passwordChecker.checkWeakPassword("Victor");
        assertTrue(actual);
    }

    /**STRONG PASSWORD**/
    /**Checking strong password with strings less than 7 chars**/
    @Test
    public void strongPasswordLessThan7Chars() {
        boolean actual = passwordChecker.checkStrongPassword("Victor");
        assertFalse(actual);
    }

    /**Checking strong password with strings equals to 7 chars, only letter**/
    @Test
    public void strongPasswordEqualsTo7CharsOnlyLetter() {
        boolean actual = passwordChecker.checkStrongPassword("Victora");
        assertFalse(actual);
    }
    /**Checking strong password with strings greater than 7 chars, only letter**/
    @Test
    public void strongPasswordGreaterThan7CharsOnlyLetter() {
        boolean actual = passwordChecker.checkStrongPassword("Victoraso");
        assertFalse(actual);
    }
    /**Checking strong password with strings equals to 7 chars, with number and lowercase**/
    @Test
    public void strongPasswordEqualsTo7CharsNumberLowercase() {
        boolean actual = passwordChecker.checkStrongPassword("victor7");
        assertFalse(actual);
    }
    /**Checking strong password with strings equals to 7 chars, with number, lowercase and uppercase**/
    @Test
    public void strongPasswordEqualsTo7CharsNumberLowercaseUppercase() {
        boolean actual = passwordChecker.checkStrongPassword("Victor7");
        assertTrue(actual);
    }
}
