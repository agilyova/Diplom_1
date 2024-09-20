package praktikum.bun;

import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final String REGULAR_NAME = "black bun";
    private final float REGULAR_PRICE = 100;
    private final double DELTA = 0.01;

    @Test
    public void constructorSetsNameCorrect() {
        Bun bun = new Bun(REGULAR_NAME, REGULAR_PRICE);

        assertEquals(REGULAR_NAME, bun.name);
    }

    @Test
    public void constructorSetsPriceCorrect() {
        Bun bun = new Bun(REGULAR_NAME, REGULAR_PRICE);

        assertEquals(REGULAR_PRICE, bun.price, DELTA);
    }

    @Test
    public void getNameReturnName() {
        Bun bun = new Bun(REGULAR_NAME, REGULAR_PRICE);

        assertEquals(REGULAR_NAME, bun.getName());
    }

    @Test
    public void getPriceReturnPrice() {
        Bun bun = new Bun(REGULAR_NAME, REGULAR_PRICE);

        assertEquals(REGULAR_PRICE, bun.getPrice(), DELTA);
    }
}