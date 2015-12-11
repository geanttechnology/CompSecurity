// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.log;

import com.amazon.device.analytics.configuration.Configuration;
import com.amazon.device.analytics.configuration.ConfigurationChangedListener;
import com.amazon.device.analytics.configuration.InMemoryConfiguration;
import com.amazon.device.analytics.log.appenders.LogAppender;
import com.amazon.device.analytics.log.appenders.LogCatAppender;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Referenced classes of package com.amazon.device.analytics.log:
//            Logger, LoggerBuilder

public class Logging
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
        public static final LogLevel WTF;

        public static LogLevel valueOf(String s)
        {
            return (LogLevel)Enum.valueOf(com/amazon/device/analytics/log/Logging$LogLevel, s);
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
            WTF = new LogLevel("WTF", 5);
            OFF = new LogLevel("OFF", 6);
            $VALUES = (new LogLevel[] {
                VERBOSE, DEBUG, INFO, WARN, ERROR, WTF, OFF
            });
        }

        private LogLevel(String s, int i)
        {
            super(s, i);
        }
    }


    private static LogLevel defaultLogLevel;
    private static Logging instance = null;
    private Map appenders;
    private ReentrantReadWriteLock configLock;
    private java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock configReadLock;
    private java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock configWriteLock;
    private Configuration configuration;
    private final ConfigurationChangedListener globalLogLevelListener = new ConfigurationChangedListener() {

        final Logging this$0;

        public void onPropertyChanged(String s, Object obj)
        {
            for (s = loggers.values().iterator(); s.hasNext();)
            {
                Logger logger = (Logger)s.next();
                try
                {
                    Logging.defaultLogLevel = LogLevel.valueOf(obj.toString());
                    logger.setGlobalLogLevel(Logging.defaultLogLevel);
                }
                catch (Exception exception) { }
            }

        }

            
            {
                this$0 = Logging.this;
                super();
            }
    };
    private Map loggers;

    private Logging()
    {
        appenders = new ConcurrentHashMap();
        loggers = new ConcurrentHashMap();
        configuration = new InMemoryConfiguration();
        configLock = new ReentrantReadWriteLock(true);
        configReadLock = configLock.readLock();
        configWriteLock = configLock.writeLock();
        appenders.put(com/amazon/device/analytics/log/appenders/LogCatAppender, new LogCatAppender());
    }

    private void attachAppender(LogAppender logappender)
    {
        while (logappender == null || appenders.containsKey(logappender.getClass())) 
        {
            return;
        }
        appenders.put(logappender.getClass(), logappender);
    }

    public static void attachLogAppender(LogAppender logappender)
    {
        getInstance().attachAppender(logappender);
    }

    private void detachAppender(LogAppender logappender)
    {
        while (logappender == null || !appenders.containsKey(logappender.getClass())) 
        {
            return;
        }
        appenders.remove(logappender.getClass());
    }

    public static void detachLogAppender(LogAppender logappender)
    {
        getInstance().detachAppender(logappender);
    }

    private Collection getAppenders()
    {
        return appenders.values();
    }

    private Logger getClassLogger(Class class1)
    {
        Object obj;
        obj = class1;
        if (class1 == null)
        {
            obj = com/amazon/device/analytics/log/Logging;
        }
        if (loggers.containsKey(obj))
        {
            return (Logger)loggers.get(obj);
        }
        configReadLock.lock();
        Object obj1;
        class1 = (new LoggerBuilder("TailwindAnalyticsSDK", ((Class) (obj)))).setGlobalLogLevel(defaultLogLevel).build();
        obj1 = configuration;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        obj1 = configuration.optString(Logger.getLogLevelConfigurationKey(((Class) (obj))), null);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        try
        {
            class1.setLogLevel(LogLevel.valueOf(((String) (obj1))));
        }
        catch (Exception exception) { }
        configuration.registerChangedListener(Logger.getLogLevelConfigurationKey(class1.getLogClass()), class1);
        loggers.put(obj, class1);
        configReadLock.unlock();
        return class1;
        class1;
        configReadLock.unlock();
        throw class1;
    }

    private static Logging getInstance()
    {
        com/amazon/device/analytics/log/Logging;
        JVM INSTR monitorenter ;
        Logging logging;
        if (instance == null)
        {
            instance = new Logging();
        }
        logging = instance;
        com/amazon/device/analytics/log/Logging;
        JVM INSTR monitorexit ;
        return logging;
        Exception exception;
        exception;
        throw exception;
    }

    public static Collection getLogAppenders()
    {
        return getInstance().getAppenders();
    }

    public static Logger getLogger(Class class1)
    {
        return getInstance().getClassLogger(class1);
    }

    private void setConfig(Configuration configuration1)
    {
        if (configuration1 == null || configuration1.equals(configuration))
        {
            break MISSING_BLOCK_LABEL_249;
        }
        configWriteLock.lock();
        if (configuration != null)
        {
            configuration.unregisterChangedListener("logLevel", globalLogLevelListener);
            Logger logger1;
            for (Iterator iterator = loggers.values().iterator(); iterator.hasNext(); configuration.unregisterChangedListener(Logger.getLogLevelConfigurationKey(logger1.getLogClass()), logger1))
            {
                logger1 = (Logger)iterator.next();
            }

        }
        break MISSING_BLOCK_LABEL_108;
        configuration1;
        configWriteLock.unlock();
        throw configuration1;
        configuration = configuration1;
        Logger logger;
        String s;
        try
        {
            defaultLogLevel = LogLevel.valueOf(configuration.optString("logLevel", defaultLogLevel.name()));
        }
        // Misplaced declaration of an exception variable
        catch (Configuration configuration1) { }
        configuration.registerChangedListener("logLevel", globalLogLevelListener);
        configuration1 = loggers.values().iterator();
_L1:
        if (!configuration1.hasNext())
        {
            break MISSING_BLOCK_LABEL_242;
        }
        logger = (Logger)configuration1.next();
        logger.setGlobalLogLevel(defaultLogLevel);
        s = configuration.optString(Logger.getLogLevelConfigurationKey(logger.getLogClass()), null);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_222;
        }
        try
        {
            logger.setLogLevel(LogLevel.valueOf(s));
        }
        catch (Exception exception) { }
        configuration.registerChangedListener(Logger.getLogLevelConfigurationKey(logger.getLogClass()), logger);
          goto _L1
        configWriteLock.unlock();
    }

    public static void setConfiguration(Configuration configuration1)
    {
        getInstance().setConfig(configuration1);
    }

    static 
    {
        defaultLogLevel = LogLevel.OFF;
    }




/*
    static LogLevel access$102(LogLevel loglevel)
    {
        defaultLogLevel = loglevel;
        return loglevel;
    }

*/
}
