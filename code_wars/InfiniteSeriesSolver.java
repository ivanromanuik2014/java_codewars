public class InfiniteSeriesSolver {

    public static double solve(double m) {
        if (m <= 0) {
            throw new IllegalArgumentException("Parameter m must be greater than 0.");
        }

        // Встановлюємо початкові межі пошуку
        double left = 0.0;
        double right = 1.0;
        double epsilon = 1e-12; // Допустима похибка

        // Двійковий пошук
        while ((right - left) > epsilon) {
            double mid = (left + right) / 2;
            double s = sum(mid); // Обчислення значення суми

            if (s > m) {
                // Якщо значення суми більше за m, зменшуємо праву межу
                right = mid;
            } else {
                // Інакше збільшуємо ліву межу
                left = mid;
            }
        }

        // Повертаємо середнє значення між left і right як результат
        return (left + right) / 2;
    }

    // Метод для обчислення значення суми ряду S(x) = x / (1 - x)^2
    private static double sum(double x) {
        return x / Math.pow(1 - x, 2);
    }

    public static void main(String[] args) {
        // Тестування функції
        System.out.println(solve(2.0)); // Очікується 0.5
        System.out.println(solve(8.0)); // Очікується приблизно 0.7034648345913732
    }
}

