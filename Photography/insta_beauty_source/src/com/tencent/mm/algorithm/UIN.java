// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.algorithm;


public class UIN extends Number
{

    private int h;

    public UIN(int i)
    {
        h = 0;
        h = i;
    }

    public UIN(long l)
    {
        h = 0;
        h = (int)(-1L & l);
    }

    public static int valueOf(String s)
    {
        int i;
        try
        {
            i = (new UIN(Long.valueOf(s).longValue())).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0;
        }
        return i;
    }

    public double doubleValue()
    {
        return (double)((long)h | 0L) + 0.0D;
    }

    public float floatValue()
    {
        return (float)((double)((long)h | 0L) + 0.0D);
    }

    public int intValue()
    {
        return h;
    }

    public long longValue()
    {
        return (long)h & 0xffffffffL;
    }

    public String toString()
    {
        return String.valueOf((long)h & 0xffffffffL);
    }

    public int value()
    {
        return h;
    }
}
