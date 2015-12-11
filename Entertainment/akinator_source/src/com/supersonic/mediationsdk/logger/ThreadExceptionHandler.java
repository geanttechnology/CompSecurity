// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.logger;


// Referenced classes of package com.supersonic.mediationsdk.logger:
//            SupersonicLoggerManager

public class ThreadExceptionHandler
    implements Thread.UncaughtExceptionHandler
{

    public ThreadExceptionHandler()
    {
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        SupersonicLoggerManager.getLogger().logException(SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append("Thread name =").append(thread.getName()).toString(), throwable);
    }
}
