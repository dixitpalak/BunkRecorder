package com.knoxpo.palak.bunk_recorder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

abstract public class SingleFragmentActivity extends AppCompatActivity {
    abstract public Fragment getFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment existingfragment=fragmentManager.findFragmentById(R.id.fragment_container);
        if(existingfragment == null){
            fragmentManager.beginTransaction()
            .replace(R.id.fragment_container,getFragment())
            .commit();


        }
    }
}
