// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import java.io.Serializable;

// Referenced classes of package com.elokence.limuleapi:
//            Session

public static class 
    implements Serializable
{

    private int mId;
    private String mQuestion;
    private boolean mValidated;

    public int getId()
    {
        return mId;
    }

    public String getQuestion()
    {
        return mQuestion;
    }

    public boolean isValidated()
    {
        return mValidated;
    }

    public void setId(int i)
    {
        mId = i;
    }

    public void setQuestion(String s)
    {
        mQuestion = s;
    }

    public void setValidated(boolean flag)
    {
        mValidated = flag;
    }

    public ()
    {
    }
}
