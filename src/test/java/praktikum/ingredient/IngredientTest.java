package praktikum.ingredient;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;

import java.util.Locale;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;

public class IngredientTest {

    private static final String REGULAR_NAME = "Острый соус";
    private static final float REGULAR_PRICE = 300;
    private static final double DELTA = 0.01;

    @Test
    public void constructorSetNameCorrect() {
        String name = new Faker(new Locale("ru")).lorem().sentence(2,3);
        Ingredient ingredient = new Ingredient(FILLING, name, REGULAR_PRICE);

        assertEquals(name, ingredient.name);
    }

    @Test
    public void getPriceReturnPrice() {
        Ingredient ingredient = new Ingredient(FILLING, REGULAR_NAME, REGULAR_PRICE);
        Assert.assertEquals(REGULAR_PRICE, ingredient.getPrice(), DELTA);
    }

    @Test
    public void getNameReturnName() {
        Ingredient ingredient = new Ingredient(FILLING, REGULAR_NAME, REGULAR_PRICE);
        Assert.assertEquals(REGULAR_NAME, ingredient.getName());
    }

    @Test
    public void getTypeReturnType() {
        Ingredient ingredient = new Ingredient(FILLING, REGULAR_NAME, REGULAR_PRICE);
        Assert.assertEquals(FILLING, ingredient.getType());
    }
}