package GUI;

import General.General_Persone;
import General.Student;
import General.Teacher;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Omer on 12/7/2016.
 */
public class Profile extends GridPane {
    General_Persone g;

    public Profile(General_Persone g){

        this.getChildren().clear();
        LogIn logIn = new LogIn();
        Circle image = new Circle(40,40,40 );
        Button add = new Button("Add");
        Button Reset = new Button("Edit");
        Label name = new Label("Name:");
        Label myName = new Label(g.getName());
        Label level = new Label("Level:");
        Label myLevel = new Label();
        Label Lclass = new Label("Class:");
        Label myClass = new Label();
        Label id = new Label("ID:");
        Label myId = new Label(g.getId());
        Label password = new Label("Password:");
        Label myPassword = new Label(g.getPassword());
        Label email = new Label("Email:");
        Label myMail = new Label(g.getE_mail());
        Reset.setOnAction(e->{


              new Register().edit(g);



        });

        GridPane imageGrid = new GridPane();
        GridPane buttonGrid = new GridPane();




        imageGrid.setAlignment(Pos.CENTER);
        buttonGrid.setAlignment(Pos.CENTER);
        this.setAlignment(Pos.CENTER);

        this.setHgap(10);
        this.setVgap(10);
        buttonGrid.setHgap(10);
        buttonGrid.setVgap(10);
        image.setRadius(40);
        myPassword.setText(logIn.pwBox.getText());
        imageGrid.add(image,0,0);
        buttonGrid.add(add,0,0);

        this.add(imageGrid,0,0);
        this.add(buttonGrid,0,1);
        this.add(name,0,2);
        this.add(myName,1,2);
        this.add(id,0,3);
        this.add(myId,1,3);
        this.add(password,0,4);
        this.add(myPassword,1,4);
        this.add(Reset,0,6);
        this.add(email,0,5);
        this.add(myMail,1,5);

        if(g.getId().equals("#0000")){


        }else if (g.getId().contains("a")||g.getId().contains("b")||g.getId().contains("c")){
            this.getChildren().remove(Reset);
            Teacher t=(Teacher)g;
            level.setText("statg");
            this.add(level,0,6);
            myLevel.setText(t.getStage());
            this.add(myLevel,1,6);
            Lclass.setText("subject");
            this.add(Lclass,0,7);
            myClass.setText(t.getSubject());
            this.add(myClass,1,7);
            this.add(Reset,0,8);
        }else {
            this.getChildren().remove(Reset);
            Student t=(Student) g;
            level.setText("Level");
            this.add(level,0,6);
            myLevel.setText(String.valueOf(t.getLevel()));
            this.add(myLevel,1,6);
            Lclass.setText("Class");
            this.add(Lclass,0,7);
            myClass.setText(t.getClasses());
            this.add(myClass,1,7);
            this.add(Reset,0,8);

        }


    }
}
