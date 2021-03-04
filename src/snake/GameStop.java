package snake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static snake.Main.*;

public class GameStop {
    public static GraphicsContext gameOverContext;
    public static Canvas gameOver = new Canvas(1000, 750);

    public static void gameStop() {
        gameOverContext = gameOver.getGraphicsContext2D();
        Score.exportScore();

        Main.root.getChildren().remove(playCanvas);
        Main.root.getChildren().add(gameOver);

        gameOverContext.setFill(Color.web("#E4FCD4"));
        gameOverContext.fillRect(0, 0, width, height);

        gameOverContext.setFill(Color.web("#254F43"));
        gameOverContext.fillRect(0, 0, width, 75);

        Frame.basicUI(gameOverContext);

        gameOverContext.setFill(Color.web("#254F43"));
        gameOverContext.setFont(new Font("", 130));
        gameOverContext.fillText("PRESS SPACE", 115, 350);

        gameOverContext.setFill(Color.web("#254F43"));
        gameOverContext.setFont(new Font("", 137));
        gameOverContext.fillText("TO RESTART", 124, 485);

        gameOverContext.setFill(Color.web("#254F43"));
        gameOverContext.setFont(new Font("", 50));
        gameOverContext.fillText("W,A,S,D TO MOVE", 300, 735);

        snake.removeAll(snake);
        Main.frame.stop();


    }
}
