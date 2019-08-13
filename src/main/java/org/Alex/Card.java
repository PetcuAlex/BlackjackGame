package org.Alex;

public class Card {

    private Suit suit;
    private Rank rank;
    public boolean isFaceUp;

    public Card(Rank rank,Suit suit){
        this.rank = rank;
        this.suit = suit;
        isFaceUp = false;
    }

    public String getSuit(){
        return suit.printSuit();
    }

    public int getRank(){
        return rank.getRank();
    }

    public String printRank(){
        return rank.printRank();
    }

    public void flipCard(){
        isFaceUp = true;
    }

    @Override
    public String toString() {
        String string = "";
        if (isFaceUp){
            string+= rank.printRank() + " of " + suit.printSuit();
        }else {
            string+="Nothing to see here.This card is face down";
        }
        return string;
    }
}
