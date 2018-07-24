import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokerHand {
    static class rankComparator implements Comparator<Card> {
        public int compare(Card a, Card b){
            int aRank = a.getRank();
            int bRank = b.getRank();
            if (aRank == 0){
                aRank = 13;
            }
            if (bRank == 0){
                bRank = 13;
            }
            if (aRank > bRank){
                return 1;
            }
            else if (aRank < bRank){
                return -1;
            }
            else {
                return 0;
            }
        }

    }

    private static String[] handSrengths = {"High Card", "Pair", "Two Pairs", "Three of a Kind",
            "Straight", "Flush", "Full House", "Four of a Kind", "Straight Flush", "Royal Flush"};
    private List<Card> cards;
    private int[] rankFreqs;
    private int maxFreq;
    private int handStrength;
    private int size;

    public PokerHand() {
        cards = new ArrayList();
        rankFreqs = new int[13];
        maxFreq = 0;
        handStrength = 0;
        size = 0;
    }

    public void addCard(Card card){
        cards.add(card);
        size++;
        rankFreqs[card.getRank()]++;
        if (rankFreqs[card.getRank()] > maxFreq){
            maxFreq = rankFreqs[card.getRank()];
        }
    }

    public int getSize(){
        return size;
    }
    public void sort(){
        Collections.sort(cards, new rankComparator());
    }

    public int getHandStrength(){
        return handStrength;
    }
    public String getHand(){
        return handSrengths[handStrength];
    }
    public void discard(int index){
        Card card = cards.remove(index);
        size--;
        rankFreqs[card.getRank()]--;
    }
    public void updateMaxFreq(){
        maxFreq = 0;
        for (int i = 0; i < rankFreqs.length; i++){
            if (rankFreqs[i] > maxFreq){
                maxFreq = rankFreqs[i];
            }
        }
    }


    public void evaluateHand(){
        sort();
        updateMaxFreq();
        if (isRoyalFlush()){
            handStrength = 9;
        }
        else if (isStraightFlush()){
            handStrength = 8;
        }
        else if (isFourOfAKind()){
            handStrength = 7;
        }
        else if (isFullHouse()){
            handStrength = 6;
        }
        else if (isFlush()){
            handStrength = 5;
        }
        else if (isStraight()){
            handStrength = 4;
        }
        else if (isThreeOfAKind()){
            handStrength = 3;
        }
        else if (isTwoPairs()){
            handStrength = 2;
        }
        else if (isPair()){
            handStrength = 1;
        }
        else {
            handStrength = 0;
        }
    }

    public Card getCard(int index){
        return cards.get(index);
    }

    public boolean isRoyalFlush(){
        return isStraightFlush() && cards.get(0).getRank() == 9;

    }
    public boolean isStraightFlush(){
        return isStraight() && isFlush();
    }

    public boolean isFourOfAKind(){
        if (maxFreq == 4){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isFullHouse(){
        if (isThreeOfAKind()){
            if (cards.get(0).getRank() == cards.get(1).getRank() &&
                    cards.get(3).getRank() == cards.get(4).getRank()){
                return true;
            }
        }
        return false;
    }
    public boolean isFlush(){
        int suit = cards.get(0).getSuit();
        for (int i = 1; i < cards.size(); i++){
            if (cards.get(i).getSuit() != suit){
                return false;
            }
        }
        return true;
    }
    public boolean isStraight(){
        for (int i = 1; i < cards.size(); i++){
            if (cards.get(i).getRank() - cards.get(i - 1).getRank() != 1){
                return false;
            }
        }
        return true;
    }
    public boolean isThreeOfAKind(){
        if (maxFreq == 3){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isTwoPairs(){
        int pairCount = 0;
        if (isPair()){
            for (int i = 0; i < rankFreqs.length; i++){
                if (rankFreqs[i] == 2){
                    pairCount++;
                }
            }
        }
        if (pairCount == 2){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isPair(){
        if (maxFreq == 2){
            return true;
        }
        else {
            return false;
        }
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
