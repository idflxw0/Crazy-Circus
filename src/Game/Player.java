package Game;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private List<String> players;
    private  String currentPlayer;
    private static int score;
    private int error;
    private boolean canPlay;

    public Player(String player) {
        this.players = new LinkedList<>();
        this.currentPlayer = player;
        this.players.add(player);
        score = 0;
        error = 0;
        canPlay = true;
    }

    //------------Getters----------------
    public List<String> getPlayers() {
        return players;
    }
    public static int getScore() {
        return score;
    }
    public int getError() {
        return error;
    }
    public boolean canPlay() {
        return canPlay;
    }

    public String getName() {
        return this.currentPlayer;
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
    public void setScore() {
        score++;
    }
    /**
     * @param L'erreur to set
     */
    public void setError() {
        error++;
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
        return  getPlayers().toString() +  " [points=" + getScore() + ", erreur=" + getError() + "]";
    }
}
