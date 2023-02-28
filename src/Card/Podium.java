package Card;

import java.util.LinkedList;

public class Podium {
    private LinkedList<Animal>  blue;
    private LinkedList<Animal> red;
    private final int MAX_LENGTH = 3;
    private int length_blue;
    private int length_red;
    //------------Constructors----------------
    public Podium() {
        blue = new LinkedList<>();
        red = new LinkedList<>();
        length_blue = 0;
        length_red = 0;
    }
    //------------Getters----------------
    public LinkedList<Animal> getBlue() {
        return blue;
    }
    public LinkedList<Animal> getRed() {
        return red;
    }
    //------------Setters----------------
    /**
     * @param animal Permet d'ajouter les animaux dans le podium bleu
     */
    public void addBlue(Animal animal) {
        blue.add(animal);
    }
    /**
     * @param animal Permet d'ajouter les animaux dans le podium rouge
     */
    public void addRed(Animal animal) {
        red.add(animal);
    }
    //------------Les Méthodes----------------
    /**
     * Permet de deplacer les animaux du podium bleu vers le podium rouge
     */
    public void KI() {
        if(blue.size() != 0) {
            Animal animal = blue.removeLast();
            red.addLast(animal);
        }
        else  {
            System.out.println("Ordre incorrect ! Vous n'avez plus le droit de jouer ce tour.");
        }
    }
    /**
     * Permet de deplacer les animaux du podium rouge vers le podium bleu
     */
    public void L0() {
        if(red.size() != 0) {
            Animal animal = red.removeLast();
            blue.addLast(animal);
        }
        else  {
            System.out.println("Ordre incorrect ! Vous n'avez plus le droit de jouer ce tour.");
        }
    }
    /**
     * Permet de swap les animaux
     */
    public void SO() {
        if(blue.size() != 0 && red.size() != 0) {
            Animal animal = blue.removeLast();
            Animal animal1 = red.removeLast();
            red.addLast(animal);
            blue.addLast(animal1);
        }
        else  {
            System.out.println("Ordre incorrect ! Vous n'avez plus le droit de jouer ce tour.");
        }
    }
    /**
     * Permet de deplacer l'animal du podium rouge vers le sommet du podium rouge
     */
    public void MA () {
        if(red.size() > 0  && red.size() <= 3) {
            Animal animal = red.removeFirst();
            Animal animal1 = red.removeLast();
            red.addLast(animal);
            red.addFirst(animal1);
        }
        else {
            System.out.println("Ordre incorrect ! Vous n'avez plus le droit de jouer ce tour.");
        }
    }
    /**
     * Permet de deplacer l'animal du podium bleu vers le sommet du podium bleu
     */
    public void NI() {
        if(blue.size() > 0  && blue.size() <= 3) {
            Animal animal = blue.removeFirst();
            Animal animal1 = blue.removeLast();
            blue.addLast(animal);
            blue.addFirst(animal1);
        }
        else {
            System.out.println("Ordre incorrect ! Vous n'avez plus le droit de jouer ce tour.");
        }
    }
    public static boolean isValidMove(String input) {
        for (Move move : Move.values()) {
            if (move.name().equals(input.toUpperCase())) {
                return true;
            }
        }
        return false;
    }


}