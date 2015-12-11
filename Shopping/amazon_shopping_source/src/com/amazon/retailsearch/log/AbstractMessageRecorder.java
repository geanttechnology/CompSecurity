// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.log;


// Referenced classes of package com.amazon.retailsearch.log:
//            MessageRecorder, AppLog

public abstract class AbstractMessageRecorder
    implements MessageRecorder
{

    private final AppLog appLog;

    protected AbstractMessageRecorder(AppLog applog)
    {
        appLog = applog;
    }

    public AppLog getAppLog()
    {
        return appLog;
    }
}
