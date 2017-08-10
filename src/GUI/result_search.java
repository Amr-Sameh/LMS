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
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by mostafa saleh on 12/22/2016.
 */
public class result_search extends GridPane{
    General_Persone persone;
    General_Persone g;
    private Text actionStatus;
    Stage registerStage = new Stage();
    public result_search(General_Persone persone,General_Persone g) {
        this.persone=persone;
this.g=g;

        registerStage.initModality(Modality.APPLICATION_MODAL);
        Circle image = new Circle();
        Scene registerScene = new Scene(this,500,500);

        this.getChildren().clear();
        Button reset = new Button("Edit");
        Button save = new Button("Save");
        Button close = new Button("close");
        Label name = new Label("Name:");
        TextField myName = new TextField(persone.getName());
        myName.setEditable(false);
        Label id = new Label("ID:");
        Label myId = new Label(persone.getId());
        final Label[] email = {new Label("E-Mail:")};
        TextField myEmail = new TextField();
        myEmail.setEditable(false);
        TextField lvel=new TextField();
        lvel.setEditable(false);
        TextField classs=new TextField();
        classs.setEditable(false);


        reset.setMinWidth(100);
        save.setMinWidth(100);
        myEmail.setMinWidth(200);

myEmail.setText(persone.getE_mail());
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

        this.add(reset,1,8);
        this.add(email[0],0,5);
        this.add(myEmail,1,5);
        this.add(save,0,8);
        this.add(close,2,8);
        Button report =new Button("Report");
        final boolean[] check = new boolean[1];
        if(g.getId().equals("#0000")) {
        }else if(g.getId().contains("a")||g.getId().contains("b")||g.getId().contains("c")){
            this.getChildren().remove(reset);
            this.getChildren().remove(save);

            this.add(report,0,8);
            report.setOnAction(e->{
Student temp=(Student) persone;
                Teacher t=(Teacher) g;
                Connection_methods.sendorder("$report("+temp.getLevel()+","+temp.getClasses()+"&"+t.getSubject()+"@"+temp.getId()+")");
                ArrayList<String> list=(ArrayList<String>)(ArrayList<?>) Connection_methods.rciveobj();
                File z = new FileChooser().showSaveDialog(null);
                Managegui.report(list,z.getAbsolutePath());





            });
        }

        if(persone.getId().equals("#0000")) {
        }else if(persone.getId().contains("a")||persone.getId().contains("b")||persone.getId().contains("c")){
            System.out.println("her");
            this.getChildren().remove(report);
            this.getChildren().remove(save);
            this.getChildren().remove(reset);
            Teacher t=(Teacher)persone;
            this.add(new Label("statg"),0,6);
            lvel.setText(t.getStage());
            this.add(lvel,1,6);
            this.add(new Label("subject"),0,7);
            classs.setText(t.getSubject());
            this.add(classs,1,7);
        }else{
            Student s=(Student) persone;
            this.getChildren().remove(save);
            this.getChildren().remove(reset);
            this.add(new Label("Level"),0,6);
            lvel.setText(String.valueOf(s.getLevel()));
            this.add(lvel,1,6);
            this.add(new Label("class"),0,7);
            classs.setText(s.getClasses());
            this.add(classs,1,7);
        }

        registerStage.setScene(registerScene);
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.getStyle();

        registerStage.show();
        close.setOnAction(e->{
        registerStage.close();
        });

    }

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

}
