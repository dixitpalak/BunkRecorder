package com.knoxpo.palak.bunk_recorder;

import java.util.Date;
import java.util.UUID;
import java.util.Calendar;

public class Bunk {

    private Date mDate;
    private boolean mIsBunked;

    public boolean isBunked()
    {
        return mIsBunked;
    }

    public void setBunked(boolean bunked)
    {
        mIsBunked = bunked;
    }




    public Bunk(Date date)
    {

        mDate=date;
    }


    public Date getDate()
    {
        return mDate;
    }


}

