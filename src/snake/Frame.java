package snake;

import java.io.IOException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import static snake.Main.*;
import static snake.Food.*;
import static snake.Audio.*;
import static snake.Controls.*;
import static snake.Score.*;

public class Frame {

    public static void frameUpdate(GraphicsContext graphicsContext) throws IOException {
        if (!gameAudio.isPlaying()) {
            gameAudioPlay();
        }

        if (isGameOver) {
            GameOver.gameStop();
            return;
        }

        //makes snakePortions follow movements of head
        for (int snakePortion = Main.snake.size() - 1; snakePortion >= 1; snakePortion--) {
            snake.get(snakePortion).xPosition = snake.get(snakePortion - 1).xPosition;
            snake.get(snakePortion).yPosition = snake.get(snakePortion - 1).yPosition;
        }

        move();
        eat();

        for (int x = 1; x < snake.size(); x++) {
            if (snake.get(0).xPosition == snake.get(x).xPosition && snake.get(0).yPosition == snake.get(x).yPosition) {
                isGameOver = true;
            }
        }
        if (score > highScore) {
            highScore = score;
        }

        //colors of the UI
        graphicsContext.setFill(Color.web("#E4FCD4"));
        graphicsContext.fillRect(0, 0, 1000, 750);

        graphicsContext.setFill(Color.web("#254F43"));
        graphicsContext.fillRect(0, 0, 1000, 75);

        snake.forEach(chunk -> {
            graphicsContext.setFill(Color.web("#254F43"));
            graphicsContext.fillRect(chunk.xPosition * 25, chunk.yPosition * 25, 24, 24);
        });

        basicUI(graphicsContext);

        graphicsContext.setFill(Color.web("#8CC474"));
        graphicsContext.fillOval(xPosition * 25, yPosition * 25, 24, 24);


    }

    static void basicUI(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.web("#8CC474"));
        graphicsContext.setFont(new Font("", 30));
        graphicsContext.fillText(String.valueOf(highScore), 10, 30);

        graphicsContext.setFill(Color.web("#8CC474"));
        graphicsContext.setFont(new Font("", 30));
        graphicsContext.fillText("High Score", 430, 30);

        graphicsContext.setFill(Color.web("#E4FCD4"));
        graphicsContext.setFont(new Font("", 30));
        graphicsContext.fillText(String.valueOf(score), 10, 60);

        graphicsContext.setFill(Color.web("#E4FCD4"));
        graphicsContext.setFont(new Font("", 30));
        graphicsContext.fillText("Current Score", 411, 60);
    }

}
