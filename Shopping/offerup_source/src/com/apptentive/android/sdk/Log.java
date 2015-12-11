// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk;

import java.util.IllegalFormatException;

public class Log
{

    private static final String TAG = "Apptentive";
    private static Level logLevel;

    public Log()
    {
    }

    public static transient void a(String s, Throwable throwable, Object aobj[])
    {
        doLog(Level.ASSERT, throwable, s, aobj);
    }

    public static transient void a(String s, Object aobj[])
    {
        doLog(Level.ASSERT, null, s, aobj);
    }

    public static boolean canLog(Level level)
    {
        return logLevel.canLog(level);
    }

    public static transient void d(String s, Throwable throwable, Object aobj[])
    {
        doLog(Level.DEBUG, throwable, s, aobj);
    }

    public static transient void d(String s, Object aobj[])
    {
        doLog(Level.DEBUG, null, s, aobj);
    }

    private static transient void doLog(Level level, Throwable throwable, String s, Object aobj[])
    {
        if (!canLog(level) || s == null) goto _L2; else goto _L1
_L1:
        String s1;
        Level level1;
        level1 = level;
        s1 = s;
        if (aobj.length <= 0)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        s1 = String.format(s, aobj);
        level1 = level;
_L4:
        android.util.Log.println(level1.getLevel(), "Apptentive", s1);
        if (throwable != null)
        {
            if (throwable.getMessage() != null)
            {
                android.util.Log.println(level1.getLevel(), "Apptentive", throwable.getMessage());
            }
            android.util.Log.println(level1.getLevel(), "Apptentive", android.util.Log.getStackTraceString(throwable));
        }
_L2:
        return;
        aobj;
        s1 = (new StringBuilder("Error formatting log message [level=")).append(level).append("]: ").append(s).toString();
        level1 = Level.ERROR;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static transient void e(String s, Throwable throwable, Object aobj[])
    {
        doLog(Level.ERROR, throwable, s, aobj);
    }

    public static transient void e(String s, Object aobj[])
    {
        doLog(Level.ERROR, null, s, aobj);
    }

    public static transient void i(String s, Throwable throwable, Object aobj[])
    {
        doLog(Level.INFO, throwable, s, aobj);
    }

    public static transient void i(String s, Object aobj[])
    {
        doLog(Level.INFO, null, s, aobj);
    }

    public static void overrideLogLevel(Level level)
    {
        logLevel = level;
    }

    public static transient void v(String s, Throwable throwable, Object aobj[])
    {
        doLog(Level.VERBOSE, throwable, s, aobj);
    }

    public static transient void v(String s, Object aobj[])
    {
        doLog(Level.VERBOSE, null, s, aobj);
    }

    public static transient void w(String s, Throwable throwable, Object aobj[])
    {
        doLog(Level.WARN, throwable, s, aobj);
    }

    public static transient void w(String s, Object aobj[])
    {
        doLog(Level.WARN, null, s, aobj);
    }

    static 
    {
        logLevel = Level.DEFAULT;
    }

    private class Level extends Enum
    {

        private static final Level $VALUES[];
        public static final Level ASSERT;
        public static final Level DEBUG;
        public static final Level DEFAULT;
        public static final Level ERROR;
        public static final Level INFO;
        public static final Level VERBOSE;
        public static final Level WARN;
        private int level;

        public static Level parse(String s)
        {
            Level level1;
            try
            {
                level1 = valueOf(s);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                android.util.Log.println(4, "Apptentive", (new StringBuilder("Error parsing unknown Log.Level: ")).append(s).toString());
                return DEFAULT;
            }
            return level1;
        }

        public static Level valueOf(String s)
        {
            return (Level)Enum.valueOf(com/apptentive/android/sdk/Log$Level, s);
        }

        public static Level[] values()
        {
            return (Level[])$VALUES.clone();
        }

        public final boolean canLog(Level level1)
        {
            return level1.getLevel() >= getLevel();
        }

        public final int getLevel()
        {
            return level;
        }

        static 
        {
            VERBOSE = new Level("VERBOSE", 0, 2);
            DEBUG = new Level("DEBUG", 1, 3);
            INFO = new Level("INFO", 2, 4);
            WARN = new Level("WARN", 3, 5);
            ERROR = new Level("ERROR", 4, 6);
            ASSERT = new Level("ASSERT", 5, 7);
            DEFAULT = new Level("DEFAULT", 6, INFO.getLevel());
            $VALUES = (new Level[] {
                VERBOSE, DEBUG, INFO, WARN, ERROR, ASSERT, DEFAULT
            });
        }

        private Level(String s, int j, int k)
        {
            super(s, j);
            level = k;
        }
    }

}
