// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            Logger

class NoOpLogger
    implements Logger
{

    NoOpLogger()
    {
    }

    public void d(String s)
    {
    }

    public void d(String s, Throwable throwable)
    {
    }

    public void e(String s)
    {
    }

    public void e(String s, Throwable throwable)
    {
    }

    public Logger.LogLevel getLogLevel()
    {
        return Logger.LogLevel.NONE;
    }

    public void i(String s)
    {
    }

    public void i(String s, Throwable throwable)
    {
    }

    public void setLogLevel(Logger.LogLevel loglevel)
    {
    }

    public void v(String s)
    {
    }

    public void v(String s, Throwable throwable)
    {
    }

    public void w(String s)
    {
    }

    public void w(String s, Throwable throwable)
    {
    }
}
