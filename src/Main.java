import Game.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(args); // On crée une nouvelle partie
        try {
            System.out.println("Bienvenue dans le jeu de CRAZY CIRCUS!");
            System.out.println("A vous de jouer!");
            game.playGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
