/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jennaemorgan.phoneticdifficulty;

import java.util.ArrayList;
import static com.github.jennaemorgan.phoneticdifficulty.LetterUtil.*;

/**
 *
 * @author Jenna Morgan <jennaedenmorgan@gmail.com>
 */
public class Word {

    private ArrayList<Letter> word = new ArrayList<>();
    private int syllables;

    /**
     * Creates a representation of a word broken down into vowels, consonants,
     * and syllable breaks represented by IPA characters
     *
     * @param str the string representation of the word to be analyzed
     */
    public Word(String str) {
        syllables = 1;
        boolean isPreNucleus = true;
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = 'b';
            if (curr == '.') {
                syllables++;
                isPreNucleus = true;
            } else if (!isProbablyConsonant(curr) && !isProbablyVowel(curr)) {
                throw new IllegalArgumentException(curr
                        + "is not a valid character");
            } //            else if (NON_RHOTICS.contains(""+curr) ||
            //                    (RHOTICS.contains(""+curr) && !isPreNucleus)) {
            else if (NON_RHOTICS.contains("" + curr) || curr == 'ɚ') {
                word.add(new Vowel(curr));
                isPreNucleus = false;
            } else {
                word.add(new Consonant(curr));
            }
        }
    }

    /**
     * Assigns the word points according to Dr. Jakielski's first IPC parameter
     *
     * @return an int representing the number of dorsal consonants the word
     * contains
     */
    public int getParam1Score() {
        int score = 0;
        for (Letter e : word) {
            if (DORSALS.contains("" + e.getChar())) {
                score++;
            }
        }
        return score;
    }

    /**
     *
     * @return an int representing the combined number of fricatives,
     * affricates, and liquids the word contains
     */
    public int getParam2Score() {
        int score = 0;
        for (Letter e : word) {
            if (FRICATIVES.contains("" + e.getChar())
                    || AFFRICATES.contains("" + e.getChar())
                    || e instanceof Consonant && LIQUIDS.contains("" + e.getChar())) {
                score++;
            }
        }
        return score;
    }

    /**
     *
     * @return an int representing the number of rhotic vowels the word contains
     */
    public int getParam3Score() {
        int score = 0;
        for (Letter e : word) {
            if (e instanceof Vowel && RHOTICS.contains("" + e.getChar())) {
                score++;
            }
        }
        return score;
    }

    /**
     *
     * @return an int really representing a boolean expression, 1 if the word
     * ends in a consonant, otherwise 0
     */
    public int getParam4Score() {
        if (word.get(word.size() - 1) instanceof Consonant) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     *
     * @return an int really representing a boolean expression, 1 if the word
     * contains at least 3 syllables, otherwise 0
     */
    public int getParam5Score() {
        if (syllables >= 3) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     *
     * @return an int representing one point added to the word for each time
     * there are consecutive lone consonants with different places of
     * articulation
     */
    public int getParam6Score() {
        int score = 0;
        for (int i = 0; i < word.size(); i++) {
            if (word.get(i) instanceof Consonant) {
                boolean isCluster = false;
                while (i < word.size() - 1 && word.get(i + 1) instanceof Consonant) {
                    i++;
                    isCluster = true;
                }
                if (isCluster) {
                    i++;
                }
                if (i == word.size() || !(word.get(i) instanceof Consonant)) {
                    continue;
                }
                Consonant curr = (Consonant) word.get(i);
                if (i < word.size() - 1 && word.get(i + 1) instanceof Vowel) {
                    for (int j = i + 2; j < word.size(); j++) {
                        if (word.get(j) instanceof Consonant) {
                            if (j + 1 < word.size() && word.get(j + 1) instanceof Consonant) {
                                i++;
                                break;
                            }
                            Consonant next = (Consonant) word.get(j);
                            if (!curr.isSamePlace(next)) {
                                score++;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return score;
    }

    /**
     *
     * @return an int indicating 1 point for each consonant cluster the word
     * contains
     */
    public int getParam7Score() {
        int score = 0;
        for (int i = 0; i < word.size(); i++) {
            if (word.get(i) instanceof Consonant) {
                if (i < word.size() - 1 && word.get(i + 1) instanceof Consonant) {
                    score++;
                    i++;
                }
                while (i < word.size() && word.get(i) instanceof Consonant) {
                    i++;
                }
            }
        }
        return score;
    }

    /**
     *
     * @return an int indicating 1 point for each consonant cluster the word
     * contains that includes more than one place of articulation
     */
    public int getParam8Score() {
        int score = 0;
        for (int i = 0; i < word.size(); i++) {
            if (word.get(i) instanceof Consonant) {
                Consonant initial = (Consonant) word.get(i);
                boolean clusterScored = false;
                while (i < word.size() - 1 && word.get(i + 1) instanceof Consonant) {
                    Consonant curr = (Consonant) word.get(i + 1);
                    if (!(curr.isSamePlace(initial) || clusterScored)) {
                        score++;
                        clusterScored = true;
                    }
                    i++;
                }
            }
        }
        return score;
    }

    /**
     *
     * @return a String laying out the score for each individual parameter plus
     * the total score
     */
    public String getScore() {
        String result = "";
        result += "Parameter 1 Points: " + getParam1Score();
        result += "\nParameter 2 Points: " + getParam2Score();
        result += "\nParameter 3 Points: " + getParam3Score();
        result += "\nParameter 4 Points: " + getParam4Score();
        result += "\nParameter 5 Points: " + getParam5Score();
        result += "\nParameter 6 Points: " + getParam6Score();
        result += "\nParameter 7 Points: " + getParam7Score();
        result += "\nParameter 8 Points: " + getParam8Score();
        result += "\nTotal Score = " + (getParam1Score() + getParam2Score()
                + getParam3Score() + getParam4Score() + getParam5Score()
                + getParam6Score() + getParam7Score() + getParam8Score());
        return result;
    }

    /**
     *
     * @return a String representation of the word, essentially the parameter
     * for the constructor minus any periods representing syllable breaks
     */
    @Override
    public String toString() {
        String result = "";
        for (Letter letter : word) {
            result += letter.getChar();
        }
        return result;
    }
}
