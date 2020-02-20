/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jennaemorgan.phoneticdifficulty;
import com.github.jennaemorgan.phoneticdifficulty.LetterAttributes.*;
import static com.github.jennaemorgan.phoneticdifficulty.LetterUtil.*;
import java.util.HashSet;

/**
 *
 * @author Jenna Morgan <jennaedenmorgan@gmail.com>
 */
public class Consonant extends Letter {
    private Place place;
    private Manner manner;
    
    public Consonant(char ch) {
        super(ch);
        for (HashSet e: PLACE_LIST) {
            place = e;
        }
    }
    
    public boolean isSamePlace(Consonant other) {
        System.out.println(this.place);
        System.out.println(other.place);
        return other.place == this.place;
    }
}
