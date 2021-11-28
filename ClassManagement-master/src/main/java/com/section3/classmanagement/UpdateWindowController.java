package com.section3.classmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.sql.Connection;
import java.util.stream.IntStream;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UpdateWindowController {

    private DataBaseConnection dataBaseConnection;
    public Stage stage;


    @FXML
    private Button cancelBtn;

    @FXML // fx:id="dayComboBox"
    private ComboBox<String> dayComboBox; // Value injected by FXMLLoader

    @FXML // fx:id="startHourComboBox"
    private ComboBox<Integer> startHourComboBox; // Value injected by FXMLLoader

    @FXML // fx:id="startMinComboBox"
    private ComboBox<Integer> startMinComboBox; // Value injected by FXMLLoader

    @FXML // fx:id="EndHourComboBox"
    private ComboBox<Integer> EndHourComboBox; // Value injected by FXMLLoader

    @FXML // fx:id="endMinComboBox"
    private ComboBox<Integer> endMinComboBox; // Value injected by FXMLLoader

    @FXML // fx:id="commitBtn"
    private Button commitBtn; // Value injected by FXMLLoader

    @FXML
    public void initialize(){
        ObservableList<String> week_days = FXCollections.observableArrayList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
        ObservableList<Integer> day_hours = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        dayComboBox.setItems(week_days);
        startHourComboBox.setItems(day_hours);
        EndHourComboBox.setItems(day_hours);
        IntStream.rangeClosed(0,59).boxed().forEach(startMinComboBox.getItems()::add);
        IntStream.rangeClosed(0,59).boxed().forEach(endMinComboBox.getItems()::add);
    }

    public UpdateWindowController(Stage stage, DataBaseConnection dataBaseController) {
        this.stage = stage;
        this.dataBaseConnection = dataBaseController;
    }

    public void initUpdateWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateWindow.fxml"));
        fxmlLoader.setController(this);
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource(
                "/com/section3/classmanagement/SectionWindowCss.css").toExternalForm());
        this.stage.setTitle("Section");
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.setScene(scene);
        this.stage.show();
    }


    // Handle actions related to the commit button
    @FXML
    void commitBtnOnAction() {
        SectionWindowController SWC= new SectionWindowController(this.stage, this.dataBaseConnection);
        String whichSection = SWC.whichSection;

        this.stage.close();
    }

    @FXML
    void cancelBtnOnAction() {
        this.stage.close();
    }


}
