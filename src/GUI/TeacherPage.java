package GUI;

import Connection.Connection_methods;
import General.FileControler;
import General.General_Persone;
import General.Student;
import General.Teacher;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Omer on 12/15/2016.
 */
public class TeacherPage extends GridPane {
    GridPane levelGrid = new GridPane();
    GridPane classGrid = new GridPane();
    Home home;
    // TimeTable classTable = new TimeTable();
    Email email ;
    //  Profile profile = new Profile();

    GridPane panel;
    Label name = new Label();
    General_Persone g;
    Teacher t;
    Label string = new Label("");

    AssignmentTeacher HomeWork = new AssignmentTeacher();

    public TeacherPage(Teacher g) {
        email= new Email(g);
        Register register;
        if (g.getE_mail() == null || g.getE_mail() == "") {
            register = new Register();
            register.edit(g);

        }

        this.t = g;
        home = new Home(t);


        GridPane assignmentGrid = new GridPane();

        assignmentGrid.setHgap(10);
        assignmentGrid.setVgap(10);
        assignmentGrid.setAlignment(Pos.CENTER);
        assignmentGrid.setPadding(new Insets(20, 20, 20, 20));

        this.setHgap(10);
        this.setVgap(10);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20, 20, 20, 20));

        levelGrid.setVgap(10);
        levelGrid.setHgap(10);
        levelGrid.setAlignment(Pos.CENTER);
        levelGrid.setPadding(new Insets(20, 20, 20, 20));


        levelAdder(g.getLevels(), g.getClasses());

        classGrid.setVgap(10);
        classGrid.setHgap(10);
        classGrid.setAlignment(Pos.CENTER);
        classGrid.setPadding(new Insets(20, 20, 20, 20));

        this.add(levelGrid, 0, 0);

        home.home.setOnAction(e -> {
            string.setText("");
            name.setText("");
            home.containGrid.getChildren().clear();
            this.getChildren().clear();
            classGrid.getChildren().clear();

            this.add(levelGrid, 0, 0);
            home.homeBorder.getChildren().remove(home.AmrAdderScroll);
            home.subjectScroll.setPadding(new Insets(10, 142, 10, 170));
            email.setPadding(new Insets(20, 66, 51, 60));
            home.subjectScroll.setStyle("-fx-background:#4a65a0;");
            home.containGrid.setStyle("-fx-background-color:#4a65a0");
            home.containGrid.add(this, 0, 0);

            email.emailTo.setTextFill(Color.WHITE);
            email.emailSubject.setTextFill(Color.WHITE);
            email.emailMessage.setTextFill(Color.WHITE);
        });
        home.containGrid.add(this, 0, 0);

        home.timetable.setOnAction(e -> {
            home.containGrid.getChildren().clear();
            home.containGrid.add(new TimeTable((General_Persone) g), 0, 0);
        });

        home.message.setOnAction(e -> {
            home.containGrid.getChildren().clear();
            home.containGrid.add(email, 0, 0);
        });
        home.profile.setOnAction(e -> {
            home.containGrid.getChildren().clear();
            home.containGrid.add(new Profile((General_Persone) g), 0, 0);
        });
        home.homeWork.setOnAction(e -> {
            home.containGrid.getChildren().clear();
            home.containGrid.add(HomeWork, 0, 0);
        });
        HomeWork.submit.setOnAction(e -> {
            String s = String.valueOf(HomeWork.deadLine.getValue());
            //get time in day and month and year and check it with this string s it like "2016-12-24" if is Greter than time which you get from server
            //do this line "string.setText(string.getText+"*"+s); it will be like "1*a*2016-12-24" addHomework with deadline and add it in arraylist of
            //String here you get file he upload it to new HomeWork.actionStatus.getText();
            Connection_methods.sendorder("$time!");
            String timenow = (String) Connection_methods.rciveobj();
            int current_year = Integer.parseInt(timenow.substring(0, timenow.indexOf('-')));
            int current_month = Integer.parseInt(timenow.substring(timenow.indexOf('-') + 1, timenow.lastIndexOf('-')));
            int current_day = Integer.parseInt(timenow.substring(timenow.lastIndexOf('-') + 1, timenow.length()));
            int deadyear = Integer.parseInt(s.substring(0, s.indexOf('-')));
            int deadmonth = Integer.parseInt(s.substring(s.indexOf('-') + 1, s.lastIndexOf('-')));
            int deadday = Integer.parseInt(s.substring(s.lastIndexOf('-') + 1, s.length()));

            if (deadyear*360+deadmonth*30+deadday>=current_year*360+current_month*30+current_day) {
                System.out.println(deadyear*360+deadmonth*30+deadday);

                if (HomeWork.actionStatus.getText() != null) {

                    Connection_methods.sendorder("$addhw(" + string.getText().substring(0, string.getText().indexOf('*')) + "," + "class-" + string.getText().substring(string.getText().indexOf('*') + 1, string.getText().length()) + "&" + t.getSubject() + ")");
                    Connection_methods.sendobj(s);
                    Connection_methods.sendobj(FileControler.readlinetolist(HomeWork.actionStatus.getText()));
                    JOptionPane.showMessageDialog(null, Connection_methods.rciveobj(), "Upload info", JOptionPane.INFORMATION_MESSAGE);

                    Connection_methods.sendorder("$getdeadline(" + string.getText().substring(0, string.getText().indexOf('*')) + "," + string.getText().substring(string.getText().indexOf('*') + 1, string.getText().length()) + "@" + t.getSubject() + ")");
                    ArrayList<String> daedline = (ArrayList<String>) (ArrayList<?>) Connection_methods.rciveobj();

                    home.containGrid.getChildren().clear();
                    int y = 0;
                    for (int k = 0; k < daedline.size(); k++) {
                        panel = new GridPane();
                        int x = k + 1;
                        panel.add(new Label("HW " + x), 0, 0);
                        panel.add(new Label(daedline.get(k)), 1, 0);
                        panel.setAlignment(Pos.CENTER);
                        panel.setHgap(50);
                        panel.setVgap(50);
                        panel.setStyle("-fx-background-color: #2b478f");
                        panel.setOnMouseClicked(event -> {
                            home.containGrid.getChildren().clear();
                            // get array list of opject student and but it in constrctor of grades
                            System.out.println(string.getText());
                            Connection_methods.sendorder("$getclasslist(" + string.getText().substring(0, string.getText().indexOf('*')) + "," + string.getText().substring(string.getText().indexOf('*') + 1, string.getText().length()) + ")");
                            ArrayList<Student> stu = (ArrayList<Student>) (ArrayList<?>) Connection_methods.rciveobj();

                            Grades grades = new Grades(stu, t, x);
                            home.containGrid.add(grades, 0, 0);

                        });
                        home.containGrid.add(panel, 0, k);
                        y++;
                    }
                    home.containGrid.add(HomeWork, 0, y);
                }
            }
        });
    }


    public void levelAdder(ArrayList<Integer> m, ArrayList<String> s) {
        int subjectCounter = 0;
        int Row = 0;
        int Colume = 0;

        int numberSubject = m.size();
        BorderPane[] subjectBorderPane = new BorderPane[numberSubject];
        HBox[] buttonBox = new HBox[numberSubject];
        Button[] level = new Button[numberSubject];

        if (numberSubject <= 2) {
            Row = 1;
            Colume = numberSubject;
        } else {
            Row = ((numberSubject / 3) + (numberSubject % 3));
            Colume = 3;
        }
        for (int i = 0; i < Row && subjectCounter < numberSubject; i++) {
            for (int j = 0; j < Colume && subjectCounter < numberSubject; j++, subjectCounter++) {
                subjectBorderPane[subjectCounter] = new BorderPane();
                buttonBox[subjectCounter] = new HBox();
                level[subjectCounter] = new Button();
                subjectBorderPane[subjectCounter].setMinSize(200, 150);
                subjectBorderPane[subjectCounter].setStyle("-fx-background-color: TRANSPARENT");
                level[subjectCounter].setTextFill(Color.WHITE);
                level[subjectCounter].setFont(Font.font(20));
                level[subjectCounter].setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
                level[subjectCounter].setMinSize(200, 100);
                buttonBox[subjectCounter].setMinSize(200, 100);
                buttonBox[subjectCounter].getChildren().add(level[subjectCounter]);
                subjectBorderPane[subjectCounter].setTop(buttonBox[subjectCounter]);
                levelGrid.add(subjectBorderPane[subjectCounter], j, i);
            }
        }
        for (int i = 0; i < numberSubject; i++) {
            level[i].setText(String.valueOf(m.get(i)));
            int finalI = i;
            level[i].setOnAction(e -> {
                string.setText(level[finalI].getText());
                this.getChildren().clear();
                this.add(classGrid, 0, 0);
                String lvel = Integer.toString(m.get(finalI));
                ArrayList<String> classes = new ArrayList<>();
                for (String s1 : s) {
                    if (lvel.length() == 1) {
                        if (s1.startsWith(lvel) && s1.length() == 2) {
                            classes.add(s1.substring(1));
                        }
                    } else {
                        if (s1.startsWith(lvel) && s1.length() == 3) {
                            classes.add(s1.substring(2));
                        }
                    }
                }
                classAdder(classes);
            });
        }
    }

    private void classAdder(ArrayList<String> s) {
        int subjectCounter = 0;
        int Row = 0;
        int Colume = 0;
        int numberSubject = s.size();
        BorderPane[] subjectBorderPane = new BorderPane[numberSubject];
        HBox[] buttonBox = new HBox[numberSubject];
        Button[] classes = new Button[numberSubject];


        if (numberSubject <= 2) {
            Row = 1;
            Colume = numberSubject;
        } else {
            Row = ((numberSubject / 2) + (numberSubject % 2));
            Colume = 2;
        }
        for (int i = 0; i < Row && subjectCounter < numberSubject; i++) {
            for (int j = 0; j < Colume && subjectCounter < numberSubject; j++, subjectCounter++) {
                subjectBorderPane[subjectCounter] = new BorderPane();
                buttonBox[subjectCounter] = new HBox();
                classes[subjectCounter] = new Button();
                subjectBorderPane[subjectCounter].setMinSize(200, 150);
                subjectBorderPane[subjectCounter].setStyle("-fx-background-color: TRANSPARENT");
                classes[subjectCounter].setTextFill(Color.WHITE);
                classes[subjectCounter].setFont(Font.font(20));
                classes[subjectCounter].setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
                classes[subjectCounter].setMinSize(200, 100);
                buttonBox[subjectCounter].setMinSize(200, 100);
                buttonBox[subjectCounter].getChildren().add(classes[subjectCounter]);
                subjectBorderPane[subjectCounter].setTop(buttonBox[subjectCounter]);
                classGrid.add(subjectBorderPane[subjectCounter], j, i);
            }
        }

        for (int i = 0; i < numberSubject; i++) {
            classes[i].setText(s.get(i));
            int finalI1 = i;
            classes[i].setOnAction(e -> {


                string.setText(string.getText() + "*" + classes[finalI1].getText());
                name.setText(classes[finalI1].getText());
                home.containGrid.getChildren().clear();
                //get from server Arraylist of string have deadlines and name it g
                Connection_methods.sendorder("$getdeadline(" + string.getText().substring(0, string.getText().indexOf('*')) + "," + string.getText().substring(string.getText().indexOf('*') + 1, string.getText().length()) + "@" + t.getSubject() + ")");
                ArrayList<String> g = (ArrayList<String>) (ArrayList<?>) Connection_methods.rciveobj();

                int y = 0;
                for (int k = 0; k < g.size(); k++) {
                    Connection_methods.sendorder("$getclasslist(" + string.getText().substring(0, string.getText().indexOf('*')) + "," + string.getText().substring(string.getText().indexOf('*') + 1, string.getText().length()) + ")");
                    ArrayList<Student> stu = (ArrayList<Student>) (ArrayList<?>) Connection_methods.rciveobj();
                    Grades grades = new Grades(stu, t, k + 1);
                    panel = new GridPane();
                    int x = k + 1;
                    panel.add(new Label("HW " + x), 0, 0);
                    panel.add(new Label(g.get(k)), 1, 0);
                    panel.setAlignment(Pos.CENTER);
                    panel.setHgap(50);
                    panel.setVgap(50);
                    panel.setStyle("-fx-background-color: #2b478f");
                    panel.setOnMouseClicked(event -> {
                        home.containGrid.getChildren().clear();
                        home.containGrid.add(grades, 0, 0);

                    });
                    home.containGrid.add(panel, 0, k);
                    y++;
                }
                home.containGrid.add(HomeWork, 0, y);
                home.homeBorder.getChildren().remove(home.AmrAdderScroll);
                this.setPadding(new Insets(10, 10, 10, 10));
                home.containGrid.setStyle("-fx-background-color:#f4f4f4");
                email.setPadding(new Insets(10, 50, 50, 50));

                email.emailTo.setTextFill(Color.BLACK);
                email.emailSubject.setTextFill(Color.BLACK);
                email.emailMessage.setTextFill(Color.BLACK);

            });
        }
        name.setTextFill(Color.WHITE);
        name.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15.0D));
    }

    private void addHomeWork() {

    }
}
