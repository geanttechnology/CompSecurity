// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


public interface Logger
{
    public static final class LogLevel extends Enum
    {

        private static final LogLevel $VALUES[];
        public static final LogLevel DEBUG;
        public static final LogLevel ERROR;
        public static final LogLevel INFO;
        public static final LogLevel NONE;
        public static final LogLevel VERBOSE;
        public static final LogLevel WARNING;

        public static LogLevel valueOf(String s)
        {
            return (LogLevel)Enum.valueOf(com/google/tagmanager/Logger$LogLevel, s);
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
            WARNING = new LogLevel("WARNING", 3);
            ERROR = new LogLevel("ERROR", 4);
            NONE = new LogLevel("NONE", 5);
            $VALUES = (new LogLevel[] {
                VERBOSE, DEBUG, INFO, WARNING, ERROR, NONE
            });
        }

        private LogLevel(String s, int j)
        {
            super(s, j);
        }
    }


    public abstract void d(String s);

    public abstract void d(String s, Throwable throwable);

    public abstract void e(String s);

    public abstract void e(String s, Throwable throwable);

    public abstract LogLevel getLogLevel();

    public abstract void i(String s);

    public abstract void i(String s, Throwable throwable);

    public abstract void setLogLevel(LogLevel loglevel);

    public abstract void v(String s);

    public abstract void v(String s, Throwable throwable);

    public abstract void w(String s);

    public abstract void w(String s, Throwable throwable);
}
