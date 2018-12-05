package recipes;

import java.util.ArrayList;
import java.util.List;

public class RecipeManager {
    /*-----------------properties--------------*/
    private List<Recipe> recipeList;
    /*-----------------Constructors--------------*/
    public RecipeManager()
    {
      recipeList = new ArrayList<Recipe>();
    }
    /*-----------------Getters and setters--------------*/
    /*-----------------Methods--------------*/
    public boolean add(Recipe newRecipe)
    {
        boolean isAdded = add(newRecipe.getName(), newRecipe.getDescription(), newRecipe.getCategory(),newRecipe.getIngridents());
        return isAdded;
    }
    // A method add recipe to the list
    public boolean add(String name,String description, FoodCategory category, String[] ingridents)
    {
        if(validate(name)&& validate(description)&& validate(ingridents) && validate(category)){
          Recipe recipe = new Recipe(50,name,description,ingridents,category);
          recipeList.add(recipe);
         return true;
        }
        return false;
    }
    //update the recipe for a particular index
    public boolean editRecipe(int index, Recipe recipe)
    {
        if(checkIndex(index))
        {
            recipeList.set(index,recipe);
            return true;
        }
        return false;
    }
    public boolean deletedRecipe(int index)
    {
        if (checkIndex(index))
        {
        recipeList.remove(index);
        return true;
        }
        return false;
    }
    public Recipe getRecipeAt(int index)
    {
        if (checkIndex(index))
            return recipeList.get(index);
        else
            return null;
    }
    public String[] getRecipeInfo()
    {
        String[] strInfo = new String[recipeList.size()];
        int i = 0;
        for(Recipe recipe : recipeList)
        {
          strInfo[i++] = recipe.toString();
        }
        return strInfo;
    }
    private boolean checkIndex(int index)
    {
        return index >= 0 && index < recipeList.size();
    }
    public boolean validate(Object input)
    {
        if (input=="" || input==null)
         throw new NullPointerException("Null/Empty!");
        //return !(input==" " || input==null);
        return true;
    }

}
