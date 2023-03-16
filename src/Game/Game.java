package Game;

import Card.*;

import java.util.*;

public class Game {
    private static final int MAX_CARDS = 24; // Nombre de cartes dans le jeu
    private static Card card; // On crée une carte
    private static LinkedList<Player> players; // On crée une liste de joueurs
    private static Podium startingPodium; // On crée un podium de départ
    private static Podium objectivePodium; // On crée un podium d'arrivée
    private ArrayList<Card> cards; // On crée une liste de cartes
    private static boolean gameOver; // On crée une variable qui permet de savoir si la partie est finie
    private int numPlayers; // On crée une variable qui permet de savoir le nombre de joueurs

    //------------Constructors----------------
    public Game(String[] args) { // On crée un constructeur qui prend en paramètre un tableau de String
        players = new LinkedList<>(); // On initialise la liste de joueurs
        card = new Card(); // On initialise la carte
        gameOver = false; // On initialise la variable gameOver à false
        card.createCards(); // On crée les cartes
        addPlayer(args); // On ajoute les joueurs
        CreateCards(); // On lance la première partie
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
     * @param p permet de vérifier si le nom du joueur est déjà pris
     * @return true si le nom du joueur est déjà pris, false sinon
     * @brief Permet de verifier si le nom du joueur est déjà pris
     */
    public static boolean eleminateDoubles(Player p) {
        for (Player player : players) { // On parcourt la liste de joueurs
            if (player != p && player.getPlayers().equals(p.getPlayers())) { // Si le nom du joueur est déjà pris
                return true; // On retourne true
            }
        }
        return false; // On retourne false
    }


    /**
     * @param startingPodium  Le podium de départ
     * @param objectivePodium Le podium d'objectif
     * @return true si les animaux sur les deux podiums sont à la même position, false sinon
     * @breif Permet de savoir si les animaux sur les deux podiums sont à la même position
     */
    public static boolean samePosition(Podium startingPodium, Podium objectivePodium) {
        return startingPodium.getBlue().equals(objectivePodium.getBlue()) && startingPodium.getRed().equals(objectivePodium.getRed()); // On retourne true si les animaux sur les deux podiums sont à la même position, false sinon
    }

    /**
     * @Brief Permet de jouer une partie
     *
     */
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);

        String input; // On récupère l'input de l'utilisateur

        boolean finished = false; // On initialise la variable finished à false pour pouvoir jouer


        int numErrors = 0; // Permet de compter le nombre d'erreurs

        Player previousPlayerWhoMadeAnError = null; // Permet de savoir qui a fait une erreur

        while (!finished) { // Tant que la partie n'est pas finie

            System.out.println(startingPodium.toString(objectivePodium)); // On affiche le podium de départ et le podium d'objectif

            input = scanner.nextLine(); // On récupère l'input de l'utilisateur

            Podium copyOfStaringPodium = startingPodium.copyPodium(); // On crée une copie du podium de départ

            String name = input.substring(0, 2).toUpperCase(); // On récupère le nom du joueur

            String command = input.substring(3).toUpperCase(); // On récupère la commande

            int winCount = 0; // Permet de compter le nombre de victoires
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
                        winCount++;
                        for (int i = 0; i < players.size(); i++) { // On met à jour le score du joueur

                            if (players.get(i).getName().equals(name)) { // Si le joueur existe, on met à jour son score

                                players.get(i).setScore(); // On met à jour le score du joueur

                            }
                        }
                        System.out.println("Voulez-vous continuer a jouer? (O/N)"); // On demande si on veut continuer à jouer
                        String answer = scanner.nextLine(); // On récupère l'input de l'utilisateur
                        if (answer.toUpperCase().equals("O")) { // Si on veut continuer à jouer
                            CreateCards(); // On crée des nouveaux cartes
                            playGame(); // On relance une partie

                        } else {
                            System.out.println("Voici le score: "); // On affiche le score
                            showScore();
                            System.exit(0); // On quitte le jeu

                        }
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
                                startingPodium = card.getRandomCard(); // On met à jour le podium de départ
                                objectivePodium = card.getRandomCard(); // On change la carte objective
                                numErrors = 0; // On remet le nombre d'erreurs à 0
                                previousPlayerWhoMadeAnError = null; // On remet le joueur qui a fait une erreur à null
                                System.out.println("Carte objective a changé");

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
                System.out.println("La partie est terminée");
                System.out.println("Voici le score: ");
                showScore(); // On affiche le score

            }
        }
    }

    //------------Getters----------------

    /**
     * @brien Permet de savoir si la partie est terminée
     * @return gameOver
     */
    public static boolean getGameOver() {
        return gameOver; // On retourne la valeur de gameOver
    }

    //------------Setters----------------

    /**
     * @brief Permet de mettre à jour la variable gameOver
     */
    public static void setGameOver() {
        if (card.isEmpty()) { // Si le paquet de cartes est vide, on met gameOver à true
            gameOver = true;
        }
    }

    //------------Methods----------------

    /**
     * @Brief Permet de créer les cartes de départ et d'objectif
     */
    private static void CreateCards() {
        startingPodium = card.getRandomCard(); // On crée une carte de départ
        objectivePodium = card.getRandomCard(); // On crée une carte d'objectif
    }

    /**
     * @brief Permet d'ajouter les joueurs
     * @param name Le nom du joueur
     * @throws IllegalArgumentException Si le nom du joueur n'est pas composé de deux lettres
     */
    public void addPlayer(String[] name) throws IllegalArgumentException {
        for (String s : name) { // On ajoute les joueurs
            try {
                if (s.length() != 2) { // Si le nom du joueur n'est pas composé de deux lettres, on affiche un message d'erreur
                    throw new IllegalArgumentException("Le nom du joueur doit être composé de deux lettres");
                } else { // Si le nom du joueur est composé de deux lettres, on ajoute le joueur
                    Player p = new Player(s.toUpperCase());
                    players.add(p);
                    System.out.println("Le joueur " + s + " a été ajouté.");
                    numPlayers++;
                }
            } catch (IllegalArgumentException e) { // Si on ne peut pas ajouter le joueur, on affiche un message d'erreur
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    }

    /**
     * @breif Permet d'afficher le score
     */
    private static void showScore(){
        for (Player p : players) { // On affiche le score
            System.out.println(p.getName() + " : " + p.getScore());
        }
    }
}
