/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gahmadakel306796;

import java.util.ArrayDeque;

/**
 *
 * @author Ahmad
 */
public class Deck {

    private ArrayDeque<Card> contents;
    private ArrayDeque<Card> originalContent;
    private ArrayDeque<Card> firstHalf;
    private ArrayDeque<Card> secoundHalf;
    private ArrayDeque<Card> outShuffeldContent;
    public int Size = 0;

    public Deck(int numberOfCards) {

        this.Size = numberOfCards;

    } // end constructor

    /**
     * Returns the contents of the deck.
     *
     * @return The contents of the deck.
     */
    public ArrayDeque<Card> getContents() {
        return this.originalContent;
    }

    public boolean nextShufler(ArrayDeque<Card> content, ArrayDeque<Card> _original) {

        boolean isEqual = false;
        if (content.size() != _original.size()) {
            return false;
        }
        Object shuffledContent[] = content.toArray();
        Object orgContent[] = _original.toArray();
        for (int i = 0; i < shuffledContent.length; i++) {
            isEqual = shuffledContent[i].toString().equals(orgContent[i].toString());
            if (!isEqual) {
                return false;
            }
        }
        return isEqual;
    }

    public ArrayDeque<Card> getTopHalf( ) {
        return firstHalf;
    }

    public ArrayDeque<Card> getBottomHalf() {
        return secoundHalf;
    }

    /**
     * Performs a perfect out-shuffle.
     */
    public ArrayDeque<Card> outShuffle(ArrayDeque<Card> content) {
        // First Cut to half ; 
        ArrayDeque<Card> outShuffeldContent = new ArrayDeque<>();
        devideDequeToHalf(content);
        ArrayDeque<Card> first = firstHalf;
        ArrayDeque<Card> sec = secoundHalf;

        while (first.size() > 0 || sec.size() > 0) {
            if (first.size() > 0) {
                outShuffeldContent.addFirst(first.pollFirst());

            }
            if (sec.size() > 0) {
                outShuffeldContent.addFirst(sec.pollFirst());

            }
        }

        return outShuffeldContent;
    } // end outShuffle

    /**
     * Performs a perfect out-shuffle.
     */
    // OUT
    public ArrayDeque<Card> INShuffle(ArrayDeque<Card> content) {
        ArrayDeque<Card> inShuffeldContent = new ArrayDeque<>();
        devideDequeToHalf(content);
        ArrayDeque<Card> first = firstHalf;
        ArrayDeque<Card> sec = secoundHalf;

        while (sec.size() > 0 || first.size() > 0) {

            if (sec.size() > 0) {

                inShuffeldContent.addFirst(sec.pollFirst());
            }
            if (first.size() > 0) {

                inShuffeldContent.addFirst(first.pollFirst());
            }

        }

        return inShuffeldContent;
    } // end outShuffle

    private void devideDequeToHalf(ArrayDeque<Card> contentTobeCutted) {
        int contentSize = contentTobeCutted.size();
        ArrayDeque<Card> mockDeque = contentTobeCutted;
        firstHalf = new ArrayDeque<>();
        secoundHalf = new ArrayDeque<>();
        if (contentSize > 1 && contentSize % 2 == 0) {
            for (int i = 1; i <= contentSize; i++) {
                if (i > contentSize / 2) {
                    secoundHalf.add(mockDeque.pollLast());
                } else {
                    //top
                    firstHalf.add(mockDeque.pollLast());
                }
            }

        }
    }

    public ArrayDeque<Card> generateContent(int num) {

        ArrayDeque<Card> generatedContent = new ArrayDeque<>(num);

        for (int i = 1; i <= num; i++) {

            generatedContent.add(new Card(Suit.SPADE, i));
        }
        return generatedContent;
    }

    /**
     * Shifts the top card of the deck a given number of positions down in the
     * deck.
     *
     * @param position The number of positions to move the top card by.
     * @param messages Whether or not messages should be displayed.
     */
    public void moveTop(int position, boolean messages) {

    } // end shiftFirst
}
