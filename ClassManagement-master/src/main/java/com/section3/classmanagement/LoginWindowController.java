package com.section3.classmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginWindowController {

    // The ownerStage is used to keep track of the owners stage in order to change the scene once the credentials are
    // verified.
    private Stage ownerStage;
    String cUsername, cPassword;

    // The new here is used to create the new window for the login and gets closed once the verification is complete
    private Stage stage;

    @FXML
    private Button cancelBtn;
    @FXML
    private TextField userName;

    @FXML
    private PasswordField passWord;

    @FXML
    private Button loginBtn;

    @FXML
    private Label invalidLogin;

    // Handles relations to the database
    private DataBaseConnection dataBaseConnection;
    public static boolean loggedIn;
    public SectionWindowController SWD;
    public ScheduleWindowController ScWC;

    // Here we used ownerStage instead of 'stage' to remind programmers that the input stage is the owner of the
    // login window that pops and acts as a modal. And the one named 'stage' is the stage the login is being displayed on.
    public LoginWindowController(Stage ownerStage, Stage stage, DataBaseConnection dataBaseConnection, SectionWindowController SWD, ScheduleWindowController ScWC) {
        this.ownerStage = ownerStage;
        this.stage = stage;
        this.dataBaseConnection = dataBaseConnection;
        this.SWD = SWD;
        this.ScWC = ScWC;
    }

    @FXML
    void cancelBtnOnAction() throws IOException{
        this.stage.close();
    }

    @FXML
    void loginBtnOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        DataBaseConnection validateLogin = new DataBaseConnection();
        boolean checkResult = validateLogin.login(userName, passWord);
        if(!checkResult) {
            invalidLogin.setText("invalid Login");
        }else{
            this.loggedIn = true;
            if(SWD != null) {
                SectionWindowController sectionController = new SectionWindowController(this.ownerStage, this.dataBaseConnection);
                sectionController.initSection();
                this.stage.close();
            }else{
                ScheduleWindowController scheduleController = new ScheduleWindowController(this.ownerStage, this.dataBaseConnection);
                scheduleController.initSchedule();
                this.stage.close();

            }
        }
    }


    public void initLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginWindow.fxml"));
        fxmlLoader.setController(this);
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        this.stage.setTitle("Login");
        this.stage.initStyle(StageStyle.UNDECORATED);
//        this.stage.centerOnScreen();  // the name is misleading and doesn't work as you might imagine
        this.stage.setResizable(false);
        this.stage.setScene(scene);
        this.stage.initModality(Modality.APPLICATION_MODAL);
        this.stage.showAndWait();
        //this.stage.initOwner(this.ownerStage);
        // need to address the stages once this stage has been initialized.
    }





}