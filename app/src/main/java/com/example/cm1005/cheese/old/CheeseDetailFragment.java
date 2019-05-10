package com.example.cm1005.cheese.old;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.cm1005.cheese.R;


public class CheeseDetailFragment extends Fragment {
    private final String TAG = getClass().toString();

    private static int[] squares = {
      R.id.sq_1, R.id.sq_2, R.id.sq_3,
      R.id.sq_4, R.id.sq_5, R.id.sq_6,
      R.id.sq_7, R.id.sq_8, R.id.sq_9,
    };

    private Board board;
    String name;

    IntentFilter filter = new IntentFilter(Constant.LOBBY_MSG);
    BroadcastReceiver broadcastReceiver;

    @Override
    public void onResume(){
        super.onResume();
        getActivity().registerReceiver(this.broadcastReceiver, filter);
    }
    @Override
    public void onPause(){
        super.onPause();
        getActivity().unregisterReceiver(this.broadcastReceiver);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d(TAG,"Broadcast message rec'd in "+TAG);
            }
        };

        View result=inflater.inflate(R.layout.content_gameboard, container, false);
        return(result);

        /* setupBtnClicks(); */

    }

    private void setupBtnClicks(){
        for(int i=0; i< Board.MAX;i++){
            findViewById(squares[i]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v) {
                    ImageButton iBtn = (ImageButton) v;
                    iBtn.setImageResource(R.drawable.blue);
                    for (int i = 0; i < Board.MAX; i++){
                        if (squares[i] == iBtn.getId()){
                            board.updateBoard(i);
                            iBtn.setOnClickListener(null);
                        }
                    }
                    if(board.checkWin()){
                        lastActivity();
                    }
                }
            });
        }
    }

    /* !!!!!! */
    private View findViewById(int square) {
        return null;
    }

    public void setImage(int resourceID){
        ImageView imageView = (ImageView) getView().findViewById(R.id.cheese_image);
        imageView.setImageResource(resourceID);
    }
}