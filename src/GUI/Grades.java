package GUI;

import Connection.Connection_methods;
import General.General_Persone;
import General.Student;
import General.Teacher;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Omer on 12/7/2016.
 */
public class Grades extends GridPane {
    ArrayList<Student> stu;
    Teacher teach;
    int hw;

    public Grades(ArrayList<Student> stu, Teacher teach, int hw) {
        this.stu = stu;
        this.teach = teach;
        this.hw = hw;
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setVgap(25);
        this.setHgap(30);
        Label name = new Label("Name");
        Label id = new Label("Id");
        Label grade = new Label("Grade");
        Label comment = new Label("Comment");
        name.setTextFill(Color.BLACK);
        id.setTextFill(Color.BLACK);
        grade.setTextFill(Color.BLACK);
        comment.setTextFill(Color.BLACK);
        name.setFont(Font.font(15));
        id.setFont(Font.font(15));
        grade.setFont(Font.font(15));
        comment.setFont(Font.font(15));

        this.add(name, 0, 0);
        this.add(id, 1, 0);
        this.add(grade, 2, 0);
        this.add(comment, 3, 0);
        showStudents(stu);
    }

    private void showStudents(ArrayList<Student> stu) {
        int number = stu.size();
        Label[] studentName = new Label[number];
        Label[] studentId = new Label[number];
        TextField[] studentGrade = new TextField[number];
        TextField[] teacherComment = new TextField[number];
        Button[] download = new Button[number];
        final Boolean[] check = new Boolean[1];
        Button[] setgrade = new Button[number];
        for (int i = 0; i < number; i++) {
            studentName[i] = new Label();
            studentId[i] = new Label();
            studentId[i].setTextFill(Color.BLACK);
            studentName[i].setTextFill(Color.BLACK);
            studentGrade[i] = new TextField();
            download[i] = new Button("Download");
            setgrade[i] = new Button("Set");
            teacherComment[i] = new TextField();
            studentGrade[i].setPromptText("Degree");
            teacherComment[i].setPromptText("Comment");
            studentGrade[i].setStyle("-fx-background-color:WHITE;-fx-border-color:BLACK");
            teacherComment[i].setStyle("-fx-background-color:WHITE;-fx-border-color:BLACK");
            int finalI = i;
            int finalI1 = i;
            setgrade[i].setOnAction(e -> {
                check[0] = Pattern.matches("(?=.*[0-9]).{1,2}", studentGrade[finalI1].getText());
                if (check[0]) {

                    if (Integer.parseInt(studentGrade[finalI].getText()) >= 0 && Integer.parseInt(studentGrade[finalI].getText()) <= 25) {
                        studentGrade[finalI].setStyle("-fx-background-color:WHITE;-fx-border-color:BLACK");
                        System.out.println("$setgrade(" + stu.get(finalI).getLevel() + "," + stu.get(finalI).getClass() + "&" + teach.getSubject() + "@" + stu.get(finalI).getId() + "*" + hw + "^" + studentGrade[finalI].getText() + "%" + teacherComment[finalI].getText() + ")");
                        Connection_methods.sendorder("$setgrade(" + stu.get(finalI).getLevel() + "," + stu.get(finalI).getClasses() + "&" + teach.getSubject() + "@" + stu.get(finalI).getId() + "*" + hw + "^" + studentGrade[finalI].getText() + "%" + teacherComment[finalI].getText() + ")");
                        JOptionPane.showMessageDialog(null, (String) Connection_methods.rciveobj(), "connection info", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        studentGrade[finalI].setStyle("-fx-background-color:RED");
                    }
                } else {
                    studentGrade[finalI].setStyle("-fx-background-color:RED");
                }

            });
            download[i].setOnAction(e -> {

                File z = new FileChooser().showSaveDialog(null);
                Managegui.download_ans(String.valueOf(this.stu.get(finalI).getLevel()), this.stu.get(finalI).getClasses(), teach.getSubject(), hw +"", z.getAbsolutePath(),this.stu.get(finalI).getId());
            });
            studentGrade[i].setMinWidth(20);

            studentName[i].setText(stu.get(i).getName());
            studentId[i].setText(stu.get(i).getId());

            this.add(studentName[i], 0, i + 1);
            this.add(studentId[i], 1, i + 1);
            this.add(studentGrade[i], 2, i + 1);
            this.add(teacherComment[i], 3, i + 1);
            this.add(download[i], 4, i + 1);
            this.add(setgrade[i], 5, i + 1);

        }
    }
}
