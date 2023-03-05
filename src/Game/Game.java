package Game;
import  Card.*;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.*;

public class Game {
    private ArrayList<Card> cards;
    private Card card;
    private static LinkedList<Player> players;
    private static Podium startingPodium;
    private static Podium objectivePodium;
    private static final int MAX_CARDS = 24;
    private boolean gameOver;
    private int numPlayers;

    //------------Constructors----------------
    public Game() {
        players = new LinkedList<>();
        card = new Card();
        this.gameOver = false;
        card.createCards();
    }

    //------------Methods----------------

    public void start() {
        System.out.println("Bienvenue dans le jeu de la carte");

        Scanner sc = new Scanner(System.in);

        System.out.print("Combien de joueurs ? : ");

        numPlayers = sc.nextInt();
        String name;
        for (int i = 0; i< numPlayers; i++) {
            System.out.print("Entrez votre nom:");
            name = sc.next();
            while(name.length() >2) {
                System.out.println("Le nom doit faire 2 lettres");
                System.out.print("Entrez votre nom:");
                name = sc.next();
            }
            while(PlayerExists(name)) {
                System.out.println("Le joueur " + name + " existe déjà.");
                System.out.print("Ressaisissez Entrez votre nom:");
                name = sc.next();
            }
            this.addPlayer(name);
        }
        beginPlay();
        playGame();
    }
    private void beginPlay() {
        startingPodium = card.getRandomCard();
        objectivePodium = card.getRandomCard();
    }
    public static void playGame() {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.print(startingPodium.toString(objectivePodium));
        boolean finished = false;
        while(true){
            System.out.println("A vous de jouer: ");
            input = sc.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String name = input.substring(0, 2);
            String commands = input.substring(3);
            if (PlayerExists(name)) {
                try {
                    startingPodium.processInput(commands);
                    System.out.println(startingPodium.toString(objectivePodium));
                    updateLength(startingPodium);
                    if (samePosition(startingPodium, objectivePodium)) {
                        System.out.println("TROUVER");
                        break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("!!!");
                }
            }
        }
    }

    /**
     * @brief Ajoute un joueur à la liste des joueurs
     * @param name permet de recuperer le nom du joueur
     */
    public void addPlayer(String name) {
        Player p = new Player(name);
        players.add(p);
        System.out.println("Le joueur " + name + " a été ajouté.");

    }
    public static boolean PlayerExists(String name) {
        return eleminateDoubles(new Player(name));
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



    public void getPlayersNames() {
        for (Player p : players) {
            System.out.println(p.getPlayers());
        }
    }

    /*
    public static void main(String[] args) {
        Podium podium = new Podium();
        Podium objectivePodium = new Podium();
        //Game game = new Game();
        //game.start();
        //game.getPlayersNames();
        //Card card = new Card();
        podium.addBlue(Animal.WHITE_BEAR);
        podium.addRed(Animal.LION);
        podium.addRed(Animal.ELEPHANT);

        objectivePodium.addRed(Animal.WHITE_BEAR);
        objectivePodium.addRed(Animal.ELEPHANT);
        objectivePodium.addRed(Animal.LION);

        //podium =  card.getRandomCard();
        //objectivePodium = card.getRandomCard();
        playGame(podium, objectivePodium);

    }

     */
}
