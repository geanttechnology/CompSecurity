// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;


public final class NumberUtil
{

    public NumberUtil()
    {
    }

    public static int safeParseInteger(String s, int i)
    {
        s = safeParseInteger(s);
        if (s == null)
        {
            return i;
        } else
        {
            return s.intValue();
        }
    }

    public static Integer safeParseInteger(String s)
    {
        if (s == null)
        {
            return null;
        }
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return Integer.valueOf(i);
    }

    public static long safeParseLong(String s, long l)
    {
        s = safeParseLong(s);
        if (s == null)
        {
            return l;
        } else
        {
            return s.longValue();
        }
    }

    public static Long safeParseLong(String s)
    {
        if (s == null)
        {
            return null;
        }
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return Long.valueOf(l);
    }
}
