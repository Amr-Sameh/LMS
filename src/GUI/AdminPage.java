package GUI;

import Connection.Connection_methods;
import General.*;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Omer on 12/15/2016.
 */
public class AdminPage extends GridPane {


    Home home;
  //  TimeTable classTable = new TimeTable();
    Email email ;     public TextField[] subject;
   // Profile profile = new Profile();
    Button check = new Button("Check");
    Button save = new Button("Save");

    General_Persone person;
    Admin admin;
    public AdminPage(General_Persone persone){
        email=new Email(person);

        Register register;
        if (persone.getE_mail()==null||persone.getE_mail()=="") {
            register = new Register();
            register.edit(persone);

        }
        persone.setName("Admin");
        this.person=persone;
        this.admin=(Admin) persone;
        home=new Home(persone);


        ArrayList<String> name = new ArrayList<>();
        Button generattimtable=new Button("Generat Time Table");
        TextField nameoridT =new TextField();
        nameoridT.setPromptText("Name Or Id");
        TextField nameoridS =new TextField();
        nameoridS.setPromptText("Name Or Id");
        Button addTM=new Button("add");
        Button addTA=new Button("add");
        Button addsM=new Button("add");
        Button addsA=new Button("add");
        Button searchT=new Button("Search");
        Button searchS=new Button("Search");
        Button teachers = new Button("Teachers");
        Button students = new Button("Students");
        Button viewAllT = new Button("View All");
        Button viewAlls = new Button("View All");
        Button addTeacher = new Button("Add New Teacher");
        Button addStuden = new Button("Add New Student");
        Button addTeachermanual = new Button("Manual");
        Button addTeacherauto = new Button("Auto By File");
        Button addStudentmanual = new Button("Manual");
        Button addstudentauto = new Button("Auto By File");
        ComboBox<String> subjects=new ComboBox<>();
        subjects.setPromptText("subject");
        ComboBox<String> stages=new ComboBox<>();
        stages.getItems().addAll("Primary","middle","High");
        stages.setPromptText("statg");
        ComboBox<String> levels=new ComboBox<>();
        levels.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
        levels.setPromptText("level");
        TextField Tname = new TextField();
        Tname.setPromptText("name");
        TextField Sname = new TextField();
        Sname.setPromptText("name");
        Label fileis=new Label();


        Button Tfilepath = new Button("add File");
        Button Sfilepath = new Button("add File");
        Label result=new Label("");


        teachers.setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
        teachers.setFont(Font.font(20));
        teachers.setTextFill(Color.WHITE);
        teachers.setMinSize(200,100);
        students.setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
        students.setFont(Font.font(20));
        students.setTextFill(Color.WHITE);
        students.setMinSize(200,100);
        viewAllT.setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
        viewAllT.setFont(Font.font(20));
        viewAllT.setTextFill(Color.WHITE);
        viewAllT.setMinSize(200,100);


        viewAlls.setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
        viewAlls.setFont(Font.font(20));
        viewAlls.setTextFill(Color.WHITE);
        viewAlls.setMinSize(200,100);



        addTeachermanual.setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
        addTeachermanual.setFont(Font.font(20));
        addTeachermanual.setTextFill(Color.WHITE);
        addTeachermanual.setMinSize(200,100);
        addTeacherauto.setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
        addTeacherauto.setFont(Font.font(20));
        addTeacherauto.setTextFill(Color.WHITE);
        addTeacherauto.setMinSize(200,100);

        generattimtable.setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
        generattimtable.setFont(Font.font(20));
        generattimtable.setTextFill(Color.WHITE);
        generattimtable.setMinSize(200,100);

        addStudentmanual.setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
        addStudentmanual.setFont(Font.font(20));
        addStudentmanual.setTextFill(Color.WHITE);
        addStudentmanual.setMinSize(200,100);
        addstudentauto.setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
        addstudentauto.setFont(Font.font(20));
        addstudentauto.setTextFill(Color.WHITE);
        addstudentauto.setMinSize(200,100);

        addTeacher.setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
        addTeacher.setFont(Font.font(20));
        addTeacher.setTextFill(Color.WHITE);
        addTeacher.setMinSize(200,100);

        addStuden.setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
        addStuden.setFont(Font.font(20));
        addStuden.setTextFill(Color.WHITE);
        addStuden.setMinSize(200,100);
        Tname.setFont(Font.font(15));
        Tname.setMinWidth(150);
        Sname.setFont(Font.font(15));
        Sname.setMinWidth(150);
        check.setMinWidth(100);
        check.setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
        check.setTextFill(Color.WHITE);
        save.setMinWidth(200);
        save.setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
        save.setTextFill(Color.WHITE);
        home.containGrid.add(this,0,0);
       this.setAlignment(Pos.CENTER);
        this.setVgap(30);
        this.setHgap(30);
        this.add(teachers,0,0);
        this.add(students,1,0);
        this.add(generattimtable,2,0);
        this.setPadding(new Insets(10,10,10,10));
        home.home.setOnAction(e->{
            home.containGrid.getChildren().clear();
            home.containGrid.add(this,0,0);
            this.getChildren().clear();
            this.add(teachers,0,0);
            this.add(students,1,0);
            this.add(generattimtable,2,0);
            stages.getItems().clear();
            stages.getItems().addAll("Primary","middle","High");
            subjects.getItems().clear();
            levels.setValue(null);
            result.setText("");
            fileis.setText("");
        });

        home.timetable.setOnAction(e->{
            home.containGrid.getChildren().clear();
           home.containGrid.add(new TimeTable((General_Persone)persone),0,0);
            home.subjectScroll.setPadding(new Insets(20,20,20,20));
        });
        home.message.setOnAction(e->{
            home.containGrid.getChildren().clear();
            home.containGrid.add(email,0,0);
        });
        home.profile.setOnAction(e->{
            home.containGrid.getChildren().clear();
            home.containGrid.add(new Profile((General_Persone)persone),0,0);
        });
//        home.homeWork.setOnAction(e->{
//            home.containGrid.getChildren().clear();
//            home.containGrid.add(HomeWork,0,0);
//        });


        teachers.setOnAction(e->{
            this.getChildren().clear();
            this.add(viewAllT,0,0);

            this.add(addTeacher,2,0);
        });
        students.setOnAction(e->{
            this.getChildren().clear();
            this.add(viewAlls,0,0);

            this.add(addStuden,2,0);
        });

        viewAllT.setOnAction(e->{// view all teachers
            this.getChildren().clear();
            Connection_methods.sendorder("$getlist(t)");
            ArrayList<Teacher> o= (ArrayList<Teacher>)(ArrayList<?>) Connection_methods.rciveobj();
if(o!=null){
            int s=0;
            for (Teacher t:o){
                this.add(new Label(t.getName()),0,s);
                this.add(new Label(t.getId()),1,s);
                this.add(new Label(t.getStage()),2,s);
                this.add(new Label(t.getSubject()),3,s);
                this.add(new Label(t.getPassword()),4,s);
                System.out.println(t.getLevels().toString());
                s++;
            }}
        });
        generattimtable.setOnAction(e->{
            Connection_methods.sendorder("$timetable!");
        });
        viewAlls.setOnAction(e->{// view all students
            this.getChildren().clear();
            Connection_methods.sendorder("$getlist(s)");
            ArrayList<Student> o= (ArrayList<Student>)(ArrayList<?>) Connection_methods.rciveobj();
            int s=0;
            if(o!=null) {
                for (Student t : o) {
                    this.add(new Label(t.getName()), 0, s);
                    this.add(new Label(t.getId()), 1, s);
                    this.add(new Label(t.getClasses()), 2, s);
                    this.add(new Label(t.getPassword()), 3, s);
                    s++;
                }
            }
        });

        searchT.setOnAction(e->{
            ArrayList<General_Persone> o=new ArrayList<General_Persone>();
            //Search.GetObject(o,nameorid.getText());
            this.add(new Label(),0,1);
        });
        searchS.setOnAction(e->{
            ArrayList<General_Persone> o=new ArrayList<General_Persone>();
            //Search.GetObject(o,nameorid.getText());
            this.add(new Label(),0,1);
        });
        addTeacher.setOnAction(e->{
            this.getChildren().clear();
            this.add(addTeachermanual,0,0);
            this.add(addTeacherauto,1,0);
        });
        addStuden.setOnAction(e->{
            this.getChildren().clear();
            this.add(addStudentmanual,0,0);
            this.add(addstudentauto,1,0);
        });
        addTeachermanual.setOnAction(e->{
            this.getChildren().clear();
            this.add(Tname,0,0);
            this.add(stages,1,0);
            this.add(subjects,2,0);
            this.add(addTM,3,0);
            this.add(result,1,1);
        });
        addStudentmanual.setOnAction(e->{
            this.getChildren().clear();
            this.add(Sname,0,0);
            this.add(levels,1,0);
            this.add(addsM,2,0);
            this.add(result,1,1);
        });
        stages.setOnAction(e->{
            if(stages.getValue()=="Primary"){
                subjects.getItems().clear();
                subjects.getItems().addAll("arabic","math","english","religion","computer","science","social studies");
            }else if(stages.getValue()=="middle"){
                subjects.getItems().clear();
                subjects.getItems().addAll("arabic","math","english","religion","computer","science","social studies","second language","patriotism");
            }else if(stages.getValue()=="High"){
                subjects.getItems().clear();
                subjects.getItems().addAll("arabic","math","english","religion","computer","physics","history","second language","patriotism","philosophy","biology","geography","chimistry");
            }
        });
        addTM.setOnAction(e->{// add teacher manual
            if(Tname.getText()!=""&&subjects.getValue()!=null&&stages.getValue()!=null){
                Connection_methods.sendorder("$rej_teach("+stages.getValue()+"@"+subjects.getValue()+")");
                ArrayList<String >temp=new ArrayList<String>();
                temp.add(Tname.getText());
                Connection_methods.sendobj(temp);
                result.setText((String) Connection_methods.rciveobj());
            }else{
                result.setText("some error");
            }
        });
        addsM.setOnAction(e->{//add student manual **done
            if(Sname.getText()!=""&&levels.getValue()!=null){
                Connection_methods.sendorder("$rej_stu("+levels.getValue()+")");
                ArrayList<String>temp=new ArrayList<String>();
                temp.add(Sname.getText());
                Connection_methods.sendobj(temp);
                result.setText("Done Successfully");
            }else{
                result.setText("some error");
            }
        });
        addTeacherauto.setOnAction(e->{
            this.getChildren().clear();
            this.add(Tfilepath,0,0);
            this.add(stages,1,0);
            this.add(subjects,2,0);
            this.add(addTA,3,0);
            this.add(result,1,1);
        });
        addstudentauto.setOnAction(e->{
            this.getChildren().clear();
            this.add(Sfilepath,0,0);
            this.add(levels,1,0);
            this.add(addsA,2,0);
            this.add(result,1,1);
        });

        Tfilepath.setOnAction(e->{
            File temp = new FileChooser().showOpenDialog(null);
            if (temp!=null)
            fileis.setText(temp.getAbsolutePath());
        });
        Sfilepath.setOnAction(e->{
            File temp = new FileChooser().showOpenDialog(null);
            if(temp!=null)
            fileis.setText(temp.getAbsolutePath());
        });
        addTA.setOnAction(e->{//add teach with file   **done
            if(fileis.getText()!=""&&subjects.getValue()!=null&&stages.getValue()!=null){
                ArrayList<String> temp= FileControler.readlinetolist(fileis.getText());
                Connection_methods.sendorder("$rej_teach("+stages.getValue()+"@"+subjects.getValue()+")");
                Connection_methods.sendobj(temp);
                result.setText((String) Connection_methods.rciveobj());

            }else{
                result.setText("some error");
            }
        });
        addsA.setOnAction(e->{//add syu with file

            if(fileis.getText()!=null&&levels.getValue()!=null){
                Connection_methods.sendorder("$rej_stu("+levels.getValue()+")");
                ArrayList<String> temp=FileControler.readlinetolist(fileis.getText());
                Connection_methods.sendobj(temp);
                result.setText("we add it");
            }else{
                result.setText("some error");
            }
        });



    }


    private void showFiles() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("TEXT files(*.txt)","*.txt");
        fileChooser.getExtensionFilters().add(filter);
    }
    public void subjectAdder(int numberSubject) {
        int subjectCounter = 0;
        int Row = 0;
        int Colume = 0;
        int i = 0;
        int j = 0;
        BorderPane[] subjectBorderPane = new BorderPane[numberSubject];

        HBox[] buttonBox = new HBox[numberSubject];
        subject = new TextField[numberSubject];
        Label [] fname = new Label[numberSubject];
        Label [] lname = new Label[numberSubject];
        if(numberSubject <= 2){
            Row = 1;
            Colume = numberSubject;
        }
        else
        {
            Row = ((numberSubject/2)+(numberSubject%2));
            Colume = 2;
        }
        for ( i = 0; i < Row && subjectCounter < numberSubject; i++) {
            for ( j = 0; j < Colume && subjectCounter < numberSubject; j++,subjectCounter++) {
                subjectBorderPane[subjectCounter] = new BorderPane();
                buttonBox[subjectCounter] = new HBox();
                subject[subjectCounter] = new TextField();
                fname[subjectCounter] = new Label();
                lname[subjectCounter] = new Label();
                subjectBorderPane[subjectCounter].setStyle("-fx-background-color: TRANSPARENT");
                buttonBox[subjectCounter].setPadding(new Insets(20,20,20,20));
                buttonBox[subjectCounter].getChildren().add(subject[subjectCounter]);
                fname[subjectCounter].setText("First Name:");
                fname[subjectCounter].setFont(Font.font(15));
                lname[subjectCounter].setText("Last Name:");
                lname[subjectCounter].setFont(Font.font(15));
                if(subjectCounter%2 == 0) {
                    subjectBorderPane[subjectCounter].setLeft(fname[subjectCounter]);
                }
                else{
                    subjectBorderPane[subjectCounter].setLeft(lname[subjectCounter]);
                }
                subjectBorderPane[subjectCounter].setCenter(buttonBox[subjectCounter]);
                this.add(subjectBorderPane[subjectCounter], j,i );
            }
        }
        this.add(save,i+1,j+1);
        this.add(check,i+1,j+2);
    }
    private boolean checkOut(int number){
        int count = 0;
        for (int i = 0; i < number; i++){
            if(subject[i].getText().length() == 0){
                count++;
            }
        }
        if(count == 0){
            return true;
        }
        else {
            return false;
        }}
}
