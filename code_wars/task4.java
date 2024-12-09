public class task4 {
  
    public static int[] squareOrSquareRoot(int[] array) {
        int[] resArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            double sqrt = Math.sqrt(array[i]);
            if (sqrt == (int) sqrt) {
                resArray[i] = (int) sqrt;
            } else {
                resArray[i] = array[i] * array[i];
            }
        }
        return resArray;
    }
  }

