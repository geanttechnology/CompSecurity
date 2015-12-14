// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.logging;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MoPubLog
{

    private static final Logger LOGGER;
    public static final String LOGGER_NAMESPACE = "com.mopub";
    private static final String LOGTAG = "MoPub";
    private static final MoPubLogHandler LOG_HANDLER;

    private MoPubLog()
    {
    }

    private static void addHandler(Logger logger, Handler handler)
    {
        Handler ahandler[] = logger.getHandlers();
        int k = ahandler.length;
        for (int j = 0; j < k; j++)
        {
            if (ahandler[j].equals(handler))
            {
                return;
            }
        }

        logger.addHandler(handler);
    }

    public static void c(String s)
    {
        c(s, null);
    }

    public static void c(String s, Throwable throwable)
    {
        LOGGER.log(Level.FINEST, s, throwable);
    }

    public static void d(String s)
    {
        d(s, null);
    }

    public static void d(String s, Throwable throwable)
    {
        LOGGER.log(Level.CONFIG, s, throwable);
    }

    public static void e(String s)
    {
        e(s, null);
    }

    public static void e(String s, Throwable throwable)
    {
        LOGGER.log(Level.SEVERE, s, throwable);
    }

    public static void i(String s)
    {
        i(s, null);
    }

    public static void i(String s, Throwable throwable)
    {
        LOGGER.log(Level.INFO, s, throwable);
    }

    public static void setSdkHandlerLevel(Level level)
    {
        LOG_HANDLER.setLevel(level);
    }

    public static void v(String s)
    {
        v(s, null);
    }

    public static void v(String s, Throwable throwable)
    {
        LOGGER.log(Level.FINE, s, throwable);
    }

    public static void w(String s)
    {
        w(s, null);
    }

    public static void w(String s, Throwable throwable)
    {
        LOGGER.log(Level.WARNING, s, throwable);
    }

    static 
    {
        LOGGER = Logger.getLogger("com.mopub");
        LOG_HANDLER = new MoPubLogHandler();
        LOGGER.setUseParentHandlers(false);
        LOGGER.setLevel(Level.ALL);
        LOG_HANDLER.setLevel(Level.FINE);
        LogManager.getLogManager().addLogger(LOGGER);
        addHandler(LOGGER, LOG_HANDLER);
    }

    private class MoPubLogHandler extends Handler
    {

        private static final Map LEVEL_TO_LOG;

        public final void close()
        {
        }

        public final void flush()
        {
        }

        public final void publish(LogRecord logrecord)
        {
            if (isLoggable(logrecord))
            {
                String s;
                Throwable throwable;
                int j;
                if (LEVEL_TO_LOG.containsKey(logrecord.getLevel()))
                {
                    j = ((Integer)LEVEL_TO_LOG.get(logrecord.getLevel())).intValue();
                } else
                {
                    j = 2;
                }
                s = (new StringBuilder()).append(logrecord.getMessage()).append("\n").toString();
                throwable = logrecord.getThrown();
                logrecord = s;
                if (throwable != null)
                {
                    logrecord = (new StringBuilder()).append(s).append(Log.getStackTraceString(throwable)).toString();
                }
                Log.println(j, "MoPub", logrecord);
            }
        }

        static 
        {
            HashMap hashmap = new HashMap(7);
            LEVEL_TO_LOG = hashmap;
            hashmap.put(Level.FINEST, Integer.valueOf(2));
            LEVEL_TO_LOG.put(Level.FINER, Integer.valueOf(2));
            LEVEL_TO_LOG.put(Level.FINE, Integer.valueOf(2));
            LEVEL_TO_LOG.put(Level.CONFIG, Integer.valueOf(3));
            LEVEL_TO_LOG.put(Level.INFO, Integer.valueOf(4));
            LEVEL_TO_LOG.put(Level.WARNING, Integer.valueOf(5));
            LEVEL_TO_LOG.put(Level.SEVERE, Integer.valueOf(6));
        }

        private MoPubLogHandler()
        {
        }

    }

}
