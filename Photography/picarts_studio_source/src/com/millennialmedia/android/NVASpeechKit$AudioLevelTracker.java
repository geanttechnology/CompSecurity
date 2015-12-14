// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


class reset
{

    double a;
    boolean b;
    private double c;
    private int d;

    static double a(double d1)
    {
        return Math.min(9.9900000000000002D, Math.max(Math.floor(d1 - 40D) / 4.0040040040040044D, 0.0D));
    }

    public boolean isTrackingAudioSample()
    {
        return b;
    }

    public void reset()
    {
        a = 0.0D;
        d = 0;
        b = false;
    }

    public void startTrackingAudioSample()
    {
        reset();
        b = true;
    }

    public boolean update(double d1)
    {
        double d2 = a;
        double d3 = c;
        c = d1;
        d = d + 1;
        for (a = (d2 * (double)(d - 1) + d1) / (double)d; b || c == d3;)
        {
            return false;
        }

        return true;
    }

    public ()
    {
        reset();
    }
}
