// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a.a;

import android.util.Log;
import com.crashlytics.android.Crashlytics;

public final class g
{

    private static boolean a = false;
    private static String b = "LogHelper";

    public static void a(Object obj, String s)
    {
    }

    public static void a(Object obj, Throwable throwable)
    {
        if (obj == null)
        {
            d("null", Log.getStackTraceString(throwable));
            return;
        } else
        {
            d(obj.getClass().getSimpleName(), Log.getStackTraceString(throwable));
            return;
        }
    }

    public static void a(String s, Exception exception)
    {
        Log.e(s, Log.getStackTraceString(exception));
        try
        {
            Crashlytics.logException(exception);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(b, Log.getStackTraceString(s));
        }
    }

    public static void a(String s, String s1)
    {
    }

    public static void a(String s, String s1, Exception exception)
    {
        Log.e(s, Log.getStackTraceString(exception));
        try
        {
            Crashlytics.logException(exception);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(b, Log.getStackTraceString(s));
        }
    }

    public static void b(Object obj, String s)
    {
        if (obj == null)
        {
            return;
        } else
        {
            obj.getClass().getSimpleName();
            return;
        }
    }

    public static void b(String s, String s1)
    {
    }

    public static void c(String s, String s1)
    {
        d(s, s1);
    }

    public static void d(String s, String s1)
    {
        Log.e(s, s1);
        Crashlytics.logException(new Exception(s1));
    }

}
