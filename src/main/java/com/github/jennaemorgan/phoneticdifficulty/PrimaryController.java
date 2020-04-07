package com.github.jennaemorgan.phoneticdifficulty;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

/**
 *
 * @author Jenna Morgan
 */
public class PrimaryController {

    @FXML
    private Label label;

    @FXML
    private Button btnθ;

    @FXML
    private TextField txtFld;

    public void initialize() {
        label.setText("Welcome to the Index of Phonetic Complexity (IPC) Calculator.\n"
                + "Please enter a word with the syllables separated by periods,\n"
                + "using the onscreen keyboard as needed.");
    }

    @FXML
    private void handleBtn(ActionEvent event) {
        txtFld.setText(txtFld.getText() + ((Button) event.getSource()).getText());
    }

    @FXML
    private void handleTxtFld(ActionEvent event) {
        Word word = null;
        try {
            word = new Word(txtFld.getText());
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Invalid Text Input");
            alert.setContentText("You entered characters not needed to represent "
                    + "American English speech. Try using only the onscreen "
                    + "keyboard and basic Latin characters.");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(AlertType.NONE);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);
        alert.setTitle("Word Scoring");
        alert.setContentText(word.getScore());
        alert.show();
    }

}
