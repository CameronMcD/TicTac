package com.example.cm1005.cheese.old;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OXOFragment {/*
    private View mContentView = null;
    private  boolean isServer;
    private DeviceDetailFragment deviceDetailFragment;
    private static OXOFragment oxoFragment;
    private Gson gson;
    private PlayerState me;
    private static int[] playerImages = {R.drawable.yellow,R.drawable.green};
    private static int[] boardImages = {R.drawable.blue,R.drawable.red};

    private static int[] squares = {
            R.id.sq_1, R.id.sq_2, R.id.sq_3,
            R.id.sq_4, R.id.sq_5, R.id.sq_6,
            R.id.sq_7, R.id.sq_8, R.id.sq_9
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.content_main, null);

        setupBtnClicks();
        oxoFragment = this;
        GameState.getThisGame();
        return mContentView;
    }

    private void setupBtnClicks() {
        for(int i=0; i<squares.length;i++) {
            mContentView.findViewById(squares[i]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deviceDetailFragment = (DeviceDetailFragment)getFragmentManager().
                            findFragmentById(R.id.fragment_right);
                    ImageButton iBtn = (ImageButton) v;
                    //first time set player detail
                    if(me==null) {
                        me = new PlayerState(GameState.getThisGame().getMyName());
                        if (DeviceDetailFragment.isServer()) {
                            isServer=true;
                            me.setPlayerType(PlayerType.NOUGHT);
                            enableInterface(false);
                        }
                        else {
                            isServer=false;
                            me.setPlayerType(PlayerType.CROSS);
                            enableInterface(true);
                        }
                        GameState.getThisGame().setPlayerDetail(me.getPlayerType());
                    }
                    iBtn.setImageResource(playerImages[me.getPlayerType().getValue()]);
                    iBtn.setOnClickListener(null);
                    enableInterface(false);
                    for (int i = 0; i < Board.MAX; i++) {
                        if (squares[i] == iBtn.getId()) {
                            PlayerMove pMove = new PlayerMove(me.getPlayerType(), i);
                            GameState.getThisGame().processPlayerMove(pMove);
                            if(GameState.getThisGame().checkForWinner() != PlayerType.NO_WINNER)
                                gameOverRoutine();
                            if(isServer)
                                deviceDetailFragment.sendServerMove(gson.toJson(pMove));
                            else
                                deviceDetailFragment.sendClientMove(gson.toJson(pMove));
                        }
                    }
                }
            });
        }
    }

    public static void handleOpponentMove(PlayerMove playerMove){
        Activity activity = oxoFragment.getActivity();
        View view = oxoFragment.mContentView;
        final ImageButton btn = (ImageButton) view.findViewById(squares[playerMove.getMove()]);
        final PlayerMove pMove = playerMove;
        GameState.getThisGame().processPlayerMove(pMove);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btn.setImageResource(playerImages[pMove.getPlayer().getValue()]);
                btn.setOnClickListener(null);
                if(GameState.getThisGame().checkForWinner() != PlayerType.NO_WINNER)
                    gameOverRoutine();
                else
                    enableInterface(true);
            }
        });
    }

    public static void enableInterface(boolean set){
        boolean[] enabledSquares = GameState.getThisGame().getEmptySquares();
        for(int i=0;i<squares.length;i++)
            if(enabledSquares[i]){
                ImageButton iBtn = (ImageButton) oxoFragment.mContentView.findViewById(squares[i]);
                iBtn.setEnabled(set);
            }
    }

    public static void gameOverRoutine() {
        GameState.getThisGame().newGame();
        resetBoard();
        enableInterface(!oxoFragment.isServer);
    }

    private static void resetBoard(){
        for(int i=0;i<squares.length;i++){
            ImageButton iBtn = (ImageButton) oxoFragment.mContentView.findViewById(squares[i]);
            iBtn.setImageResource(boardImages[i%2]);
        }
    }

    private void setPlayerNames(){

    } */
}
