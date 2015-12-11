// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.log;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.amazon.retailsearch.log:
//            BoundMessageLogger, MessageRecorder, MessageLogger

public class AppLog
{

    public static final int OFF = -1;
    private static AppLog appLog;
    private volatile boolean enabled;
    private volatile int level;
    private List recorders;

    public AppLog()
    {
        this(false, -1);
    }

    public AppLog(boolean flag, int i)
    {
        recorders = new CopyOnWriteArrayList();
        enabled = flag;
        level = i;
    }

    public static AppLog getAppLog()
    {
        com/amazon/retailsearch/log/AppLog;
        JVM INSTR monitorenter ;
        AppLog applog;
        if (appLog == null)
        {
            appLog = new AppLog();
        }
        applog = appLog;
        com/amazon/retailsearch/log/AppLog;
        JVM INSTR monitorexit ;
        return applog;
        Exception exception;
        exception;
        throw exception;
    }

    public static MessageLogger getLog(Class class1)
    {
        return getAppLog().getLogFor(class1);
    }

    public static boolean isEnabled()
    {
        return getAppLog().enabled();
    }

    public static boolean isEnabled(int i)
    {
        return getAppLog().enabled(i);
    }

    public static void setAppLog(AppLog applog)
    {
        com/amazon/retailsearch/log/AppLog;
        JVM INSTR monitorenter ;
        appLog = applog;
        com/amazon/retailsearch/log/AppLog;
        JVM INSTR monitorexit ;
        return;
        applog;
        throw applog;
    }

    public boolean enabled()
    {
        return enabled && level > -1;
    }

    public boolean enabled(int i)
    {
        return enabled() && i >= level;
    }

    public int getLevel()
    {
        return level;
    }

    public MessageLogger getLogFor(Class class1)
    {
        return new BoundMessageLogger(this, class1.toString());
    }

    public List getRecorders()
    {
        return recorders;
    }

    public void log(MessageLogger messagelogger, int i, String s, Throwable throwable)
    {
        for (Iterator iterator = recorders.iterator(); iterator.hasNext(); ((MessageRecorder)iterator.next()).log(messagelogger, i, s, throwable)) { }
    }

    public void setEnabled(boolean flag)
    {
        enabled = flag;
    }

    public void setLevel(int i)
    {
        level = i;
    }
}
