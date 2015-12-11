// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.logger;

import java.util.Arrays;

// Referenced classes of package com.j256.ormlite.logger:
//            Log

public class Logger
{

    private static final String ARG_STRING = "{}";
    private static final int ARG_STRING_LENGTH = "{}".length();
    private final Log log;

    public Logger(Log log1)
    {
        log = log1;
    }

    private String buildFullMessage(String s, Object aobj[])
    {
        int j = 0;
        StringBuilder stringbuilder = new StringBuilder(128);
        int i = 0;
        do
        {
            int k = s.indexOf("{}", j);
            if (k == -1)
            {
                stringbuilder.append(s.substring(j));
                return stringbuilder.toString();
            }
            stringbuilder.append(s.substring(j, k));
            j = ARG_STRING_LENGTH;
            if (i < aobj.length)
            {
                Object obj = aobj[i];
                if (obj != null && obj.getClass().isArray())
                {
                    stringbuilder.append(Arrays.toString((Object[])(Object[])obj));
                } else
                {
                    stringbuilder.append(obj);
                }
                i++;
            }
            j = k + j;
        } while (true);
    }

    private void log(Log.Level level, Throwable throwable, String s, Object aobj[])
    {
label0:
        {
            if (log.isLevelEnabled(level))
            {
                s = buildFullMessage(s, aobj);
                if (throwable != null)
                {
                    break label0;
                }
                log.log(level, s);
            }
            return;
        }
        log.log(level, s, throwable);
    }

    public transient void debug(String s, Object aobj[])
    {
        log(Log.Level.DEBUG, null, s, aobj);
    }

    public transient void debug(Throwable throwable, String s, Object aobj[])
    {
        log(Log.Level.DEBUG, throwable, s, aobj);
    }

    public transient void error(String s, Object aobj[])
    {
        log(Log.Level.ERROR, null, s, aobj);
    }

    public transient void error(Throwable throwable, String s, Object aobj[])
    {
        log(Log.Level.ERROR, throwable, s, aobj);
    }

    public transient void fatal(String s, Object aobj[])
    {
        log(Log.Level.FATAL, null, s, aobj);
    }

    public transient void fatal(Throwable throwable, String s, Object aobj[])
    {
        log(Log.Level.FATAL, throwable, s, aobj);
    }

    public transient void info(String s, Object aobj[])
    {
        log(Log.Level.INFO, null, s, aobj);
    }

    public transient void info(Throwable throwable, String s, Object aobj[])
    {
        log(Log.Level.INFO, throwable, s, aobj);
    }

    public boolean isLevelEnabled(Log.Level level)
    {
        return log.isLevelEnabled(level);
    }

    public transient void trace(String s, Object aobj[])
    {
        log(Log.Level.TRACE, null, s, aobj);
    }

    public transient void trace(Throwable throwable, String s, Object aobj[])
    {
        log(Log.Level.TRACE, throwable, s, aobj);
    }

    public transient void warn(String s, Object aobj[])
    {
        log(Log.Level.WARNING, null, s, aobj);
    }

    public transient void warn(Throwable throwable, String s, Object aobj[])
    {
        log(Log.Level.WARNING, throwable, s, aobj);
    }

}
