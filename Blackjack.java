/**
 * File: Blackjack.java
 * creates a game of blackjack between a player and a dealer
 * Author: Dylan Walsh
 * Date: 02/18/19
 */

 import java.util.Scanner;

class Blackjack{

    private Deck deck = new Deck();
    private Hand plrHand = new Hand();
    private Hand dlrHand = new Hand();

    //Constructor sets up new deck for blackjack
    public Blackjack(){
        reset(true);
    }

    //Creates a new deck and shuffles if the first time calling if not it will just build and reshuffle the deck
    public void reset( boolean newDeck ) {

        if(newDeck){

            this.deck = new Deck();
            this.deck.build();
            this.deck.shuffle();

        }

        else{ 

            this.deck.build();
            this.deck.shuffle();

        }

    }

    //deals 2 cards to each hand
    public void deal(){

        for(int i = 0; i < 2; i++){

            plrHand.add(this.deck.deal());
            dlrHand.add(this.deck.deal());

        }

    }

    //Prints the cards in both hands
    public String toString(){
        
        return "Player's Hand Value: " + Integer.toString(this.plrHand.getTotalValue()) + "\nDealer's Hand Value: " + Integer.toString(this.dlrHand.getTotalValue());

    } 

    //Player adds cards to hand until total value is at least 16 if the value is over 21 they busted and will return false
    public boolean playerTurn(){

        int total = plrHand.getTotalValue();
        while(total < 16){
            plrHand.add(this.deck.deal());
            total = plrHand.getTotalValue();
        }
        if(total > 21){
            return false;
        }
        else{
            return true;
        }

    }

    //Dealer adds cards to hand until total value is at least 17 if the value is over 21 they busted and will return false
    public boolean dealerTurn(){
        if(playerTurn() == false){
            return true;
        }
        int total = dlrHand.getTotalValue();
        while(total < 17){
            dlrHand.add(this.deck.deal());
            total = dlrHand.getTotalValue();
        }
        if(total > 21){
            return false;
        }
        else{
            return true;
        }

    }

    //Plays a game of blackjack and prints the initial hands, the finals hands, and the result of the game.
    public int game(boolean verbose){

        if(verbose){
            if(this.deck.size() < 26){
                reset(true);
            }
            this.plrHand.reset();
            this.dlrHand.reset();
            deal();
            System.out.println("Initial: \n" + toString());
            playerTurn();
            dealerTurn();
            System.out.println("Final: \n" + toString());
            if(this.plrHand.getTotalValue() > 21){
                System.out.println("Result: Dealer wins\n");
                return -1;
            }
            else if(this.dlrHand.getTotalValue() > 21){
                System.out.println("Result: Player wins\n");
                return 1;
            }
            else if(this.plrHand.getTotalValue() < this.dlrHand.getTotalValue()){
                System.out.println("Result: Dealer wins\n");
                return -1;
            }
            else if(this.plrHand.getTotalValue() > this.dlrHand.getTotalValue()){
                System.out.println("Result: Player wins\n");
                return 1;
            }
            else if(this.plrHand.getTotalValue() == this.dlrHand.getTotalValue()){
                System.out.println("Result: Push\n");
                return 0;
            }
        }
        else{
            if(this.deck.size() < 26){
                reset(true);
            }
            this.plrHand.reset();
            this.dlrHand.reset();
            deal();
            playerTurn();
            dealerTurn();
            if(this.plrHand.getTotalValue() > 21){
                return -1;
            }
            else if(this.dlrHand.getTotalValue() > 21){
                return 1;
            }
            else if(this.plrHand.getTotalValue() < this.dlrHand.getTotalValue()){
                return -1;
            }
            else if(this.plrHand.getTotalValue() > this.dlrHand.getTotalValue()){
                return 1;
            }
            else if(this.plrHand.getTotalValue() == this.dlrHand.getTotalValue()){
                return 0;
            }
        }
        return 5;
    }

    //Runs three games of blackjack
    public static void main(String[] args){

        Blackjack b = new Blackjack();

        b.game(true);
        b.game(true);
        b.game(true);



    }
}