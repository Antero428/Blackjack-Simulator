/**
 * File: Simulation.java
 * Creates a simulation of 1000 games between a dealer and a player and prints the results
 * Author: Dylan Walsh
 * Date: 02/18/19
 */

import java.util.ArrayList;

class Simulation{
    public static void main(String[] args){
        ArrayList<Integer> win = new ArrayList<Integer>();
        ArrayList<Integer> loss = new ArrayList<Integer>();
        ArrayList<Integer> push = new ArrayList<Integer>();
        ArrayList<Integer> error = new ArrayList<Integer>();
        Blackjack b = new Blackjack();
        for(int i = 0; i < 1000; i++){
            int x = b.game(false);
            if(x == 0){
                push.add(1);
            }
            else if(x == -1){
                loss.add(1);
            }
            else if(x == 1){
                win.add(1);
            }
            else if(x == 5){
                error.add(1);
            }
        }
        System.out.println("The results are \nPlayer wins: " + win.size() + "\nPlayer win percentage: " + win.size()/1000.00*100 + "\nDealer wins: " + loss.size() + "\nDealer win percentage: " + loss.size()/1000.00*100 + "\nTimes pushed: " + push.size() + "\nPush Percentage: " + push.size()/1000.00*100 + "\nErrors: " + error.size());
    }

}