// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.logger;


// Referenced classes of package com.supersonic.mediationsdk.logger:
//            SupersonicLogger, LogListener

public class PublisherLogger extends SupersonicLogger
{

    public static final String NAME = "publisher";
    private LogListener mLogListener;

    private PublisherLogger()
    {
        super("publisher");
    }

    public PublisherLogger(LogListener loglistener, int i)
    {
        super("publisher", i);
        mLogListener = loglistener;
    }

    public void log(SupersonicLogger.SupersonicTag supersonictag, String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (mLogListener != null)
        {
            mLogListener.onLog(supersonictag, s, i);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        supersonictag;
        throw supersonictag;
    }

    public void logException(SupersonicLogger.SupersonicTag supersonictag, String s, Throwable throwable)
    {
        log(supersonictag, throwable.getMessage(), 3);
    }

    public void setLogListener(LogListener loglistener)
    {
        mLogListener = loglistener;
    }
}
