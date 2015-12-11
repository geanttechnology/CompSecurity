// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;


public final class MoPubReward
{

    public static final int NO_REWARD_AMOUNT = -123;
    public static final String NO_REWARD_LABEL = "";
    private final int mAmount;
    private final String mLabel;
    private final boolean mSuccess;

    private MoPubReward(boolean flag, String s, int i)
    {
        mSuccess = flag;
        mLabel = s;
        mAmount = i;
    }

    public static MoPubReward failure()
    {
        return new MoPubReward(false, "", 0);
    }

    public static MoPubReward success(String s, int i)
    {
        return new MoPubReward(true, s, i);
    }

    public final int getAmount()
    {
        return mAmount;
    }

    public final String getLabel()
    {
        return mLabel;
    }

    public final boolean isSuccessful()
    {
        return mSuccess;
    }
}
