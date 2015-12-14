// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.log;

import com.amazon.insights.core.log.appender.DeveloperLogCatAppender;
import com.amazon.insights.core.log.appender.LogAppender;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.insights.core.log:
//            LogInitializer

public class Logger
{
    public static final class LogLevel extends Enum
    {

        private static final LogLevel $VALUES[];
        public static final LogLevel DEBUG;
        public static final LogLevel ERROR;
        public static final LogLevel INFO;
        public static final LogLevel OFF;
        public static final LogLevel VERBOSE;
        public static final LogLevel WARN;

        public static LogLevel valueOf(String s)
        {
            return (LogLevel)Enum.valueOf(com/amazon/insights/core/log/Logger$LogLevel, s);
        }

        public static LogLevel[] values()
        {
            return (LogLevel[])$VALUES.clone();
        }

        static 
        {
            VERBOSE = new LogLevel("VERBOSE", 0);
            DEBUG = new LogLevel("DEBUG", 1);
            INFO = new LogLevel("INFO", 2);
            WARN = new LogLevel("WARN", 3);
            ERROR = new LogLevel("ERROR", 4);
            OFF = new LogLevel("OFF", 5);
            $VALUES = (new LogLevel[] {
                VERBOSE, DEBUG, INFO, WARN, ERROR, OFF
            });
        }

        private LogLevel(String s, int j)
        {
            super(s, j);
        }
    }


    static final boolean $assertionsDisabled;
    private static Map appenders = new ConcurrentHashMap();
    private static LogLevel globalLevel;
    private static boolean initialized = false;
    private static Map loggers = new ConcurrentHashMap();
    private LogLevel classLevel;
    private Class cls;
    private String tag;

    public Logger(String s, Class class1)
    {
        classLevel = null;
        cls = null;
        tag = "AmazonInsightsSDK";
        if (!$assertionsDisabled && class1 == null)
        {
            throw new AssertionError();
        } else
        {
            cls = class1;
            tag = s;
            return;
        }
    }

    public static void attachAppender(LogAppender logappender)
    {
        while (logappender == null || appenders.containsKey(logappender.getClass())) 
        {
            return;
        }
        appenders.put(logappender.getClass(), logappender);
    }

    public static Collection getAppenders()
    {
        return appenders.values();
    }

    static Logger getClassLogger(Class class1)
    {
        com/amazon/insights/core/log/Logger;
        JVM INSTR monitorenter ;
        Object obj;
        obj = class1;
        if (class1 == null)
        {
            obj = com/amazon/insights/core/log/Logger;
        }
        if (!loggers.containsKey(obj)) goto _L2; else goto _L1
_L1:
        class1 = (Logger)loggers.get(obj);
_L4:
        com/amazon/insights/core/log/Logger;
        JVM INSTR monitorexit ;
        return class1;
_L2:
        class1 = new Logger("AmazonInsightsSDK", ((Class) (obj)));
        loggers.put(obj, class1);
        if (true) goto _L4; else goto _L3
_L3:
        class1;
        throw class1;
    }

    public static LogLevel getGlobalLevel()
    {
        return globalLevel;
    }

    public static Collection getLogAppenders()
    {
        return getAppenders();
    }

    public static Logger getLogger(Class class1)
    {
        return getClassLogger(class1);
    }

    public static void setGlobalLevel(LogLevel loglevel)
    {
        com/amazon/insights/core/log/Logger;
        JVM INSTR monitorenter ;
        globalLevel = loglevel;
        com/amazon/insights/core/log/Logger;
        JVM INSTR monitorexit ;
        return;
        loglevel;
        throw loglevel;
    }

    public static void tryInitialize()
    {
        com/amazon/insights/core/log/Logger;
        JVM INSTR monitorenter ;
        if (!initialized)
        {
            tryInitialize(new LogInitializer() {

                public void tryInitialize()
                {
                    Logger.setGlobalLevel(LogLevel.WARN);
                    Logger.attachAppender(new DeveloperLogCatAppender());
                }

            });
        }
        com/amazon/insights/core/log/Logger;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void tryInitialize(LogInitializer loginitializer)
    {
        com/amazon/insights/core/log/Logger;
        JVM INSTR monitorenter ;
        if (initialized || loginitializer == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        loginitializer.tryInitialize();
        initialized = true;
        com/amazon/insights/core/log/Logger;
        JVM INSTR monitorexit ;
        return;
        loginitializer;
        throw loginitializer;
    }

    public void d(String s)
    {
        if (isLoggingEnabled(LogLevel.DEBUG))
        {
            LogAppender logappender;
            for (Iterator iterator = getLogAppenders().iterator(); iterator.hasNext(); logappender.d(getTag(), logappender.decorateMessage(cls, s)))
            {
                logappender = (LogAppender)iterator.next();
            }

        }
    }

    public void deve(String s)
    {
        LogAppender logappender;
        for (Iterator iterator = getLogAppenders().iterator(); iterator.hasNext(); logappender.deve(tag, logappender.decorateMessage(cls, s)))
        {
            logappender = (LogAppender)iterator.next();
        }

    }

    public void deve(String s, Throwable throwable)
    {
        LogAppender logappender;
        for (Iterator iterator = getLogAppenders().iterator(); iterator.hasNext(); logappender.deve(tag, logappender.decorateMessage(cls, s), throwable))
        {
            logappender = (LogAppender)iterator.next();
        }

    }

    public void devi(String s)
    {
        LogAppender logappender;
        for (Iterator iterator = getLogAppenders().iterator(); iterator.hasNext(); logappender.devi(getTag(), logappender.decorateMessage(cls, s)))
        {
            logappender = (LogAppender)iterator.next();
        }

    }

    public void devv(String s)
    {
        LogAppender logappender;
        for (Iterator iterator = getLogAppenders().iterator(); iterator.hasNext(); logappender.devv(getTag(), logappender.decorateMessage(cls, s)))
        {
            logappender = (LogAppender)iterator.next();
        }

    }

    public void devw(String s)
    {
        LogAppender logappender;
        for (Iterator iterator = getLogAppenders().iterator(); iterator.hasNext(); logappender.devw(getTag(), logappender.decorateMessage(cls, s)))
        {
            logappender = (LogAppender)iterator.next();
        }

    }

    public void e(String s)
    {
        if (isLoggingEnabled(LogLevel.ERROR))
        {
            LogAppender logappender;
            for (Iterator iterator = getLogAppenders().iterator(); iterator.hasNext(); logappender.e(tag, logappender.decorateMessage(cls, s)))
            {
                logappender = (LogAppender)iterator.next();
            }

        }
    }

    public void e(String s, Throwable throwable)
    {
        if (isLoggingEnabled(LogLevel.ERROR))
        {
            LogAppender logappender;
            for (Iterator iterator = getLogAppenders().iterator(); iterator.hasNext(); logappender.e(tag, logappender.decorateMessage(cls, s), throwable))
            {
                logappender = (LogAppender)iterator.next();
            }

        }
    }

    LogLevel getLogLevel()
    {
        this;
        JVM INSTR monitorenter ;
        LogLevel loglevel = LogLevel.OFF;
        if (classLevel == null) goto _L2; else goto _L1
_L1:
        loglevel = classLevel;
_L4:
        this;
        JVM INSTR monitorexit ;
        return loglevel;
_L2:
        loglevel = getGlobalLevel();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    String getTag()
    {
        return tag;
    }

    public void i(String s)
    {
        if (isLoggingEnabled(LogLevel.INFO))
        {
            LogAppender logappender;
            for (Iterator iterator = getLogAppenders().iterator(); iterator.hasNext(); logappender.i(getTag(), logappender.decorateMessage(cls, s)))
            {
                logappender = (LogAppender)iterator.next();
            }

        }
    }

    public void i(String s, Throwable throwable)
    {
        if (isLoggingEnabled(LogLevel.INFO))
        {
            LogAppender logappender;
            for (Iterator iterator = getLogAppenders().iterator(); iterator.hasNext(); logappender.i(getTag(), logappender.decorateMessage(cls, s), throwable))
            {
                logappender = (LogAppender)iterator.next();
            }

        }
    }

    public boolean isLoggingEnabled(LogLevel loglevel)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = false;
        int j = loglevel.compareTo(getLogLevel());
        if (j >= 0)
        {
            flag = true;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        loglevel;
        throw loglevel;
    }

    public void v(String s)
    {
        if (isLoggingEnabled(LogLevel.VERBOSE))
        {
            LogAppender logappender;
            for (Iterator iterator = getLogAppenders().iterator(); iterator.hasNext(); logappender.v(getTag(), logappender.decorateMessage(cls, s)))
            {
                logappender = (LogAppender)iterator.next();
            }

        }
    }

    public void w(String s)
    {
        if (isLoggingEnabled(LogLevel.WARN))
        {
            LogAppender logappender;
            for (Iterator iterator = getLogAppenders().iterator(); iterator.hasNext(); logappender.w(getTag(), logappender.decorateMessage(cls, s)))
            {
                logappender = (LogAppender)iterator.next();
            }

        }
    }

    public void w(String s, Throwable throwable)
    {
        if (isLoggingEnabled(LogLevel.WARN))
        {
            LogAppender logappender;
            for (Iterator iterator = getLogAppenders().iterator(); iterator.hasNext(); logappender.w(getTag(), logappender.decorateMessage(cls, s), throwable))
            {
                logappender = (LogAppender)iterator.next();
            }

        }
    }

    static 
    {
        boolean flag;
        if (!com/amazon/insights/core/log/Logger.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
        globalLevel = LogLevel.WARN;
    }
}
