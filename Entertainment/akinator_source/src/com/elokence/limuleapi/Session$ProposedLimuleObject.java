// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;


// Referenced classes of package com.elokence.limuleapi:
//            Session

public static class mRanking_limit extends mRanking_limit
{

    private boolean mDoesValidateConstraint;
    private int mIdInSession;
    private String mPicturePath;
    private int mRanking_limit;

    public int getIdSession()
    {
        return mIdInSession;
    }

    public String getPicturePath()
    {
        return mPicturePath;
    }

    public int getRankingLimit()
    {
        return mRanking_limit;
    }

    public boolean isValidateConstraint()
    {
        return mDoesValidateConstraint;
    }

    public void setIdSession(int i)
    {
        mIdInSession = i;
    }

    public void setPicturePath(String s)
    {
        mPicturePath = s;
    }

    public void setRankingLimit(int i)
    {
        mRanking_limit = i;
    }

    public void setValideConstrait(boolean flag)
    {
        mDoesValidateConstraint = flag;
    }

    public _cls9()
    {
    }

    public _cls9(int i, String s, String s1, int j, String s2, boolean flag, int k)
    {
        super(i, s, s1);
        mIdInSession = j;
        mPicturePath = s2;
        mDoesValidateConstraint = flag;
        mRanking_limit = k;
    }
}
