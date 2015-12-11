// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.log;


// Referenced classes of package com.amazon.retailsearch.log:
//            MessageLogger, AppLog

public class BoundMessageLogger
    implements MessageLogger
{

    private final AppLog appLog;
    private final String tag;

    public BoundMessageLogger(AppLog applog, String s)
    {
        appLog = applog;
        tag = s;
    }

    public void debug(String s)
    {
        log(3, s);
    }

    public void debug(String s, Throwable throwable)
    {
        log(3, s, throwable);
    }

    public boolean enabled()
    {
        return appLog.enabled();
    }

    public boolean enabled(int i)
    {
        return appLog.enabled(i);
    }

    public void error(String s)
    {
        log(6, s);
    }

    public void error(String s, Throwable throwable)
    {
        log(6, s, throwable);
    }

    public AppLog getAppLog()
    {
        return appLog;
    }

    public String getTag()
    {
        return tag;
    }

    public void info(String s)
    {
        log(4, s);
    }

    public void info(String s, Throwable throwable)
    {
        log(4, s, throwable);
    }

    public void log(int i, String s)
    {
        log(i, s, null);
    }

    public void log(int i, String s, Throwable throwable)
    {
        appLog.log(this, i, s, throwable);
    }

    public void verbose(String s)
    {
        log(2, s);
    }

    public void verbose(String s, Throwable throwable)
    {
        log(2, s, throwable);
    }

    public void warn(String s)
    {
        log(5, s);
    }

    public void warn(String s, Throwable throwable)
    {
        log(5, s, throwable);
    }
}
