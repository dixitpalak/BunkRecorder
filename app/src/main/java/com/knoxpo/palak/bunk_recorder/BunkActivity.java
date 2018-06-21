package com.knoxpo.palak.bunk_recorder;

import android.support.v4.app.Fragment;


public class BunkActivity extends SingleFragmentActivity {
    public Fragment getFragment(){
        return new BunkFragment();
    }

}
