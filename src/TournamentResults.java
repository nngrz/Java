import java.util.Arrays;

public class TournamentResults {
    // The helper function returns index in the four-element array of total scores for each team
    public static int getIndex(String team) {
        return switch (team) {
            case "Germany" -> 0;
            case "Ireland" -> 1;
            case "Poland" -> 2;
            case "Scotland" -> 3;
            default -> -1; // Code unreachable
        };
    }

    public static void main (String[] args) {
        String[][] arr =
            { {"Germany",  "2", "Scotland", "1"},
                {"Poland",   "2", "Germany",  "0"},
                {"Germany",  "1", "Ireland",  "1"},
                {"Poland",   "2", "Scotland", "2"},
                {"Scotland", "1", "Ireland",  "0"},
                {"Ireland",  "1", "Poland",   "1"},
                {"Ireland",  "1", "Scotland", "1"},
                {"Germany",  "3", "Poland",   "1"},
                {"Scotland", "2", "Germany",  "3"},
                {"Ireland",  "1", "Germany",  "0"},
                {"Scotland", "2", "Poland",   "2"},
                {"Poland",   "2", "Ireland",  "1"} };

        // A four-element array of ints representing scores of teams of Germany, Ireland, Poland and Scotland
        int[] scoreTeams = new int[4];

        for (int i = 0; i < arr.length; i++) {
            String team1 = arr[i][0];
            String team2 = arr[i][2];
            int score1 = Integer.parseInt(arr[i][1]);
            int score2 = Integer.parseInt(arr[i][3]);

            int team1Index = getIndex(team1);
            int team2Index = getIndex(team2);

            if (score1 > score2) {
                scoreTeams[team1Index] += 3; // Team 1 wins
            } else if (score1 < score2) {
                scoreTeams[team2Index] += 3; // Team 2 wins
            } else {
                scoreTeams[team1Index] += 1; // Draw
                scoreTeams[team2Index] += 1; // Draw
            }
        }
        System.out.println(Arrays.toString(scoreTeams));
    }
}
