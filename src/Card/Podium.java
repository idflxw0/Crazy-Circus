package Card;

import java.util.*;
import java.util.stream.Collectors;

public class Podium {
    private LinkedList<Animal> blue;
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
    public Podium(LinkedList<Animal> bluePodium, LinkedList<Animal> redPodium) {
        this.blue = bluePodium;
        this.red = redPodium;
        setBlueLength();
        setRedLength();
    }
    public Podium(Podium podium) {
        this.blue = new LinkedList<>(podium.blue);
        this.red = new LinkedList<>(podium.red);
        this.length_blue = podium.length_blue;
        this.length_red = podium.length_red;
    }


    //------------Getters----------------
    public LinkedList<Animal> getBlue() {
        return blue;
    }

    public LinkedList<Animal> getRed() {
        return red;
    }
    public int getLength_blue() {
        return length_blue;
    }
    public int getLength_red() {
        return length_red;
    }
    //------------Setters----------------

    /**
     * @param animal Permet d'ajouter les animaux dans le podium bleu
     */
    public void addBlue(Animal animal) {
        blue.add(animal);
        setBlueLength();
    }

    /**
     * @param animal Permet d'ajouter les animaux dans le podium rouge
     */
    public void addRed(Animal animal) {
        red.add(animal);
        setRedLength();
    }
    public void setBlueLength() {
        length_blue = blue.size();
    }
    public void setRedLength() {
        length_red = red.size();
    }
    //------------Les Méthodes----------------

    /**
     * Permet de deplacer les animaux du podium bleu vers le podium rouge
     */
    public void KI() {
        if (blue.size() != 0) {
            Animal animal = blue.removeLast();
            red.addLast(animal);
        } else {
            System.out.println("Ordre incorrect ! Vous n'avez plus le droit de jouer ce tour.");
        }
    }

    /**
     * Permet de deplacer les animaux du podium rouge vers le podium bleu
     */
    public void LO() {
        if (red.size() != 0) {
            Animal animal = red.removeLast();
            blue.addLast(animal);
        } else {
            System.out.println("Ordre incorrect ! Vous n'avez plus le droit de jouer ce tour.");
        }
    }

    /**
     * Permet de swap les animaux
     */
    public void SO() {
        if (blue.size() != 0 && red.size() != 0) {
            Animal animal = blue.removeLast();
            Animal animal1 = red.removeLast();
            red.addLast(animal);
            blue.addLast(animal1);
        } else {
            System.out.println("Ordre incorrect ! Vous n'avez plus le droit de jouer ce tour.");
        }
    }

    /**
     * Permet de deplacer l'animal du podium rouge vers le sommet du podium rouge
     */
    public void MA() {
        if (red.size() > 0 && red.size() <= 3) {
            Animal animal = red.removeFirst();
            Animal animal1 = red.removeLast();
            red.add(animal1);
            red.addLast(animal);
        } else {
            System.out.println("Ordre incorrect ! Vous n'avez plus le droit de jouer ce tour.");
        }
    }

    /**
     * @breif Permet de deplacer l'animal du podium bleu vers le sommet du podium bleu
     */
    public void NI() {
        if (blue.size() > 0 && blue.size() <= 3) {
            Animal animal = blue.removeFirst(); // Retire le dernier élément de la liste
            Animal animal1 = blue.removeLast(); // Retire le premier élément de la liste
            blue.add(animal1); // Ajoute l'élément à la fin de la liste
            blue.addLast(animal); // Ajoute l'élément au début de la liste
        } else {
            System.out.println("Ordre incorrect ! Vous n'avez plus le droit de jouer ce tour."); // Affiche un message d'erreur
        }
    }

    /**
     * @breif Permet de Vérifier si la chaîne d'entrée est une séquence valide de mouvements
     * @param input chaîne de caractères à vérifier
     * @return true si l'ordre est valide, false sinon
     */
    public static boolean isValidMove(String input) {
        /*
        Set<String> validCommands = Arrays.stream(Move.values())
                .map(Enum::name)
                .collect(Collectors.toSet());
         */
        // Crée un ensemble de chaînes de caractères valides à partir des valeurs de l'énumération Move
        Set<String> validCommands = new HashSet<>(); // Création d'un objet HashSet
        for (Move move : Move.values()) { // Parcours de la liste des mouvements
            validCommands.add(move.name()); // Ajout des mouvements dans la liste
        }
        int i = 0; // Initialisation de i à 0
        while (i < input.length()) { // Tant que i est inférieur à la longueur de la chaîne de caractères
            String command = input.substring(i, i + 2); // On récupère les deux premiers caractères
            // Vérifie si la commande est valide en la comparant avec l'ensemble des commandes valides
            if (validCommands.contains(command)) {
                i += 2;
            } else {
                return false; // Si la commande n'est pas valide, retourne false
            }
        }
        return true;  // Si toutes les commandes sont valides, retourne true
    }

    /**
     * @breif Permet de traiter les séquences de l'utilisateur
     * @param input Permet de traiter les entrées de l'utilisateur
     */
    public void processInput(String input) {
        input = input.toUpperCase(); // On met la chaîne de caractères en majuscule
        for (int i = 0; i < input.length(); i += 2) {
            String move = input.substring(i, i + 2); // On récupère les deux premiers caractères
            if (!isValidMove(input)) { // Si la commande n'est pas valide
                System.out.println("Invalid move: " + move); // On affiche un message d'erreur
                return; // On arrête le traitement
            }
            switch (move) {  // On traite la commande
                case "KI":  // Si la commande est KI
                    KI();  // On appelle la méthode KI
                    break; // On arrête le traitement
                case "LO": // Si la commande est LO
                    LO();// On appelle la méthode LO
                    break; // On arrête le traitement
                case "SO": // Si la commande est SO
                    SO(); // On appelle la méthode SO
                    break; // On arrête le traitement
                case "NI": // Si la commande est NI
                    NI();// On appelle la méthode NI
                    break; // On arrête le traitement
                case "MA": // Si la commande est MA
                    MA(); // On appelle la méthode MA
                    break; // On arrête le traitement
                default: // Si la commande n'est pas valide
                    System.out.println("Invalid move: " + move); // On affiche un message d'erreur
                    return; // On arrête le traitement
            }
        }
    }
    public String displayMoves() {
        return String.format(" %5s %5s  %15s\n %5s %5s %15s\n %s", "KI : Bleu-->Rouge", "|", "MA : Rouge ^",
                "LO : Blue<--Rouge", "|", "NI : Bleu ^", "SO : Bleu<-->Rouge");
    }
    /**
     * @return Retour de la chaîne de caractères finale
     * @breif Permet d'afficher le podium
     */
    public String toString(Podium objectivePodium) {
        StringBuilder sb = new StringBuilder();
        int maxStackSize = Math.max(blue.size(), red.size());

        Podium objectiveState = objectivePodium == null ? null : new Podium(objectivePodium);

        for (int i = maxStackSize ; i >= 0; i--) {
            // Blue stack
            if (i < blue.size()) {
                sb.append(String.format("%-12s", blue.get(i)));
            } else {
                sb.append(String.format("%-12s", ""));
            }

            sb.append("     ");

            // Red stack
            if (i < red.size()) {
                sb.append(String.format("%-12s", red.get(i)));
            } else {
                sb.append(String.format("%-12s", ""));
            }

            if (objectiveState != null) {
                sb.append("            ");

                // Objective Blue stack
                if (i < objectiveState.blue.size()) {
                    sb.append(String.format("%-12s", objectiveState.blue.get(i)));
                } else {
                    sb.append(String.format("%-12s", ""));
                }

                sb.append("     ");

                // Objective Red stack
                if (i < objectiveState.red.size()) {
                    sb.append(String.format("%-12s", objectiveState.red.get(i)));
                } else {
                    sb.append(String.format("%-12s", ""));
                }
            }

            sb.append("\n");
        }

        // Podium separator
        for (int i = 0; i < 12; i++) {
            sb.append("-");
        }

        sb.append("     ");

        for (int i = 0; i < 12; i++) {
            sb.append("-");
        }

        if (objectiveState != null) {
            sb.append("            ");

            for (int i = 0; i < 12; i++) {
                sb.append("-");
            }

            sb.append("     ");

            for (int i = 0; i < 12; i++) {
                sb.append("-");
            }
        }

        sb.append("\n");

        // Podium labels
        sb.append(String.format("%-12s", "BLUE"));
        sb.append("     ");
        sb.append(String.format("%-12s", "ROUGE"));

        if (objectiveState != null) {
            sb.append("            ");
            sb.append(String.format("%-12s", "BLUE"));
            sb.append("     ");
            sb.append(String.format("%-12s", "ROUGE"));
        }

        sb.append("\n");
        sb.append("-----------------------------------------------------------------------");
        sb.append("\n");
        sb.append(this.displayMoves());
        sb.append("\n");
        return sb.toString();
    }

    public Podium copyPodium() {
        Podium copy = new Podium();
        copy.blue = new LinkedList<>(blue);
        copy.red = new LinkedList<>(red);
        return copy;
    }
}