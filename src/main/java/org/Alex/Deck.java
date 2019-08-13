package org.Alex;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    Random rand = new Random();

    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    public void populate() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suit);
                card.flipCard();
                this.cards.add(card);
            }
        }
    }

    public void shuffle() {
        for (int i = cards.size() - 1; i>0; i--){
            int pick = rand.nextInt(i);
            Card randCard = cards.get(pick);
            Card lastCard = cards.get(i);
            cards.set(i,randCard);
            cards.set(pick,lastCard);
        }

    }

    public void removeCard(int i){
        this.cards.remove(i);
    }

    public Card getCard(int i){
      return   this.cards.get(i);
    }

    public void addCard(Card addCard){
        this.cards.add(addCard);
    }

    public void draw(Deck comingFrom){
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }

    public int deckSize(){
        return this.cards.size();
    }

    public void moveAllToDeck(Deck moveTo){
        int thisDeckSize = this.cards.size();

        for (int i = 0;i<thisDeckSize;i++){
            moveTo.addCard(this.getCard(i));
        }
        for (int i = 0;i<thisDeckSize;i++){
            this.removeCard(0);
        }
    }


    public int getTotal() {
        int totalPoints = 0;
        boolean hasAce = false;
        for (int i = 0; i < cards.size(); i++) {
            totalPoints += cards.get(i).getRank();
            if (cards.get(i).printRank().equals("Ace")) {
                hasAce = true;
            }
            if (hasAce && totalPoints <= 11) {
                totalPoints += 10;
            }
        }

        return totalPoints;
    }


    public String toString() {
        String string = "";
        for (Card card : cards) {
            string += card.toString() + "\n";
        }
        return string;

    }
}
