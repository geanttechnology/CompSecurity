// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.text.TextUtils;
import android.util.Log;

final class cy
{

    private static int fb = 4000;
    private static boolean fc = false;
    private static int fd = 5;

    cy()
    {
    }

    private static void a(int i, String s, String s1)
    {
        if (!fc && fd <= i)
        {
            int j;
            int l;
            if (TextUtils.isEmpty(s1))
            {
                j = 0;
            } else
            {
                j = s1.length();
            }
            l = 0;
            do
            {
                if (l >= j)
                {
                    break;
                }
                int k;
                if (fb > j - l)
                {
                    k = j;
                } else
                {
                    k = fb + l;
                }
                if (Log.println(i, s, s1.substring(l, k)) <= 0)
                {
                    break;
                }
                l = k;
            } while (true);
        }
    }

    static void a(int i, String s, String s1, Throwable throwable)
    {
        (new StringBuilder()).append(s1).append('\n').append(Log.getStackTraceString(throwable)).toString();
    }

    static void a(String s, String s1, Throwable throwable)
    {
        b(3, s, s1, throwable);
    }

    static void aD()
    {
        fc = true;
    }

    static void aE()
    {
        fc = false;
    }

    private static void b(int i, String s, String s1, Throwable throwable)
    {
        a(i, s, (new StringBuilder()).append(s1).append('\n').append(Log.getStackTraceString(throwable)).toString());
    }

    static void b(String s, String s1, Throwable throwable)
    {
        b(6, s, s1, throwable);
    }

    static void c(String s, String s1)
    {
        a(3, s, s1);
    }

    static void d(String s, String s1)
    {
        a(6, s, s1);
    }

    static void e(String s, String s1)
    {
        a(4, s, s1);
    }

    static void f(String s, String s1)
    {
        a(2, s, s1);
    }

    static void g(String s, String s1)
    {
        a(5, s, s1);
    }

    static void setLogLevel(int i)
    {
        fd = i;
    }

}
