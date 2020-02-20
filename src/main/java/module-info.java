module com.github.jennaemorgan.phoneticdifficulty {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.github.jennaemorgan.phoneticdifficulty to javafx.fxml;
    exports com.github.jennaemorgan.phoneticdifficulty;
}