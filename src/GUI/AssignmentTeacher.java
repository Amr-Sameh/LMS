package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by mostafa saleh on 12/20/2016.
 */
public class AssignmentTeacher extends GridPane {
    Text actionStatus=new Text();

    DatePicker deadLine = new DatePicker();

    Button submit = new Button("Submit");
    public AssignmentTeacher(){
        deadLine.setEditable(false);

        this.setAlignment(Pos.CENTER);
        this.setHgap(20);
        this.setVgap(20);
        this.setPadding(new Insets(20,20,20,20));
        TextField level = new TextField();
        TextField className = new TextField();

        level.setPromptText("Level_Number");
        className.setPromptText("Class_Name");
        deadLine.setPromptText("DeadLine");
        Button upload = new Button("upload");



        this.add(upload,0,0);
        this.add(deadLine,3,0);
        this.add(submit,4,0);
        upload.setOnAction(e->{
            try {
                showFiles();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    }

    private void showFiles() throws IOException {

        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            actionStatus.setText(String.valueOf(selectedFile.getAbsoluteFile()));
        }
        else {
            actionStatus.setText("File selection cancelled.");
        }
    }

}
