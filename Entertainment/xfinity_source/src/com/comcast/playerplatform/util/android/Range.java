// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.util.android;


public class Range
{

    private int max;
    private int min;

    public Range(int i, int j)
    {
        min = i;
        max = j;
    }

    public int getMax()
    {
        return max;
    }

    public int getMin()
    {
        return min;
    }

    public void setMax(int i)
    {
        max = i;
    }

    public void setMin(int i)
    {
        min = i;
    }
}
