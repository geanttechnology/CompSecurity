// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.logger;

import java.lang.reflect.Constructor;

// Referenced classes of package com.j256.ormlite.logger:
//            LocalLog, Log, Logger

public class LoggerFactory
{
    public static class LogType extends Enum
    {

        private static final LogType $VALUES[];
        public static final LogType ANDROID;
        public static final LogType COMMONS_LOGGING;
        public static final LogType LOCAL;
        public static final LogType LOG4J;
        public static final LogType LOG4J2;
        public static final LogType SLF4J;
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
            Log log;
            try
            {
                log = createLogFromClassName(s);
            }
            catch (Exception exception)
            {
                s = new LocalLog(s);
                s.log(Log.Level.WARNING, (new StringBuilder()).append("Unable to call constructor with single String argument for class ").append(logClassName).append(", so had to use local log: ").append(exception.getMessage()).toString());
                return s;
            }
            return log;
        }

        Log createLogFromClassName(String s)
            throws Exception
        {
            return (Log)Class.forName(logClassName).getConstructor(new Class[] {
                java/lang/String
            }).newInstance(new Object[] {
                s
            });
        }

        public boolean isAvailable()
        {
            if (!isAvailableTestClass())
            {
                return false;
            }
            try
            {
                createLogFromClassName(getClass().getName()).isLevelEnabled(Log.Level.INFO);
            }
            catch (Exception exception)
            {
                return false;
            }
            return true;
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
            SLF4J = new LogType("SLF4J", 1, "org.slf4j.LoggerFactory", "com.j256.ormlite.logger.Slf4jLoggingLog");
            COMMONS_LOGGING = new LogType("COMMONS_LOGGING", 2, "org.apache.commons.logging.LogFactory", "com.j256.ormlite.logger.CommonsLoggingLog");
            LOG4J2 = new LogType("LOG4J2", 3, "org.apache.logging.log4j.LogManager", "com.j256.ormlite.logger.Log4j2Log");
            LOG4J = new LogType("LOG4J", 4, "org.apache.log4j.Logger", "com.j256.ormlite.logger.Log4jLog");
            LOCAL = new LogType("LOCAL", 5, com/j256/ormlite/logger/LocalLog.getName(), com/j256/ormlite/logger/LocalLog.getName()) {

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
                ANDROID, SLF4J, COMMONS_LOGGING, LOG4J2, LOG4J, LOCAL
            });
        }

        private LogType(String s, int i, String s1, String s2)
        {
            super(s, i);
            detectClassName = s1;
            logClassName = s2;
        }

    }


    private static LogType logType;

    private LoggerFactory()
    {
    }

    private static LogType findLogType()
    {
        String s = System.getProperty("com.j256.ormlite.logger.type");
        if (s == null) goto _L2; else goto _L1
_L1:
        Object obj = LogType.valueOf(s);
_L4:
        return ((LogType) (obj));
        obj;
        (new LocalLog(com/j256/ormlite/logger/LoggerFactory.getName())).log(Log.Level.WARNING, (new StringBuilder()).append("Could not find valid log-type from system property 'com.j256.ormlite.logger.type', value '").append(s).append("'").toString());
_L2:
        LogType alogtype[] = LogType.values();
        int j = alogtype.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                LogType logtype = alogtype[i];
                obj = logtype;
                if (logtype.isAvailable())
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
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
}
