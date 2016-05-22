package com.example.mohit.fragmenttransaction;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentB extends Fragment {

    TextView tv;

    public FragmentB() {

        // Required empty public constructor
    }
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b,container,false);
        tv = (TextView) view.findViewById(R.id.textView);

        return view;
    }

    public void setData(String counter){
        //Toast.makeText(getActivity(),counter,Toast.LENGTH_SHORT).show();
        tv.setText(counter);
    }


}
