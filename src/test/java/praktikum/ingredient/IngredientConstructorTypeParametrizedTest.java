package praktikum.ingredient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientConstructorTypeParametrizedTest {

    private final static String REGULAR_NAME = "Острый соус";
    private final static float REGULAR_PRICE = (float) 300;

    private IngredientType type;
    private String name;
    private float price;


    public IngredientConstructorTypeParametrizedTest(IngredientType type, String name, Float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setParameters() {
        return new Object[][] {
                {SAUCE, REGULAR_NAME, REGULAR_PRICE},
                {FILLING, REGULAR_NAME, REGULAR_PRICE},
        };
    }

    @Test
    public void constructorSetTypeCorrect() {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.type);
    }
}
