package com.example.cm1005.cheese.old;

import android.app.ListFragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cm1005.cheese.R;

import java.util.ArrayList;
import java.util.List;


public class CheeseListFragment extends ListFragment {
    List<String> updateList;

    IntentFilter filter = new IntentFilter(Constant.LIST_MSG);
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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateList = new ArrayList<>();
        String[] emptyList = {};


        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,Cheese.names ));

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String cheese = intent.getStringExtra(Constant.CHEESE_DETAIL);
                updateList(cheese);
            }
        };
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //popup a bottom of the screen
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();

        //update facts fragment
        if(position >= Cheese.names.length){return;}
        ((CheeseFactsFragment)getFragmentManager().findFragmentById(R.id.fragment_right))
                .populatePlanetFacts(position);
        //update image fragment
        ((CheeseDetailFragment)getFragmentManager().findFragmentById(R.id.fragment_centre))
                .setImage(Cheese.cheeseResource[position]);
        //broadcast message to LOBBY_MSG registered listeners
        broadcastIntent();
    }

    public void broadcastIntent() {
        Intent intent = new Intent();
        intent.setAction(Constant.LOBBY_MSG);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        getActivity().sendBroadcast(intent);
    }

    public void updateList(String s){
        updateList.add(s);
        String[] newList = updateList.toArray(new String[updateList.size()]);

        ListAdapter mAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, newList);
        setListAdapter(mAdapter);
    }
}