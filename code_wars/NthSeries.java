public class NthSeries {

    public static String seriesSum(int n) {
        if (n == 0) {
            return "0.00";
        }

        double totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += 1.0d / (3 * i + 1);
        }

        return String.format("%.2f", totalSum);
    }
}