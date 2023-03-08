package Game;
import  Card.*;

import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.*;

public class Game {
    private ArrayList<Card> cards;
    private static Card card;
    private static LinkedList<Player> players;
    private static Podium startingPodium;
    private static Podium objectivePodium;
    private static final int MAX_CARDS = 24;
    private boolean gameOver;
    private int numPlayers;

    //------------Constructors----------------
    public Game(String[] args) {
        players = new LinkedList<>();
        card = new Card();
        this.gameOver = false;
        card.createCards();
        addPlayer(args);
        FirstGame();
    }
    //------------Getters----------------
    public boolean getGameOver() {
        return this.gameOver;
    }
    public void getPlayersNames() {
        for (Player p : players) {
            System.out.println(p.getPlayers());
        }
    }
    public static void getScore() {
        System.out.println(Player.getScore());
    }
    //------------Setters----------------
    public void setGameOver() {
        if(card.isEmpty()){
            this.gameOver = true;
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
     * @brief Permet d'ajouter les joueurs
     * @param name Le nom du joueur
     * @throws IllegalArgumentException Si le nom du joueur n'est pas composé de deux lettres
     */
    public void addPlayer(String[] name) throws IllegalArgumentException {
        for (String s : name) {
            try {
                if (s.length() != 2) {
                    throw new IllegalArgumentException("Le nom du joueur doit être composé de deux lettres");
                }
                else {
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

    /**
     * @brief Permet de savoir si le nom du joueur est déjà pris
     * @param name Le nom du joueur
     * @return true si le nom du joueur est déjà pris, false sinon
     */
    public static boolean PlayerExists(String name) {
        return eleminateDoubles(new Player(name)); // On crée un joueur temporaire pour pouvoir utiliser la méthode eleminateDoubles: true si le nom du joueur est déjà pris, false sinon
    }

    /**
     * @brief Permet de verifier si le nom du joueur est déjà pris
     * @param p Le joueur
     * @return true si le nom du joueur est déjà pris, false sinon
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
     * @breif Permet de savoir si les deux podiums ont la même longueur
     * @param startingPodium Le podium de départ
     * @param objectivePodium Le podium d'objectif
     * @return true si les deux podiums ont la même longueur, false sinon
     */
    public static boolean sameLength(Podium startingPodium, Podium objectivePodium) {
        return startingPodium.getLength_blue() == objectivePodium.getLength_blue() && startingPodium.getLength_red() == objectivePodium.getLength_red();
    }

    /**
     * @breif Permet de mettre à jour la longueur des podiums
     * @param startingPodium Le podium de départ
     */
    public static void updateLength(Podium startingPodium) {
        startingPodium.setBlueLength();
        startingPodium.setRedLength();
    }


    /**
     * @breif Permet de savoir si les animaux sur les deux podiums sont à la même position
     * @param startingPodium Le podium de départ
     * @param objectivePodium Le podium d'objectif
     * @return true si les animaux sur les deux podiums sont à la même position, false sinon
     */
    public static boolean samePosition(Podium startingPodium, Podium objectivePodium) {
        return startingPodium.getBlue().equals(objectivePodium.getBlue()) && startingPodium.getRed().equals(objectivePodium.getRed());
    }


    public static void playGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean finished = false;
        System.out.println("Bienvenue dans le jeu de CRAZY CIRCUS!");
        System.out.println("A vous de jouer!");
        int inputPlayerIndex = 0;
       while(!finished) {
           System.out.println(startingPodium.toString(objectivePodium));
           input = scanner.nextLine();

           String name = input.substring(0, 2).toUpperCase();
           String command = input.substring(3).toUpperCase();
           int chance = 1;
           if(PlayerExists(name)) {
               try {
                   startingPodium.processInput(command);

                   if (samePosition(startingPodium, objectivePodium)) {
                       System.out.println("Bien joué! Vous avez gagné!");
                       for(int i =0; i<players.size(); i++){
                           if(players.get(i).getName().equals(name)){
                               players.get(i).setScore();
                           }
                       }
                   }
                   else {
                       chance =0;
                       System.out.println("Vous avez perdu!");
                       for(int i =0; i<players.size(); i++){
                           if(players.get(i).getName().equals(name)){
                               players.get(i).setError();
                           }
                       }
                   }

               }
               catch (Exception e) {
                     System.out.println("Jouer n'existe pas");
               }


               }
           }




    }

    public static void continueToPlay() throws Exception {
        assert(!card.isEmpty());
        Scanner sc = new Scanner(System.in);
        try {
            if (card.isEmpty()) {
                throw new Exception("Il n'y a plus de cartes");
            }
            String input;
            System.out.println("Voulez-vous continuer à jouer? (oui/non)");
            input = sc.nextLine();
            if (input.equals("oui")) {
                startingPodium = card.getRandomCard();
                objectivePodium = card.getRandomCard();
                System.out.println(startingPodium.toString(objectivePodium));
                playGame();
            }
            else {
                System.out.println("Merci d'avoir joué!");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
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



}
