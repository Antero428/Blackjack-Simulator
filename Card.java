/**
 * File: Card.java
 * Creates a Card with a specific value
 * Author: Dylan Walsh
 * Date: 02/18/19
 */

public class Card {
    private int cValue = 0;

    // Constructor assignes the cards value to v if v is between 0 and 12
    public Card(int v){
        
        if(v > 0 && v < 12){
            this.cValue = v;
        }

    }

    //Returns the Cards value
    public int getValue(){ return this.cValue; }

    //Main code tests to see if the setter and getter works
    public static void main(String[] args){

        Card x = new Card(5);
        System.out.println("The card is " + x.getValue());

    }

}