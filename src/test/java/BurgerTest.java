import org.junit.jupiter.api.Test;
import org.menu.Burger;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BurgerTest {
    @Test
    public void testAddSingleToppingPrice() {
        Burger burger = new Burger();
        burger.addTopping("Bacon");
        assertEquals(1.00, burger.getPrice(), 0.01);
    }

    @Test
    public void testTotalPriceWithToppings() {
        // Replace pizza with burger equivalent
        Burger burger = new Burger();
        burger.addBun("Brioche");
        burger.addPatty("Veg");
        burger.addTopping("Tomato");
        burger.addCheese("Swiss");
        assertEquals(2.50 + 1.50 + 0.25 + 0.75, burger.getPrice(), 0.01);
    }

    @Test
    public void testOrderTotalWithSingleBurger() {
        Burger burger = new Burger();
        burger.addBun("Sesame");
        burger.addPatty("NonVeg");
        burger.addTopping("Onion");
        burger.addCheese("Cheddar");

        double expected = 2.00 + 1.00 + 0.15 + 0.50;
        assertEquals(expected, burger.getPrice(), 0.01);
    }

    @Test
    public void testOrderTotalWithTwoBurgers() {
        Burger burger1 = new Burger();
        burger1.addBun("Sesame");
        burger1.addPatty("Chicken");

        Burger burger2 = new Burger();
        burger2.addBun("Brioche");
        burger2.addPatty("Impossible");

        double expected = (2.00 + 1.00) + (2.50 + 0.75);
        double total = burger1.getPrice() + burger2.getPrice();
        assertEquals(expected, total, 0.01);
    }

    @Test
    public void testSortedPriceList() {
        Burger burger = new Burger();
        burger.addBun("Sesame");     // 2.00
        burger.addCheese("Pepper Jack"); // 1.00
        burger.addTopping("Lettuce");   // 0.10
        burger.addPatty("Veg");      // 1.50

        var sorted = burger.getSortedPrice();

        assertEquals(List.of(0.10, 1.00, 1.50, 2.00), sorted);
    }
}
