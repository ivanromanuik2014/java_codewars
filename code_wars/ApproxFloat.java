class ApproxFloat {

    public static double f(double x) {
        if (Math.abs(x) < 1e-15) {
            // Використовуємо числову ідентичність для малих x
            return x / (Math.sqrt(1 + x) + 1);
        } else {
            // Для більших значень x використовуємо оригінальну формулу
            return Math.sqrt(1 + x) - 1;
        }
    }
}