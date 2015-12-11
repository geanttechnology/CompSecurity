// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.util.Log;

// Referenced classes of package com.millennialmedia.android:
//            MMSDK

static class 
{

    static void d(String s)
    {
        if (MMSDK.logLevel >= 1)
        {
            android.util.Log.i("MillennialMediaSDK", (new StringBuilder()).append("Diagnostic - ").append(s).toString());
        }
    }

    static transient void d(String s, Object aobj[])
    {
        if (MMSDK.logLevel >= 1)
        {
            android.util.Log.i("MillennialMediaSDK", (new StringBuilder()).append("Diagnostic - ").append(String.format(s, aobj)).toString());
        }
    }

    static void d(Throwable throwable)
    {
        if (MMSDK.logLevel >= 1)
        {
            d(android.util.Log.getStackTraceString(throwable));
        }
    }

    static void e(String s)
    {
        android.util.Log.e("MillennialMediaSDK", s);
    }

    static transient void e(String s, Object aobj[])
    {
        android.util.Log.e("MillennialMediaSDK", String.format(s, aobj));
    }

    static void e(Throwable throwable)
    {
        e(android.util.Log.getStackTraceString(throwable));
    }

    static void i(String s)
    {
        android.util.Log.i("MillennialMediaSDK", s);
    }

    static transient void i(String s, Object aobj[])
    {
        android.util.Log.i("MillennialMediaSDK", String.format(s, aobj));
    }

    static void i(Throwable throwable)
    {
        i(android.util.Log.getStackTraceString(throwable));
    }

    static void p(String s)
    {
        if (MMSDK.logLevel > 3)
        {
            android.util.Log.i("MillennialMediaSDK", (new StringBuilder()).append("Private - ").append(s).toString());
        }
    }

    static transient void p(String s, Object aobj[])
    {
        if (MMSDK.logLevel > 3)
        {
            android.util.Log.i("MillennialMediaSDK", (new StringBuilder()).append("Private - ").append(String.format(s, aobj)).toString());
        }
    }

    static void p(Throwable throwable)
    {
        if (MMSDK.logLevel > 3)
        {
            p(android.util.Log.getStackTraceString(throwable));
        }
    }

    static void v(String s)
    {
        if (MMSDK.logLevel >= 3)
        {
            android.util.Log.i("MillennialMediaSDK", (new StringBuilder()).append("Verbose - ").append(s).toString());
        }
    }

    static transient void v(String s, Object aobj[])
    {
        if (MMSDK.logLevel >= 3)
        {
            android.util.Log.i("MillennialMediaSDK", (new StringBuilder()).append("Verbose - ").append(String.format(s, aobj)).toString());
        }
    }

    static void v(Throwable throwable)
    {
        if (MMSDK.logLevel >= 3)
        {
            v(android.util.Log.getStackTraceString(throwable));
        }
    }

    static void w(String s)
    {
        android.util.Log.w("MillennialMediaSDK", s);
    }

    static transient void w(String s, Object aobj[])
    {
        android.util.Log.w("MillennialMediaSDK", String.format(s, aobj));
    }

    static void w(Throwable throwable)
    {
        w(android.util.Log.getStackTraceString(throwable));
    }

    ()
    {
    }
}
