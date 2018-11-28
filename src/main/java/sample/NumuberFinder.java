package sample;

/**
 * This class finds the smallest and the largest number form the given array
 */
public class NumuberFinder {
    //set the smallest
    private int smallest=Integer.MAX_VALUE;
    private  int largest=Integer.MIN_VALUE;
    //A method that finds both the smallest and the largest number from the array of integers
    public void find(int [] number){
        for(int num : number){
            if(num < smallest ){
                smallest=num;
            }if(num > largest){//the logic fails for inputs of array in decreasing order for if-else if
                largest=num;
            }
        }
    }
    //Getter-get the smallest number from the list of numbers
    public int getSmallest(){
        return smallest;
    }
    //Getter-get the largest number from the list of numbers
    public int getLargest(){
        return largest;
    }
}
