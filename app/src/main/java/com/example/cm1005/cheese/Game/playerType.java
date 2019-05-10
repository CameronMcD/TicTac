package com.example.cm1005.cheese.Game;

public enum playerType {

    CROSS(0),
    NOUGHT(1),
    FREE(2),
    NO_WINNER(3);

    private final int id;

    playerType(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }

}


