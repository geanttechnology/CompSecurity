// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.log.appender;

import android.util.Log;

// Referenced classes of package com.amazon.insights.core.log.appender:
//            LogAppender

public class DeveloperLogCatAppender extends LogAppender
{

    public DeveloperLogCatAppender()
    {
    }

    public void deve(String s, String s1)
    {
        Log.e(s, s1);
    }

    public void deve(String s, String s1, Throwable throwable)
    {
        Log.e(s, s1, throwable);
    }

    public void devi(String s, String s1)
    {
        Log.i(s, s1);
    }

    public void devv(String s, String s1)
    {
        Log.v(s, s1);
    }

    public void devw(String s, String s1)
    {
        Log.w(s, s1);
    }
}
