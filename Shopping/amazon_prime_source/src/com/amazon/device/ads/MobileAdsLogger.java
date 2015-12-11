// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.amazon.device.ads:
//            Logger, DebugProperties, Settings, Version

class MobileAdsLogger
    implements Logger
{
    public static final class Level extends Enum
    {

        private static final Level $VALUES[];
        public static final Level DEBUG;
        public static final Level ERROR;
        public static final Level INFO;
        public static final Level VERBOSE;
        public static final Level WARN;

        public static Level valueOf(String s)
        {
            return (Level)Enum.valueOf(com/amazon/device/ads/MobileAdsLogger$Level, s);
        }

        public static Level[] values()
        {
            return (Level[])$VALUES.clone();
        }

        static 
        {
            DEBUG = new Level("DEBUG", 0);
            ERROR = new Level("ERROR", 1);
            INFO = new Level("INFO", 2);
            VERBOSE = new Level("VERBOSE", 3);
            WARN = new Level("WARN", 4);
            $VALUES = (new Level[] {
                DEBUG, ERROR, INFO, VERBOSE, WARN
            });
        }

        private Level(String s, int j)
        {
            super(s, j);
        }
    }


    private static final String DEFAULT_LOGTAG_PREFIX = "AmazonMobileAds";
    private static final int DEFAULT_MAX_LENGTH = 1000;
    static final String LOGGING_ENABLED = "loggingEnabled";
    private final DebugProperties debugProperties;
    private final Logger logger;
    private int maxLength;
    private final Settings settings;

    public MobileAdsLogger(Logger logger1)
    {
        this(logger1, DebugProperties.getInstance(), Settings.getInstance());
    }

    MobileAdsLogger(Logger logger1, DebugProperties debugproperties, Settings settings1)
    {
        maxLength = 1000;
        logger = logger1.withLogTag("AmazonMobileAds");
        debugProperties = debugproperties;
        settings = settings1;
    }

    private transient void doLog(boolean flag, Level level, String s, Object aobj[])
    {
        if (canLog() || flag)
        {
            s = formatAndSplit(s, aobj).iterator();
            do
            {
                if (!s.hasNext())
                {
                    break;
                }
                aobj = (String)s.next();
                static class _cls1
                {

                    static final int $SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level[];

                    static 
                    {
                        $SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level = new int[Level.values().length];
                        try
                        {
                            $SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level[Level.DEBUG.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            $SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level[Level.ERROR.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level[Level.INFO.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level[Level.VERBOSE.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level[Level.WARN.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls1..SwitchMap.com.amazon.device.ads.MobileAdsLogger.Level[level.ordinal()])
                {
                case 1: // '\001'
                    logger.d(((String) (aobj)));
                    break;

                case 2: // '\002'
                    logger.e(((String) (aobj)));
                    break;

                case 3: // '\003'
                    logger.i(((String) (aobj)));
                    break;

                case 4: // '\004'
                    logger.v(((String) (aobj)));
                    break;

                case 5: // '\005'
                    logger.w(((String) (aobj)));
                    break;
                }
            } while (true);
        }
    }

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
        return split(s1, maxLength);
    }

    private Iterable split(String s, int j)
    {
        ArrayList arraylist = new ArrayList();
        if (s != null && s.length() != 0)
        {
            int k = 0;
            while (k < s.length()) 
            {
                arraylist.add(s.substring(k, Math.min(s.length(), k + j)));
                k += j;
            }
        }
        return arraylist;
    }

    public boolean canLog()
    {
        if (logger == null || debugProperties == null)
        {
            return false;
        } else
        {
            return debugProperties.getDebugPropertyAsBoolean("debug.logging", Boolean.valueOf(settings.getBoolean("loggingEnabled", false))).booleanValue();
        }
    }

    public void d(String s)
    {
        d(s, (Object[])null);
    }

    public transient void d(String s, Object aobj[])
    {
        log(Level.DEBUG, s, aobj);
    }

    public void e(String s)
    {
        e(s, (Object[])null);
    }

    public transient void e(String s, Object aobj[])
    {
        log(Level.ERROR, s, aobj);
    }

    public void enableLogging(boolean flag)
    {
        settings.putTransientBoolean("loggingEnabled", flag);
    }

    public final void enableLoggingWithSetterNotification(boolean flag)
    {
        if (!flag)
        {
            logSetterNotification("Debug logging", Boolean.valueOf(flag));
        }
        enableLogging(flag);
        if (flag)
        {
            logSetterNotification("Debug logging", Boolean.valueOf(flag));
            d("Amazon Mobile Ads API Version: %s", new Object[] {
                Version.getRawSDKVersion()
            });
        }
    }

    public transient void forceLog(Level level, String s, Object aobj[])
    {
        doLog(true, level, s, aobj);
    }

    public void i(String s)
    {
        i(s, (Object[])null);
    }

    public transient void i(String s, Object aobj[])
    {
        log(Level.INFO, s, aobj);
    }

    public transient void log(Level level, String s, Object aobj[])
    {
        doLog(false, level, s, aobj);
    }

    public void logSetterNotification(String s, Object obj)
    {
        if (!canLog())
        {
            return;
        }
        if (obj instanceof Boolean)
        {
            if (((Boolean)obj).booleanValue())
            {
                obj = "enabled";
            } else
            {
                obj = "disabled";
            }
            d("%s has been %s.", new Object[] {
                s, obj
            });
            return;
        } else
        {
            d("%s has been set: %s", new Object[] {
                s, String.valueOf(obj)
            });
            return;
        }
    }

    public void v(String s)
    {
        v(s, (Object[])null);
    }

    public transient void v(String s, Object aobj[])
    {
        log(Level.VERBOSE, s, aobj);
    }

    public void w(String s)
    {
        w(s, (Object[])null);
    }

    public transient void w(String s, Object aobj[])
    {
        log(Level.WARN, s, aobj);
    }

    public volatile Logger withLogTag(String s)
    {
        return withLogTag(s);
    }

    public MobileAdsLogger withLogTag(String s)
    {
        logger.withLogTag((new StringBuilder()).append("AmazonMobileAds ").append(s).toString());
        return this;
    }

    public MobileAdsLogger withMaxLength(int j)
    {
        maxLength = j;
        return this;
    }
}
