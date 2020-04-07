/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jennaemorgan.phoneticdifficulty;

/**
 *
 * @author Jenna Morgan <jennaedenmorgan@gmail.com>
 */
public abstract class Letter {

    private char ipaChar;

    /**
     *
     * @param ch a char indicating a particular speech sound
     */
    public Letter(char ch) {
        ipaChar = ch;
    }

    /**
     *
     * @return the char representation of this Letter
     */
    public char getChar() {
        return ipaChar;
    }

    /**
     *
     * @return the String representation of this Letter
     */
    @Override
    public String toString() {
        return "" + ipaChar;
    }
}
