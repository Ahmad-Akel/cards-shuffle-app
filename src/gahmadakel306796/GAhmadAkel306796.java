/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gahmadakel306796;

import java.util.ArrayDeque;
import org.w3c.dom.css.Counter;

/**
 *
 * @author Ahmad
 */
public class GAhmadAkel306796 {

    /**
     * @param args the command line arguments
     */
    private static void printContent(ArrayDeque<Card> content) {
        for (Card c : content) {
            System.out.print(c.toString() + " ");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Deck d = new Deck(8);

        ArrayDeque<Card> generatedContent = d.generateContent(d.Size);
        System.out.println("---Testing Number of In-Shuffles to Return to Original Order---");
        System.out.println("IN-SHUFFLE #1");
        System.out.print("Original Deck : ");
        printContent(generatedContent);
        ArrayDeque<Card> InShiffled = d.INShuffle(generatedContent);
        System.out.print("shuffled: ");
        printContent(InShiffled);
        System.out.println("");

        int inShuffleCounter = 2;
        boolean isEqual = false;
        while (isEqual == false) {
            InShiffled = d.INShuffle(InShiffled);
            System.out.println("\n" + "--shuffle " + "#" + inShuffleCounter + "--");
            System.out.println("IN-SHUFFLE");
            System.out.print("Original Deck : ");
            printContent(generatedContent);
            printContent(InShiffled);
            isEqual = d.nextShufler(InShiffled, d.generateContent(d.Size));
            if (!isEqual) {
                inShuffleCounter++;
            }

        }
        System.out.println("\nCounter " + inShuffleCounter);

        ArrayDeque<Card> outShiffled = d.outShuffle(d.generateContent(d.Size));
        System.out.println("#1 OUT");
        printContent(outShiffled);
        System.out.println("");
        int outShuffleCounter = 2;
        boolean isEqual_out = false;
        while (isEqual_out == false) {
            outShiffled = d.outShuffle(outShiffled);
            System.out.println("\n" + "#" + outShuffleCounter + " OUT Shuffled :");
            printContent(outShiffled);
            isEqual_out = d.nextShufler(outShiffled, d.generateContent(d.Size));
            if (!isEqual_out) {
                outShuffleCounter++;
            }

        }
        System.out.println("\nCounter " + outShuffleCounter);

    }

}
