package snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static List<Snake> snake = new ArrayList<>();
    public static Direction direction = Direction.down;
    public static boolean isGameOver = false;
    public static Frame frame = new Frame();
    public static GraphicsContext graphicsContext;
    public static Pane root;
    public static Scene scene;
    public static int width = 1000;
    public static int height = 750;
    public static Canvas playCanvas = new Canvas(width, height);

    @Override
    public void start(Stage primaryStage){
        Score.importScore();
        graphicsContext = playCanvas.getGraphicsContext2D();
        root = new Pane();

        scene = new Scene(root, width, height);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake");
        primaryStage.show();
        primaryStage.getIcons().add(new Image(Main.class.getResource("favicon.ico").toString()));

        GameStart.gameStart();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
