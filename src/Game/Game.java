package Game;
import  Card.*;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;

public class Game {
    private ArrayList<Card> cards;
    private Card card;
    private static LinkedList<Player> players;
    private  Podium startingPodium;
    private  Podium objectivePodium;
    private static final int MAX_CARDS = 24;
    private boolean gameOver;
    private int numPlayers;

    //------------Constructors----------------
    public Game(String[] args) {
        players = new LinkedList<>();
        card = new Card();
        this.gameOver = false;
        addPlayer(args);
    }

    public void addPlayer(String[] name) {
        for (String s : name) {
            Player p = new Player(s);
            players.add(p);
        }
    }
    public void Start() {
        System.out.println("Bienvenue dans le jeu de la carte");
        Scanner sc = new Scanner(System.in);
        System.out.print("Combien de joueurs ? : ");
        numPlayers = sc.nextInt();
        String s= "";
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Entre votre nom : ");
            s = sc.next();
            while(s.length() > 2) {
                System.out.println("votre nom doit etre de 2 caractères maximum");
                System.out.print("ressaisissez votre nom : ");
                s = sc.next();
            }
            while (eleminateDoubles(new Player(s))) {
                System.out.println("Nom déjà pris : Veuillez en saisir un autre.");
                s = sc.next();
            }
            Player p = new Player(s);
            players.add(p);
        }
    }
    public static void playGame(Podium startingPodium, Podium objectivePodium) {
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.print(startingPodium.toString(objectivePodium));
        boolean finished = false;
        while(true){
            System.out.print("Enter a move: ");
            input = sc.nextLine();
            if (input.equals("quit")) {
                break;
            }
            try {
                startingPodium.processInput(input);
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

    /**
     * @breif Permet de savoir si le nom du joueur est déjà pris
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
    public void getPlayersnames() {
        for (Player p : players) {
            System.out.println(p.getPlayers());
        }
    }
    public static void main(String[] args) {
        Podium podium = new Podium();
        Podium objectivePodium = new Podium();
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
}
