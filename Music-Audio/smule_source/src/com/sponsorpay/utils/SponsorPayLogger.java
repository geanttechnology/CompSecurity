// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.sponsorpay.utils:
//            SPLoggerListener

public class SponsorPayLogger
{

    private static SponsorPayLogger INSTANCE = new SponsorPayLogger();
    private static boolean logging = false;
    private static final String prefix = "[SP] ";
    private Set listeners;

    private SponsorPayLogger()
    {
        listeners = new HashSet();
    }

    public static boolean addLoggerListener(SPLoggerListener sploggerlistener)
    {
        return INSTANCE.listeners.add(sploggerlistener);
    }

    public static void d(String s, String s1)
    {
        if (shouldLog())
        {
            Log.d((new StringBuilder("[SP] ")).append(s).toString(), s1);
            INSTANCE.log(Level.DEBUG, s, s1, null);
        }
    }

    public static void e(String s, String s1)
    {
        if (shouldLog())
        {
            Log.e((new StringBuilder("[SP] ")).append(s).toString(), s1);
            INSTANCE.log(Level.ERROR, s, s1, null);
        }
    }

    public static void e(String s, String s1, Exception exception)
    {
        if (shouldLog())
        {
            Log.w((new StringBuilder("[SP] ")).append(s).toString(), s1, exception);
            INSTANCE.log(Level.ERROR, s, s1, exception);
        }
    }

    public static boolean enableLogging(boolean flag)
    {
        logging = flag;
        return logging;
    }

    public static void i(String s, String s1)
    {
        if (shouldLog())
        {
            Log.i((new StringBuilder("[SP] ")).append(s).toString(), s1);
            INSTANCE.log(Level.INFO, s, s1, null);
        }
    }

    public static boolean isLogging()
    {
        return logging;
    }

    public static boolean removeLoggerListener(SPLoggerListener sploggerlistener)
    {
        return INSTANCE.listeners.remove(sploggerlistener);
    }

    private static boolean shouldLog()
    {
        return logging || Log.isLoggable("SponsorPay", 2);
    }

    public static boolean toggleLogging()
    {
        boolean flag;
        if (logging)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        logging = flag;
        return logging;
    }

    public static void v(String s, String s1)
    {
        if (shouldLog())
        {
            Log.v((new StringBuilder("[SP] ")).append(s).toString(), s1);
            INSTANCE.log(Level.VERBOSE, s, s1, null);
        }
    }

    public static void w(String s, String s1)
    {
        if (shouldLog())
        {
            Log.w((new StringBuilder("[SP] ")).append(s).toString(), s1);
            INSTANCE.log(Level.WARNING, s, s1, null);
        }
    }

    public static void w(String s, String s1, Exception exception)
    {
        if (shouldLog())
        {
            Log.w((new StringBuilder("[SP] ")).append(s).toString(), s1, exception);
            INSTANCE.log(Level.WARNING, s, s1, exception);
        }
    }

    public void log(final Level level, final String tag, final String message, final Exception exception)
    {
        if (!listeners.isEmpty())
        {
            (new Thread(new Runnable() {

                final SponsorPayLogger this$0;
                private final Exception val$exception;
                private final Level val$level;
                private final String val$message;
                private final String val$tag;

                public void run()
                {
                    Iterator iterator = listeners.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            return;
                        }
                        ((SPLoggerListener)iterator.next()).log(level, tag, message, exception);
                    } while (true);
                }

            
            {
                this$0 = SponsorPayLogger.this;
                level = level1;
                tag = s;
                message = s1;
                exception = exception1;
                super();
            }
            })).start();
        }
    }

    static 
    {
        logging = false;
    }


    private class Level extends Enum
    {

        public static final Level DEBUG;
        private static final Level ENUM$VALUES[];
        public static final Level ERROR;
        public static final Level INFO;
        public static final Level VERBOSE;
        public static final Level WARNING;

        public static Level valueOf(String s)
        {
            return (Level)Enum.valueOf(com/sponsorpay/utils/SponsorPayLogger$Level, s);
        }

        public static Level[] values()
        {
            Level alevel[] = ENUM$VALUES;
            int j = alevel.length;
            Level alevel1[] = new Level[j];
            System.arraycopy(alevel, 0, alevel1, 0, j);
            return alevel1;
        }

        static 
        {
            VERBOSE = new Level("VERBOSE", 0);
            DEBUG = new Level("DEBUG", 1);
            INFO = new Level("INFO", 2);
            WARNING = new Level("WARNING", 3);
            ERROR = new Level("ERROR", 4);
            ENUM$VALUES = (new Level[] {
                VERBOSE, DEBUG, INFO, WARNING, ERROR
            });
        }

        private Level(String s, int j)
        {
            super(s, j);
        }
    }

}
