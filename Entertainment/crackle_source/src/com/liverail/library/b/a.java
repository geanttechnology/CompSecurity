// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.b;

import android.util.Log;

public class a
{

    public static boolean a = true;
    public static String b = "LiveRailAdManager";

    private a()
    {
    }

    private static void a(int i, String s, String s1)
    {
        int j = s1.length();
        String s2;
        if (j > 4000)
        {
            s2 = s1.substring(0, 4000);
        } else
        {
            s2 = s1;
        }
        if (j > 4000)
        {
            s1 = s1.substring(4000);
        } else
        {
            s1 = null;
        }
        Log.println(i, s, s2);
        if (s1 != null)
        {
            a(i, s, s1);
        }
    }

    public static void a(String s)
    {
        if (a)
        {
            a(2, b, s);
        }
    }

    public static void b(String s)
    {
        if (a)
        {
            a(3, b, s);
        }
    }

    public static void c(String s)
    {
        if (a)
        {
            a(4, b, s);
        }
    }

    public static void d(String s)
    {
        if (a)
        {
            a(5, b, s);
        }
    }

    public static void e(String s)
    {
        if (a)
        {
            a(6, b, s);
        }
    }

}
