// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;


public final class StringConversionHelpers
{

    private StringConversionHelpers()
    {
    }

    public static boolean toBoolean(String s)
    {
        return "true".equalsIgnoreCase(s) || "yes".equalsIgnoreCase(s) || "1".equalsIgnoreCase(s);
    }

    public static int toInt(String s, int i)
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

    public static Integer toInteger(String s)
    {
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

    public static Long toLong(String s)
    {
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
