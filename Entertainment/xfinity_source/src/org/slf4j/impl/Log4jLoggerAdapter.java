// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j.impl;

import java.io.Serializable;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

public final class Log4jLoggerAdapter extends MarkerIgnoringBase
    implements Serializable, LocationAwareLogger
{

    static final String FQCN;
    static Class class$org$slf4j$impl$Log4jLoggerAdapter;
    final transient Logger logger;
    final boolean traceCapable = isTraceCapable();

    Log4jLoggerAdapter(Logger logger1)
    {
        logger = logger1;
        name = logger1.getName();
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    private boolean isTraceCapable()
    {
        try
        {
            logger.isTraceEnabled();
        }
        catch (NoSuchMethodError nosuchmethoderror)
        {
            return false;
        }
        return true;
    }

    public void debug(String s)
    {
        logger.log(FQCN, Level.DEBUG, s, null);
    }

    public void debug(String s, Object obj)
    {
        if (logger.isDebugEnabled())
        {
            s = MessageFormatter.format(s, obj);
            logger.log(FQCN, Level.DEBUG, s.getMessage(), s.getThrowable());
        }
    }

    public void debug(String s, Object obj, Object obj1)
    {
        if (logger.isDebugEnabled())
        {
            s = MessageFormatter.format(s, obj, obj1);
            logger.log(FQCN, Level.DEBUG, s.getMessage(), s.getThrowable());
        }
    }

    public void debug(String s, Throwable throwable)
    {
        logger.log(FQCN, Level.DEBUG, s, throwable);
    }

    public void debug(String s, Object aobj[])
    {
        if (logger.isDebugEnabled())
        {
            s = MessageFormatter.arrayFormat(s, aobj);
            logger.log(FQCN, Level.DEBUG, s.getMessage(), s.getThrowable());
        }
    }

    public void error(String s)
    {
        logger.log(FQCN, Level.ERROR, s, null);
    }

    public void error(String s, Object obj)
    {
        if (logger.isEnabledFor(Level.ERROR))
        {
            s = MessageFormatter.format(s, obj);
            logger.log(FQCN, Level.ERROR, s.getMessage(), s.getThrowable());
        }
    }

    public void error(String s, Object obj, Object obj1)
    {
        if (logger.isEnabledFor(Level.ERROR))
        {
            s = MessageFormatter.format(s, obj, obj1);
            logger.log(FQCN, Level.ERROR, s.getMessage(), s.getThrowable());
        }
    }

    public void error(String s, Throwable throwable)
    {
        logger.log(FQCN, Level.ERROR, s, throwable);
    }

    public void error(String s, Object aobj[])
    {
        if (logger.isEnabledFor(Level.ERROR))
        {
            s = MessageFormatter.arrayFormat(s, aobj);
            logger.log(FQCN, Level.ERROR, s.getMessage(), s.getThrowable());
        }
    }

    public void info(String s)
    {
        logger.log(FQCN, Level.INFO, s, null);
    }

    public void info(String s, Object obj)
    {
        if (logger.isInfoEnabled())
        {
            s = MessageFormatter.format(s, obj);
            logger.log(FQCN, Level.INFO, s.getMessage(), s.getThrowable());
        }
    }

    public void info(String s, Object obj, Object obj1)
    {
        if (logger.isInfoEnabled())
        {
            s = MessageFormatter.format(s, obj, obj1);
            logger.log(FQCN, Level.INFO, s.getMessage(), s.getThrowable());
        }
    }

    public void warn(String s)
    {
        logger.log(FQCN, Level.WARN, s, null);
    }

    public void warn(String s, Object obj)
    {
        if (logger.isEnabledFor(Level.WARN))
        {
            s = MessageFormatter.format(s, obj);
            logger.log(FQCN, Level.WARN, s.getMessage(), s.getThrowable());
        }
    }

    public void warn(String s, Object obj, Object obj1)
    {
        if (logger.isEnabledFor(Level.WARN))
        {
            s = MessageFormatter.format(s, obj, obj1);
            logger.log(FQCN, Level.WARN, s.getMessage(), s.getThrowable());
        }
    }

    public void warn(String s, Throwable throwable)
    {
        logger.log(FQCN, Level.WARN, s, throwable);
    }

    static 
    {
        Class class1;
        if (class$org$slf4j$impl$Log4jLoggerAdapter == null)
        {
            class1 = _mthclass$("org.slf4j.impl.Log4jLoggerAdapter");
            class$org$slf4j$impl$Log4jLoggerAdapter = class1;
        } else
        {
            class1 = class$org$slf4j$impl$Log4jLoggerAdapter;
        }
        FQCN = class1.getName();
    }
}
