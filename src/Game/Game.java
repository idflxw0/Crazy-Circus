package Game;

import Card.*;

import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.*;

public class Game {
    private static final int MAX_CARDS = 24;
    private static Card card;
    private static LinkedList<Player> players;
    private static Podium startingPodium;
    private static Podium objectivePodium;
    private ArrayList<Card> cards;
    private static boolean gameOver;
    private int numPlayers;

    //------------Constructors----------------
    public Game(String[] args) {
        players = new LinkedList<>();
        card = new Card();
        gameOver = false;
        card.createCards();
        addPlayer(args);
        FirstGame();
    }

    public static void getScore() {
        System.out.println(Player.getScore());
    }

    /**
     * @param name Le nom du joueur
     * @return true si le nom du joueur est déjà pris, false sinon
     * @brief Permet de savoir si le nom du joueur est déjà pris
     */
    public static boolean PlayerExists(String name) {
        return eleminateDoubles(new Player(name)); // On crée un joueur temporaire pour pouvoir utiliser la méthode eleminateDoubles: true si le nom du joueur est déjà pris, false sinon
    }

    /**
     * @param p Le joueur
     * @return true si le nom du joueur est déjà pris, false sinon
     * @brief Permet de verifier si le nom du joueur est déjà pris
     */
    public static boolean eleminateDoubles(Player p) {
        for (Player player : players) {
            if (player != p && player.getPlayers().equals(p.getPlayers())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param startingPodium  Le podium de départ
     * @param objectivePodium Le podium d'objectif
     * @return true si les deux podiums ont la même longueur, false sinon
     * @breif Permet de savoir si les deux podiums ont la même longueur
     */
    public static boolean sameLength(Podium startingPodium, Podium objectivePodium) {
        return startingPodium.getLength_blue() == objectivePodium.getLength_blue() && startingPodium.getLength_red() == objectivePodium.getLength_red();
    }

    /**
     * @param startingPodium Le podium de départ
     * @breif Permet de mettre à jour la longueur des podiums
     */
    public static void updateLength(Podium startingPodium) {
        startingPodium.setBlueLength();
        startingPodium.setRedLength();
    }

    /**
     * @param startingPodium  Le podium de départ
     * @param objectivePodium Le podium d'objectif
     * @return true si les animaux sur les deux podiums sont à la même position, false sinon
     * @breif Permet de savoir si les animaux sur les deux podiums sont à la même position
     */
    public static boolean samePosition(Podium startingPodium, Podium objectivePodium) {
        return startingPodium.getBlue().equals(objectivePodium.getBlue()) && startingPodium.getRed().equals(objectivePodium.getRed());
    }

    /**
     * @Brief Permet de jouer une partie
     *
     */
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);

        String input; // On récupère l'input de l'utilisateur

        boolean finished = false; // On initialise la variable finished à false pour pouvoir jouer

        System.out.println("Bienvenue dans le jeu de CRAZY CIRCUS!");
        System.out.println("A vous de jouer!");

        int numErrors = 0; // Permet de compter le nombre d'erreurs

        Player previousPlayerWhoMadeAnError = null; // Permet de savoir qui a fait une erreur

        while (!finished) { // Tant que la partie n'est pas finie

            System.out.println(startingPodium.toString(objectivePodium)); // On affiche le podium de départ et le podium d'objectif

            input = scanner.nextLine(); // On récupère l'input de l'utilisateur

            Podium copyOfStaringPodium = startingPodium.copyPodium(); // On crée une copie du podium de départ

            String name = input.substring(0, 2).toUpperCase(); // On récupère le nom du joueur

            String command = input.substring(3).toUpperCase(); // On récupère la commande

            if (previousPlayerWhoMadeAnError != null && previousPlayerWhoMadeAnError.getName().equals(name)) { // Si le joueur a déjà fait une erreur, il ne peut plus jouer ce tour
                System.out.println("Vous avez déjà fait une erreur, vous ne pouvez plus jouer ce tour");
            }

            // Si le joueur existe et qu'il n'a pas fait d'erreur, on peut jouer
            if (PlayerExists(name) && !(previousPlayerWhoMadeAnError != null && previousPlayerWhoMadeAnError.getName().equals(name))) {
                System.out.println();
                try { // On essaye de jouer
                    startingPodium.processInput(command); // On joue

                    if (samePosition(startingPodium, objectivePodium)) { // Si les animaux sont à la même position, on a gagné
                        System.out.println("Bien joué! Vous avez gagné!");

                        for (int i = 0; i < players.size(); i++) { // On met à jour le score du joueur

                            if (players.get(i).getName().equals(name)) { // Si le joueur existe, on met à jour son score

                                players.get(i).setScore(); // On met à jour le score du joueur

                            }
                        }
                        playGame(); // On relance une partie
                    } else { // Si les animaux ne sont pas à la même position, on a perdu
                        System.out.println("Vous avez perdu!");

                        for (int i = 0; i < players.size(); i++) { // On met à jour le score du joueur

                            if (players.get(i).getName().equals(name)) {

                                players.get(i).setError(); // On met à jour le nombre d'erreurs du joueur

                                if (!(previousPlayerWhoMadeAnError == players.get(i))) { //Si le joueur n'a pas fait d'erreur, on incrémente le nombre d'erreurs
                                    numErrors++;
                                }
                                previousPlayerWhoMadeAnError = players.get(i); // On met à jour le joueur qui a fait une erreur

                                startingPodium = copyOfStaringPodium; // On remet le podium de départ à son état initial
                            }

                            if (numErrors == players.size()) { // Si le nombre d'erreurs est égal au nombre de joueurs, on change la carte objective
                                System.out.println("Carte objective a changé");
                                startingPodium = objectivePodium; // On met à jour le podium de départ
                                objectivePodium = card.getRandomCard(); // On change la carte objective
                                System.out.println("nouveau objective carte: ");
                                System.out.println(startingPodium.toString(objectivePodium));
                            }
                        }
                    }
                } catch (Exception e) { // Si on ne peut pas jouer, on affiche un message d'erreur
                    System.out.println("Jouer n'existe pas");
                }
            }
            else if (!PlayerExists(name)) { // Si le joueur n'existe pas, on affiche un message d'erreur
                System.out.println("Ce joueur n'existe pas");
            }
            setGameOver(); // On met à jour la variable gameOver

            if(getGameOver()) { // Si gameOver est à true, on arrête la partie
                finished = true;
            }
        }
    }

    public static void continueToPlay() throws Exception {
        assert (!getGameOver());

    }

    public static void addScore() {
        for (Player p : players) {
            if (samePosition(startingPodium, objectivePodium)) {
                // p.setScore(1);
            }
        }
    }

    public static void handlePlayerError(String playerName) {
        for (Player player : players) {
            if (player.getPlayers().contains(playerName)) {
                player.setError();
                player.setCanPlay(false);
                System.out.println("vous ne pouvez plus jouer");
                return;
            }
        }
    }

    //------------Getters----------------
    public static boolean getGameOver() {
        return gameOver;
    }

    public void getPlayersNames() {
        for (Player p : players) {
            System.out.println(p.getPlayers());
        }
    }

    //------------Setters----------------
    public static void setGameOver() {
        if (card.isEmpty()) {
            gameOver = true;
        }
    }

    //------------Methods----------------
    public void start() {
        System.out.println("Bienvenue dans le jeu de CRAZY CIRCUS!");
        Scanner sc = new Scanner(System.in);
        String name;
        String[] names = new String[numPlayers];

    }

    private void FirstGame() {
        startingPodium = card.getRandomCard();
        objectivePodium = card.getRandomCard();
    }

    /**
     * @param name Le nom du joueur
     * @throws IllegalArgumentException Si le nom du joueur n'est pas composé de deux lettres
     * @brief Permet d'ajouter les joueurs
     */
    public void addPlayer(String[] name) throws IllegalArgumentException {
        for (String s : name) {
            try {
                if (s.length() != 2) {
                    throw new IllegalArgumentException("Le nom du joueur doit être composé de deux lettres");
                } else {
                    Player p = new Player(s.toUpperCase());
                    players.add(p);
                    System.out.println("Le joueur " + s + " a été ajouté.");
                    numPlayers++;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    }


}
