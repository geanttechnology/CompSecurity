// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.logger;


public interface Log
{
    public static final class Level extends Enum
    {

        private static final Level $VALUES[];
        public static final Level DEBUG;
        public static final Level ERROR;
        public static final Level FATAL;
        public static final Level INFO;
        public static final Level TRACE;
        public static final Level WARNING;
        private int level;

        public static Level valueOf(String s)
        {
            return (Level)Enum.valueOf(com/j256/ormlite/logger/Log$Level, s);
        }

        public static Level[] values()
        {
            return (Level[])$VALUES.clone();
        }

        public boolean isEnabled(Level level1)
        {
            return level <= level1.level;
        }

        static 
        {
            TRACE = new Level("TRACE", 0, 1);
            DEBUG = new Level("DEBUG", 1, 2);
            INFO = new Level("INFO", 2, 3);
            WARNING = new Level("WARNING", 3, 4);
            ERROR = new Level("ERROR", 4, 5);
            FATAL = new Level("FATAL", 5, 6);
            $VALUES = (new Level[] {
                TRACE, DEBUG, INFO, WARNING, ERROR, FATAL
            });
        }

        private Level(String s, int i, int j)
        {
            super(s, i);
            level = j;
        }
    }


    public abstract boolean isLevelEnabled(Level level);

    public abstract void log(Level level, String s);

    public abstract void log(Level level, String s, Throwable throwable);
}
