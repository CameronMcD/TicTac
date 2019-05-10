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
import android.widget.Button;
import android.widget.TextView;

import com.example.cm1005.cheese.R;


public class CheeseFactsFragment extends Fragment {
    private final String TAG = getClass().toString();
    View view;
    int cheeseNum=1;

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

    private void BroadcastIntent (String cheese){
        Intent intent = new Intent();
        intent.setAction(Constant.LIST_MSG);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.putExtra(Constant.CHEESE_DETAIL, cheese);
        getActivity().sendBroadcast(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d(TAG,"Broadcast message rec'd in "+TAG);
            }
        };
        view = inflater.inflate(R.layout.planet_fact_frag, container, false);

        ((Button)view.findViewById(R.id.add_list_item_btn)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        BroadcastIntent("Cheese_"+cheeseNum++);
                    }
                }
        );

        return (view);
    }



    public void populatePlanetFacts(int planet){
        //static call to Planet class to get planet
        Cheese p = Cheese.cheeseFacts[planet];
        ((TextView)view.findViewById(R.id.page_header))
                .setText("Cheese Facts for "+p.getName());
        ((TextView)view.findViewById(R.id.Viscosity))
                .setText("Viscosity =: "+p.getViscosity());
        ((TextView)view.findViewById(R.id.meltingPoint))
                .setText("Melting Point =: "+p.getMeltingPoint());
        ((TextView)view.findViewById(R.id.origin))
                .setText("Origin =: "+p.getOrigin());

    }
}