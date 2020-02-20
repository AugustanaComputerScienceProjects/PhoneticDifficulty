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
public class LetterAttributes {
    public enum Place {
        LABIAL, CORONAL, DORSAL, GLOTTAL;
    } 
    
    public enum Manner {
        STOP, NASAL, GLIDE, FRICATIVE, AFFRICATE, LIQUID;
    }
    
    public enum Rhoticity {
        RHOTIC, NOT_RHOTIC;
    }
}
