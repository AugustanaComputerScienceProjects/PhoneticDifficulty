/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jennaemorgan.phoneticdifficulty;

import com.github.jennaemorgan.phoneticdifficulty.LetterAttributes.*;
import java.util.HashMap;

/**
 *
 * @author Jenna Morgan <jennaedenmorgan@gmail.com>
 */
public final class LetterUtil {

    public static final String LABIALS, CORONALS, DORSALS, GLOTTALS, STOPS,
            NASALS, GLIDES, FRICATIVES, AFFRICATES, LIQUIDS, RHOTICS,
            NON_RHOTICS;
    public static final HashMap<String, Place> PLACE_LIST;
    public static final HashMap<String, Manner> MANNER_LIST;
    public static final HashMap<String, Rhoticity> RHOTICITY_LIST;

    private LetterUtil() {
    }

    //puts the speech inventory of American English into conveniently
    //useable and searchable sets and subsets
    static {
        PLACE_LIST = new HashMap<>();
        MANNER_LIST = new HashMap<>();
        RHOTICITY_LIST = new HashMap<>();
        LABIALS = "pbmwfv";
        PLACE_LIST.put(LABIALS, Place.LABIAL);
        CORONALS = "θðtdɾnszjʃʒʧʤlrɹ";
        PLACE_LIST.put(CORONALS, Place.CORONAL);
        DORSALS = "kgŋ";
        PLACE_LIST.put(DORSALS, Place.DORSAL);
        GLOTTALS = "hʔ";
        PLACE_LIST.put(GLOTTALS, Place.GLOTTAL);

        STOPS = "pbtdɾkgʔ";
        MANNER_LIST.put(STOPS, Manner.STOP);
        NASALS = "mnŋ";
        MANNER_LIST.put(NASALS, Manner.NASAL);
        GLIDES = "wj";
        MANNER_LIST.put(GLIDES, Manner.GLIDE);
        FRICATIVES = "fvθðszʃʒh";
        MANNER_LIST.put(FRICATIVES, Manner.FRICATIVE);
        AFFRICATES = "ʧʤ";
        MANNER_LIST.put(AFFRICATES, Manner.AFFRICATE);
        LIQUIDS = "lrɹ";
        MANNER_LIST.put(LIQUIDS, Manner.LIQUID);
        RHOTICS = "ɚrɹ";
        RHOTICITY_LIST.put(RHOTICS, Rhoticity.RHOTIC);
        NON_RHOTICS = "iɪeɛæəauʊoɔɑ";
        RHOTICITY_LIST.put(NON_RHOTICS, Rhoticity.NON_RHOTIC);
    }

    /**
     *
     * @param ch the char representing a sound to be analyzed
     * @return true if the sound is most likely a consonant (bearing in mind
     * rhotics are a unique case that can throw things off), otherwise false
     */
    public static boolean isProbablyConsonant(char ch) {
        for (String key : PLACE_LIST.keySet()) {
            if (key.indexOf(ch) != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param ch the char representing a sound to be analyzed
     * @return true if the sound is most likely a consonant (bearing in mind
     * rhotics are a unique case that can throw things off), otherwise false
     */
    public static boolean isProbablyVowel(char ch) {
        for (String key : RHOTICITY_LIST.keySet()) {
            if (key.indexOf(ch) != -1) {
                return true;
            }
        }
        return false;
    }

}
