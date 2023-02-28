package Game;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Menu {
    public static void Dispalymenu() {
        boolean exit = false;
       // Game game = new Game();
        while (!exit) {
            System.out.println("Bienvenue dans le jeu Crazy Circus !");
            System.out.println("1. Lancez une partie");
            System.out.println("2. Maîtriser commandes");
            System.out.println("3. Quitter");
            System.out.println("4.Crédit");
            System.out.print("Entrez votre choix: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Lancement de la partie");
                   // game.Start();
                    break;
                case 2:
                    System.out.println("KI - L’animal se trouvant en haut de la pile du podium bleu saute pour rejoindre le sommet de la pile du podium rouge.");
                    System.out.println("LO - L’animal se trouvant en haut de la pile du podium rouge saute pour rejoindre le sommet de la pile du podium bleu.");
                    System.out.println("SO - L'animal se trouvant au sommet despile des deux podiums s ´echangent leur place.");
                    System.out.println("NI - L'animal se trouvant en bas de la pile du podium bleu monte et se place en haut de la pile de ce même podium.");
                    System.out.println("MA - L'animal se trouvant en bas de la pile du podium rouge monte et se place en haut de la pile de ce même podium.");
                    break;
                case 3:
                    System.out.println("Au revoir");
                    exit = true;
                    break;
                case 4:
                    System.out.println("Ce jeu a été conçu par Gobigan MATHIALAHAN et Eric ZHANG, étudiants en 1ère année à l'IUT Paris Descartes. " +
                            "vous pouvez utilisez notre code afin de vous inspirer pour vos projets.");
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }
}
