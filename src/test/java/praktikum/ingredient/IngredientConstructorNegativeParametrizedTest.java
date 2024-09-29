package praktikum.ingredient;

import com.github.javafaker.Faker;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;

@RunWith(Parameterized.class)
public class IngredientConstructorNegativeParametrizedTest {
    private String name;
    private float price;

    private static final String REGULAR_NAME = "Острый соус";
    private static final float REGULAR_PRICE = 300;
    private static final String EMPTY_STRING = "";
    private static final String WHITE_SPACE_STRING = "";
    private static final float negativePrice = new Faker().number().numberBetween(-500, -100);

    public IngredientConstructorNegativeParametrizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setParameters() {
        return new Object[][] {
                {REGULAR_NAME, negativePrice},
                {EMPTY_STRING, REGULAR_PRICE},
                {WHITE_SPACE_STRING, REGULAR_PRICE}
        };
    }

    @Ignore("Не реализовано")
    @Test(expected = IllegalArgumentException.class)
    public void constructorNegativeValuesReturnError() {
        new Ingredient(FILLING, name, price);
    }
}
