/**
 * File: Deck.java
 * Creates a regular deck of 52 cards that holds methods for picking cards and shuffling the deck
 * Author: Dylan Walsh
 * Date: 02/18/19
 */

import java.util.ArrayList;
import java.util.Random;

class Deck{
    private ArrayList<Card> deck = new ArrayList<Card>();
    private Random rand = new Random();

    //Constructor
    public Deck(){
        
        build();

    }

    //Builds a regular deck of 52 cards
    public void build(){
        if(0 < this.deck.size()){
            this.deck.clear();
        }

        for(int i = 0; i < 4; i++){
            for(int w = 0; w < 8; w++){
                this.deck.add(new Card(w + 2));
            }
            for(int w = 0; w < 4; w++){
                this.deck.add(new Card(10));
            }
            this.deck.add(new Card(11));
        }

    }

    //Returns the amount of cards in the deck
    public int size(){return this.deck.size();}

    //Takes the card off the top and returns it
    public Card deal(){

        Card x = this.deck.get(0);
        this.deck.remove(x);

        return x;

    }

    //Takes the card at index i and returns it
    public Card pick(int i){

        Card x = this.deck.get(i);
        this.deck.remove(x);

        return x;

    }

    //Shuffles the cards in the deck randomly
    public void shuffle(){

        ArrayList<Card> temp = new ArrayList<Card>();
        while(0 < this.deck.size()){
            Card x = this.deck.get(this.rand.nextInt(this.deck.size()));
            this.deck.remove(x);
            temp.add(x);
        }

        while(0 < temp.size()){
            Card x = temp.get(this.rand.nextInt(temp.size()));
            temp.remove(x);
            this.deck.add(x);
        }

    }

    //Loop through and print all cards in the deck
    public String toString(){
        String s = "The cards in the deck are ";
        for(int i = 0; i < this.deck.size(); i++){
            s += this.deck.get(i).getValue() + ", ";
        }
        return s;
    }

    //Creates a new deck and tests the shuffle method
    public static void main(String[] args){

        Deck d = new Deck();

        System.out.println(d.size());
        System.out.println(d.toString());
        d.shuffle();
        System.out.println(d.toString());
        System.out.println(d.size());

    }

}
