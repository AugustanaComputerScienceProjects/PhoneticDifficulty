/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jennaemorgan.phoneticdifficulty;

import java.util.ArrayList;
import java.util.List;
import static com.github.jennaemorgan.phoneticdifficulty.LetterUtil.*;

/**
 *
 * @author Jenna Morgan <jennaedenmorgan@gmail.com>
 */
public class Word {
    private ArrayList<Letter> word = new ArrayList<>();
    private int syllables;
    
    public Word(String str) {
        syllables = 1;
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = 'b';
            if (curr == '.') 
                syllables++;
            else if (NON_RHOTICS.contains(curr)) {
                word.add(new Vowel(curr));
            }
            else if (RHOTICS.contains(curr)) {
                if (NON_RHOTICS.contains(prev) &&
                        (i == str.length() - 1) || str.charAt(i+1) == '.') {
                    word.add(new Vowel(curr));
                }
                else if (curr == 'ɚ') {
                    word.add(new Vowel(curr));
                }
                else {
                    word.add(new Consonant(curr));
                }
            }
            else if (LetterUtil.isProbablyConsonant(curr)) {
                word.add(new Consonant(curr));
            }            
        }
    }
    
    public int getParam1Score() {
        int score = 0;
        for (Letter e: word)
            if (DORSALS.contains(e.getChar()))
                score++;
        return score;
    }
    public int getParam2Score() {
        int score = 0;
        for (Letter e: word) 
            if (FRICATIVES.contains(e.getChar())
                    || AFFRICATES.contains(e.getChar())
                    || e instanceof Consonant && LIQUIDS.contains(e.getChar()))
                score++;    
        return score;
    }
    public int getParam3Score() {
        int score = 0;
        for (Letter e: word) 
            if (e instanceof Vowel && RHOTICS.contains(e.getChar()))
                score++;
        return score;
    }
    public int getParam4Score() {
        if (word.get(word.size() - 1) instanceof Consonant)
            return 1;
        else return 0;
    }
    public int getParam5Score() {
        if (syllables >= 3)
            return 1;
        else return 0;
    }
    
    public int getParam6Score() {
        int score = 0;
        for (int i = 0; i < word.size(); i++) {
            if (word.get(i) instanceof Consonant) {
                Consonant curr =(Consonant)word.get(i);
                System.out.println("curr " + curr.getChar());
                if (i < word.size() - 1 && word.get(i + 1) instanceof Vowel) {
                    for (int j = i + 2; j < word.size(); j++) { 
                        if (word.get(j) instanceof Consonant) {
                            Consonant next = (Consonant)word.get(j);
                            System.out.println("next " + next.getChar());
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
    
    public int getParam7Score() {
        int score = 0;
        for (int i = 0; i < word.size(); i++) {
            if (word.get(i) instanceof Consonant) {
                if (word.get(i + 1) instanceof Consonant && i < word.size()) {
                    score++;
                    i++;
                }
                while (word.get(i) instanceof Consonant && i < word.size()) {
                    i++;
                }
            }
        }
        return score;
    }
    
    public int getParam8Score() {
        int score = 0;
        for (int i = 0; i < word.size(); i++) {
            if (word.get(i) instanceof Consonant) {
                Consonant first = (Consonant)word.get(i);
                i++;
                while (word.get(i) instanceof Consonant && i < word.size()) {
                    if (!first.isSamePlace((Consonant)word.get(i))) {
                        score++;
                        i++;
                        while (word.get(i) instanceof Consonant && i < word.size()) {
                            i++;
                        }
                    }
                    
                }
            }
        }
        return score;
    }
    
    public void getScore() {
        System.out.println(getParam1Score());
        System.out.println(getParam2Score());
        System.out.println(getParam3Score());
        System.out.println(getParam4Score());
        System.out.println(getParam5Score());
        System.out.println(getParam6Score());
        System.out.println(getParam7Score());
        System.out.println(getParam8Score());
    }
}
