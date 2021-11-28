package com.section3.classmanagement;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ProgramStart extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException, ClassNotFoundException {
        DataBaseConnection databaseLink = new DataBaseConnection();
        SectionWindowController sectionController = new SectionWindowController(stage, databaseLink);
        stage.initStyle(StageStyle.UNDECORATED);
        sectionController.initSection();
    }

    public static void main(String[] args) {
        launch();
    }
}