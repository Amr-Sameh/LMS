package GUI;

import Connection.Connection_methods;
import GUI.LogIn;
import General.General_Persone;
import General.Student;
import General.Teacher;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Omer on 12/4/2016.
 */
public class Home {
    private General_Persone persone;
    public GridPane containGrid = new GridPane();
    public BorderPane toolBorder = new BorderPane();
    public GridPane gridSRight = new GridPane();
    public GridPane gridSLeft = new GridPane();
    public GridPane gridSCenter = new GridPane();
    public BorderPane homeBorder = new BorderPane();
    public VBox AmrAdder = new VBox();
    public ScrollPane AmrAdderScroll = new ScrollPane(AmrAdder);
    public ScrollPane subjectScroll = new ScrollPane(containGrid);
    public Label name = new Label();
    public Label id = new Label();
    public Label Class = new Label();
    public Label level = new Label();
    public Button message = new Button("Message");
    public Button timetable = new Button("TimeTable");
    public Button setImage = new Button("setImage");
    public Button logOut = new Button("LogOut");
    public Button home = new Button("Home");
    public Button profile = new Button("Profile");
    public Button homeWork = new Button("HomeWork");
    public Button grades = new Button("Grades");

    public Home(General_Persone persone) {




        this.persone = persone;
        Stage primaryStage = new Stage();
        primaryStage.getIcons().add(new Image("5.png"));
        primaryStage.setTitle("Student Home");
        homeBorder.setStyle("-fx-background-color:WHITE");
        subjectScroll.setStyle("-fx-background:#4a65a0");
        Path path = new Path();
        MoveTo moveTo = new MoveTo();
        moveTo.setX(0.0);
        moveTo.setY(105.0);
        VLineTo vLineTo = new VLineTo();
        path.getElements().add(moveTo);
        path.getElements().add(vLineTo);
        ComboBox search = new ComboBox();
        search.setEditable(false);

        Button searchbtn = new Button("Search");
        HBox topBox = new HBox();
        BorderPane Amr = new BorderPane();
        VBox addAmrAdder = new VBox();
        GridPane info = new GridPane();
        Circle image = new Circle();




        Scene scene = new Scene(homeBorder, 1000, 650);
        name.setTextFill(Color.WHITE);
        id.setTextFill(Color.WHITE);
        Class.setTextFill(Color.WHITE);
        level.setTextFill(Color.WHITE);
        timetable.setTextFill(Color.WHITE);
        message.setTextFill(Color.WHITE);
        searchbtn.setTextFill(Color.WHITE);
        setImage.setTextFill(Color.WHITE);
        logOut.setTextFill(Color.WHITE);
        home.setTextFill(Color.WHITE);
        profile.setTextFill(Color.WHITE);
        grades.setTextFill(Color.WHITE);
        homeWork.setTextFill(Color.WHITE);
        grades.setFont(Font.font(20));
        homeWork.setFont(Font.font(20));
        message.setStyle("-fx-background-color: TRANSPARENT;-fx-border-color: WHITE;");
        searchbtn.setStyle("-fx-background-color: TRANSPARENT;-fx-border-color: WHITE;");
        timetable.setStyle("-fx-background-color: TRANSPARENT; -fx-border-color: WHITE");
        setImage.setStyle("-fx-background-color: TRANSPARENT; -fx-border-color: WHITE");
        logOut.setStyle("-fx-background-color: TRANSPARENT; -fx-border-color: WHITE");
        home.setStyle("-fx-background-color: TRANSPARENT; -fx-border-color: WHITE");
        profile.setStyle("-fx-background-color: TRANSPARENT; -fx-border-color: WHITE");
        grades.setStyle("-fx-background-color: TRANSPARENT; -fx-border-color: TRANSPARENT");
        homeWork.setStyle("-fx-background-color: TRANSPARENT; -fx-border-color: TRANSPARENT");
        image.setRadius(40);
        image.setFill(Color.WHITE);
        info.setPadding(new Insets(40, 0, 0, 0));
        AmrAdder.getChildren().add(Amr);
        Amr.setCenter(addAmrAdder);
        addAmrAdder.getChildren().add(info);
        info.add(grades, 0, 0);
        info.add(homeWork, 0, 1);
        info.setAlignment(Pos.CENTER);
        info.setVgap(10);
        info.setHgap(10);
        //ScolloSubject.
        AmrAdderScroll.setStyle("-fx-background-color: #2b478f; -fx-opacity: 0.825");
        containGrid.setAlignment(Pos.CENTER);
        containGrid.setStyle("-fx-background-color:#4a65a0");
        subjectScroll.setPadding(new Insets(10, 142, 10, 170));

        logOut.setOnAction(e -> {
            try {

                LogIn logIn = new LogIn();
                Stage out = new Stage();
                out.initStyle(StageStyle.UNDECORATED);
                logIn.logIn(out);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            primaryStage.close();

        });
        addAmrAdder.setMinHeight(478);
        addAmrAdder.setMinWidth(275);
        AmrAdderScroll.setStyle("-fx-background-color:#2b478f");
        AmrAdder.setStyle("-fx-background-color: #2b478f; -fx-opacity: 0.825");
        Amr.setStyle("-fx-background-color: TRANSPARENT");
        Amr.setPadding(new Insets(10, 0, 10, 0));

        homeBorder.setCenter(subjectScroll);
        AmrAdderScroll.autosize();

        // RightS.
        GridPane logoutGrid = new GridPane();
        GridPane searchGrid = new GridPane();
        logoutGrid.setHgap(10);
        logoutGrid.setVgap(10);
        searchGrid.setHgap(10);
        searchGrid.setVgap(10);
        gridSRight.setHgap(10.0D);
        gridSRight.setVgap(10.0D);
        gridSRight.setPadding(new Insets(0.0D, 25.0D, 0.0D, 25.0D));
        search.setMinWidth(210);
        gridSRight.add(logoutGrid, 0, 0);
        gridSRight.add(searchGrid, 0, 1);
        logoutGrid.add(home, 0, 0);
        logoutGrid.add(timetable, 1, 0);
        logoutGrid.add(message, 2, 0);
        logoutGrid.add(logOut, 3, 0);
        logoutGrid.add(profile, 4, 0);
        searchGrid.add(search, 1, 0);
        searchGrid.add(searchbtn, 2, 0);
        gridSRight.setAlignment(Pos.CENTER);
        TextField textField = new TextField();
        searchGrid.add(textField, 0, 0);
        // LestS.
        gridSLeft.setHgap(0.0D);
        gridSLeft.setVgap(10.0D);
        gridSLeft.setPadding(new Insets(0.0D, 10.0D, 5.0D, 10.0D));
        gridSLeft.setAlignment(Pos.CENTER);
        gridSLeft.add(image, 0, 0);
        gridSLeft.add(name, 1, 0);
        gridSLeft.add(id, 1, 1);
        gridSLeft.add(Class, 2, 0);
        gridSLeft.add(level, 2, 1);

        // CenterS.
        gridSCenter.setHgap(10.0D);
        gridSCenter.setVgap(10.0D);
        gridSCenter.setPadding(new Insets(0, 5, 0, 10));
        Class.setPadding(new Insets(0, 0, 0, 35));
        level.setPadding(new Insets(0, 0, 0, 35));
        name.setPadding(new Insets(0, 0, 0, 10));
        id.setPadding(new Insets(0, 0, 0, 10));
        gridSCenter.add(path, 5, 0);
        level.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15.0D));
        Class.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15.0D));
        name.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15.0D));
        id.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15.0D));
        gridSCenter.setAlignment(Pos.BASELINE_LEFT);

        // TopS.
        Button closeBtn = new Button("×");
        Button miniMize = new Button("-");
        closeBtn.setOnAction((e) -> {
            Platform.exit();
        });
        miniMize.setOnAction((e) -> {
            ((Stage) ((Button) e.getSource()).getScene().getWindow()).setIconified(true);
        });
        closeBtn.setFont(Font.font(20.0D));
        closeBtn.setTextFill(Color.WHITE);
        closeBtn.setStyle("-fx-background-color: TRANSPARENT");
        closeBtn.setPadding(new Insets(0, 10, 0, 0));
        miniMize.setFont(Font.font(25.0D));
        miniMize.setTextFill(Color.WHITE);
        miniMize.setStyle("-fx-background-color: TRANSPARENT;");
        miniMize.setPadding(new Insets(0, 10, 0, 0));
        toolBorder.setStyle("-fx-background-color: #3b478f");
        topBox.getChildren().addAll(miniMize, closeBtn);
        topBox.setAlignment(Pos.TOP_RIGHT);
        topBox.autosize();
        toolBorder.setRight(gridSRight);
        toolBorder.setLeft(gridSLeft);
        toolBorder.setCenter(gridSCenter);
        toolBorder.setTop(topBox);
        homeBorder.setTop(toolBorder);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getStyle();
        primaryStage.toBack();
        primaryStage.setScene(scene);
        primaryStage.show();
        textField.setPromptText("Search .......");

        searchbtn.setOnAction(e -> {
            search.getItems().clear();
            ComboBox z = search;
            Connection_methods.sendorder("$search(" + textField.getText() + ")");
            Connection_methods.sendobj(persone);
            ArrayList<General_Persone> c = (ArrayList<General_Persone>) (ArrayList<?>) Connection_methods.rciveobj();
            for (General_Persone x : c) {
                if(persone.getId().contains("a")||persone.getId().contains("b")||persone.getId().contains("c")){
               if (!x.getId().contains("a")&&!x.getId().contains("b")&&!x.getId().contains("c"))
                search.getItems().add(x.getId() + " " + x.getName());
                }else
                    search.getItems().add(x.getId() + " " + x.getName());


            }

        });

        search.setOnAction(e -> {
            String temp = search.getSelectionModel().getSelectedItem() + "";
            if (temp!=null){

            if(temp.substring(0, temp.indexOf(' ')).contains("a")||temp.substring(0, temp.indexOf(' ')).contains("b")||temp.substring(0, temp.indexOf(' ')).contains("c")){

                Connection_methods.sendorder("$getteacher(" + temp.substring(0, temp.indexOf(' ')) + ")");
                General_Persone p = (General_Persone) Connection_methods.rciveobj();
                result_search result_search = new result_search(p,this.persone);
            }
            else {
                Connection_methods.sendorder("$getobj(" + temp.substring(0, temp.indexOf(' ')) + ")");
                General_Persone p = (General_Persone) Connection_methods.rciveobj();

                result_search result_search = new result_search(p,this.persone);

            }}
        });


        //-------------------*set values*------------------
        name.setText(persone.getName());
        id.setText(persone.getId());
        // level.setText(((Teacher)persone).getSubject());


    }


}
