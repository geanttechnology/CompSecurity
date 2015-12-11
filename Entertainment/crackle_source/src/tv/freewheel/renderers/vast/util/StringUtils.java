// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.util;


public class StringUtils
{

    public StringUtils()
    {
    }

    public static boolean isBlank(String s)
    {
        return s == null || s.length() == 0;
    }

    public static Boolean parseBoolean(String s)
    {
        return parseBoolean(s, null);
    }

    public static Boolean parseBoolean(String s, Boolean boolean1)
    {
        try
        {
            s = Boolean.valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return boolean1;
        }
        return s;
    }

    public static Double parseDouble(String s)
    {
        return parseDouble(s, null);
    }

    public static Double parseDouble(String s, Double double1)
    {
        try
        {
            s = Double.valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return double1;
        }
        return s;
    }

    public static int parseInt(String s)
    {
        return parseInt(s, 0);
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

    public static Integer parseInteger(String s)
    {
        return parseInteger(s, null);
    }

    public static Integer parseInteger(String s, Integer integer)
    {
        try
        {
            s = Integer.valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return integer;
        }
        return s;
    }
}
