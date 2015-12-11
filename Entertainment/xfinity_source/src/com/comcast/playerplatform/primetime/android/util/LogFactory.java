// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.util;

import com.adobe.mediacore.logging.Logger;

// Referenced classes of package com.comcast.playerplatform.primetime.android.util:
//            PlayerLogger

public final class LogFactory
    implements com.adobe.mediacore.logging.LogFactory
{

    private static LogFactory instance;
    private static PlayerLogger logger;

    private LogFactory()
    {
        logger = new PlayerLogger();
    }

    public static LogFactory getInstance()
    {
        com/comcast/playerplatform/primetime/android/util/LogFactory;
        JVM INSTR monitorenter ;
        LogFactory logfactory;
        if (instance == null)
        {
            instance = new LogFactory();
        }
        logfactory = instance;
        com/comcast/playerplatform/primetime/android/util/LogFactory;
        JVM INSTR monitorexit ;
        return logfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile Logger getLogger(String s)
    {
        return getLogger(s);
    }

    public PlayerLogger getLogger()
    {
        return getLogger("");
    }

    public PlayerLogger getLogger(String s)
    {
        if (s.equals("[PSDK]::TimelineMonitor") || s.equals("[PSDK]::VideoEngineContentMarkerCache"))
        {
            s = new PlayerLogger();
            s.setVerbosityLevel(com.adobe.mediacore.logging.Logger.Verbosity.NONE);
            return s;
        } else
        {
            return logger;
        }
    }
}
