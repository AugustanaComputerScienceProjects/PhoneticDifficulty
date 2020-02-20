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
    
    public Letter(char ch) {
        ipaChar = ch;
    }
    
    public char getChar() {
        return ipaChar;
    }
}
