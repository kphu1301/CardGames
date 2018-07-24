import java.util.Scanner;

public class Poker extends Deck {
    PokerHand dealerHand;
    PokerHand playerHand;

    public Poker(){
        super();
    }

    public void play(){
        super.shuffle();
        playerHand = new PokerHand();
        dealerHand = new PokerHand();

        for (int i = 0; i < 5; i++){
            playerHand.addCard(super.dealCard());
            dealerHand.addCard(super.dealCard());
        }
        playerHand.evaluateHand();
        Scanner in = new Scanner(System.in);


        System.out.println("Player's Hand: " + playerHand.toString() + ". " +
                playerHand.getHand());
        System.out.println("How many cards would you like to discard?");
        int numCardsToDiscard = in.nextInt();
        int index;
        if (numCardsToDiscard == 5){
            for (int i = 0; i < numCardsToDiscard; i++){
                playerHand.discard(0);
            }
        }
        else {
            for (int i = 0; i < numCardsToDiscard; i++) {
                System.out.println("Enter index of card you'd like to discard " +
                        "(1 - " + playerHand.getSize() + ")");
                index = in.nextInt() - 1;
                System.out.println("Discarding Card " + (index + 1) + ": " + playerHand.getCard(index).toString());
                playerHand.discard(index);
                System.out.println("Player's Hand: " + playerHand.toString());
            }
        }
        System.out.print("Dealing " + numCardsToDiscard + " cards: ");
        for (int i = 0; i < numCardsToDiscard; i++){
            Card temp = super.dealCard();
            System.out.print(temp.toString() + " ");
            playerHand.addCard(temp);
        }
        System.out.println();
        playerHand.evaluateHand();
        System.out.println("Player's Hand: " + playerHand.toString() + ". " + playerHand.getHand());
    }
}
