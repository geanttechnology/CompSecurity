// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.elokence.limuleapi:
//            Session

public static class mAnswers
    implements Serializable
{

    private ArrayList mAnswers;
    private float mProgress;
    private String mQuestion;
    private int mStep;

    public ArrayList getAnswers()
    {
        return mAnswers;
    }

    public float getProgression()
    {
        return mProgress;
    }

    public String getQuestion()
    {
        return mQuestion;
    }

    public int getStep()
    {
        return mStep;
    }



/*
    static int access$002( , int i)
    {
        .mStep = i;
        return i;
    }

*/



/*
    static String access$102(mStep mstep, String s)
    {
        mstep.mQuestion = s;
        return s;
    }

*/



/*
    static float access$202(mQuestion mquestion, float f)
    {
        mquestion.mProgress = f;
        return f;
    }

*/



/*
    static ArrayList access$302(mProgress mprogress, ArrayList arraylist)
    {
        mprogress.mAnswers = arraylist;
        return arraylist;
    }

*/

    public mAnswers()
    {
    }
}
