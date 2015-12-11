// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.util.Log;

public class dh
{

    private static boolean a = false;
    private static String b = "NetswipeScanSDK";

    public static void a(String s)
    {
        Log.e(b, s);
    }

    public static void a(String s, Throwable throwable)
    {
        Log.e(b, s, throwable);
    }

    public static void a(String s, boolean flag)
    {
        if (a || flag)
        {
            Log.d(b, s);
        }
    }

    public static void a(boolean flag)
    {
        a = flag;
    }

    public static void b(String s)
    {
        a(s, false);
    }

    public static void c(String s)
    {
        Log.w(b, s);
    }

}
