package com.jetbrains;

import java.util.Arrays;
import java.util.Scanner;

/**
 * LAB 8 GOALS
 * Ask for number of players and create a jagged array based on those numbers.
 * Ask user for number of at-bats.
 * Ask user for number of bases earned per each at bat.
 * Calculate and display batting average.
 * Calculate and display slugging percentage.
 * Use validation to validate # of bases and number of players.
 * Use methods to calculate and display averages & percentages.
 */

public class Main {

    public static void main(String[] args) {

        Scanner scan1 = new Scanner(System.in);
        double sum = 0.0;
        double battingAverage = 0.0;
        double sluggingPercentage = 0.0;
        double sluggingCount = 0.0;
        double atBatCount = 0.0;

        System.out.println("Welcome, fellow human! Please enter a number of players you'd like to evaluate: ");
        int numberOfPlayers = scan1.nextInt();
        int[][] playersArray = new int[numberOfPlayers][];

        for (int i = 0; i < playersArray.length; i++) {
            System.out.printf("Enter a number of times at-bat for player " + (i + 1) + " in their at bat #" + (i + 1) + ": ", i + 1);
            int atBatNumber = scan1.nextInt();
            playersArray[i] = new int[atBatNumber];

            for (int j = 0; j < playersArray[i].length; j++) {
                System.out.printf("Please enter how many bases earned for player # " + (i + 1) + ": ", i + 1, j + 1);
                //make into a new array?
                playersArray[i][j] = scan1.nextInt();

                //validation for bases
                if (playersArray[i][j] > 4 || playersArray[i][j] < 0) {
                    System.out.println("Oops! That wasn't a correct number of bases. ");
                    System.out.printf("Please enter how many bases earned for player # " + (i + 1) + ": ", i + 1, j + 1);
                    playersArray[i][j] = scan1.nextInt();
                }
            }
        }

        //TODO make this into its own method
        //this calculates batting average
        for (int i = 0; i < playersArray.length; i++) {
            for (int j = 0; j < playersArray[i].length; j++) {
                sum = sum + playersArray[i][j];
            }
            battingAverage = sum / playersArray[i].length;
            sum = 0.0;
            System.out.printf("Batting average for player " + (i + 1) + " is: %.3f", battingAverage);
            System.out.println();

        }

        //this calculates slugging percent method
        //TODO make this into its own method
        for (int i = 0; i < playersArray.length; i++) {
            for (int j = 0; j < playersArray[i].length; j++) {
                atBatCount = atBatCount + 1.0;
                if (playersArray[i][j] >= 1.0) {
                    sluggingCount = sluggingCount + 1.0;
                }
            }
            sluggingPercentage = sluggingCount / atBatCount;
            atBatCount = 0.0;
            sluggingCount = 0.0;
            System.out.printf("Slugging percentage for player " + (i + 1) + " is: %.3f", sluggingPercentage);
            System.out.println("%");

        }
        System.out.println();
        System.out.println("The whole array is: " + Arrays.deepToString(playersArray));

    }
}

