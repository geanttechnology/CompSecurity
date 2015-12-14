// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.log;

import android.util.Log;

public final class LoggerFactory
{
    static abstract class BaseLogger
        implements Logger
    {

        String tag;

        protected transient StringBuilder formatArguments(Object aobj[])
        {
            StringBuilder stringbuilder = new StringBuilder();
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                Object obj = aobj[i];
                stringbuilder.append((new StringBuilder()).append(obj).append(", ").toString());
            }

            return stringbuilder;
        }

        public BaseLogger(String s)
        {
            tag = s;
        }
    }

    static class ConsoleLogger extends BaseLogger
    {

        public void error(String s)
        {
            Log.e(tag, s);
        }

        public transient void error(String s, Object aobj[])
        {
            Log.e(tag, String.format(s, aobj));
        }

        public void info(String s)
        {
            Log.i(tag, s);
        }

        public transient void info(String s, Object aobj[])
        {
            Log.i(tag, String.format(s, aobj));
        }

        public void log(String s)
        {
            Log.d(tag, s);
        }

        public transient void log(String s, Object aobj[])
        {
            Log.d(tag, String.format(s, aobj));
        }

        public transient void verbose(String s, Object aobj[])
        {
            Log.v(tag, String.format(s, aobj));
        }

        public void warn(String s)
        {
            Log.w(tag, s);
        }

        public transient void warn(String s, Object aobj[])
        {
            Log.w(tag, String.format(s, aobj));
        }

        public ConsoleLogger(String s)
        {
            super(s);
        }
    }

    public static interface Logger
    {

        public abstract void error(String s);

        public transient abstract void error(String s, Object aobj[]);

        public abstract void info(String s);

        public transient abstract void info(String s, Object aobj[]);

        public abstract void log(String s);

        public transient abstract void log(String s, Object aobj[]);

        public transient abstract void verbose(String s, Object aobj[]);

        public abstract void warn(String s);

        public transient abstract void warn(String s, Object aobj[]);
    }

    public static final class LoggerType extends Enum
    {

        private static final LoggerType $VALUES[];
        public static final LoggerType ConsoleLoggerType;

        public static LoggerType valueOf(String s)
        {
            return (LoggerType)Enum.valueOf(com/aviary/android/feather/common/log/LoggerFactory$LoggerType, s);
        }

        public static LoggerType[] values()
        {
            return (LoggerType[])$VALUES.clone();
        }

        static 
        {
            ConsoleLoggerType = new LoggerType("ConsoleLoggerType", 0);
            $VALUES = (new LoggerType[] {
                ConsoleLoggerType
            });
        }

        private LoggerType(String s, int i)
        {
            super(s, i);
        }
    }

    static class NullLogger extends BaseLogger
    {

        public void error(String s)
        {
        }

        public transient void error(String s, Object aobj[])
        {
        }

        public void info(String s)
        {
        }

        public transient void info(String s, Object aobj[])
        {
        }

        public void log(String s)
        {
        }

        public transient void log(String s, Object aobj[])
        {
        }

        public transient void verbose(String s, Object aobj[])
        {
        }

        public void warn(String s)
        {
        }

        public transient void warn(String s, Object aobj[])
        {
        }

        public NullLogger(String s)
        {
            super(s);
        }
    }


    public static final String BASE_LOG_TAG = "Aviary-SDK";
    public static final boolean LOG_ENABLED = true;

    private LoggerFactory()
    {
    }

    public static Logger getLogger(String s)
    {
        return getLogger(s, LoggerType.ConsoleLoggerType);
    }

    public static Logger getLogger(String s, LoggerType loggertype)
    {
        if (loggertype == LoggerType.ConsoleLoggerType)
        {
            return new ConsoleLogger(s);
        } else
        {
            return new NullLogger(s);
        }
    }

    public static void printDeveloperError(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("==================================================\n");
        stringbuffer.append("==================================================\n");
        stringbuffer.append(s);
        stringbuffer.append("\n");
        stringbuffer.append("==================================================\n");
        stringbuffer.append("==================================================\n");
        Log.e("Aviary-SDK", stringbuffer.toString());
    }
}
