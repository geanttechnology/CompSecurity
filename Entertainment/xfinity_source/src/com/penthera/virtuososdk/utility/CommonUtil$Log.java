// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.utility;

import android.util.Log;

// Referenced classes of package com.penthera.virtuososdk.utility:
//            CommonUtil

public static final class 
{

    public static int iLogLevel = 0;

    public static void a(String s, String s1)
    {
        android.util.Log.i(s, s1);
    }

    public static void d(String s, String s1)
    {
        if (iLogLevel > 2)
        {
            android.util.Log.i(s, s1);
        }
    }

    public static void d(String s, String s1, Throwable throwable)
    {
        if (iLogLevel > 2)
        {
            android.util.Log.i(s, s1, throwable);
        }
    }

    public static void e(String s, String s1)
    {
        if (iLogLevel > 0)
        {
            android.util.Log.e(s, s1);
        }
    }

    public static void e(String s, String s1, Throwable throwable)
    {
        if (iLogLevel > 0)
        {
            android.util.Log.e(s, s1, throwable);
        }
    }

    public static void i(String s, String s1)
    {
        if (iLogLevel > 1)
        {
            android.util.Log.i(s, s1);
        }
    }

    public static void w(String s, String s1)
    {
        if (iLogLevel > 0)
        {
            android.util.Log.e(s, s1);
        }
    }

}
