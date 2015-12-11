// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;


public class DMSProfile
{

    private double interval;
    private double offset;

    public DMSProfile()
    {
    }

    public double getInterval()
    {
        return interval;
    }

    public double getOffset()
    {
        return offset;
    }

    public void setInterval(double d)
    {
        interval = d;
    }

    public void setOffset(double d)
    {
        offset = d;
    }
}
