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
    //represents the groupings of the various places in the mouth consonants can
    //be articulated in American English
    public enum Place {
        LABIAL, CORONAL, DORSAL, GLOTTAL;
    } 
    
    //represents the groupings of the various manners in which one can obstruct
    //airflow to articulate consonants in American English
    public enum Manner {
        STOP, NASAL, GLIDE, FRICATIVE, AFFRICATE, LIQUID;
    }
    
    //represents normal vowels as well as "r-like" vowels which can double as 
    //consonants
    public enum Rhoticity {
        RHOTIC, NON_RHOTIC;
    }
}
