package contest.y2025;

import java.util.HashSet;
import java.util.Set;

public class PerformingInstructions {
    public static void main(String[] args) {
        System.out.println(new PerformingInstructions().calculateScore(new String[]{"jump","add","add","jump","add","jump"}, new int[]{2,1,3,1,-2,-3}));
        System.out.println(new PerformingInstructions().calculateScore(new String[]{"jump"}, new int[]{0}));
    }

    public long calculateScore(String[] instructions, int[] values) {

        long score = 0;
        int i = 0;
        Set<Integer> visited = new HashSet<>();
        while (i >= 0 && i < instructions.length && !visited.contains(i)) {
            visited.add(i);
            if (instructions[i].equals("add")) {
                score += values[i];
                i++;
            } else {
                i += values[i];
            }
        }

        return score;
    }
}
