//package org.Alex;
//
//import java.util.ArrayList;
//
//public class Hand {
//
//    public ArrayList<Card> cards;
//
//    public Hand() {
//        cards = new ArrayList<Card>();
//    }
//
//    public void clear() {
//        cards.clear();
//    }
//
//    public void add(Card card) {
//        cards.add(card);
//    }
//
//    public String showHand() {
//
//        String string = "";
//        boolean allFaceUp = true;
//        for (Card c : cards) {
//            string += c.toString() + "\n";
//            if (!c.isFaceUp) {
//                allFaceUp = false;
//            }
//        }
//        if (allFaceUp) {
//            string += "Total points: " + getTotal() + "\n";
//        }
//        return string;
//    }
//
//    public void flipCards() {
//        for (Card card : cards) {
//            card.flipCard();
//        }
//    }
//
//    public boolean give(Card card, Hand otherHand) {
//        if (!(cards.contains(card))) {
//            return false;
//        } else {
//            cards.remove(card);
//            otherHand.add(card);
//            return true;
//        }
//    }
//
//    public int getTotal() {
//        int totalPoints = 0;
//        boolean hasAce = false;
//        for (int i = 0; i < cards.size(); i++) {
//            totalPoints += cards.get(i).getRank();
//            if (cards.get(i).printRank() == "Ace") {
//                hasAce = true;
//            }
//            if (hasAce && totalPoints <= 11) {
//                totalPoints += 10;
//            }
//        }
//
//        return totalPoints;
//    }
//
//    public String toString() {
//        String string = "";
//        for (Card card : cards) {
//            string += card.toString() + "\n";
//        }
//        return string;
//    }
//
//}
