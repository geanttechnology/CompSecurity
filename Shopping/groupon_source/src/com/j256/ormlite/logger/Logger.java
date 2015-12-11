// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.logger;

import java.util.Arrays;

// Referenced classes of package com.j256.ormlite.logger:
//            Log

public class Logger
{

    private static final int ARG_STRING_LENGTH = "{}".length();
    private static final Object UNKNOWN_ARG = new Object();
    private final Log log;

    public Logger(Log log1)
    {
        log = log1;
    }

    private void appendArg(StringBuilder stringbuilder, Object obj)
    {
        if (obj == UNKNOWN_ARG)
        {
            return;
        }
        if (obj == null)
        {
            stringbuilder.append("null");
            return;
        }
        if (obj.getClass().isArray())
        {
            stringbuilder.append(Arrays.toString((Object[])(Object[])obj));
            return;
        } else
        {
            stringbuilder.append(obj);
            return;
        }
    }

    private String buildFullMessage(String s, Object obj, Object obj1, Object obj2, Object aobj[])
    {
        StringBuilder stringbuilder = null;
        int j = 0;
        int i = 0;
        do
        {
            int k = s.indexOf("{}", j);
            StringBuilder stringbuilder1;
            if (k == -1)
            {
                if (stringbuilder == null)
                {
                    return s;
                } else
                {
                    stringbuilder.append(s.substring(j));
                    return stringbuilder.toString();
                }
            }
            stringbuilder1 = stringbuilder;
            if (stringbuilder == null)
            {
                stringbuilder1 = new StringBuilder(128);
            }
            stringbuilder1.append(s.substring(j, k));
            j = k + ARG_STRING_LENGTH;
            if (aobj == null)
            {
                if (i == 0)
                {
                    appendArg(stringbuilder1, obj);
                } else
                if (i == 1)
                {
                    appendArg(stringbuilder1, obj1);
                } else
                if (i == 2)
                {
                    appendArg(stringbuilder1, obj2);
                }
            } else
            if (i < aobj.length)
            {
                appendArg(stringbuilder1, aobj[i]);
            }
            i++;
            stringbuilder = stringbuilder1;
        } while (true);
    }

    private void innerLog(Log.Level level, Throwable throwable, String s, Object obj, Object obj1, Object obj2, Object aobj[])
    {
label0:
        {
            if (log.isLevelEnabled(level))
            {
                s = buildFullMessage(s, obj, obj1, obj2, aobj);
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

    public void debug(String s)
    {
        innerLog(Log.Level.DEBUG, null, s, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void debug(String s, Object obj)
    {
        innerLog(Log.Level.DEBUG, null, s, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void debug(String s, Object obj, Object obj1)
    {
        innerLog(Log.Level.DEBUG, null, s, obj, obj1, UNKNOWN_ARG, null);
    }

    public void debug(String s, Object obj, Object obj1, Object obj2)
    {
        innerLog(Log.Level.DEBUG, null, s, obj, obj1, obj2, null);
    }

    public void debug(String s, Object aobj[])
    {
        innerLog(Log.Level.DEBUG, null, s, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, aobj);
    }

    public void error(String s)
    {
        innerLog(Log.Level.ERROR, null, s, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void error(String s, Object obj, Object obj1)
    {
        innerLog(Log.Level.ERROR, null, s, obj, obj1, UNKNOWN_ARG, null);
    }

    public void error(String s, Object obj, Object obj1, Object obj2)
    {
        innerLog(Log.Level.ERROR, null, s, obj, obj1, obj2, null);
    }

    public void error(Throwable throwable, String s)
    {
        innerLog(Log.Level.ERROR, throwable, s, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void info(String s, Object obj)
    {
        innerLog(Log.Level.INFO, null, s, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void info(String s, Object obj, Object obj1)
    {
        innerLog(Log.Level.INFO, null, s, obj, obj1, UNKNOWN_ARG, null);
    }

    public void info(String s, Object obj, Object obj1, Object obj2)
    {
        innerLog(Log.Level.INFO, null, s, obj, obj1, obj2, null);
    }

    public boolean isLevelEnabled(Log.Level level)
    {
        return log.isLevelEnabled(level);
    }

    public void trace(String s, Object obj)
    {
        innerLog(Log.Level.TRACE, null, s, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void trace(String s, Object obj, Object obj1)
    {
        innerLog(Log.Level.TRACE, null, s, obj, obj1, UNKNOWN_ARG, null);
    }

    public void trace(String s, Object obj, Object obj1, Object obj2)
    {
        innerLog(Log.Level.TRACE, null, s, obj, obj1, obj2, null);
    }

    public void warn(Throwable throwable, String s)
    {
        innerLog(Log.Level.WARNING, throwable, s, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void warn(Throwable throwable, String s, Object aobj[])
    {
        innerLog(Log.Level.WARNING, throwable, s, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, aobj);
    }

}
