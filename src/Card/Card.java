package Card;

import java.util.*;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Card {

    private LinkedList<Podium> cards;
    private Random rand;
    public Card() {
        this.cards = new LinkedList<>();
        this.rand = new Random();
        this.createCards();
    }

    public LinkedList<Podium> getCards() {
        return cards;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
    public Podium getRandomCard() {
        assert (!this.isEmpty());
        Podium p = cards.get(rand.nextInt(this.cards.size()));
        cards.remove(p);
        return p;
    }

    public void createCards() {
        Animal A = Animal.LION;
        Animal B = Animal.ELEPHANT;
        Animal C = Animal.WHITE_BEAR;

        Podium CARD_ZERO = new Podium(); //1
        CARD_ZERO.addBlue(C);
        CARD_ZERO.addBlue(B);
        CARD_ZERO.addBlue(A);
        cards.add(CARD_ZERO);

        Podium CARD_ONE = new Podium(); //2
        CARD_ONE.addBlue(C);
        CARD_ONE.addBlue(A);
        CARD_ONE.addBlue(B);
        cards.add(CARD_ONE);

        Podium CARD_TWO = new Podium();     //3
        CARD_TWO.addBlue(B);
        CARD_TWO.addBlue(C);
        CARD_TWO.addBlue(A);
        cards.add(CARD_TWO);

        Podium CARD_THREE = new Podium();  //4
        CARD_THREE.addBlue(B);
        CARD_THREE.addBlue(A);
        CARD_THREE.addBlue(C);
        cards.add(CARD_THREE);

        Podium CARD_FOUR = new Podium(); //5
        CARD_FOUR.addBlue(A);
        CARD_FOUR.addBlue(B);
        CARD_FOUR.addBlue(C);
        cards.add(CARD_FOUR);

        Podium CARD_FIVE = new Podium(); //6
        CARD_FIVE.addBlue(A);
        CARD_FIVE.addBlue(C);
        CARD_FIVE.addBlue(B);
        cards.add(CARD_FIVE);

        Podium CARD_SIX = new Podium(); //7
        CARD_SIX.addRed(B);
        CARD_SIX.addRed(C);
        CARD_SIX.addRed(A);

        Podium CARD_SEVEN = new Podium(); //8
        CARD_SEVEN.addRed(B);
        CARD_SEVEN.addRed(A);
        CARD_SEVEN.addRed(C);
        cards.add(CARD_SEVEN);

        Podium CARD_EIGHT = new Podium(); //9
        CARD_EIGHT.addRed(A);
        CARD_EIGHT.addRed(B);
        CARD_EIGHT.addRed(C);
        cards.add(CARD_EIGHT);

        Podium CARD_NINE = new Podium(); //10
        CARD_NINE.addRed(A);
        CARD_NINE.addRed(C);
        CARD_NINE.addRed(B);
        cards.add(CARD_NINE);

        Podium CARD_TEN = new Podium(); //11
        CARD_TEN.addRed(C);
        CARD_TEN.addRed(B);
        CARD_TEN.addRed(A);
        cards.add(CARD_TEN);

        Podium CARD_ELEVEN = new Podium(); //12
        CARD_ELEVEN.addRed(C);
        CARD_ELEVEN.addRed(A);
        CARD_ELEVEN.addRed(B);
        cards.add(CARD_ELEVEN);

        Podium CARD_TWELVE = new Podium(); //13
        CARD_TWELVE.addBlue(C);
        CARD_TWELVE.addBlue(A);
        CARD_TWELVE.addRed(B);
        cards.add(CARD_TWELVE);

        Podium CARD_THIRTEEN = new Podium(); //14
        CARD_THIRTEEN.addRed(C);
        CARD_THIRTEEN.addRed(A);
        CARD_THIRTEEN.addBlue(B);
        cards.add(CARD_THIRTEEN);

        Podium CARD_FOURTEEN = new Podium(); //15
        CARD_FOURTEEN.addBlue(C);
        CARD_FOURTEEN.addBlue(B);
        CARD_FOURTEEN.addRed(A);
        cards.add(CARD_FOURTEEN);

        Podium CARD_FIFTEEN = new Podium(); //16
        CARD_FIFTEEN.addRed(C);
        CARD_FIFTEEN.addRed(B);
        CARD_FIFTEEN.addBlue(A);
        cards.add(CARD_FIFTEEN);

        Podium CARD_SIXTEEN = new Podium(); //17
        CARD_SIXTEEN.addBlue(A);
        CARD_SIXTEEN.addBlue(C);
        CARD_SIXTEEN.addRed(B);
        cards.add(CARD_SIXTEEN);

        Podium CARD_SEVENTEEN = new Podium(); //18
        CARD_SEVENTEEN.addRed(A);
        CARD_SEVENTEEN.addRed(C);
        CARD_SEVENTEEN.addBlue(B);
        cards.add(CARD_SEVENTEEN);

        Podium CARD_EIGHTEEN = new Podium(); //19
        CARD_EIGHTEEN.addBlue(A);
        CARD_EIGHTEEN.addBlue(B);
        CARD_EIGHTEEN.addRed(C);
        cards.add(CARD_EIGHTEEN);

        Podium CARD_NINETEEN = new Podium(); //20
        CARD_NINETEEN.addRed(A);
        CARD_NINETEEN.addRed(B);
        CARD_NINETEEN.addBlue(C);
        cards.add(CARD_NINETEEN);

        Podium CARD_TWENTY = new Podium(); //21
        CARD_TWENTY.addBlue(B);
        CARD_TWENTY.addBlue(A);
        CARD_TWENTY.addRed(C);
        cards.add(CARD_TWENTY);

        Podium CARD_TWENTYONE = new Podium(); //22
        CARD_TWENTYONE.addRed(B);
        CARD_TWENTYONE.addRed(A);
        CARD_TWENTYONE.addBlue(C);
        cards.add(CARD_TWENTYONE);

        Podium CARD_TWENTYTWO = new Podium(); //23
        CARD_TWENTYTWO.addRed(B);
        CARD_TWENTYTWO.addRed(C);
        CARD_TWENTYTWO.addBlue(A);
        cards.add(CARD_TWENTYTWO);

        Podium CARD_TWENTYTHREE = new Podium(); //24
        CARD_TWENTYTHREE.addBlue(B);
        CARD_TWENTYTHREE.addBlue(C);
        CARD_TWENTYTHREE.addRed(A);
        cards.add(CARD_TWENTYTHREE);
    }
}







