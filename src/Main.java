import GUI.LogIn;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by PC - MeiR on 12/17/2016.
 */
public class Main extends Application{
    public static void main(String []args){
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.getIcons().add(new Image("5.png"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        LogIn log=new LogIn();
        log.logIn(primaryStage);
    }
}
