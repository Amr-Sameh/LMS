package GUI;

import Connection.Connection_methods;
import General.General_Persone;
import General.Student;
import General.Teacher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Omer on 12/7/2016.
 */

public class Assignment extends GridPane {
    private String sub;
    private Text actionStatus;
    private Student stu;
    private Teacher teach;
    private  File dest;
    GridPane homeWorkGrid = new GridPane();
    GridPane downloadButton = new GridPane();
    GridPane grades=new GridPane();

    public Assignment(Student stu,String sub){
        this.stu=stu;
        this.sub=sub;

grades.setVgap(50);
        grades.setHgap(15);
        grades.setAlignment(Pos.CENTER);
        initializeAssignment();
        actionStatus = new Text();

        actionStatus.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
        actionStatus.setFill(Color.FIREBRICK);
        downloadButton.setPadding(new Insets(10,10,10,10));

        this.setHgap(15);
        this.setVgap(50);
        this.setAlignment(Pos.CENTER);

        homeWorkGrid.setAlignment(Pos.CENTER);
        homeWorkGrid.setPadding(new Insets(10,10,10,10));
    }
    private void showFiles() throws IOException {

        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            actionStatus.setText("File selected: " + selectedFile.getAbsoluteFile());
        }
        else {
            actionStatus.setText("File selection cancelled.");
        }
    }
    private void initializeAssignment(){
        int i;
        Connection_methods.sendorder("$hwnumber("+stu.getLevel()+","+stu.getClasses()+"&"+sub+")");
        int assignmentNumber= (int)Connection_methods.rciveobj();
        if(assignmentNumber!=0 ){
        Label[] name = new Label[assignmentNumber];
        Button[] download = new Button[assignmentNumber];
        Button [] upload = new Button[assignmentNumber];
            ArrayList<String> grade=new ArrayList<>();
            for (int o=1;o<=assignmentNumber;o++){
              //  System.out.println("$viewgrade("+this.stu.getLevel()+","+this.stu.getClasses()+"&"+this.teach.getSubject()+"@"+this.stu.getId()+"*"+o+")");

                Connection_methods.sendorder("$viewgrade("+this.stu.getLevel()+","+this.stu.getClasses()+"&"+sub+"@"+this.stu.getId()+"*"+o+")");
           grade.add((String) Connection_methods.rciveobj());
            }


        for(i = 0; i < assignmentNumber ; i++) {
            download[i] = new Button();
            final int j = i + 1;

            download[i].setOnAction(event -> {
                File z = new FileChooser().showSaveDialog(null);
                Managegui.download_hws(String.valueOf(this.stu.getLevel()), this.stu.getClasses(), sub, j + "", z.getAbsolutePath());

            });
            upload[i] = new Button();
            upload[i].setOnAction(e -> {
                File z = new FileChooser().showOpenDialog(null);

                JOptionPane.showMessageDialog(null, Managegui.add_solu(stu.getLevel() + "", stu.getClasses(), sub, stu.getId(), j + "", z), " INFO", JOptionPane.INFORMATION_MESSAGE);
            });

            download[i].setStyle("-fx-background-color: TRANSPARENT; -fx-border-color: TRANSPARENT");
            name[i] = new Label();
            name[i].setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15.0D));
            name[i].setText("hw" + (i + 1));
            download[i].setText("Download");
            upload[i].setText("Upload");
            this.add(name[i], 0, i);
            this.add(download[i], 1, i);
            this.add(upload[i], 2, i);
            grades.add(new Label(name[i].getText()), 0, i);
            grades.add(new Label(grade.get(i)), 1, i);


        }
        }else JOptionPane.showMessageDialog(null,"Some Error Happened (missing files in database \\ no homworks uploaded)","Error IN Database",JOptionPane.ERROR_MESSAGE);


    }




    public Assignment(Teacher stu,String sub){
        this.teach=stu;
        this.sub=sub;


        initializeAssignment();
        actionStatus = new Text();

        actionStatus.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
        actionStatus.setFill(Color.FIREBRICK);
        downloadButton.setPadding(new Insets(10,10,10,10));

        this.setHgap(15);
        this.setVgap(50);
        this.setAlignment(Pos.CENTER);

        homeWorkGrid.setAlignment(Pos.CENTER);
        homeWorkGrid.setPadding(new Insets(10,10,10,10));
    }







}
