import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackjackHand {
    private List<Card> cards;
    private int score;
    private int aceCount;

    public BlackjackHand(){
        this.cards = new ArrayList();
        score = 0;
        aceCount = 0;
    }

    public int getScore(){
        return score;
    }

    public void addCard(Card card){
        cards.add(card);
        if (card.getRank() == 0){
            score += 11;
            aceCount++;
        }
        else if (card.getRank() >= 9){
            score += 10;
        }
        else {
            score += (card.getRank() + 1);
        }
        while (aceCount > 0 && score > 21){
            score -= 10;
            aceCount--;
        }
    }

    public Card getCard(int index){
        return cards.get(index);
    }
    public String toString(){
        String result = "";
        for (int i = 0; i < cards.size(); i++){
            if (i == cards.size() - 1){
                result += cards.get(i).toString();
            }
            else {
                result += cards.get(i).toString() + ", ";
            }
        }
        return result;
    }
}
