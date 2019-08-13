package org.Alex;

import java.util.Scanner;

public class Game {

    public void start() {

        Scanner in = new Scanner(System.in);

        Deck deck = new Deck();
        deck.populate();
        deck.shuffle();

        System.out.println("Enter your name:");
        String playerName = in.nextLine();
        System.out.println("Hi " + playerName + ", welcome to blackjack.");

        Deck playerHand = new Deck();
        Deck dealerHand = new Deck();

        double playerMoney = 100;

        while (playerMoney > 0) {

            System.out.println("You have $" + playerMoney + "." + " How much you want to bet?");
            double playerBet = in.nextDouble();
            if (playerBet > playerMoney) {
                System.out.println("You can not bet more then you have.Please leave!");
                break;
            }

            boolean endRound = false;

            playerHand.draw(deck);
            playerHand.draw(deck);

            dealerHand.draw(deck);
            dealerHand.draw(deck);


            while (true) {

                System.out.println("Your hand:");
                System.out.println(playerHand.toString());
                System.out.println("Your hand is valued at: " + playerHand.getTotal());

                System.out.println("Dealer's hand: " + dealerHand.getCard(0).toString() + " and [Hidden]");

                System.out.println("Would you like to (1)Hit or (2)Stand?");
                int response = in.nextInt();
                if (response == 1) {
                    playerHand.draw(deck);
                    System.out.println("You draw a: " + playerHand.getCard(playerHand.deckSize() - 1).toString());
                    if (playerHand.getTotal() > 21) {
                        System.out.println("Bust.Currently valued at: " + playerHand.getTotal());
                        playerMoney = playerMoney - playerBet;
                        endRound = true;
                        break;
                    }

                }

                if (response == 2) {
                    break;
                }

            }

            System.out.println("Dealer cards: " + dealerHand.toString());
            if (dealerHand.getTotal() > playerHand.getTotal() && !endRound) {
                System.out.println("Dealer beats you!");
                playerMoney = playerMoney - playerBet;
                endRound = true;

            }
            while (dealerHand.getTotal() < 17 && !endRound) {
                dealerHand.draw(deck);
                System.out.println("Dealer Draws: " + dealerHand.getCard(dealerHand.deckSize() - 1).toString());
            }
            System.out.println("Dealer's hand is valued at: " + dealerHand.getTotal());
            if (dealerHand.getTotal() > 21 && !endRound) {
                System.out.println("Dealer busts!You win.");
                playerMoney = playerMoney + playerBet;
                endRound = true;
            }
            if (playerHand.getTotal() == dealerHand.getTotal() && !endRound) {
                System.out.println("Push");
                endRound = true;
            }
            if (playerHand.getTotal() > dealerHand.getTotal() && !endRound) {
                System.out.println("You win the hand!");
                playerMoney = playerMoney + playerBet;
                endRound = true;
            } else if (!endRound) {
                System.out.println("You lose the hand.");
                playerMoney = playerMoney - playerBet;
                endRound = true;
            }

            playerHand.moveAllToDeck(deck);
            dealerHand.moveAllToDeck(deck);
            deck.moveAllToDeck(deck);
            System.out.println("End of hand");

        }

        System.out.println("You are out of money!Game over!");


    }
}
