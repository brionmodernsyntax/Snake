package snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static List<Snake> snake = new ArrayList<>();
    public static Direction direction = Direction.down;
    public static boolean isGameOver = false;
    public static FrameRate frameRate = new FrameRate();
    public static GraphicsContext graphicsContext;
    public static Pane root;
    public static Scene scene;
    public static Canvas playCanvas = new Canvas(1000, 750);

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
        Score.importScore();
        graphicsContext = playCanvas.getGraphicsContext2D();
        root = new Pane();

        scene = new Scene(root, 1000, 750);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake");
        primaryStage.show();

        GameStart.gameStart();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
