package com.section3.classmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class ScheduleWindowController {

    private DataBaseConnection dataBaseConnection;
    // back button for the schedule window

    @FXML
    private Button teacherBtn;

    @FXML
    private Button adminBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button minimizeBtn;

    @FXML
    private Label monday0;

    @FXML
    private Label monday1;

    @FXML
    private Label monday2;

    @FXML
    private Label monday3;

    @FXML
    private Label tuesday0;

    @FXML
    private Label tuesday1;

    @FXML
    private Label tuesday2;

    @FXML
    private Label tuesday3;

    @FXML
    private Label wed0;

    @FXML
    private Label wed1;

    @FXML
    private Label wed2;

    @FXML
    private Label wed3;

    @FXML
    private Label thursday0;

    @FXML
    private Label thursday1;

    @FXML
    private Label thursday2;

    @FXML
    private Label thursday3;

    @FXML
    private Label fri0;

    @FXML
    private Label fri1;

    @FXML
    private Label fri2;

    @FXML
    private Label fri3;

    // I don't see the use for this btn yet. Might get deleted.
    @FXML
    private Button editBtn;

    public Stage stage;
    public ScheduleWindowController(Stage stage, DataBaseConnection dataBaseConnection) {

        this.stage = stage;
        this.dataBaseConnection = dataBaseConnection;
    }

    public void initSchedule() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ScheduleWindow.fxml"));
        ScheduleWindowController scheduleController;
        fxmlLoader.setController(this);
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        this.stage.setTitle("Schedule");
        this.stage.setScene(scene);
        this.stage.show();
    }
    // handles X(cancelBtn) when pressed closing the window
    @FXML
    void cancelBtnOnAction(){
        this.stage.close();
    }

    @FXML
    void teacherBtnOnAction() throws IOException{
        LoginWindowController loginWindowController = new LoginWindowController(stage, new Stage(), dataBaseConnection, null, this);
        loginWindowController.initLogin();
    }

    @FXML
    void adminBtnOnAction() throws IOException{
        LoginWindowController loginWindowController = new LoginWindowController(stage, new Stage(), dataBaseConnection, null, this);
        loginWindowController.initLogin();
    }

    // handles back button when pressed by going back to the section window.
    @FXML
    void goBack() throws IOException {
        SectionWindowController sectionController = new SectionWindowController(stage, dataBaseConnection);
        sectionController.initSection();

    }

    // Checks different SQL related things in order to be able to edit the schedule
    @FXML
    void editSchedule() throws IOException {
        LoginWindowController loginWindowController = new LoginWindowController(stage, new Stage(), dataBaseConnection, null, this);
        loginWindowController.initLogin();
    }

    // Handle actions related to the schedule buttons
    // Don't forget to use the action events to get the source and update it accordingly
    @FXML
    void scheduleBtn(ActionEvent event) throws  IOException{
        UpdateWindowController updateWindowController = new UpdateWindowController(new Stage(), this.dataBaseConnection);
        LoginWindowController loginWindowController = new LoginWindowController(stage, new Stage(), dataBaseConnection, null, this);
        System.out.println(LoginWindowController.loggedIn);
        if(LoginWindowController.loggedIn){
            updateWindowController.initUpdateWindow();
        }else{
            loginWindowController.initLogin();
        }
    }

}



