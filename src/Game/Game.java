package Game;
import  Card.*;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;

public class Game {
    private ArrayList<Card> cards;
    private static LinkedList<Player> players;
    private Card card;
    private static final int MAX_CARDS = 24;
    private int numPlayers;

    //------------Constructors----------------
    public Game() {
        this.cards = new ArrayList<>();
        this.players = new LinkedList<>();
        card = new Card();

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
    public static boolean eleminateDoubles(Player p) {
        for (Player player : players) {
            if (player != p && player.getPlayers().equals(p.getPlayers())) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Podium podium = new Podium();

        podium.addBlue(Animal.ELEPHANT);
        //podium.addBlue(Animal.WHITE_BEAR);
        podium.addBlue(Animal.LION);

        podium.addRed(Animal.WHITE_BEAR);

        podium.NI();

        System.out.println("Blue podium:");
        for (Animal animal : podium.getBlue()) {
            System.out.println(animal);
        }
        System.out.println();
        System.out.println("Red podium:");
        for (Animal animal : podium.getRed()) {
            System.out.println(animal);
        }

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(podium.isValidMove(input)) {
            System.out.println("Valid move");
        }
        else {
            System.out.println("Invalid move");
        }
    }
}
