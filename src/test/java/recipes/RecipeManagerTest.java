package recipes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class RecipeManagerTest {
    private Recipe recipe;
    private RecipeManager recipeManager;
    private FoodCategory foodCategory;

    @BeforeEach
    void setUp() {
        recipe = Mockito.mock(Recipe.class);
        recipeManager = new RecipeManager();
    }

    @Test
    void testRecipeManager() {
        recipe.setCategory(FoodCategory.Meat);
        recipe.setName("ketefo");
        recipe.setDescription("Ingredients of the Steak Tartar (Kitfo) which is prepared from lamb meat");
        String[] ketefoIngrident = new String[]{"2 lbs top round beef (freshly cut)",
                "6 teaspoons ground cayenne pepper (Mitmita*) ",
                "4 tablespoons clarified butter (Nitir Kebe)",
                "1 teaspoon cardamom powder (korerima)",
                "1⁄4 teaspoon garlic powder (optional)",
                "salt and black pepper."
        };
        recipe.addIngredients(ketefoIngrident);
        recipeManager.add(recipe);
        when(recipeManager.add(recipe)).thenReturn(true);
        assertAll("Test dependencies",
                () -> assertEquals("ketefo", recipe.getName()),
                () -> assertEquals(FoodCategory.Meat, recipe.getCategory())
        );
    }

}
