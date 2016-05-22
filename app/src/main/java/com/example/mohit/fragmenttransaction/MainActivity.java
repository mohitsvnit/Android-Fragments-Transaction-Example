package com.example.mohit.fragmenttransaction;

import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentA.Communicator {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FragmentA fragmentA;
    FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentid,fragmentA,"FragmentA");
        fragmentTransaction.commit();

    }

    @Override
    public void respond(String data) {
        Toast.makeText(getBaseContext(),data,Toast.LENGTH_SHORT).show();
        fragmentB = (FragmentB)fragmentManager.findFragmentById(R.id.fragmentid2);
        fragmentB.setData(data);
    }
}
