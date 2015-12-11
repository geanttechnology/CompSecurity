// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import java.io.Serializable;

// Referenced classes of package com.elokence.limuleapi:
//            Session

public static class mAnswerExpected
    implements Serializable
{

    private String mAnswerExpected;
    private String mAnswerGiven;
    private String mQuestionLabel;

    public String getExpectedAnswer()
    {
        return mAnswerExpected;
    }

    public String getGivenAnswer()
    {
        return mAnswerGiven;
    }

    public String getQuestionLabel()
    {
        return mQuestionLabel;
    }

    public void setAnswerExpected(String s)
    {
        mAnswerExpected = s;
    }

    public void setGivenAnswer(String s)
    {
        mAnswerGiven = s;
    }

    public void setQuestionLabel(String s)
    {
        mQuestionLabel = s;
    }

    public ()
    {
    }

    public (String s, String s1, String s2)
    {
        mQuestionLabel = s;
        mAnswerExpected = s1;
        mAnswerExpected = s2;
    }
}
