// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.util.Log;

// Referenced classes of package com.amazon.device.ads:
//            Logger

class LogcatLogger
    implements Logger
{

    private String logTag;

    LogcatLogger()
    {
    }

    public void d(String s)
    {
        Log.d(logTag, s);
    }

    public void e(String s)
    {
        Log.e(logTag, s);
    }

    public void i(String s)
    {
        Log.i(logTag, s);
    }

    public void v(String s)
    {
        Log.v(logTag, s);
    }

    public void w(String s)
    {
        Log.w(logTag, s);
    }

    public LogcatLogger withLogTag(String s)
    {
        logTag = s;
        return this;
    }

    public volatile Logger withLogTag(String s)
    {
        return withLogTag(s);
    }
}
