// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android;

import android.util.Log;

public final class d
{

    public static String a = "sin";
    public static boolean b = true;

    public static int a(String s)
    {
        if (b)
        {
            return Log.i(a, s);
        } else
        {
            return 0;
        }
    }

    public static int a(String s, String s1)
    {
        if (b)
        {
            return Log.i(s, s1);
        } else
        {
            return 0;
        }
    }

    public static int a(String s, String s1, Throwable throwable)
    {
        return Log.w(s, s1, throwable);
    }

    public static int a(String s, Throwable throwable)
    {
        return Log.e(a, s, throwable);
    }

    public static transient int a(String s, Object aobj[])
    {
        int i = 0;
        if (!b)
        {
            return 0;
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (; i < 2; i++)
        {
            stringbuilder.append(aobj[i]);
        }

        return Log.i(s, stringbuilder.toString());
    }

    public static transient int a(Object aobj[])
    {
        int i = 0;
        boolean flag = false;
        if (b)
        {
            StringBuilder stringbuilder = new StringBuilder();
            for (i = ((flag) ? 1 : 0); i < 2; i++)
            {
                stringbuilder.append(aobj[i]);
            }

            i = Log.d(a, stringbuilder.toString());
        }
        return i;
    }

    public static int b(String s)
    {
        return Log.e(a, s);
    }

    public static int b(String s, String s1)
    {
        if (b)
        {
            return Log.w(s, s1);
        } else
        {
            return 0;
        }
    }

    public static int b(String s, String s1, Throwable throwable)
    {
        return Log.e(s, s1, throwable);
    }

    public static transient int b(String s, Object aobj[])
    {
        int i = 0;
        boolean flag = false;
        if (b)
        {
            StringBuilder stringbuilder = new StringBuilder();
            int j = aobj.length;
            for (i = ((flag) ? 1 : 0); i < j; i++)
            {
                stringbuilder.append(aobj[i]);
            }

            i = Log.d(s, stringbuilder.toString());
        }
        return i;
    }

    public static transient int b(Object aobj[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < 2; i++)
        {
            stringbuilder.append(aobj[i]);
        }

        return Log.w(a, stringbuilder.toString());
    }

    public static transient int c(Object aobj[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(aobj[i]);
        }

        return Log.e(a, stringbuilder.toString());
    }

}
