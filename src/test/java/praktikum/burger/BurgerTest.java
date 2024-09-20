package praktikum.burger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private final float BUN_PRICE = 300;
    private final String BUN_NAME = "black bun";
    private final float FIRST_INGREDIENT_PRICE = 125;
    private final String FIRST_INGREDIENT_NAME = "hot sauce";
    private final float SECOND_INGREDIENT_PRICE = 100.5F;
    private final String SECOND_INGREDIENT_NAME = "cutlet";
    private final float EXPECTED_BURGER_WITH_ZERO_INGREDIENTS_PRICE = 600;
    private final float EXPECTED_BURGER_WITH_ONE_INGREDIENT_PRICE = 725;
    private final float EXPECTED_BURGER_WITH_TWO_INGREDIENTS_PRICE = 825.5F;
    private final double DELTA = 0.01;
    private final String LS = System.lineSeparator();

    @Mock
    private Bun bun;

    @Mock
    private Ingredient firstIngredient;

    @Mock
    private Ingredient secondIngredient;

    @Spy
    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsSetBunsCorrect() {
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientOneIngredientSetCorrect() {
        burger.addIngredient(firstIngredient);

        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(firstIngredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientRemoveCorrect() {
        burger.ingredients.add(firstIngredient);
        burger.removeIngredient(0);

        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Ignore("Обработка не реализована")
    @Test
    public void removeIngredientOutOfBoundReturnErrorMessage() {
        try {
            burger.ingredients.add(firstIngredient);
            burger.removeIngredient(burger.ingredients.size());
        }
        catch (IndexOutOfBoundsException e) {
            assertEquals("Данного ингридиента нет в бугере", e.getMessage());
        }
    }

    @Test
    public void moveIngredientMoveItemOnCorrectIndex() {
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);

        burger.moveIngredient(0, 1);

        Assert.assertEquals(firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void moveIngredientNotMovedItemStayInList() {
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);

        burger.moveIngredient(0, 1);

        assertEquals(secondIngredient, burger.ingredients.get(0));
    }

    @Ignore("Обработка не реализована")
    @Test
    public void moveIngredientNewIndexOutOfBoundReturnMessage() {
        try {
            burger.ingredients.add(firstIngredient);
            burger.ingredients.add(secondIngredient);
            burger.moveIngredient(0, burger.ingredients.size());
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Невозможно переместить ингридиент на данную позицию", e.getMessage());
        }
    }

    @Test
    public void getPriceOneIngredientReturnCorrectPrice() {
        burger.bun = bun;
        burger.ingredients.add(firstIngredient);

        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(firstIngredient.getPrice()).thenReturn(FIRST_INGREDIENT_PRICE);

        Assert.assertEquals(EXPECTED_BURGER_WITH_ONE_INGREDIENT_PRICE, burger.getPrice(), DELTA);
    }

    @Test
    public void getPriceSeveralIngredientsReturnCorrectPrice() {
        burger.bun = bun;
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);

        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(firstIngredient.getPrice()).thenReturn(FIRST_INGREDIENT_PRICE);
        Mockito.when(secondIngredient.getPrice()).thenReturn(SECOND_INGREDIENT_PRICE);

        Assert.assertEquals(EXPECTED_BURGER_WITH_TWO_INGREDIENTS_PRICE, burger.getPrice(), DELTA);
    }

    @Test
    public void getPriceZeroIngredientsReturnCorrectPrice() {
        burger.bun = bun;
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);

        Assert.assertEquals(EXPECTED_BURGER_WITH_ZERO_INGREDIENTS_PRICE, burger.getPrice(), DELTA);
    }

    @Ignore("Npe, не обаботана ситуация, когда не добавлена булка")
    @Test
    public void getPriceZeroBunReturnCorrectPrice() {
        burger.ingredients.add(firstIngredient);
        Mockito.when(firstIngredient.getPrice()).thenReturn(FIRST_INGREDIENT_PRICE);

        Assert.assertEquals(FIRST_INGREDIENT_PRICE, burger.getPrice(), DELTA);
    }

    @Test
    public void getReceiptBunAndOneIngredientReturnReceipt() {
        burger.bun = bun;
        burger.ingredients.add(firstIngredient);
        Mockito.when(burger.bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(firstIngredient.getName()).thenReturn(FIRST_INGREDIENT_NAME);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(burger.getPrice()).thenReturn(EXPECTED_BURGER_WITH_ONE_INGREDIENT_PRICE);
        String expectedReceipt = "" +
                "(==== " + BUN_NAME + " ====)" + LS +
                "= sauce " + FIRST_INGREDIENT_NAME + " =" + LS +
                "(==== " + BUN_NAME + " ====)" + LS +
                LS +
                "Price: 725,000000" + LS;

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void getReceiptBunAndTwoIngredientReturnReceipt() {
        burger.bun = bun;
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        Mockito.when(burger.bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(firstIngredient.getName()).thenReturn(FIRST_INGREDIENT_NAME);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn(SECOND_INGREDIENT_NAME);
        Mockito.when(burger.getPrice()).thenReturn(EXPECTED_BURGER_WITH_TWO_INGREDIENTS_PRICE);
        String expectedReceipt = "" +
                "(==== " + BUN_NAME + " ====)" + LS +
                "= sauce " + FIRST_INGREDIENT_NAME + " =" + LS +
                "= filling " + SECOND_INGREDIENT_NAME + " =" + LS +
                "(==== " + BUN_NAME + " ====)" + LS +
                LS +
                "Price: 825,500000" + LS;

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}