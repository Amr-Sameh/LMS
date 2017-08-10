package GUI;

import Connection.Connection_methods;
import General.FileControler;
import General.General_Persone;
import General.HW;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioTrack;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sun.audio.AudioStream;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Omer on 12/7/2016.
 */
public class LogIn {
    //__________________ Client attributes_________________
    static final int port = 6257;
    static final String ip = "Pc-MeiR";
    //_________________________________________________________

    PasswordField pwBox = new PasswordField();
    private static double x = 0;
    private static double y = 0;



    public void logIn(Stage logInStage) {

        /**
         * start the connection to the server
         */
        Socket soc = null;
        try {
            soc = new Socket(ip, port);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Can Not Connect To The Server","Connection Error",JOptionPane.ERROR_MESSAGE);
        }
        Connection_methods.setSoc(soc);
        //____________________________________________________________________________________


        logInStage.setTitle("Learing Management System");
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER_RIGHT);
        grid.setHgap(10);
        grid.setVgap(10);

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 35));
        scenetitle.setFill(Color.WHITE);
        grid.add(scenetitle, 0, 1, 2, 1);
        TextField userTextField = new TextField();
        userTextField.setMinWidth(200);
        userTextField.setPromptText("Id");


        grid.add(userTextField, 1, 2);

        grid.setPadding(new Insets(50, 50, 50, 50));

        grid.setId("root");

        pwBox.setPromptText("Password");
        grid.add(pwBox, 1, 3);
        Button signIn = new Button("Sign in");
        signIn.setMinWidth(150);
        signIn.setStyle("-fx-background-color: TRANSPARENT; " +
                "-fx-border-color: WHITE");

        Label label2 = new Label();
        grid.add(label2, 1, 6);
        label2.setTextFill(Color.RED);
        signIn.setOnMouseClicked(e -> {
            boolean id = Pattern.matches("(?=.*[0-9]).{2,30}", userTextField.getText());
            boolean pass = Pattern.matches(".{3,20}", pwBox.getText());

            if (id&&pass) {
                label2.setText("");
                Connection_methods.sendorder("$login("+userTextField.getText()+'*'+pwBox.getText()+'@'+" )");
                if((String)Connection_methods.rciveobj()!=null){
                //new AdminPage();
                    Managegui.runhome(userTextField.getText());
                logInStage.close();}
                else
                    JOptionPane.showMessageDialog(null,"Error In Information","Connection Error",JOptionPane.ERROR_MESSAGE);
            } else
                label2.setText("Wrong ID or Password");
        });
        signIn.setTextFill(Color.WHITE);
        HBox hbBtn = new HBox(20);
        hbBtn.setAlignment(Pos.CENTER_RIGHT);
        hbBtn.getChildren().add(signIn);
        grid.add(hbBtn, 1, 5);
        grid.setStyle("-fx-background-color: #2b478f ");
        BorderPane borderPane = new BorderPane();
        Button closeBtn = new Button("×");
        closeBtn.setOnAction(e -> {
            Platform.exit();
        });
        closeBtn.setFont(Font.font(20));
        closeBtn.setTextFill(Color.WHITE);
        HBox omer = new HBox(10);
        omer.getChildren().add(closeBtn);
        omer.setAlignment(Pos.CENTER_RIGHT);
        omer.setMinWidth(480);
        ToolBar toolBar = new ToolBar();
        toolBar.setPrefHeight(30);
        toolBar.setMinHeight(30);
        toolBar.setMaxHeight(30);
        toolBar.getItems().add(omer);
        borderPane.setTop(toolBar);
        toolBar.setStyle("-fx-background-color: TRANSPARENT");
        closeBtn.setStyle("-fx-background-color: TRANSPARENT");
        borderPane.setStyle("-fx-background-color: #2b478f");
        borderPane.setCenter(grid);
        Scene scene = new Scene(borderPane, 500, 275);
        scene.getStylesheets().addAll(this.getClass().getResource("login.css").toExternalForm());
        logInStage.setScene(scene);

        borderPane.setOnMousePressed(e -> {
            x = logInStage.getX() - e.getScreenX();
            y = logInStage.getY() - e.getScreenY();
        });
        borderPane.setOnMouseDragged(e -> {
            logInStage.setX(e.getSceneX() + x);
            logInStage.setY(e.getSceneY() + y);

        });
        /**
         * connect moment
         */
signIn.setDefaultButton(true);

        logInStage.show();
    }
}
