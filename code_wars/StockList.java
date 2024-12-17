import java.util.HashMap;
import java.util.Map;

public class StockList {
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {

        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<String, Integer> countOfBookInCategory = new HashMap<>();

        for (String category : lstOf1stLetter) {
            countOfBookInCategory.put(category, 0);
        }

        for (String bookName : lstOfArt) {
            String[] parts = bookName.split(" ");
            String category = parts[0].substring(0, 1);
            int quantity = Integer.parseInt(parts[1]);

            if (countOfBookInCategory.containsKey(category)) {
                countOfBookInCategory.put(category, countOfBookInCategory.get(category) + quantity);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            String category = lstOf1stLetter[i];
            int count = countOfBookInCategory.get(category);
            result.append("(").append(category).append(" : ").append(count).append(")");
            if (i < lstOf1stLetter.length - 1) {
                result.append(" - ");
            }
        }

        return result.toString();
    }
}

