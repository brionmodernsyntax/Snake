/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import static snake.Main.*;
import static snake.Score.*;

public class GameStart {

    public static void gameStart() {
        //reset params
        FrameRate.speed = 125;
        score = 0;
        frameRate.start();
        isGameOver = false;
        direction = Direction.down;

        root.getChildren().add(playCanvas);
        root.getChildren().remove(GameOver.gameOver);

        //generate snake
        for (int x = 0; x < 3; x++) {
            snake.add(new Snake(20, 15));
        }


    }
}
