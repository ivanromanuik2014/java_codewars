public class task5 {
    public static int[] processArray(int[] input) {

        if (input == null || input.length == 0) {
            return new int[0];
        }

        int countPositives = 0;
        int sumNegatives = 0;

        for (int i : input) {
            if (i > 0) {
                countPositives++;
            } else if (i < 0) {
                sumNegatives += i;
            }
        }

        return new int[] { countPositives, sumNegatives };
    }
}
