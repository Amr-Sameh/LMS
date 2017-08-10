package GUI;

//import General.General_Persone;

import Connection.Connection_methods;
import General.General_Persone;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
public class Email extends GridPane {
    Label emailTo = new Label("To:");
    Label emailSubject = new Label("Subjrct:");
    Label emailMessage = new Label("Message:");
    TextField textField = new TextField();
    Button search = new Button("Search");
    private Text actionStatus;
    ComboBox mailList = new ComboBox();
General_Persone persone;
    public Email(General_Persone persone) {
        this.persone=persone;
        textField.setPromptText("Search ......");
        this.setPadding(new Insets(20, 66, 51, 60));
        HBox toFrom = new HBox();
        HBox send = new HBox();
        GridPane sendClear = new GridPane();
        GridPane senderGrid = new GridPane();
        this.setHgap(10);
        this.setVgap(10);
        senderGrid.setHgap(10);
        senderGrid.setVgap(10);
        sendClear.setHgap(10);
        sendClear.setVgap(10);
        TextField textTo = new TextField();
        TextField textSubject = new TextField();
        TextArea textMessage = new TextArea();
        Button sendbtn = new Button("Send");
        Button clear = new Button("Clear");
        emailTo.setTextFill(Color.WHITE);
        emailSubject.setTextFill(Color.WHITE);
        emailMessage.setTextFill(Color.WHITE);
        sendbtn.setMinSize(200, 30);
        clear.setMinSize(100, 30);
        toFrom.getChildren().add(senderGrid);
        send.getChildren().add(sendClear);
        send.setAlignment(Pos.BASELINE_RIGHT);
        send.setMinWidth(500);
        senderGrid.add(emailTo, 0, 0);
        senderGrid.add(search, 3, 0);
        senderGrid.add(textField,2,0);
        senderGrid.add(textTo, 1, 0);
        senderGrid.add(emailSubject, 0, 2);
        senderGrid.add(textSubject, 1, 2);
        this.add(senderGrid, 0, 0);
        this.add(emailMessage, 0, 1);
        this.add(textMessage, 0, 2);
        this.add(send, 0, 3);
        sendClear.add(sendbtn, 0, 0);
        sendClear.add(clear, 1, 0);
        textTo.setMinWidth(450);
        textTo.setMinHeight(30);
        textSubject.setMinHeight(30);
        emailTo.setFont((Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15.0D)));
        //  emailFrom.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15.0D));
        emailMessage.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15.0D));
        emailSubject.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15.0D));
        emailMessage.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15.0D));
        sendbtn.setStyle("-fx-border-color: WHITE");
        clear.setStyle("-fx-border-color: WHITE");
        textMessage.setWrapText(true);
        textMessage.setMinWidth(500);
        textMessage.setMinHeight(220);
        senderGrid.setAlignment(Pos.CENTER_LEFT);
        this.setAlignment(Pos.CENTER);
        getMailList();
        senderGrid.getChildren().remove(textTo);
        senderGrid.add(mailList, 1, 0);
//            addPerson().setOnAction(e->{
//                    getSelectedOne(addPerson().getSelectionModel().getSelectedIndex());
//
//            });

        clear.setOnAction(e -> {

            textMessage.clear();
        });

        mailList.setMinWidth(250);

        search.setOnAction(e -> {
            mailList.getItems().clear();
            ComboBox z = mailList;

            Connection_methods.sendorder("$search(" + textField.getText() + ")");
            Connection_methods.sendobj(persone);
            ArrayList<General_Persone> c = (ArrayList<General_Persone>) (ArrayList<?>) Connection_methods.rciveobj();
            for (General_Persone x : c) {
                mailList.getItems().add(x.getId() +" - "+x.getName()+ "  " + x.getE_mail());
            }

        });
        sendbtn.setOnAction(e->{
            String to=mailList.getValue().toString();
            to=to.substring(to.lastIndexOf(" ")+1);


           Connection_methods.sendorder("$mail!("+to+","+textSubject.getText()+" [messeage from "+persone.getName()+"]"+"^"+textMessage.getText()+")");
            JOptionPane.showMessageDialog(null,(String)Connection_methods.rciveobj(),"E-mail connection",JOptionPane.WARNING_MESSAGE);
        });
    }

    private void addPerson(ArrayList<General_Persone> mail) {
        for (General_Persone o : mail) {
            mailList.getItems().add(o.getName());
        }
    }

    /*private String getSelectedOne(int index,ArrayList<General_Persone> email){

    }*/
    private ComboBox getMailList() {
        return mailList;
    }

    private void showFiles() throws IOException {

        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showSaveDialog(null);
        if (selectedFile != null) {
            actionStatus.setText("File selected: " + selectedFile.getAbsoluteFile());
        } else {
            actionStatus.setText("File selection cancelled.");
        }
    }

}
