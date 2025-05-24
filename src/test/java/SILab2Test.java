import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void testEveryStatement() {
        Item item1 = new Item("item1", 1, 100, 0);
        Item item2 = new Item("item2", 5, 400, 0.2);
        List<Item> items = List.of(item1, item2);
        String validCard = "1234567890123456";
        double result = SILab2.checkCart(items, validCard);
        assertEquals(100 + (400 * 0.8 * 5 - 30), result, 0.01);
    }

    @Test
    public void testEveryBranch() {
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234567890123456"));

        Item invalidItem = new Item("", 1, 100, 0);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(invalidItem), "1234567890123456"));

        Item validItem = new Item("valid", 1, 100, 0);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(validItem), "123ABC7890123456"));

        assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(validItem), null));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(validItem), "123"));
    }
}
