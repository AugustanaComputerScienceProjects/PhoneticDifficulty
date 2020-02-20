package com.github.jennaemorgan.phoneticdifficulty;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrimaryController {

    @FXML
    private Label label;

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        label.setText("ʃ Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
        Consonant b = new Consonant('b');
        Consonant d = new Consonant('d');
        System.out.println(b.isSamePlace(d));
        Word word = new Word("be.bi.dal");
        System.out.println(word.getParam6Score());
    }
}