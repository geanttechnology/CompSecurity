// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


class agr
{

    static double a(double d)
    {
        d = Math.sin(0.5D * d);
        return d * d;
    }

    static double a(double d, double d1, double d2)
    {
        return a(d - d1) + a(d2) * Math.cos(d) * Math.cos(d1);
    }

    static double b(double d)
    {
        return 2D * Math.asin(Math.sqrt(d));
    }
}
