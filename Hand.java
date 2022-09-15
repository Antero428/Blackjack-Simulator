/**
 * File: Hand.java
 * Creates an array list to hold Cards which will be the player and dealer hands in a game of black jack
 * Author: Dylan Walsh
 * Date: 02/18/19
 */

import java.util.ArrayList;

class Hand{
    private ArrayList<Card> hand;
    
    //Contructor creates a new Array List of Cards
    public Hand(){

        this.hand = new ArrayList<Card>();

    }

    //Clears the hand of its cards
    public void reset(){

        hand.clear();

    }

    //Adds a card to the hand
    public void add( Card card ){

        this.hand.add(card);

    }

    //Returns the amount of cards in the hand
    public int size(){ return this.hand.size();}

    //Gets card at position i
    public Card getCard( int i ){return this.hand.get(i-1);}

    //Adds the total values of the cards together then returns it
    public int getTotalValue(){

        int total = 0;
        for(int i = 0; i < this.hand.size(); i++){

            total += this.hand.get(i).getValue();

        }
        return total;
    }


    //Will loop through and print each card in the hand
    public String toString(){
        String s = "The cards in the deck are ";
        for(int i = 0; i < this.hand.size(); i++){
            s += this.hand.get(i).getValue() + ", ";
        }
        return s;
    }

    //adds three cards to a hand and tests all methods in the class
    public static void main(String[] args){

        Card a = new Card(1);
        Card b = new Card(2);
        Card c = new Card(3);

        Hand h = new Hand();
        h.add(a);
        h.add(b);
        h.add(c);

        System.out.println(h.size());

        System.out.println(h.getCard(1).getValue());

        System.out.println(h.getTotalValue());

        System.out.println(h.toString());

        h.reset();

        System.out.println(h.size());



    }

}