// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.tracking.mobile.events.MobileEvent;
import com.groupon.tracking.mobile.events.PageView;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.util:
//            LoggerNotifier

public class LoggerProxy extends Logger
{

    private Logger logger;
    private LoggerNotifier loggerNotifier;

    public LoggerProxy()
    {
    }

    public LoggerProxy(boolean flag)
    {
        throw new RuntimeException("this methods should not be called");
    }

    public void forceLogRotate()
    {
        logger.forceLogRotate();
    }

    public void info(String s)
    {
        logger.info(s);
    }

    public void log(MobileEvent mobileevent)
    {
        logger.log(mobileevent);
        if (mobileevent instanceof PageView)
        {
            loggerNotifier.notify(String.format("%s", new Object[] {
                mobileevent
            }));
        }
    }

    public void log(Exception exception)
    {
        logger.log(exception);
    }
}
