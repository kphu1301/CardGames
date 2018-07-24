import java.util.Scanner;

public class CardGames {
    static Scanner scan = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("\nWelcome to CardGames!");
        System.out.println("1. Play BlackJack\n2. Play Poker\n3. Quit");
    }

    public static int getChoice() {
        int response = 0;
        try {
            response = scan.nextInt();

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");

        }
        return response;
    }

    public static void play(int choice) {
        char response;
        if (choice == 1) {
            Blackjack game = new Blackjack();
            do {
                game.play();
                System.out.println("Play Again? (Y/N)");
                response = scan.next().charAt(0);
                System.out.println("YEEEEEE" + response);
                response = Character.toUpperCase(response);
            } while (response == 'Y');
        } else {
            Poker game = new Poker();
            do {
                game.play();
                System.out.println("Play Again? (Y/N)");
                response = scan.next().charAt(0);
                response = Character.toUpperCase(response);
            } while (response == 'Y');
        }
    }


    public static void main(String[] args) {
        int choice = 0;
        do {
            displayMenu();
            choice = getChoice();
            switch (choice) {
                case 1:
                    play(1);
                    break;
                case 2:
                    play(2);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Please enter a valid number (1-3)");
                    break;
            }
        } while(choice != 3);
    }
}
