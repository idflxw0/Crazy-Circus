import Game.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(args);
        //game.start();
        game.getPlayersNames();
        try {
            game.playGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
