package com.example.cm1005.cheese.Game;

public class move {

    private playerMove player;
    private int moveDetail;

    public Move(playerType Player){
        this.player = player;
    }

    public  playerType getPlayer(){ return player; }

    public int getMove() { return moveDetail; }
}
