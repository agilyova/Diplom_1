package praktikum.ingredientType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeParametrizedTest {
    private IngredientType ingredientType;
    private String ingredientTypeValue;

    public IngredientTypeParametrizedTest(IngredientType ingredientType, String ingredientTypeValue) {
        this.ingredientType = ingredientType;
        this.ingredientTypeValue = ingredientTypeValue;
    }

    @Parameterized.Parameters
    public static Object[][] setParameters() {
        return new Object[][]{
                {SAUCE, "SAUCE"},
                {FILLING, "FILLING"}
        };
    }

    @Test
    public void ingredientTypeReturnCorrectValueOf() {
        assertEquals(ingredientType, IngredientType.valueOf(ingredientTypeValue));
    }
}
