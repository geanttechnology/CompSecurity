// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.log.appenders;

import android.util.Log;

// Referenced classes of package com.amazon.device.analytics.log.appenders:
//            LogAppender

public class LogCatAppender
    implements LogAppender
{

    public LogCatAppender()
    {
    }

    public void d(String s, String s1)
    {
        Log.d(s, s1);
    }

    public void d(String s, String s1, Throwable throwable)
    {
        Log.d(s, s1, throwable);
    }

    public void e(String s, String s1)
    {
        Log.e(s, s1);
    }

    public void e(String s, String s1, Throwable throwable)
    {
        Log.e(s, s1, throwable);
    }

    public void i(String s, String s1)
    {
        Log.i(s, s1);
    }

    public void v(String s, String s1)
    {
        Log.v(s, s1);
    }

    public void w(String s, String s1)
    {
        Log.w(s, s1);
    }

    public void w(String s, String s1, Throwable throwable)
    {
        Log.w(s, s1, throwable);
    }
}
