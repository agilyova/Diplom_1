package praktikum.ingredient;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientConstructorPricePositiveParametrizedTest {

    private static final String REGULAR_NAME = "Острый соус";
    private static final float INTEGER_PRICE = (float) new Faker().number().numberBetween(1, 5000);
    private static final float FLOAT_PRICE = (float) new Faker().number().randomDouble(5, 100, 5000);
    private static final float ZERO_PRICE = 0;
    private static final double DELTA = 0.01;

    private float price;

    public IngredientConstructorPricePositiveParametrizedTest(Float price) {
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setParameters() {
        return new Object[][] {
                {INTEGER_PRICE},
                {FLOAT_PRICE},
                {ZERO_PRICE}
        };
    }

    @Test
    public void constructorSetPriceCorrect() {
        Ingredient ingredient = new Ingredient(SAUCE, REGULAR_NAME, price);

        assertEquals(price, ingredient.price, DELTA);
    }
}
