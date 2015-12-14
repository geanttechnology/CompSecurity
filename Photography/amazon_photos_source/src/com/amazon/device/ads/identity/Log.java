// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.amazon.device.ads.identity:
//            DebugProperties, ILog

class Log
{
    public static final class Level extends Enum
    {

        private static final Level $VALUES[];
        public static final Level DEBUG;
        public static final Level ERROR;
        public static final Level INFO;
        public static final Level VERBOSE;
        public static final Level WARN;
        private final int level;

        public static Level valueOf(String s)
        {
            return (Level)Enum.valueOf(com/amazon/device/ads/identity/Log$Level, s);
        }

        public static Level[] values()
        {
            return (Level[])$VALUES.clone();
        }

        static 
        {
            DEBUG = new Level("DEBUG", 0, 3);
            ERROR = new Level("ERROR", 1, 6);
            INFO = new Level("INFO", 2, 4);
            VERBOSE = new Level("VERBOSE", 3, 2);
            WARN = new Level("WARN", 4, 5);
            $VALUES = (new Level[] {
                DEBUG, ERROR, INFO, VERBOSE, WARN
            });
        }


        private Level(String s, int i, int j)
        {
            super(s, i);
            level = j;
        }
    }

    private static class LogcatLogger
        implements ILog
    {

        private transient Iterable formatAndSplit(String s, Object aobj[])
        {
            String s1 = s;
            if (aobj != null)
            {
                s1 = s;
                if (aobj.length > 0)
                {
                    s1 = String.format(s, aobj);
                }
            }
            return Log.split$3274cb7b(s1);
        }

        public transient void d$524da578(String s, Object aobj[])
        {
            for (s = formatAndSplit(s, aobj).iterator(); s.hasNext(); s.next()) { }
        }

        public transient void e(String s, String s1, Object aobj[])
        {
            for (s1 = formatAndSplit(s1, aobj).iterator(); s1.hasNext(); android.util.Log.e(s, (String)s1.next())) { }
        }

        public transient void i(String s, String s1, Object aobj[])
        {
            for (s1 = formatAndSplit(s1, aobj).iterator(); s1.hasNext(); android.util.Log.i(s, (String)s1.next())) { }
        }

        public transient void v$524da578(String s, Object aobj[])
        {
            for (s = formatAndSplit(s, aobj).iterator(); s.hasNext(); s.next()) { }
        }

        public transient void w(String s, String s1, Object aobj[])
        {
            for (s1 = formatAndSplit(s1, aobj).iterator(); s1.hasNext(); android.util.Log.w(s, (String)s1.next())) { }
        }

        private LogcatLogger()
        {
        }

        LogcatLogger(byte byte0)
        {
            this();
        }
    }


    private static ILog logger = new LogcatLogger((byte)0);
    private static boolean loggingEnabled = false;

    public static boolean canLog()
    {
        if (logger == null)
        {
            return false;
        } else
        {
            return DebugProperties.getInstance().getDebugPropertyAsBoolean("debug.logging", loggingEnabled);
        }
    }

    public static transient void d(String s, String s1, Object aobj[])
    {
        if (canLog())
        {
            ILog ilog = logger;
            (new StringBuilder("AmazonMobileAds ")).append(s).toString();
            ilog.d$524da578(s1, aobj);
        }
    }

    public static transient void e(String s, String s1, Object aobj[])
    {
        if (canLog())
        {
            logger.e((new StringBuilder("AmazonMobileAds ")).append(s).toString(), s1, aobj);
        }
    }

    public static transient void forceLog(Level level, String s, String s1, Object aobj[])
    {
        canLog();
        switch (level.level)
        {
        default:
            return;

        case 3: // '\003'
            level = logger;
            (new StringBuilder("AmazonMobileAds ")).append(s).toString();
            level.d$524da578(s1, aobj);
            return;

        case 6: // '\006'
            logger.e((new StringBuilder("AmazonMobileAds ")).append(s).toString(), s1, aobj);
            return;

        case 4: // '\004'
            logger.i((new StringBuilder("AmazonMobileAds ")).append(s).toString(), s1, aobj);
            return;

        case 2: // '\002'
            level = logger;
            (new StringBuilder("AmazonMobileAds ")).append(s).toString();
            level.v$524da578(s1, aobj);
            return;

        case 5: // '\005'
            logger.w((new StringBuilder("AmazonMobileAds ")).append(s).toString(), s1, aobj);
            return;
        }
    }

    static Iterable split$3274cb7b(String s)
    {
        ArrayList arraylist = new ArrayList();
        if (s != null && s.length() != 0)
        {
            int i = 0;
            while (i < s.length()) 
            {
                arraylist.add(s.substring(i, Math.min(s.length(), i + 1000)));
                i += 1000;
            }
        }
        return arraylist;
    }

    public static transient void v(String s, String s1, Object aobj[])
    {
        if (canLog())
        {
            ILog ilog = logger;
            (new StringBuilder("AmazonMobileAds ")).append(s).toString();
            ilog.v$524da578(s1, aobj);
        }
    }

    public static transient void w(String s, String s1, Object aobj[])
    {
        if (canLog())
        {
            logger.w((new StringBuilder("AmazonMobileAds ")).append(s).toString(), s1, aobj);
        }
    }

}
