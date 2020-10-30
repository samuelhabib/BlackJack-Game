package coe318.lab5;

import java.util.Scanner;
import coe318.lab5.BlackjackGame;


public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);
    boolean boo;
    int a = 0;
   
  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println("");
      System.out.println("House Cards: " + "\n" +  this.game.getHouseCards().toString());
      System.out.println("Your Cards:" +  "\n" + this.game.getYourCards().toString());
       System.out.println("---------------------------------------------------------");
     
    }

  @Override
    public boolean hitMe() {
       
      
     
        System.out.println("Do you want another card? (Please enter 'Yes' or 'No')");
        
        String userInput = user.nextLine();
        
        
        if (userInput.contains("Yes") || userInput.contains("yes") ){
        
            boo = true;
        }
        else if(userInput.contains("No") || userInput.contains("no")){
            
            boo = false;
        }
        else{
        System.out.println("You have put an invalid input.");
                hitMe();
        }
     
    return boo;
        
    }

  @Override
    public void gameOver() {
        //FIX THIS
   
      System.out.println("The House Score: " + game.score(game.getHouseCards()));
       System.out.println("Your Cards Score: " + game.score(game.getYourCards()));   
        
        
       int score1 = game.score(game.getYourCards());
       int housescore = game.score(game.getHouseCards());
       
       if (score1 == housescore){
           System.out.println("You Lose, House wins");
           
       }
       else if (score1 > housescore && score1 <= 21 && housescore <= 21){
        
           System.out.println("You win, Congrats!");
       }
       
       else if(score1 <= 21 && housescore > 21){
        
           System.out.println("You win, Congrats!");
     
       }
       
       else if(score1 > 21){
           System.out.println("You Lose, House wins");
       }
       else{
           System.out.println("You Lose, House wins");
       }
       
    }

}
