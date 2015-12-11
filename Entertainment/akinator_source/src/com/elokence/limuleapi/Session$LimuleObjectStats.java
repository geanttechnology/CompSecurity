// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import java.io.Serializable;

// Referenced classes of package com.elokence.limuleapi:
//            Session

public static class mDelayAward
    implements Serializable
{

    private int mDelayAward;
    private int mFlagPhoto;
    private int mIdBase;
    private int mNbPlayed;
    private String mPreviousTime;

    public int getDelayAward()
    {
        return mDelayAward;
    }

    public int getFlagPhoto()
    {
        return mFlagPhoto;
    }

    public int getIdBase()
    {
        return mIdBase;
    }

    public int getNbPlayed()
    {
        return mNbPlayed;
    }

    public String getPreviousTime()
    {
        return mPreviousTime;
    }

    public void setDelayAward(int i)
    {
        mDelayAward = i;
    }

    public void setFlagPhoto(int i)
    {
        mFlagPhoto = i;
    }

    public void setIdBase(int i)
    {
        mIdBase = i;
    }

    public void setNbPlayed(int i)
    {
        mNbPlayed = i;
    }

    public void setPreviousTime(String s)
    {
        mPreviousTime = s;
    }



/*
    static int access$402( , int i)
    {
        .mIdBase = i;
        return i;
    }

*/



/*
    static int access$502(mIdBase midbase, int i)
    {
        midbase.mNbPlayed = i;
        return i;
    }

*/



/*
    static int access$602(mNbPlayed mnbplayed, int i)
    {
        mnbplayed.mDelayAward = i;
        return i;
    }

*/



/*
    static String access$702(mDelayAward mdelayaward, String s)
    {
        mdelayaward.mPreviousTime = s;
        return s;
    }

*/



/*
    static int access$802(mPreviousTime mprevioustime, int i)
    {
        mprevioustime.mFlagPhoto = i;
        return i;
    }

*/

    public mFlagPhoto()
    {
    }

    public mFlagPhoto(int i, int j, int k, String s, int l)
    {
        mNbPlayed = i;
        mIdBase = j;
        mFlagPhoto = k;
        mPreviousTime = s;
        mDelayAward = l;
    }
}
