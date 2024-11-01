package controller;

import com.sun.jna.platform.win32.Netapi32Util;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.Event;
import javafx.stage.Stage;
import model.AppModel;
import model.Employee;

import java.util.Locale;
import java.util.ResourceBundle;

public class UiController {
    @FXML
    public Label langLabel;
    @FXML
    public ChoiceBox langCombo;
    @FXML
    public Label lastnameLabel;
    @FXML
    public TextField lastnameInput;
    @FXML
    public Label firstnameLabel;
    @FXML
    public TextField firstnameInput;
    @FXML
    public Label emailLabel;
    @FXML
    public TextField emailInput;
    @FXML
    public Button saveButton;

    Locale locale;
    ResourceBundle app;
    AppModel model;
    Stage stage;

    public void initialize() {
        model = new AppModel();
        locale = new Locale("en", "US");
        app = ResourceBundle.getBundle("app", locale);

        langLabel.setText(app.getString("langLabel"));
        firstnameLabel.setText(app.getString("firstnameLabel"));
        lastnameLabel.setText(app.getString("lastnameLabel"));
        emailLabel.setText(app.getString("emailLabel"));
        saveButton.setText(app.getString("button"));

        langCombo.getItems().addAll("English", "Farsi", "Japanese");
        langCombo.setValue("English");

        langCombo.setOnAction((event) -> chooseLang(event));


        saveButton.setOnAction((event) -> handleSave());

    }

    public void handleSave() {
        Employee emp = new Employee(firstnameInput.getText(), lastnameInput.getText(), emailInput.getText());
        model.addEmployee(emp, locale);
    }

    public void chooseLang(Event event) {
        String selectedLanguage = (String) langCombo.getValue();
        switch (selectedLanguage) {
            case "English":
                locale = new Locale("en", "US");
                break;
            case "Farsi":
                locale = new Locale("fa", "IR");
                break;
            case "Japanese":
                locale = new Locale("ja", "JP");
                break;
        }
        app = ResourceBundle.getBundle("app", locale);
        updateApp();
    }

    public void updateApp() {
        langLabel.setText(app.getString("langLabel"));
        firstnameLabel.setText(app.getString("firstnameLabel"));
        lastnameLabel.setText(app.getString("lastnameLabel"));
        emailLabel.setText(app.getString("emailLabel"));
        saveButton.setText(app.getString("button"));
        stage.setTitle(app.getString("title"));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
