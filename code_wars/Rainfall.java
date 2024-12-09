public class Rainfall {
    
    public static double mean(String town, String strng) {
        // Розбиваємо вхідний рядок на окремі міста
        String[] townsData = strng.split("\n");

        // Перебираємо кожне місто
        for (String townData : townsData) {
            // Розділяємо на назву міста та дані про опади
            String[] parts = townData.split(":");
            String name = parts[0].trim();
            String[] rainfallData = parts[1].trim().split(",");

            // Якщо знайдено потрібне місто, обчислюємо середнє
            if (name.equals(town)) {
                double sum = 0;
                for (String rainfall : rainfallData) {
                    // Отримуємо значення опадів, розділяючи за пробілом
                    String[] monthData = rainfall.split(" ");
                    sum += Double.parseDouble(monthData[1]);
                }
                return sum / rainfallData.length;
            }
        }
        // Якщо місто не знайдено, повертаємо -1
        return -1.0;
    }

    // Функція для обчислення дисперсії
    public static double variance(String town, String strng) {
        String[] townsData = strng.split("\n");
        
        for (String townData : townsData) {
            String[] parts = townData.split(":");
            String name = parts[0].trim();
            String[] rainfallData = parts[1].trim().split(",");
            
            if (name.equals(town)) {
                double sum = 0;
                for (String rainfall : rainfallData) {
                    String[] monthData = rainfall.split(" ");
                    sum += Double.parseDouble(monthData[1]);
                }
                double mean = sum / rainfallData.length;

                double variance = 0;
                for (String rainfall : rainfallData) {
                    String[] monthData = rainfall.split(" ");
                    variance += Math.pow(Double.parseDouble(monthData[1]) - mean, 2);
                }
                // Для вибіркової дисперсії ділимо на (n-1)
                return variance / (rainfallData.length);
            }
        }
        return -1.0;
    }
}