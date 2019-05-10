package com.example.cm1005.cheese.old;

import com.example.cm1005.cheese.Game.playerType;

public class Board {
    public static final int MAX = 9;
    private playerType[] cells = new playerType[MAX];

    Public Board(){
        for(int i=0; i<MAX;i++){
            board[i]=0;
        }
    }
    // reset

    public void reset(){
        for(int i=0; i<MAX; i++)
            cells[i] = playerType.FREE;
    }

    public void move(playerType player, int move){
        cells[move] = player;
    }

    // Boolean get empty squares

    // CHECK win
    public playerType checkWin(){
        //top row
        if((cells[0] == cells[1]) && (cells[1] == cells[2])){
            return cells[0];}

        //first col
        else if((cells[0] == cells[3]) && (cells[3] == cells[6])){return cells[0];}
        //second col

        //L2R diag
        else if((cells[0] == cells[4]) && (cells[4] == cells[8])){return cells[0];}

        return playerType.FREE;
    }




}
