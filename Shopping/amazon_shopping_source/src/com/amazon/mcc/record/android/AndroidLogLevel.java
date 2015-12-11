// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.record.android;


public final class AndroidLogLevel extends Enum
{

    private static final AndroidLogLevel $VALUES[];
    public static final AndroidLogLevel DEBUG;
    public static final AndroidLogLevel DEBUG_THROWABLE;
    public static final AndroidLogLevel ERROR;
    public static final AndroidLogLevel ERROR_THROWABLE;
    public static final AndroidLogLevel INFO;
    public static final AndroidLogLevel INFO_THROWABLE;
    public static final AndroidLogLevel VERBOSE;
    public static final AndroidLogLevel VERBOSE_THROWABLE;
    public static final AndroidLogLevel WARNING;
    public static final AndroidLogLevel WARNING_THROWABLE;
    public static final AndroidLogLevel WARNING_THROWABLE_NO_MESSAGE;
    public static final AndroidLogLevel WTF;
    public static final AndroidLogLevel WTF_THROWABLE;
    public static final AndroidLogLevel WTF_THROWABLE_NO_MESSAGE;
    private final String humanReadable;

    private AndroidLogLevel(String s, int i, String s1)
    {
        super(s, i);
        humanReadable = s1;
    }

    public static AndroidLogLevel valueOf(String s)
    {
        return (AndroidLogLevel)Enum.valueOf(com/amazon/mcc/record/android/AndroidLogLevel, s);
    }

    public static AndroidLogLevel[] values()
    {
        return (AndroidLogLevel[])$VALUES.clone();
    }

    public String toString()
    {
        return humanReadable;
    }

    static 
    {
        DEBUG = new AndroidLogLevel("DEBUG", 0, "Debug");
        DEBUG_THROWABLE = new AndroidLogLevel("DEBUG_THROWABLE", 1, "Debug");
        ERROR = new AndroidLogLevel("ERROR", 2, "Error");
        ERROR_THROWABLE = new AndroidLogLevel("ERROR_THROWABLE", 3, "Error");
        INFO = new AndroidLogLevel("INFO", 4, "Info");
        INFO_THROWABLE = new AndroidLogLevel("INFO_THROWABLE", 5, "Info");
        VERBOSE = new AndroidLogLevel("VERBOSE", 6, "Verbose");
        VERBOSE_THROWABLE = new AndroidLogLevel("VERBOSE_THROWABLE", 7, "Verbose");
        WARNING = new AndroidLogLevel("WARNING", 8, "Warning");
        WARNING_THROWABLE = new AndroidLogLevel("WARNING_THROWABLE", 9, "Warning");
        WARNING_THROWABLE_NO_MESSAGE = new AndroidLogLevel("WARNING_THROWABLE_NO_MESSAGE", 10, "Warning");
        WTF = new AndroidLogLevel("WTF", 11, "WTF?!");
        WTF_THROWABLE = new AndroidLogLevel("WTF_THROWABLE", 12, "WTF?!");
        WTF_THROWABLE_NO_MESSAGE = new AndroidLogLevel("WTF_THROWABLE_NO_MESSAGE", 13, "WTF?!");
        $VALUES = (new AndroidLogLevel[] {
            DEBUG, DEBUG_THROWABLE, ERROR, ERROR_THROWABLE, INFO, INFO_THROWABLE, VERBOSE, VERBOSE_THROWABLE, WARNING, WARNING_THROWABLE, 
            WARNING_THROWABLE_NO_MESSAGE, WTF, WTF_THROWABLE, WTF_THROWABLE_NO_MESSAGE
        });
    }
}
