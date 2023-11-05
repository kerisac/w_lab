import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InnDearchTest {

    @Test
    void testValidateInn() {
        InnDearch innSearch = new InnDearch();

        // Валидный ИНН
        String validInn = "7707083893";
        boolean result = innSearch.validateInn(validInn);
        assertTrue(result);

        // Невалидный ИНН - неправильная длина
        String invalidInn = "123456789";
        result = innSearch.validateInn(invalidInn);
        assertFalse(result);

        // Невалидный ИНН - неверная контрольная сумма
        String invalidInn2 = "7707083894";
        result = innSearch.validateInn(invalidInn2);
        assertFalse(result);
    }

}