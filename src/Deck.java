import java.util.ArrayList;
import java.util.List;

public class Deck {
    private Card[] cards;
    private static final int deckSize = 52;
    private int currCard;

    public Deck() {
        cards = new Card[deckSize];
        currCard = 0;
        for (int i = 0; i < deckSize; i++) {
            cards[i] = new Card(i % 13, i / 13);
        }
    }
    public int getCurrCard(){
        return currCard;
    }

    public void shuffle(){
        int pos;
        Card temp;

        for (int i = 0; i < deckSize; i++) {
            pos = (int) Math.floor(Math.random() * deckSize);
            temp = cards[i];
            cards[i] = cards[pos];
            cards[pos] = temp;
        }
    }

    public Card dealCard(){
        if (currCard < deckSize - 1) {
            currCard++;
            return cards[currCard];
        }
        else {
            return null;
        }
    }

    public void printDeck(){
        int i = 1;
        for (Card x : cards){
            System.out.print(x.toString() + " ");
            if (i% 13 == 0){
                System.out.println("\n");
            }
            i++;
        }
    }

}
