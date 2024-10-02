package praktikum.bun;

import com.github.javafaker.Faker;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunConstructorNegativeParametrizedTest {
    private String name;
    private float price;

    private static final String REGULAR_NAME = "black bun";
    private static final String EMPTY_STRING = "";
    private static final String WHITE_SPACE_STRING = " ";
    private static final float REGULAR_PRICE = 100;
    private static final float ZERO_PRICE = 0;
    private static final float NEGATIVE_PRICE = new Faker().number().numberBetween(-5000, -10);

    public BunConstructorNegativeParametrizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setParameters() {
        return new Object[][] {
                {REGULAR_NAME, ZERO_PRICE},
                {REGULAR_NAME, NEGATIVE_PRICE},
                {EMPTY_STRING, REGULAR_PRICE},
                {WHITE_SPACE_STRING, REGULAR_PRICE}
        };
    }

    @Ignore("Не реализовано")
    @Test(expected = IllegalArgumentException.class)
    public void constructorNegativeValuesReturnError() {
        new Bun(name, price);
    }
}
