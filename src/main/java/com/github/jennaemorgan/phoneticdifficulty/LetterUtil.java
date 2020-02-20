/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jennaemorgan.phoneticdifficulty;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Jenna Morgan <jennaedenmorgan@gmail.com>
 */
public final class LetterUtil {
    public static final HashSet LABIALS, CORONALS, DORSALS, GLOTTALS, STOPS,
            NASALS, GLIDES, FRICATIVES, AFFRICATES, LIQUIDS, RHOTICS, 
            NON_RHOTICS;
    public static final HashSet[] PLACE_LIST, MANNER_LIST, RHOTICITY_LIST;
    private  LetterUtil() {  
    };
    
    private static HashSet makeSet(String letters) {
        return new HashSet(letters.chars().
            mapToObj(i -> (char) i).collect(Collectors.toList()));
    }
    
    static {
        LABIALS = makeSet("pbmwfv");
        CORONALS = makeSet("θðtdɾnszjʃʒʧʤlrɹ");
        DORSALS = makeSet("kgŋ");
        GLOTTALS = makeSet("hʔ");
        STOPS = makeSet("pbtdɾkgʔ");
        NASALS = makeSet("mnŋ");
        GLIDES = makeSet("wj");
        FRICATIVES = makeSet("fvθðszʃʒh");
        AFFRICATES = makeSet("ʧʤ");
        LIQUIDS = makeSet("lrɹ");
        RHOTICS = makeSet("ɚrɹ");
        NON_RHOTICS = makeSet("iɪeɛæəauʊoɔɑ");
        
        PLACE_LIST = new HashSet[] {LABIALS, CORONALS, DORSALS, GLOTTALS};
        MANNER_LIST = new HashSet[] {STOPS, NASALS, GLIDES, FRICATIVES,
                AFFRICATES, LIQUIDS};
        RHOTICITY_LIST = new HashSet[] {RHOTICS, NON_RHOTICS};
    } 
    public static boolean isProbablyConsonant(char ch) {
        for (HashSet e: PLACE_LIST) 
            if (e.contains(ch)) return true;
        return false;
    }
    public static boolean isProbablyVowel(char ch) {
        for (HashSet e: RHOTICITY_LIST) 
            if (e.contains(ch)) return true;
        return false;
    }
    
}
