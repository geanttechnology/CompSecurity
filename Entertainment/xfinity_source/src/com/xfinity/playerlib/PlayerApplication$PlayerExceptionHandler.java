// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib;

import com.comcast.cim.analytics.CrashReportEventData;
import com.comcast.cim.cmasl.analytics.AnalyticsLogger;
import com.comcast.cim.container.PlayerContainer;

// Referenced classes of package com.xfinity.playerlib:
//            PlayerApplication

private class defaultHandler
    implements tionHandler
{

    private xception defaultHandler;
    final PlayerApplication this$0;

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        try
        {
            CrashReportEventData crashreporteventdata = new CrashReportEventData(thread, throwable, getVersionNumber());
            PlayerContainer.getInstance().getSplunkLogger().logData(crashreporteventdata);
        }
        catch (Exception exception) { }
        defaultHandler.uncaughtException(thread, throwable);
    }

    public ()
    {
        this$0 = PlayerApplication.this;
        super();
        defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    }
}
