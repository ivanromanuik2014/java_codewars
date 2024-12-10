public class ASum {

    public static long findNb(long m) {
        long n = 0;
        long totalValue = 0;

        while (totalValue < m) {
            n++;
            totalValue += n * n * n;
            if (totalValue == m) {
                return n;
            }
        }
        return -1L;
    }
}
