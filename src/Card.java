public class Card {
    private int rank;
    private int suit;
    private static String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
            "10", "Jack", "Queen", "King"};
    private static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public Card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit(){
        return suit;
    }

    public static String rankString(int rank){
        return ranks[rank];
    }
    public String toString(){
        return ranks[rank] + " of " + suits[suit];
    }
}
