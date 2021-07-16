/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gahmadakel306796;

/**
 *
 * @author Ahmad
 */
class Card {

    private Suit suit;
    private int value = 0;

    public Card(Suit s, int v) {
        setSuit(s);
        setValue(v);
    } // end constructor
    // Sets the suit of the card.

    private void setSuit(Suit theSuit) {
        suit = theSuit;
    } // end setSuit

    /**
     * Returns the suit of the card as a constant from the Suit enum.
     *
     * @return The suit of the card.
     */
    public Suit getSuit() {
        return suit;
    } // end getSuit
    // Sets the value / number of the card.

    private void setValue(int theValue) {
        value = theValue;
    } // end setValue

    /**
     * Returns the value of the card as an int.
     *
     * @return The value of the card.
     */
    public int getValue() {
        return value;
    } // end getValue

    public String toString() {
        char suitChar = ' '; // A character version of the suit
        switch (suit) {
            case SPADE:
                suitChar = 'S';
                break;
            case CLUB:
                suitChar = 'C';
                break;
            case HEART:
                suitChar = 'H';
                break;
            case DIAMOND:
                suitChar = 'D';
                break;
        }
        String valueString = "" + value;
        return "[" + suitChar + " " + valueString + "]";
    } // end toString
} // end Card
