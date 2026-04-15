import java.util.*;
public class freq{
    public static void main(String[] args) {
      int[] arr={1,2,3,1,1,1,2,4,3};
        Map<Integer,Integer> Map = new HashMap<>();

        for (int i:arr) {
          Map.put(i, Map.getOrDefault(c, 0) + 1);
        }

        System.out.println("Character Frequency:");
        for (Map.Entry<Integer, Integer> entry :  Map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}