import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void utils_constructor_runs() {
        new Utils();
    }

    @Test
    void checkName_null_returnsFalse() {
        assertFalse(Utils.checkName(null));
    }

    @Test
    void checkName_empty_returnsFalse() {
        assertFalse(Utils.checkName(""));
    }

    @Test
    void checkName_nonEmpty_returnsTrue() {
        assertTrue(Utils.checkName("Upama"));
    }

    @Test
    void isValidAge_negative_returnsFalse() {
        assertFalse(Utils.isValidAge(-1));
    }

    @Test
    void isValidAge_zero_returnsTrue() {
        assertTrue(Utils.isValidAge(0));
    }

    @Test
    void isValidAge_120_returnsTrue() {
        assertTrue(Utils.isValidAge(120));
    }

    @Test
    void isValidAge_over120_returnsFalse() {
        assertFalse(Utils.isValidAge(121));
    }
}
