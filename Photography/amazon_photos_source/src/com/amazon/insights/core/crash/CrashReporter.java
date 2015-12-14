// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.crash;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.insights.core.crash:
//            CrashAppender

public class CrashReporter
{

    private Map appenders;
    private final Class cls;

    public CrashReporter(Class class1)
    {
        appenders = new ConcurrentHashMap();
        cls = class1;
    }

    public void attachAppender(CrashAppender crashappender)
    {
        while (crashappender == null || appenders.containsKey(crashappender.getClass())) 
        {
            return;
        }
        appenders.put(crashappender.getClass(), crashappender);
    }

    public Collection getAppenders()
    {
        return appenders.values();
    }

    public Class getReportingClass()
    {
        return cls;
    }

    public void report(String s, Throwable throwable)
    {
        for (Iterator iterator = getAppenders().iterator(); iterator.hasNext(); ((CrashAppender)iterator.next()).report(this, s, throwable)) { }
    }
}
