package com.example.mohit.fragmenttransaction;

import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class FragmentA extends Fragment implements View.OnClickListener{

    Button btn;
    Button btncnt;
    FragmentB fragmentB;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    int cnt = 0;

    Communicator comm;
   // View.OnClickListener onClickListener;


    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        comm = (Communicator) getActivity();
        btn = (Button) view.findViewById(R.id.button);
        btncnt = (Button) view.findViewById(R.id.button2);
        btn.setOnClickListener(this);
        btncnt.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        if(v == btn){
            //Toast.makeText(getActivity(),"Khupach",Toast.LENGTH_SHORT).show();

            fragmentB = new FragmentB();
            fragmentManager = getActivity().getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragmentid2,fragmentB,"FragmentB");
            fragmentTransaction.commit();
        }
        else if (v == btncnt){
            cnt++;
            comm.respond(String.valueOf(cnt));
        }
    }

    public interface Communicator {
        public void respond(String data);
    }
}
