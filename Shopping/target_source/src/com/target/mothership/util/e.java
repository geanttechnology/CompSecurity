// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;


public class e
{

    public static final double METERS_PER_MILE = 1609.3440000000001D;

    public static double a(double d, double d1, double d2, double d3)
    {
        double d4 = Math.toRadians(d2 - d);
        d1 = Math.toRadians(d3 - d1);
        d3 = Math.sin(d4 / 2D);
        d1 = Math.sin(d1 / 2D);
        d = Math.pow(d3, 2D) + Math.pow(d1, 2D) * Math.cos(Math.toRadians(d)) * Math.cos(Math.toRadians(d2));
        return 3958.75D * (Math.atan2(Math.sqrt(d), Math.sqrt(1.0D - d)) * 2D);
    }
}
