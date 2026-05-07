import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> table = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;

            while ((line = br.readLine()) != null) {

                // Split into two teams
                String[] parts = line.split(",");

                String[] team1Data = parts[0].trim().split(" ");
                String[] team2Data = parts[1].trim().split(" ");

                int score1 = Integer.parseInt(team1Data[team1Data.length - 1]);
                int score2 = Integer.parseInt(team2Data[team2Data.length - 1]);

                String team1 = String.join(" ",
                        Arrays.copyOf(team1Data, team1Data.length - 1));

                String team2 = String.join(" ",
                        Arrays.copyOf(team2Data, team2Data.length - 1));

                table.putIfAbsent(team1, 0);
                table.putIfAbsent(team2, 0);

                if (score1 > score2) {
                    table.put(team1, table.get(team1) + 3);
                } else if (score2 > score1) {
                    table.put(team2, table.get(team2) + 3);
                } else {
                    table.put(team1, table.get(team1) + 1);
                    table.put(team2, table.get(team2) + 1);
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error reading file.");
            return;
        }

        // Convert to list for sorting
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(table.entrySet());

        list.sort((a, b) -> {
            if (!b.getValue().equals(a.getValue())) {
                return b.getValue() - a.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        });

        int rank = 1;
        int previousPoints = -1;

        for (int i = 0; i < list.size(); i++) {

            int points = list.get(i).getValue();

            if (points != previousPoints) {
                rank = i + 1;
            }

            System.out.println(rank + ". " + list.get(i).getKey());
            System.out.println(points);

            previousPoints = points;
        }
    }
}