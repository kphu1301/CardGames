import java.util.Scanner;

public class Blackjack extends Deck {
    private BlackjackHand dealerHand;
    private BlackjackHand playerHand;


    public Blackjack() {
        super();
    }

    public void play() {
        char response;
        super.shuffle();

        playerHand = new BlackjackHand();
        dealerHand = new BlackjackHand();

        for (int i = 0; i < 2; i++) {
            playerHand.addCard(super.dealCard());
            dealerHand.addCard(super.dealCard());
        }

        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Player's Hand: " + playerHand.toString() +
                    ". Score: " + playerHand.getScore());
            System.out.println("Dealer's Hand: " + dealerHand.getCard(0).toString() + ", ?");
            System.out.println("Hit or Stay? (H/S)");
            response = in.nextLine().charAt(0);
            response = Character.toUpperCase(response);

            if (response == 'H') {
                System.out.println("Player Hits");
                playerHand.addCard(super.dealCard());
            }
        } while(playerHand.getScore() < 21 && response == 'H');

        if (playerHand.getScore() > 21) {
            System.out.println("Player Score: " + playerHand.getScore() + ". Bust! You Lose!");
        } else {
            System.out.println("Dealer's Hand: " + dealerHand.toString() +
                    ". Score: " + dealerHand.getScore());
            while (dealerHand.getScore() < 17) {
                System.out.println("Dealer Hits");
                dealerHand.addCard(super.dealCard());
                System.out.println("Dealer's Hand: " + dealerHand.toString() +
                        ". Score: " + dealerHand.getScore());
            }

            if (dealerHand.getScore() > 21) {
                System.out.println(playerHand.getScore() + " > " + dealerHand.getScore());
                System.out.println("Dealer Busts. You Win!");
            }
            else if (playerHand.getScore() > dealerHand.getScore()) {
                System.out.println(playerHand.getScore() + " > " + dealerHand.getScore());
                System.out.println("You Win!");
            }
            else if (playerHand.getScore() < dealerHand.getScore()) {
                System.out.println(playerHand.getScore() + " < " + dealerHand.getScore());
                System.out.println("You Lose!");
            }
            else {
                System.out.println(playerHand.getScore() + " = " + dealerHand.getScore());
                System.out.println("Tie!");
            }
        }
    }
}
