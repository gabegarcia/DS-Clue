/**
 * Homework 2 DS-Clue
 * Write a Driver that solves the case in less than 21 tries.
 * DetectiveJill.java driver class
 * 
 * @author Gabe Garcia
 * @version 1.0
 * @Date 0/28/2021
 * 
 */


package edu.miracosta.cs113;

import java.util.Random;
import java.util.Scanner;
import model.Theory;
import model.AssistantJack;

public class DetectiveJill {

		public static void main(String[] args) {
			int answerSet, solution;
			int murder, weapon, location;
			//murder = weapon = location = 1;
			Theory answer;
	        AssistantJack jack;
	        Scanner keyboard = new Scanner(System.in);
	        Random random = new Random();
	     
	        System.out.println("Dective Jill is working on 5 cases and tyring to solve each case in less than 21 tries...");
	        
	        for(int i = 1; i < 6; i++) {
	        	murder = weapon = location = 1;
	        	System.out.println("\nDetective Jill is working on case " + i);
			     // PROCESSING
			        jack = new AssistantJack(3); //setting this int to 3 so that AssistantJack() constructor will always create a random answerSet.
			        
			        //track 'solution' and change weapon, location, murder based on 'solution'
			        solution = jack.checkAnswer(weapon, location, murder);
			        if(solution != 0) {
			        	
			        
				        do {
				        	if(solution == 1) {weapon += 1;}
				        	else if(solution == 2) {location += 1;} 
				            else if(solution == 3) {murder += 1;}
				            
				            solution = jack.checkAnswer(weapon, location, murder);
				            
				        } while (solution != 0);
				        
			        }
			        
			        //This is the correct Theory
			        answer = new Theory(weapon, location, murder);
			        
		
			        // OUTPUT
			        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);
		
			        if (jack.getTimesAsked() > 20) {
			            System.out.println("FAILED!! You're a horrible Detective...");
			        } else {
			            System.out.println("WOW! You might as well be called Batman!");
			        }
		
				}
		}     
	
}
