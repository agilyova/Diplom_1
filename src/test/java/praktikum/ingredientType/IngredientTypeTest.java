package praktikum.ingredientType;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeEnumContainsCorrectValues() {
        IngredientType[] expectedArray = {SAUCE, FILLING};
        IngredientType[] factArray = IngredientType.values();

        assertEquals(expectedArray, factArray);
    }
}