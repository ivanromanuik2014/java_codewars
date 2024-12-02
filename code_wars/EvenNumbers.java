import java.util.ArrayList;

public class EvenNumbers {
    public static int[] divisibleBy(int[] numbers, int divider) {
        ArrayList<Integer> resList = new ArrayList<>();
        
        for (int item : numbers) {
            if (item % divider == 0) {
                resList.add(item);
            }
        }

        return resList.stream().mapToInt(Integer::intValue).toArray();
    }
}
