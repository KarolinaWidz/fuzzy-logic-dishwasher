import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fuzzy Logic - Dishwasher");
        primaryStage.setScene(new Scene(new Controller().getStageGrid(),600,150));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
