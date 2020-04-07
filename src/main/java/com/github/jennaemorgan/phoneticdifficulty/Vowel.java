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
public class Vowel extends Letter {

    private Rhoticity rhoticity;

    /**
     *
     * @param ch a char indicating a particular vowel sound
     */
    public Vowel(char ch) {
        super(ch);
        for (String key : RHOTICITY_LIST.keySet()) {
            if (key.indexOf(ch) != -1) {
                rhoticity = RHOTICITY_LIST.get(key);
            }
        }
    }

}
