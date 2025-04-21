import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode: 781. Rabbits in Forest
 */
public class RabbitsInForest {
    public static void main(String[] args) {
        System.out.println(new RabbitsInForest().numRabbits(new int[]{1, 1, 2}));
        System.out.println(new RabbitsInForest().numRabbits(new int[]{10, 10, 10}));
//        //1,0,1,0,0
        System.out.println(new RabbitsInForest().numRabbits(new int[]{1,0,1,0,0}));
        System.out.println(new RabbitsInForest().numRabbits(new int[]{1, 1, 1, 0, 0}));
    }

    public int numRabbits(int[] answers) {

        Map<Integer, Integer> ansCountMap = new HashMap<>();

        for (int ans : answers) {
            ansCountMap.put(ans, ansCountMap.getOrDefault(ans, 0) + 1);
        }

        int rabbits = 0;
        for (Map.Entry<Integer, Integer> entry : ansCountMap.entrySet()) {
            int otherCount = entry.getKey();
            int votes = entry.getValue();

            while (votes > 0) {
                rabbits += otherCount + 1;
                votes -= (otherCount + 1);
            }

        }
        return rabbits;

    }


}
