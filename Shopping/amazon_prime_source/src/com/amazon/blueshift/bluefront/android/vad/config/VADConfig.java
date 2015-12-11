// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.vad.config;


public abstract class VADConfig
{

    public static final int DEFAULT_ENDPOINTING_THRESHOLD = 50;
    public static final int DEFAULT_STARTPOINTING_THRESHOLD = 26;
    private final int mEndpointingThreshold;
    private final int mStartpointingThreshold;

    public VADConfig(int i, int j)
    {
        mStartpointingThreshold = i;
        mEndpointingThreshold = j;
    }

    public int getEndpointingThreshold()
    {
        return mEndpointingThreshold;
    }

    public int getStartpointingThreshold()
    {
        return mStartpointingThreshold;
    }
}
