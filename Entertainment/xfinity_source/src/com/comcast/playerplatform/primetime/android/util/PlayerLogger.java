// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.util;

import com.adobe.mediacore.logging.Logger;
import java.util.List;
import org.slf4j.LoggerFactory;

public class PlayerLogger
    implements Logger
{

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(com/comcast/playerplatform/primetime/android/util/PlayerLogger);
    private com.adobe.mediacore.logging.Logger.Verbosity maxVerbosityLevel;

    public PlayerLogger()
    {
        maxVerbosityLevel = com.adobe.mediacore.logging.Logger.Verbosity.INFO;
    }

    public void clear()
    {
    }

    public void d(String s, String s1)
    {
        if (maxVerbosityLevel.getLevel() >= com.adobe.mediacore.logging.Logger.Verbosity.DEBUG.getLevel())
        {
            logger.debug((new StringBuilder()).append(s).append(" ").append(s1).toString());
        }
    }

    public void e(String s, String s1)
    {
        if (maxVerbosityLevel.getLevel() >= com.adobe.mediacore.logging.Logger.Verbosity.ERROR.getLevel())
        {
            logger.error((new StringBuilder()).append(s).append(" ").append(s1).toString());
        }
    }

    public void e(String s, String s1, Exception exception)
    {
        if (maxVerbosityLevel.getLevel() >= com.adobe.mediacore.logging.Logger.Verbosity.ERROR.getLevel())
        {
            logger.error((new StringBuilder()).append(s).append(" ").append(s1).toString(), exception);
        }
    }

    public List getEntries()
    {
        return null;
    }

    public void i(String s, String s1)
    {
        if (maxVerbosityLevel.getLevel() >= com.adobe.mediacore.logging.Logger.Verbosity.INFO.getLevel())
        {
            logger.info((new StringBuilder()).append(s).append(" ").append(s1).toString());
        }
    }

    public void setCapacity(int j)
    {
    }

    public void setVerbosityLevel(com.adobe.mediacore.logging.Logger.Verbosity verbosity)
    {
        maxVerbosityLevel = verbosity;
    }

    public void w(String s, String s1)
    {
        if (maxVerbosityLevel.getLevel() >= com.adobe.mediacore.logging.Logger.Verbosity.WARN.getLevel())
        {
            logger.warn((new StringBuilder()).append(s).append(" ").append(s1).toString());
        }
    }

    public void w(String s, String s1, Exception exception)
    {
        if (maxVerbosityLevel.getLevel() >= com.adobe.mediacore.logging.Logger.Verbosity.WARN.getLevel())
        {
            logger.warn((new StringBuilder()).append(s).append(" ").append(s1).toString(), exception);
        }
    }
}
