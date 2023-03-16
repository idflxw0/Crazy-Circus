package Card;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PodiumTest {

    @Test
    void getBlue() {
        Podium blue = new Podium();
        blue.addBlue(Animal.LION);
        blue.addBlue(Animal.ELEPHANT);
        blue.addBlue(Animal.WHITE_BEAR);

        LinkedList<Animal> blueList = blue.getBlue();
        assertEquals(Animal.LION, blueList.get(0));
        assertEquals(Animal.ELEPHANT, blueList.get(1));
        assertEquals(Animal.WHITE_BEAR, blueList.get(2));
    }

    @Test
    void getRed() {
        Podium red = new Podium();
        red.addRed(Animal.LION);
        red.addRed(Animal.ELEPHANT);
        red.addRed(Animal.WHITE_BEAR);

        LinkedList<Animal> redList = red.getRed();
        assertEquals(Animal.LION, redList.get(0));
        assertEquals(Animal.ELEPHANT, redList.get(1));
        assertEquals(Animal.WHITE_BEAR, redList.get(2));
    }

    @Test
    void getLength_blue() {
        Podium blue = new Podium();
        blue.addBlue(Animal.LION);
        blue.addBlue(Animal.ELEPHANT);
        blue.addBlue(Animal.WHITE_BEAR);

        assertEquals(3, blue.getLength_blue());
    }

    @Test
    void getLength_red() {
        Podium red = new Podium();
        red.addRed(Animal.LION);
        red.addRed(Animal.ELEPHANT);
        red.addRed(Animal.WHITE_BEAR);

        assertEquals(3, red.getLength_red());
    }

    @Test
    void addBlue() {
        Podium blue = new Podium();
        blue.addBlue(Animal.LION);
        blue.addBlue(Animal.ELEPHANT);
        blue.addBlue(Animal.WHITE_BEAR);

        LinkedList<Animal> blueList = blue.getBlue();
        assertEquals(Animal.LION, blueList.get(0));
        assertEquals(Animal.ELEPHANT, blueList.get(1));
        assertEquals(Animal.WHITE_BEAR, blueList.get(2));
    }

    @Test
    void addRed() {
        Podium red = new Podium();
        red.addRed(Animal.LION);
        red.addRed(Animal.ELEPHANT);
        red.addRed(Animal.WHITE_BEAR);

        LinkedList<Animal> redList = red.getRed();
        assertEquals(Animal.LION, redList.get(0));
        assertEquals(Animal.ELEPHANT, redList.get(1));
        assertEquals(Animal.WHITE_BEAR, redList.get(2));
    }

    @Test
    void setBlueLength() {
        Podium blue = new Podium();
        blue.addBlue(Animal.LION);
        blue.addBlue(Animal.ELEPHANT);
        blue.addBlue(Animal.WHITE_BEAR);

        LinkedList<Animal> blueList = blue.getBlue();
        assertEquals(Animal.LION, blueList.get(0));
        assertEquals(Animal.ELEPHANT, blueList.get(1));
        assertEquals(Animal.WHITE_BEAR, blueList.get(2));

        assertEquals(3, blue.getLength_blue());
    }

    @Test
    void setRedLength() {
        Podium red = new Podium();
        red.addRed(Animal.LION);
        red.addRed(Animal.ELEPHANT);
        red.addRed(Animal.WHITE_BEAR);

        LinkedList<Animal> redList = red.getRed();
        assertEquals(Animal.LION, redList.get(0));
        assertEquals(Animal.ELEPHANT, redList.get(1));
        assertEquals(Animal.WHITE_BEAR, redList.get(2));

        assertEquals(3, red.getLength_red());
    }

    @Test
    void KI() {
        LinkedList<Animal> blueList = new LinkedList<>();
        LinkedList<Animal> redList = new LinkedList<>();

        blueList.add(Animal.LION);
        blueList.add(Animal.ELEPHANT);

        redList.add(Animal.WHITE_BEAR);

        Podium test = new Podium(blueList, redList);
        test.KI();
        assertEquals(Animal.WHITE_BEAR, test.getRed().get(0));
        assertEquals(Animal.ELEPHANT, test.getRed().get(1));
        assertEquals(Animal.LION, test.getBlue().get(0));

        LinkedList<Animal> blueList1 = new LinkedList<>();
        LinkedList<Animal> redList1 = new LinkedList<>();

        blueList1.add(Animal.LION);
        blueList1.add(Animal.ELEPHANT);
        blueList1.add(Animal.WHITE_BEAR);

        Podium test1 = new Podium(blueList1, redList1);
        test1.KI();
        assertEquals(Animal.WHITE_BEAR, test1.getRed().get(0));
        assertEquals(Animal.LION, test1.getBlue().get(0));
        assertEquals(Animal.ELEPHANT, test1.getBlue().get(1));
    }

    @Test
    void testLO() {
        LinkedList<Animal> blueList = new LinkedList<>();
        LinkedList<Animal> redList = new LinkedList<>();

        blueList.add(Animal.LION);

        redList.add(Animal.WHITE_BEAR);
        redList.add(Animal.ELEPHANT);

        Podium test = new Podium(blueList, redList);
        test.LO();

        assertEquals(Animal.ELEPHANT, test.getBlue().get(1));
        assertEquals(Animal.WHITE_BEAR, test.getRed().getFirst());
        assertEquals(2, test.getBlue().size());
        assertEquals(1, test.getRed().size());
    }

    @Test
    void SO() {
        LinkedList<Animal> blueList = new LinkedList<>();
        LinkedList<Animal> redList = new LinkedList<>();

        blueList.add(Animal.LION);
        blueList.add(Animal.ELEPHANT);

        redList.add(Animal.WHITE_BEAR);

        Podium test = new Podium(blueList, redList);
        test.SO();
        assertEquals(Animal.WHITE_BEAR, test.getBlue().get(1));
        assertEquals(Animal.LION, test.getBlue().get(0));
        assertEquals(Animal.ELEPHANT, test.getRed().get(0));

        LinkedList<Animal> blueList1 = new LinkedList<>();
        LinkedList<Animal> redList1 = new LinkedList<>();

        blueList1.add(Animal.LION);

        redList1.add(Animal.WHITE_BEAR);
        redList1.add(Animal.ELEPHANT);

        Podium test1 = new Podium(blueList1, redList1);
        test1.SO();
        assertEquals(Animal.ELEPHANT, test1.getBlue().get(0));
        assertEquals(Animal.LION, test1.getRed().get(1));
        assertEquals(Animal.WHITE_BEAR, test1.getRed().get(0));
    }

    @Test
    void MA() {
        LinkedList<Animal> BlueList = new LinkedList<>();
        LinkedList<Animal> RedList = new LinkedList<>();


        RedList.add(Animal.LION);
        RedList.add(Animal.ELEPHANT);
        RedList.add(Animal.WHITE_BEAR);

        Podium test = new Podium(BlueList, RedList);
        test.MA();

        assertEquals(Animal.LION, test.getRed().get(2));
        assertEquals(Animal.WHITE_BEAR, test.getRed().get(1));
        assertEquals(Animal.ELEPHANT, test.getRed().getFirst());

        LinkedList<Animal> BlueList1 = new LinkedList<>();
        LinkedList<Animal> RedList1 = new LinkedList<>();

        RedList1.add(Animal.LION);
        RedList1.add(Animal.ELEPHANT);

        Podium test1 = new Podium(BlueList1, RedList1);
        test1.MA();

        assertEquals(Animal.LION, test1.getRed().get(1));
        assertEquals(Animal.ELEPHANT, test1.getRed().getFirst());
    }

    @Test
    void NI() {
        LinkedList<Animal> BlueList = new LinkedList<>();
        LinkedList<Animal> RedList = new LinkedList<>();

        BlueList.add(Animal.LION);
        BlueList.add(Animal.ELEPHANT);
        BlueList.add(Animal.WHITE_BEAR);

        Podium test = new Podium(BlueList, RedList);
        test.NI();

        assertEquals(Animal.LION, test.getBlue().get(2));
        assertEquals(Animal.WHITE_BEAR, test.getBlue().get(1));
        assertEquals(Animal.ELEPHANT, test.getBlue().getFirst());

        LinkedList<Animal> BlueList1 = new LinkedList<>();
        LinkedList<Animal> RedList1 = new LinkedList<>();

        BlueList1.add(Animal.LION);
        BlueList1.add(Animal.ELEPHANT);

        Podium test1 = new Podium(BlueList1, RedList1);
        test1.NI();

        assertEquals(Animal.LION, test1.getBlue().get(1));
        assertEquals(Animal.ELEPHANT, test1.getBlue().getFirst());

    }

    @Test
    void testIsValidMove() {
        // Valid input
        assertTrue(Podium.isValidMove("KILO"));
        assertTrue(Podium.isValidMove("LOMAKI"));
        assertTrue(Podium.isValidMove("SOKINILOMA"));
        assertTrue(Podium.isValidMove("NIMA"));
        assertTrue(Podium.isValidMove("MAKI"));
        assertTrue(Podium.isValidMove("LO"));
        assertTrue(Podium.isValidMove("SO"));
        assertTrue(Podium.isValidMove("MA"));
        assertTrue(Podium.isValidMove("NI"));
    }


    @Test
    void processInput() {
        //KI
        LinkedList<Animal> blueList = new LinkedList<>();
        LinkedList<Animal> redList = new LinkedList<>();

        blueList.add(Animal.LION);
        blueList.add(Animal.ELEPHANT);

        redList.add(Animal.WHITE_BEAR);

        Podium test = new Podium(blueList, redList);
        test.processInput("KI");
        assertEquals(Animal.WHITE_BEAR, test.getRed().get(0));
        assertEquals(Animal.ELEPHANT, test.getRed().get(1));
        assertEquals(Animal.LION, test.getBlue().get(0));

        //LO
        LinkedList<Animal> blueList1 = new LinkedList<>();
        LinkedList<Animal> redList1 = new LinkedList<>();
        blueList1.add(Animal.LION);

        redList1.add(Animal.WHITE_BEAR);
        redList1.add(Animal.ELEPHANT);

        Podium test1 = new Podium(blueList1, redList1);
        test1.processInput("LO");
        assertEquals(Animal.ELEPHANT, test1.getBlue().get(1));
        assertEquals(Animal.WHITE_BEAR, test1.getRed().getFirst());
        assertEquals(2, test1.getBlue().size());
        assertEquals(1, test1.getRed().size());

        //SO
        LinkedList<Animal> blueList2 = new LinkedList<>();
        LinkedList<Animal> redList2 = new LinkedList<>();
        blueList2.add(Animal.LION);
        blueList2.add(Animal.ELEPHANT);

        redList2.add(Animal.WHITE_BEAR);

        Podium test2 = new Podium(blueList2, redList2);
        test2.processInput("SO");
        assertEquals(Animal.WHITE_BEAR, test2.getBlue().get(1));
        assertEquals(Animal.LION, test2.getBlue().get(0));
        assertEquals(Animal.ELEPHANT, test2.getRed().get(0));

        //MA
        LinkedList<Animal> blueList3 = new LinkedList<>();
        LinkedList<Animal> redList3 = new LinkedList<>();
        redList3.add(Animal.LION);
        redList3.add(Animal.ELEPHANT);
        redList3.add(Animal.WHITE_BEAR);

        Podium test3 = new Podium(blueList3, redList3);
        test3.processInput("MA");

        assertEquals(Animal.LION, test3.getRed().get(2));
        assertEquals(Animal.WHITE_BEAR, test3.getRed().get(1));
        assertEquals(Animal.ELEPHANT, test3.getRed().getFirst());

        //NI
        LinkedList<Animal> blueList4 = new LinkedList<>();
        LinkedList<Animal> redList4 = new LinkedList<>();
        blueList4.add(Animal.LION);
        blueList4.add(Animal.ELEPHANT);
        blueList4.add(Animal.WHITE_BEAR);

        Podium test4 = new Podium(blueList4, blueList4);
        test4.processInput("NI");

        assertEquals(Animal.LION, test4.getBlue().get(2));
        assertEquals(Animal.WHITE_BEAR, test4.getBlue().get(1));
        assertEquals(Animal.ELEPHANT, test4.getBlue().getFirst());
    }

    @Test
    void testDisplayMoves() {
        Podium p = new Podium();
        String expected = " KI : Bleu-->Rouge     |     MA : Rouge ^\n" +
                " LO : Blue<--Rouge     |     NI : Bleu ^\n" +
                " SO : Bleu<-->Rouge";
        String result = p.displayMoves();
        assertEquals(expected, result);
    }
    @Test
    void testToString() {
    }

    @Test
    void copyPodium() {
        LinkedList<Animal> blueList = new LinkedList<>();
        LinkedList<Animal> redList = new LinkedList<>();

        blueList.add(Animal.LION);
        blueList.add(Animal.ELEPHANT);

        redList.add(Animal.WHITE_BEAR);

        Podium test = new Podium(blueList, redList);
        Podium test1 = test.copyPodium();

        assertEquals(test.getBlue(), test1.getBlue());
        assertEquals(test.getRed(), test1.getRed());
    }
}