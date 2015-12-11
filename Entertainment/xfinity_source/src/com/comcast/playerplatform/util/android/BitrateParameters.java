// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.util.android;


public class BitrateParameters
{

    private int initial;
    private int max;
    private int min;

    public BitrateParameters(int i, int j, int k)
    {
        initial = i;
        min = j;
        max = k;
    }

    public int getInitialBitrate()
    {
        return initial;
    }

    public int getMaximumBitrate()
    {
        return max;
    }

    public int getMinimumBitrate()
    {
        return min;
    }

    public void setInitialBitrate(int i)
    {
        initial = i;
    }

    public void setMaximumBitrate(int i)
    {
        max = i;
    }

    public void setMinimumBitrate(int i)
    {
        min = i;
    }
}
