// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.logger;


// Referenced classes of package com.j256.ormlite.logger:
//            Logger

public class LoggerFactory
{

    private static LogType logType;

    private LoggerFactory()
    {
    }

    private static LogType findLogType()
    {
        LogType alogtype[] = LogType.values();
        int j = alogtype.length;
        for (int i = 0; i < j; i++)
        {
            LogType logtype = alogtype[i];
            if (logtype.isAvailable())
            {
                return logtype;
            }
        }

        return LogType.LOCAL;
    }

    public static Logger getLogger(Class class1)
    {
        return getLogger(class1.getName());
    }

    public static Logger getLogger(String s)
    {
        if (logType == null)
        {
            logType = findLogType();
        }
        return new Logger(logType.createLog(s));
    }

    public static String getSimpleClassName(String s)
    {
        String as[] = s.split("\\.");
        if (as.length <= 1)
        {
            return s;
        } else
        {
            return as[as.length - 1];
        }
    }

    private class LogType extends Enum
    {

        private static final LogType $VALUES[];
        public static final LogType ANDROID;
        public static final LogType COMMONS_LOGGING;
        public static final LogType LOCAL;
        public static final LogType LOG4J;
        private final String detectClassName;
        private final String logClassName;

        public static LogType valueOf(String s)
        {
            return (LogType)Enum.valueOf(com/j256/ormlite/logger/LoggerFactory$LogType, s);
        }

        public static LogType[] values()
        {
            return (LogType[])$VALUES.clone();
        }

        public Log createLog(String s)
        {
            return createLogFromClassName(s);
        }

        Log createLogFromClassName(String s)
        {
            Log log;
            try
            {
                log = (Log)Class.forName(logClassName).getConstructor(new Class[] {
                    java/lang/String
                }).newInstance(new Object[] {
                    s
                });
            }
            catch (Exception exception)
            {
                s = new LocalLog(s);
                s.log(Log.Level.WARNING, (new StringBuilder()).append("Unable to call constructor for class ").append(logClassName).append(", so had to use local log").toString(), exception);
                return s;
            }
            return log;
        }

        public boolean isAvailable()
        {
            return isAvailableTestClass();
        }

        boolean isAvailableTestClass()
        {
            try
            {
                Class.forName(detectClassName);
            }
            catch (Exception exception)
            {
                return false;
            }
            return true;
        }

        static 
        {
            ANDROID = new LogType("ANDROID", 0, "android.util.Log", "com.j256.ormlite.android.AndroidLog");
            COMMONS_LOGGING = new LogType("COMMONS_LOGGING", 1, "org.apache.commons.logging.LogFactory", "com.j256.ormlite.logger.CommonsLoggingLog");
            LOG4J = new LogType("LOG4J", 2, "org.apache.log4j.Logger", "com.j256.ormlite.logger.Log4jLog");
            LOCAL = new LogType("LOCAL", 3, "com.j256.ormlite.logger.LocalLog", "com.j256.ormlite.logger.LocalLog") {

                public Log createLog(String s)
                {
                    return new LocalLog(s);
                }

                public boolean isAvailable()
                {
                    return true;
                }

            };
            $VALUES = (new LogType[] {
                ANDROID, COMMONS_LOGGING, LOG4J, LOCAL
            });
        }

        private LogType(String s, int i, String s1, String s2)
        {
            super(s, i);
            detectClassName = s1;
            logClassName = s2;
        }

    }

}
