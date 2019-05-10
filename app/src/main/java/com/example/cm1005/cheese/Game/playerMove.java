package com.example.cm1005.cheese.Game;

public class playerMove {

        playerType player;
        String name;
        int move;

        public playerMove(playerType player, int move){
            this.player = player;
            this.move = move;
            this.name = GameState.getThisGame().getMyName();
        }

        public int getMove(){
            return move;
        }

        public playerType getPlayer(){
            return player;
        }

        public void setPlayerName(String name){
            this.name=name;
        }

        public String getPlayerName(){
            return name;
        }
    }


