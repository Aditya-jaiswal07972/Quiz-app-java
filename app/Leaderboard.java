package app;
import java.util.*;

public class Leaderboard {
    static ArrayList<Player> scores = new ArrayList<>();

    public static void addScore(String name, int score) {
        scores.add(new Player(name, score));
        scores.sort((p1, p2) -> p2.score - p1.score);
    }

    public static ArrayList<Player> getScores() {
        return scores;
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
