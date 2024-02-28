package org.example.snakeladder;

import javafx.util.Pair;
import org.example.snakeladder.SnakeLadder;

import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer, Integer>> positionCoordinates;

    ArrayList<Integer> snakeLadderPosition;

    public Board(){
        positionCoordinates = new ArrayList<>();
        populatePositionCoordinates();
        populateSnakeLadder();
    }

    private void populatePositionCoordinates(){
        positionCoordinates.add(new Pair<>(0,0)); //dummy value
        for (int i = 0; i < SnakeLadder.height; i++) {
            for (int j = 0; j < SnakeLadder.width; j++) {
                //x coordinates
                int xCord = 0;
                if (i % 2 == 0)
                {
                    xCord = j * SnakeLadder.tileSize + SnakeLadder.tileSize/2;
                }
                else {
                    xCord = SnakeLadder.tileSize * SnakeLadder.height - (j * SnakeLadder.tileSize) - SnakeLadder.tileSize/2;
                }
                //y coordinates
                int yCord = SnakeLadder.tileSize * SnakeLadder.height - (i * SnakeLadder.tileSize) - SnakeLadder.tileSize/2;
                positionCoordinates.add(new Pair<>(xCord, yCord));
            }
        }
    }

    private void populateSnakeLadder(){
        snakeLadderPosition = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeLadderPosition.add(i);
        }
        snakeLadderPosition.set(5, 58);
        snakeLadderPosition.set(14,49);
        snakeLadderPosition.set(38,20);
        snakeLadderPosition.set(51,10);
        snakeLadderPosition.set(53,72);
        snakeLadderPosition.set(76,54);
        snakeLadderPosition.set(91,73);
        snakeLadderPosition.set(97,61);
        snakeLadderPosition.set(64,83);

    }

    public int getNewPosition(int currentPosition){
        if(currentPosition > 0 && currentPosition <= 100){
            return  snakeLadderPosition.get(currentPosition);
        }
        return -1;
    }

    int getXCoordinate(int position){
        if (position >= 1 && position <= 100)
            return positionCoordinates.get(position).getKey();
        return -1;
    }

    int getYCoordinate(int position){
        if (position >= 1 && position <= 100)
            return positionCoordinates.get(position).getValue();
        return -1;
    }

    //    public static void main(String[] args) {
    //        Board board = new Board();
    //        for (int i = 0; i < board.positionCoordinates.size(); i++) {
    //            System.out.println(i + " $ x :" + board.positionCoordinates.get(i).getKey() +
    //                    " y : " + board.positionCoordinates.get(i).getValue()
    //                    );
    //        }
    //    }
}


