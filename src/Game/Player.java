package Game;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private List<String> players;
    private int score;
    private int error;
    private boolean canPlay;

    public Player(String player) {
        this.players = new LinkedList<>();
        this.players.add(player);
        score = 0;
        error = 0;
        canPlay = false;
    }

    //------------Getters----------------
    public List<String> getPlayers() {
        return players;
    }
    public int getScore() {
        return score;
    }
    public int getError() {
        return error;
    }
    public boolean canPlay() {
        return canPlay;
    }

    //------------Setters----------------
    /**
     * @param player Le joueur to set
     */
    public void addPlayer(String player) {
        this.players.add(player);
    }
    /**
     * @param points Les points to set
     */
    public void setScore(int points) {
        this.score = points;
    }
    /**
     * @param error L'erreur to set
     */
    public void setError(int error) {
        this.error = error;
    }
    /**
     * @param canPlay the peutJouer to set
     */
    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }

    //------------Methods----------------
    @Override
    public String toString() {
        return "Joueur [joueur=" + getPlayers() + ", points=" + getScore() + ", erreur=" + getError() + "]";
    }
}
