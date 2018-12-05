package recipes;

public class Recipe {
    /*-----------------properties--------------*/
    private FoodCategory category; //See the enum FoodCategory
    private String description;//Cooking instructions and other info
    private String[] ingridents; //List for saving ingredients Ex, "2 dl milk", "4 large Eggs", etc.
    private String name; //name of the recipe
    private int size;
    /*-----------------Constructors--------------*/
    public Recipe(int maxNumberOfIngredients,Recipe recipe) {
        this(maxNumberOfIngredients,recipe.name, recipe.description, recipe.ingridents, recipe.category);
    }
    public Recipe(int maxNumberOfIngredients,String name, String description, String[] ingridents, FoodCategory category )
    {
        if (validate(name) && validate(ingridents)) {
            ingridents = new String[maxNumberOfIngredients];
            this.name = name;
            this.description = description;
            this.category = category;
            this.ingridents = ingridents;
            size=0;
        }
    }
    /*-----------------Getters and setters--------------*/
    public FoodCategory getCategory(){
        return category;
    }
    public void setCategory(FoodCategory category){
        if(validate(category)){
            this.category=category;
        }
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        if(validate(description)){
            this.description=description;
        }
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        if(validate(name)){
            this.name=name;
        }
    }
   public String[] getIngridents(){
        return  ingridents;
   }
   public  void setIngridents(String[] ingridents){
        this.ingridents=ingridents;
   }
    /* The capacity of the array -> the maximum number that can be saved
     * in a recipe object is that size of the array
     */
    public int maxNumOfIngredients()
    {
     return ingridents.length;
    }
    public int currentNumOfIngredients()
    {
        return size;
    }
    /*-----------------Methods--------------*/
    public boolean addIngredients(String value)
    {
        if (!isIngredientFull())
        {
            ingridents[size++] = value;
            return true;
        }
        return false;
    }
    public boolean addIngredients(String[] value)
    {
        if (value.length <=ingridents.length && ingridents.length==0)
        {
            int i=0;
            for(String val:value){
                ingridents[i] = value[i];
            }

           return true;
        }
        return false;
    }
    public boolean changeIngredientsAt(int index, String value)
    {
        if(checkIndex(index))
        {
            ingridents[index] = value;//update
            return true;
        }
        return false;
    }
    public boolean deleteIngredientAt(int index)
    {
        if (checkIndex(index))
        {
            removeSpace(index);
            size--;
            return true;
        }
        return false;
    }
    public String getIngrident(int index) {
        if (checkIndex(index)) {
            return ingridents[index];
        }
        return null;
    }
    private void removeSpace(int index)
    {
        /* remove space */
        for (int i = index+1; i < ingridents.length; i++)
            ingridents[i-1] = ingridents[i];
    }
    private boolean checkIndex(int index)
    {
        return index >= 0 && index < ingridents.length;
    }
    private boolean isIngredientFull() {
        return size < ingridents.length;
    }
    private boolean validate(Object input)
    {
        if (input=="" || input==null)
            throw new NullPointerException(" Null/Empty is not allowed");
        return true;
    }
}
