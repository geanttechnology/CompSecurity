// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics;

import android.graphics.PointF;

public class CubicCurve
{

    private double mx0;
    private double mx1;
    private double mx2;
    private double mx3;
    private double my0;
    private double my1;
    private double my2;
    private double my3;

    public CubicCurve(double d, double d1, double d2, double d3, double d4, double d5, double d6, 
            double d7)
    {
        update(d, d1, d2, d3, d4, d5, d6, d7);
    }

    public PointF getA()
    {
        return new PointF((float)mx0, (float)my0);
    }

    public PointF getB()
    {
        return new PointF((float)mx3, (float)my3);
    }

    public double getSquareFlatness()
    {
        double d3 = mx0;
        double d4 = my0;
        double d5 = mx3;
        double d = my3;
        double d6 = mx1;
        double d7 = my1;
        double d1 = (d3 - d5) * (d3 - d5) + (d4 - d) * (d4 - d);
        double d2;
        double d8;
        double d9;
        double d10;
        if (d1 == 0.0D)
        {
            d1 = d3;
            d2 = d;
        } else
        {
            d2 = ((d6 - d3) * (d5 - d3) + (d7 - d4) * (d - d4)) / d1;
            if (d2 < 0.0D)
            {
                d1 = d3;
                d2 = d4;
            } else
            if (d2 > 1.0D)
            {
                d1 = d5;
                d2 = d;
            } else
            {
                d1 = d3 + (d5 - d3) * d2;
                d2 = d4 + (d - d4) * d2;
            }
        }
        d8 = mx2;
        d9 = my2;
        d10 = (d3 - d5) * (d3 - d5) + (d4 - d) * (d4 - d);
        if (d10 == 0.0D)
        {
            d4 = d3;
            d3 = d;
            d = d4;
        } else
        {
            d10 = ((d8 - d3) * (d5 - d3) + (d9 - d4) * (d - d4)) / d10;
            if (d10 < 0.0D)
            {
                d = d3;
                d3 = d4;
            } else
            if (d10 > 1.0D)
            {
                d3 = d;
                d = d5;
            } else
            {
                d3 += (d5 - d3) * d10;
                d4 += (d - d4) * d10;
                d = d3;
                d3 = d4;
            }
        }
        return Math.max((d1 - d6) * (d1 - d6) + (d2 - d7) * (d2 - d7), (d - d8) * (d - d8) + (d3 - d9) * (d3 - d9));
    }

    public double[] subdivide()
    {
        double d = (mx0 + mx1) / 2D;
        double d1 = (my0 + my1) / 2D;
        double d2 = (mx3 + mx2) / 2D;
        double d3 = (my3 + my2) / 2D;
        double d6 = (mx1 + mx2) / 2D;
        double d7 = (my1 + my2) / 2D;
        double d4 = (d + d6) / 2D;
        double d5 = (d1 + d7) / 2D;
        d6 = (d6 + d2) / 2D;
        d7 = (d7 + d3) / 2D;
        double d8 = (d4 + d6) / 2D;
        double d9 = (d5 + d7) / 2D;
        return (new double[] {
            mx0, my0, d, d1, d4, d5, d8, d9, d8, d9, 
            d6, d7, d2, d3, mx3, my3
        });
    }

    public void update(double d, double d1, double d2, double d3, double d4, double d5, double d6, 
            double d7)
    {
        mx0 = d;
        my0 = d1;
        mx1 = d2;
        my1 = d3;
        mx2 = d4;
        my2 = d5;
        mx3 = d6;
        my3 = d7;
    }
}
