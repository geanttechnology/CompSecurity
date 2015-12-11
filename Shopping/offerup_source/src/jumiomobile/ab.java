// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.util.Log;

public class ab
{

    private static boolean a = false;

    public static void a(String s)
    {
        b("JumioMobileSDK", s);
    }

    public static void a(String s, String s1)
    {
        if (a)
        {
            Log.i(s, s1);
        }
    }

    public static void a(String s, String s1, Throwable throwable)
    {
        if (a)
        {
            Log.e(s, s1, throwable);
        }
    }

    public static void a(String s, Throwable throwable)
    {
        a("JumioMobileSDK", s, throwable);
    }

    public static void a(String s, boolean flag)
    {
        if (a || flag)
        {
            Log.d("JumioMobileSDK", s);
        }
    }

    public static void a(Throwable throwable)
    {
        if (a)
        {
            throwable.printStackTrace();
        }
    }

    public static void b(String s)
    {
        c("JumioMobileSDK", s);
    }

    public static void b(String s, String s1)
    {
        if (a)
        {
            Log.e(s, s1);
        }
    }

    public static void b(String s, String s1, Throwable throwable)
    {
        if (a)
        {
            Log.w(s, s1, throwable);
        }
    }

    public static void b(String s, Throwable throwable)
    {
        b("JumioMobileSDK", s, throwable);
    }

    public static void c(String s)
    {
        d("JumioMobileSDK", s);
    }

    public static void c(String s, String s1)
    {
        if (a)
        {
            Log.d(s, s1);
        }
    }

    public static void d(String s)
    {
        e("JumioMobileSDK", s);
    }

    public static void d(String s, String s1)
    {
        if (a)
        {
            Log.v(s, s1);
        }
    }

    public static void e(String s, String s1)
    {
        if (a)
        {
            Log.w(s, s1);
        }
    }

}
