package snake;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import static snake.GameStart.gameStart;
import static snake.Main.direction;
import static snake.Main.frameRate;
import static snake.Main.isGameOver;
import static snake.Main.scene;
import static snake.Main.snake;

public class Controls {

    public static void move() {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if ((key.getCode() == KeyCode.W || key.getCode() == KeyCode.UP) && direction != Direction.down) {
                direction = Direction.up;
            }
            if ((key.getCode() == KeyCode.A || key.getCode() == KeyCode.LEFT) && direction != Direction.right) {
                direction = Direction.left;
            }
            if ((key.getCode() == KeyCode.S || key.getCode() == KeyCode.DOWN) && direction != Direction.up) {
                direction = Direction.down;
            }
            if ((key.getCode() == KeyCode.D || key.getCode() == KeyCode.RIGHT) && direction != Direction.left) {
                direction = Direction.right;
            }
            if (key.getCode() == KeyCode.ESCAPE) {
                frameRate.stop();
            }
            if (isGameOver) {
                if (key.getCode() == KeyCode.SPACE) {
                    gameStart();
                }
            }

        });

        switch (direction) {
            case up:
                snake.get(0).yPosition--;
                if (snake.get(0).yPosition < 3) {
                    isGameOver = true;
                }
                break;
            case down:
                snake.get(0).yPosition++;
                if (snake.get(0).yPosition > 29) {
                    isGameOver = true;
                }
                break;
            case left:
                snake.get(0).xPosition--;
                if (snake.get(0).xPosition < 0) {
                    isGameOver = true;
                }
                break;
            case right:
                snake.get(0).xPosition++;
                if (snake.get(0).xPosition > 39) {
                    isGameOver = true;
                }
                break;
            default:
                snake.get(0).xPosition--;
                break;
        }

    }
}
