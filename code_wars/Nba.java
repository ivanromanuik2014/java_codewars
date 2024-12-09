import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nba {

    public static String nbaCup(String resultSheet, String toFind) {

        if (toFind == null || toFind.isEmpty()) {
            return "";
        }

        int countWins = 0, countDraw = 0, countLose = 0, countScored = 0, countConceded = 0, countPoints = 0;

        ArrayList<String> matches = new ArrayList<>();
        for (String item : resultSheet.split(",")) {
            if (item.contains(toFind)) {
                matches.add(item);
            }
        }

        Pattern pattern = Pattern.compile("(.+?)\\s(\\d+)\\s(.+?)\\s(\\d+)$");
        for (String match : matches) {
            match = match.trim();
            Matcher matcher = pattern.matcher(match);

            if (!matcher.find()) {
                if (match.matches(".*\\d+\\.\\d+.*")) {
                    return "Error(float number):" + match;
                }
                continue;
            }

            String team1 = matcher.group(1).trim();
            Integer score1 = Integer.parseInt(matcher.group(2));
            String team2 = matcher.group(3).trim();
            Integer score2 = Integer.parseInt(matcher.group(4));

            if (!team1.equals(toFind) && !team2.equals(toFind)) {
                return toFind + ":This team didn't play!";
            }

            if (team1.equals(toFind)) {
                if (score1 > score2) {
                    countWins++;
                } else if (score1 == score2) {
                    countDraw++;
                } else if (score1 < score2) {
                    countLose++;
                }
                countScored += score1;
                countConceded += score2;
            }
            if (team2.equals(toFind)) {
                if (score2 > score1) {
                    countWins++;
                } else if (score2 == score1) {
                    countDraw++;
                } else if (score2 < score1) {
                    countLose++;
                }
                countScored += score2;
                countConceded += score1;
            }
        }

        countPoints = countWins * 3 + countDraw;

        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, countWins, countDraw, countLose, countScored, countConceded, countPoints);
    }
}
