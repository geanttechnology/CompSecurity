// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;


public interface Logger
{
    public static final class LogLevel extends Enum
    {

        private static final LogLevel $VALUES[];
        public static final LogLevel ERROR;
        public static final LogLevel INFO;
        public static final LogLevel VERBOSE;
        public static final LogLevel WARNING;

        public static LogLevel valueOf(String s)
        {
            return (LogLevel)Enum.valueOf(com/google/analytics/tracking/android/Logger$LogLevel, s);
        }

        public static LogLevel[] values()
        {
            return (LogLevel[])$VALUES.clone();
        }

        static 
        {
            VERBOSE = new LogLevel("VERBOSE", 0);
            INFO = new LogLevel("INFO", 1);
            WARNING = new LogLevel("WARNING", 2);
            ERROR = new LogLevel("ERROR", 3);
            $VALUES = (new LogLevel[] {
                VERBOSE, INFO, WARNING, ERROR
            });
        }

        private LogLevel(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void error(Exception exception);

    public abstract void error(String s);

    public abstract LogLevel getLogLevel();

    public abstract void info(String s);

    public abstract void setLogLevel(LogLevel loglevel);

    public abstract void verbose(String s);

    public abstract void warn(String s);
}
