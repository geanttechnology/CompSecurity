// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.imagezoom.easing;


public class Cubic
{

    public Cubic()
    {
    }

    public double easeInOut(double d, double d1, double d2, double d3)
    {
        d /= d3 / 2D;
        if (d < 1.0D)
        {
            return (d2 / 2D) * d * d * d + d1;
        } else
        {
            d2 /= 2D;
            d -= 2D;
            return d2 * (d * d * d + 2D) + d1;
        }
    }

    public double easeOut(double d, double d1, double d2, double d3)
    {
        d = d / d3 - 1.0D;
        return (d * d * d + 1.0D) * d2 + d1;
    }
}
