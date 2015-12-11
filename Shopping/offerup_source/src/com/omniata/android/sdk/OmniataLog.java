// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.omniata.android.sdk;

import android.util.Log;

class OmniataLog
{

    private static int priority = 7;

    OmniataLog()
    {
    }

    public static int d(String s, String s1)
    {
        return log(3, s, s1, null);
    }

    public static int d(String s, String s1, Throwable throwable)
    {
        return log(3, s, s1, throwable);
    }

    public static int e(String s, String s1)
    {
        return log(6, s, s1, null);
    }

    public static int e(String s, String s1, Throwable throwable)
    {
        return log(6, s, s1, throwable);
    }

    public static int i(String s, String s1)
    {
        return log(4, s, s1, null);
    }

    public static int i(String s, String s1, Throwable throwable)
    {
        return log(4, s, s1, throwable);
    }

    private static String join(Object aobj[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        int k = aobj.length;
        for (int j = 0; j < k; j++)
        {
            stringbuilder.append(aobj[j].toString());
        }

        return stringbuilder.toString();
    }

    private static int log(int j, String s, String s1, Throwable throwable)
    {
        if (j >= priority)
        {
            if (throwable == null)
            {
                return Log.println(j, s, s1);
            } else
            {
                return Log.println(j, s, (new StringBuilder()).append(s1).append("\n").append(join(throwable.getStackTrace())).toString());
            }
        } else
        {
            return 0;
        }
    }

    public static void setPriority(int j)
    {
        priority = j;
    }

    public static int v(String s, String s1)
    {
        return log(2, s, s1, null);
    }

    public static int v(String s, String s1, Throwable throwable)
    {
        return log(2, s, s1, throwable);
    }

    public static int w(String s, String s1)
    {
        return log(5, s, s1, null);
    }

    public static int w(String s, String s1, Throwable throwable)
    {
        return log(5, s, s1, throwable);
    }

    public static int wtf(String s, String s1)
    {
        return log(7, s, s1, null);
    }

    public static int wtf(String s, String s1, Throwable throwable)
    {
        return log(7, s, s1, throwable);
    }

}
