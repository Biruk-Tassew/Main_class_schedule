package com.section3.classmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class SectionWindowController {

    // Handles relations to the database
    private  DataBaseConnection dataBaseConnection;

    // might be a good idea to put these sections in an ArrayList

    @FXML
    private Button cancelBtn;

    @FXML
    private Button teacherBtn;

    @FXML
    private Button adminBtn;

    @FXML
    private Button section1;

    @FXML
    private Button section6;

    @FXML
    private Button section2;

    @FXML
    private Button section7;

    @FXML
    private Button section3;

    @FXML
    private Button section8;

    @FXML
    private Button section4;

    @FXML
    private Button section9;

    @FXML
    private Button section5;

    @FXML
    private Button section10;

    public Stage stage;
    public String whichSection;

    public SectionWindowController(Stage stage, DataBaseConnection dataBaseConnection) {
        this.stage = stage;
        this.dataBaseConnection = dataBaseConnection;
    }

    public void initSection() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SectionWindow.fxml"));
        fxmlLoader.setController(this);
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/com/section3/classmanagement/SectionWindowCss.css").toExternalForm());
        this.stage.setTitle("Section");
        this.stage.setScene(scene);
        this.stage.show();
    }

    // Handle actions taken when the different sections are pressed.

    @FXML
    void cancelBtnOnAction() throws IOException{
        this.stage.close();
    }

    @FXML
    void sectionBtn(ActionEvent event) throws IOException{
        ScheduleWindowController scheduleController = new ScheduleWindowController(stage, dataBaseConnection);
        scheduleController.initSchedule();
        whichSection = ((Control)event.getSource()).getId();
    }

    @FXML
    void teacherBtnOnAction(ActionEvent event) throws IOException{
        LoginWindowController loginWindowController = new LoginWindowController(stage, new Stage(), dataBaseConnection, this, null);
        loginWindowController.initLogin();
    }
    @FXML
    void adminBtnOnAction(ActionEvent event) throws IOException{
        LoginWindowController loginWindowController = new LoginWindowController(stage, new Stage(), dataBaseConnection, this, null);
        loginWindowController.initLogin();
    }

}
