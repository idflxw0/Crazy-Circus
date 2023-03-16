package Game;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private List<String> players; // Liste des joueurs
    private  String currentPlayer; // Joueur courant
    private static int score; // Score du joueur
    private int error; // Nombre d'erreur du joueur
    private boolean canPlay; // Peut-il jouer?

    public Player(String player) { // Constructeur
        this.players = new LinkedList<>(); // On crée une liste de joueurs
        this.currentPlayer = player; // On définit le joueur courant
        this.players.add(player); // On ajoute le joueur courant à la liste des joueurs
        score = 0; // On initialise le score à 0
        error = 0; // On initialise le nombre d'erreur à 0
        canPlay = true; // On initialise le fait que le joueur peut jouer à true
    }

    //------------Getters----------------
    /**
     * @brif permet de récupérer la liste des joueurs
     * @return the players
     */
    public List<String> getPlayers() {
        return players;
    }

    /**
     * @breif permet de récupérer le score du joueur
     * @return the score
     */
    public static int getScore() {
        return score;
    }

    /**
     * @breif permet de récupérer le nombre d'erreur du joueur
     * @return the error
     */
    public int getError() {
        return error;
    }

    /**
     * @breif permet de récupérer le fait que le joueur peut jouer
     * @return the peutJouer
     */
    public boolean canPlay() {
        return canPlay;
    }
    /**
     * @breif permet de récupérer le joueur courant
     * @return the currentPlayer
     */

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
     * @breif permet d'ajouter un point au joueur
     */
    public void setScore() {
        score++;
    }
    /**
     * @breif permet d'ajouter une erreur au joueur
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
