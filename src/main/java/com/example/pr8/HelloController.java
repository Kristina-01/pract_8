package com.example.pr8;
/*
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button givespisok;

    @FXML
   void initialize() {
        givespisok.setOnAction(actionEvent -> {
            System.out.println("Вы нажали на кнопку список");
        });
     }
}


 */

import java.io.IOException;
import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button givespisok;

    @FXML
    private Button addnew;

    @FXML
    void initialize() {

       givespisok.setOnAction(actionEvent -> {
          // System.out.println("Вы нажали кнопку");
       });

       addnew.setOnAction(actionEvent -> {
           addnew.getScene().getWindow().hide();

           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("ggg.fxml"));

           try {
               loader.load();
           } catch (IOException e) {
               e.printStackTrace();
           }

           Parent root = loader.getRoot();
           Stage stage = new Stage();
           stage.setScene(new Scene(root));
           stage.showAndWait();
       });

    }




}

