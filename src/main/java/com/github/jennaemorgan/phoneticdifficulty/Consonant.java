/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jennaemorgan.phoneticdifficulty;

import com.github.jennaemorgan.phoneticdifficulty.LetterAttributes.*;
import static com.github.jennaemorgan.phoneticdifficulty.LetterUtil.*;

/**
 *
 * @author Jenna Morgan <jennaedenmorgan@gmail.com>
 */
public class Consonant extends Letter {

    private Place place;
    private Manner manner;

    /**
     *
     * @param ch a char indicating a particular consonant sound
     */
    public Consonant(char ch) {
        super(ch);
        for (String key : PLACE_LIST.keySet()) {
            if (key.indexOf(ch) != -1) {
                place = PLACE_LIST.get(key);
            }
        }
        for (String key : MANNER_LIST.keySet()) {
            if (key.indexOf(ch) != -1) {
                manner = MANNER_LIST.get(key);
            }
        }
    }

    /**
     *
     * @return the place of articulation of this Consonant
     */
    public Place getPlace() {
        return place;
    }

    /**
     *
     * @param other another Consonant to be compared to
     * @return true if this and other have the same place of articulation,
     * otherwise false
     */
    public boolean isSamePlace(Consonant other) {
        return other.place == this.place;
    }
}
