package sample;
import java.util.Map;
import java.util.HashMap;
/**
 * This class converts roman number to number numbers
 */

public class RomanNumeral {
    private static Map<Character,Integer>map;
    static {
        map=new HashMap<Character,Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }
    public int convert(String s) {
        return 0;
    }
}
