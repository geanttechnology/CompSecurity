// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


class NumberUtils
{

    private NumberUtils()
    {
    }

    public static final long convertToMillisecondsFromNanoseconds(long l)
    {
        return l / 0xf4240L;
    }

    public static final long convertToMillisecondsFromSeconds(long l)
    {
        return 1000L * l;
    }

    public static int parseInt(String s, int i)
    {
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return i;
        }
        return j;
    }
}
