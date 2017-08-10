package GUI;

import Connection.Connection_methods;
import General.General_Persone;
import General.Student;
import General.Teacher;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.*;
import sun.misc.Launcher;
import sun.security.util.Password;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by Omer on 12/11/2016.
 */
public class Register extends GridPane {
    General_Persone persone;
    private Text actionStatus;
    Stage registerStage = new Stage();
  /*  public Register(General_Persone persone) {
        this.persone=persone;

        registerStage.setAlwaysOnTop(true);
        //registerStage.

        Circle image = new Circle();
        Scene registerScene = new Scene(this,500,500);
        Button add = new Button("Add");
        add.setOnAction(e->{

        });
        this.getChildren().clear();
        Button reset = new Button("Edit");
        Button save = new Button("Save");
        Label name = new Label("Name:");
        Label myName = new Label(persone.getName());
        Label id = new Label("ID:");
        Label myId = new Label(persone.getId());
        Label password = new Label("Password:");
        TextField myPassword = new TextField(persone.getPassword());
        myPassword.setEditable(false);
        final Label[] email = {new Label("E-Mail:")};
        TextField myEmail = new TextField();
        myEmail.setEditable(false);
        reset.setOnAction(e->{
            myPassword.setEditable(true);
            myEmail.setEditable(true);
        });
        add.setMinWidth(100);
        reset.setMinWidth(100);
        save.setMinWidth(100);
        myEmail.setMinWidth(200);

        this.setStyle("-fx-background-color:WHITE");
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20,20,20,20));
        image.setRadius(45);
        this.add(image,0,0);
        this.add(add,0,1);
        this.add(name,0,2);
        this.add(myName,1,2);
        this.add(id,0,3);
        this.add(myId,1,3);
        this.add(password,0,4);
        this.add(myPassword,1,4);
        this.add(reset,1,8);
        this.add(email[0],0,5);
        this.add(myEmail,1,5);
        this.add(save,0,8);
        final boolean[] check = new boolean[1];
        if(persone.getId().equals("#0000")) {
        }else if(persone.getId().contains("a")||persone.getId().contains("a")||persone.getId().contains("a")){
            Teacher t=(Teacher)persone;
            this.add(new Label("statg"),0,6);
            this.add(new Label(t.getStage()),1,6);
            this.add(new Label("subject"),0,7);
            this.add(new Label(t.getSubject()),1,7);
        }else{
            Student s=(Student) persone;
            this.add(new Label("Level"),0,6);
            this.add(new Label(String.valueOf(s.getLevel())),1,6);
            this.add(new Label("class"),0,7);
            this.add(new Label(s.getClasses()),1,7);
        }
        save.setOnMouseClicked(event -> {
            check[0] = Pattern.matches("^(([a-zA-Z0-9_]{1,20})|([a-zA-Z_%+-]{1,20}+\\.[a-zA-Z0-9]{1,6}))+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$",myEmail.getText());
            if(check[0]){
                persone.setPassword(myPassword.getText());
                persone.setE_mail(myEmail.getText());
            }
            else{

                this.add(new Label("some error"),0,9);
            }
        });
        save.setOnAction(e->{

        });
        registerStage.setScene(registerScene);
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.getStyle();
        registerStage.show();

    }*/
    private void showFiles() throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("jpg"),new FileChooser.ExtensionFilter("png"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            actionStatus.setText("File selected: " + selectedFile.getAbsoluteFile());
        }
        else {
            actionStatus.setText("File selection cancelled.");
        }
    }


    public General_Persone edit(General_Persone persone){
        this.persone=persone;

        //registerStage.setAlwaysOnTop(true);
        //registerStage.

        Circle image = new Circle();
        Scene registerScene = new Scene(this,500,500);
        //Button add = new Button("Add");

        this.getChildren().clear();
        Button reset = new Button("Edit");
        Button save = new Button("Save");
        Label name = new Label("Name:");
        Label myName = new Label(persone.getName());
        Label id = new Label("ID:");
        Label myId = new Label(persone.getId());
        Label password = new Label("Password:");
        TextField myPassword = new TextField(persone.getPassword());
        myPassword.setEditable(false);
        final Label[] email = {new Label("E-Mail:")};
        TextField myEmail = new TextField(persone.getE_mail());
        myEmail.setEditable(false);
        reset.setOnAction(e->{
            myPassword.setEditable(true);
            myEmail.setEditable(true);
        });

        reset.setMinWidth(100);
        save.setMinWidth(100);
        myEmail.setMinWidth(200);

        this.setStyle("-fx-background-color:WHITE");
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20,20,20,20));
        image.setRadius(45);
        this.add(image,0,0);
        this.add(name,0,2);
        this.add(myName,1,2);
        this.add(id,0,3);
        this.add(myId,1,3);
        this.add(password,0,4);
        this.add(myPassword,1,4);
        this.add(reset,1,8);
        this.add(email[0],0,5);
        this.add(myEmail,1,5);
        this.add(save,0,8);
        final boolean[] check = new boolean[1];
        if(persone.getId().equals("#0000")) {
        }else if(persone.getId().contains("a")||persone.getId().contains("b")||persone.getId().contains("c")){
            Teacher t=(Teacher)persone;
            this.add(new Label("statge"),0,6);
            this.add(new Label(t.getStage()),1,6);
            this.add(new Label("subject"),0,7);
            this.add(new Label(t.getSubject()),1,7);
        }else{
            Student s=(Student) persone;
            this.add(new Label("Level"),0,6);
            this.add(new Label(String.valueOf(s.getLevel())),1,6);
            this.add(new Label("class"),0,7);
            this.add(new Label(s.getClasses()),1,7);
        }
        save.setOnMouseClicked(event -> {

            if(myEmail.getText()!=null ||myEmail.getText()!=" "){
            check[0] = Pattern.matches("^(([a-zA-Z0-9_]{1,20})|([a-zA-Z_%+-]{1,20}+\\.[a-zA-Z0-9]{1,6}))+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$",myEmail.getText());
            if(check[0]) {
                Connection_methods.sendorder("$edit!");
                Connection_methods.sendobj(persone);
                persone.setPassword(myPassword.getText());
                persone.setE_mail(myEmail.getText());

                Connection_methods.sendobj(persone);
                registerStage.close();
            }
            else{

                this.add(new Label("some error"),0,9);
            }
            }


        });

        registerStage.setScene(registerScene);
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.initModality(Modality.APPLICATION_MODAL);
        registerStage.getStyle();
        registerStage.showAndWait();
        return persone;
    }

}
