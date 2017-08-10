package GUI;

import General.General_Persone;
import General.Student;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

/**
 * Created by Omer on 12/15/2016.
 */
public class StudentPage extends GridPane {




    private Student stu;
    Home home ;
    public Label subjectName = new Label();
    //public GridPane this = new GridPane();
    TimeTable classTable ;
    Email email ;
    Assignment HomeWork;
    Profile profile ;
    ArrayList<String> sub=new ArrayList<>();
    public StudentPage(Student stu){
        email=new Email(stu);
        Register register;
        if (stu.getE_mail()==null||stu.getE_mail()=="") {
            register = new Register();
            General_Persone temp=register.edit(stu);
        }

        this.stu=stu;
        classTable= new TimeTable(stu);
        home= new Home((General_Persone)stu);
        profile=new Profile(stu);
        subjectAdder(sub);
        this.setHgap(20);
        this.setVgap(20);
        this.setPadding(new Insets(20, 15, 20, 20));
        this.setAlignment(Pos.CENTER);
        home.containGrid.add(this,0,0);
        subjectName.setText("");
        subjectName.setText("");
            home.home.setOnAction(e->{
            home.containGrid.getChildren().removeAll(classTable,email,HomeWork,profile);
            home.homeBorder.getChildren().remove(home.AmrAdderScroll);
            home.subjectScroll.setPadding(new Insets(10,142,10,170));
            email.setPadding(new Insets(20,66,51,60));
            home.subjectScroll.setStyle("-fx-background:#4a65a0;");
            home.containGrid.setStyle("-fx-background-color:#4a65a0");
            home.containGrid.add(this,0,0);
           // email.emailFrom.setTextFill(Color.WHITE);
            email.emailTo.setTextFill(Color.WHITE);
            email.emailSubject.setTextFill(Color.WHITE);
            email.emailMessage.setTextFill(Color.WHITE);
        });
        home.timetable.setOnAction(e->{
            home.containGrid.getChildren().clear();
            home.containGrid.add(classTable,0,0);
        });
        home.message.setOnAction(e->{
            home.containGrid.getChildren().clear();
            home.containGrid.add(email,0,0);
        });
        home.profile.setOnAction(e->{
            home.containGrid.getChildren().clear();
            home.containGrid.add(profile,0,0);
        });
        home.homeWork.setOnAction(e->{
            home.containGrid.getChildren().clear();
            home.containGrid.add(HomeWork,0,0);
        });
        home.grades.setOnAction(e->{
            home.containGrid.getChildren().clear();
            home.containGrid.add(HomeWork.grades,0,0);
        });
home.id.setText(this.stu.getId());
        home.level.setText(this.stu.getLevel()+"");
        home.Class.setText(this.stu.getClasses());
    }
    public void subjectAdder(ArrayList<String> stu_sub) {
        //__________________________________________________
         ArrayList<String> lvl1_3=new ArrayList<>();
        lvl1_3.add("arabic");
        lvl1_3.add("math");
        lvl1_3.add("english");
        lvl1_3.add("religion");
           ArrayList <String> lvl4_6=new ArrayList<>();
        lvl4_6.addAll(lvl1_3);
        lvl4_6.add("computer");
        lvl4_6.add("science");
        lvl4_6.add("social stadies");
           ArrayList<String> lvl7_9=new ArrayList<>();
        lvl7_9.addAll(lvl4_6);
        lvl7_9.add("second language");
        lvl7_9.add("patriotism");
           ArrayList<String> lvl10_12=new ArrayList<>();
        lvl10_12.addAll(lvl1_3);
        lvl10_12.add("computer");
        lvl10_12.add("second language");
        lvl10_12.add("patriotism");
        lvl10_12.add("history");
        lvl10_12.add("physics");
        lvl10_12.add("philosophy");
        lvl10_12.add("biology");
        lvl10_12.add("geography");
        lvl10_12.add("chimistry");

         ArrayList<ArrayList<String>> levels_subjects=new ArrayList<ArrayList<String>>();
        levels_subjects.add(lvl1_3);
        levels_subjects.add(lvl1_3);
        levels_subjects.add(lvl1_3);
        levels_subjects.add(lvl4_6);
        levels_subjects.add(lvl4_6);
        levels_subjects.add(lvl4_6);
        levels_subjects.add(lvl7_9);
        levels_subjects.add(lvl7_9);
        levels_subjects.add(lvl7_9);
        levels_subjects.add(lvl10_12);
        levels_subjects.add(lvl10_12);
        levels_subjects.add(lvl10_12);
        //________________________________________________________________________




        int numberSubject=levels_subjects.get(stu.getLevel()-1).size();
        int subjectCounter = 0;
        int Row = 0;
        int Colume = 0;
        BorderPane[] subjectBorderPane = new BorderPane[numberSubject];
        HBox[] buttonBox = new HBox[numberSubject];
        Button[] subject = new Button[numberSubject];

        if(numberSubject <= 3){
            Row = 1;
            Colume = numberSubject;
        }
        else
        {
            Row = ((numberSubject/3)+(numberSubject%3));
            Colume = 3;
        }
        for (int i = 0; i < Row && subjectCounter < levels_subjects.get(stu.getLevel()-1).size(); i++) {
            for (int j = 0; j < Colume && subjectCounter < levels_subjects.get(stu.getLevel()-1).size(); j++,subjectCounter++) {
                subjectBorderPane[subjectCounter] = new BorderPane();
                buttonBox[subjectCounter] = new HBox();
                subject[subjectCounter] = new Button();
                subjectBorderPane[subjectCounter].setMinSize(200, 150);
                subjectBorderPane[subjectCounter].setStyle("-fx-background-color: TRANSPARENT");
                subject[subjectCounter].setTextFill(Color.WHITE);
                subject[subjectCounter].setFont(Font.font(20));
                subject[subjectCounter].setStyle("-fx-background-color:TRANSPARENT;-fx-border-color:WHITE");
                subject[subjectCounter].setMinSize(200, 100);
                buttonBox[subjectCounter].setMinSize(200, 100);
                subject[subjectCounter].setText(levels_subjects.get(stu.getLevel()-1).get(subjectCounter));
               // subject[subjectCounter].setText("arabic");
                buttonBox[subjectCounter].getChildren().add(subject[subjectCounter]);
                subjectBorderPane[subjectCounter].setTop(buttonBox[subjectCounter]);
                this.add(subjectBorderPane[subjectCounter], j,i );
            }
        }

        for (int i = 0 ; i < numberSubject; i++) {
            int finalI = i;
            subject[i].setOnAction(e -> {
                subjectName.setText(subject[finalI].getText());
                home.containGrid.getChildren().removeAll(classTable,this,HomeWork,email);
                home.homeBorder.setLeft(home.AmrAdderScroll);
                home.subjectScroll.setPadding(new Insets(10,10,10,30));
                this.setPadding(new Insets(10, 10, 10, 10));
                home.subjectScroll.setStyle("-fx-background-color:#f4f4f4");
                home.containGrid.setStyle("-fx-background-color:#f4f4f4");
                email.setPadding(new Insets(10,50,50,50));
                email.emailTo.setTextFill(Color.BLACK);
                email.emailSubject.setTextFill(Color.BLACK);
                email.emailMessage.setTextFill(Color.BLACK);
                HomeWork=  new Assignment(this.stu,subjectName.getText());
            });
        }
        subjectName.setTextFill(Color.WHITE);
        subjectName.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15.0D));
        home.gridSCenter.add(subjectName,6,0);

    }
}
