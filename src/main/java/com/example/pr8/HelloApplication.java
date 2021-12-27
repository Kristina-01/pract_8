package com.example.pr8;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import  javafx.collections.ObservableList;

public class HelloApplication extends Application {
    static public ArrayList<Pet> pets = new ArrayList<>();
    public static  Stage _stage;
    @Override
    public void start(Stage stage) throws IOException {

        _stage = stage;


        okno(stage);
    }

    public static void okno(Stage stage)throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Привет!");
        stage.setScene(scene);
        stage.show();

        if(pets.size()==0)
            for(int i=0;i<5;i++) {
                Pet p = new Pet();
                p.number=i+1;
                pets.add(p);
            }


        ComboBox cb = (ComboBox) scene.lookup("#Combo_Box");
        cb.setItems(FXCollections.observableArrayList(pets));

        cb.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {//вывод информации о конкретном животном из списка
            Pet p = (Pet)newValue;
            TextField tftype = (TextField) scene.lookup("#type") ;
            tftype.setText(p.type);
            TextField tfnickname = (TextField) scene.lookup("#nickname");
            tfnickname.setText(p.nickname);
            TextField tfage = (TextField) scene.lookup("#age");
            tfage.setText(Integer.toString(p.age));
            TextField tfdofb = (TextField) scene.lookup("#DateofBirth");
            tfdofb.setText(p.DateofBirth);
            TextField tftypev = (TextField) scene.lookup("#typevaccines");
            tftypev.setText(p.vaccines.get(0).type);
            TextField tfnamev = (TextField) scene.lookup("#namev");
            tfnamev.setText(p.vaccines.get(0).drugname);
            TextField tfdate = (TextField) scene.lookup("#datav");
            tfdate.setText(p.vaccines.get(0).date);

        });

        Button b = (Button) scene.lookup("add");
    }



    public static void main(String[] args) {
        launch(args);
    }
}