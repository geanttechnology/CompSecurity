// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;


// Referenced classes of package com.elokence.limuleapi:
//            Session

public static class mElementMinibaseId extends mElementMinibaseId
{

    private int mElementMinibaseId;
    private boolean mMyWorldAddable;
    private int mNbPlayed;

    public int getElementMinibaseId()
    {
        return mElementMinibaseId;
    }

    public int getNbPlayed()
    {
        return mNbPlayed;
    }

    public boolean isMyWorldAddable()
    {
        return mMyWorldAddable;
    }

    public void setElementMinibaseId(int i)
    {
        mElementMinibaseId = i;
    }

    public void setMyWorldAddable(boolean flag)
    {
        mMyWorldAddable = flag;
    }

    public void setNbPlayed(int i)
    {
        mNbPlayed = i;
    }

    public A()
    {
        mMyWorldAddable = false;
        mElementMinibaseId = -1;
        mNbPlayed = 0;
    }

    public mNbPlayed(int i, String s, String s1, int j, String s2, boolean flag, int k, 
            boolean flag1, int l)
    {
        super(i, s, s1, j, s2, flag, k);
        mMyWorldAddable = false;
        mElementMinibaseId = -1;
        mNbPlayed = 0;
        mMyWorldAddable = flag1;
        mElementMinibaseId = l;
    }
}
