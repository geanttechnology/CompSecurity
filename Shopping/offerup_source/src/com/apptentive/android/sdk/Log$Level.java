// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk;

import android.util.Log;

public final class level extends Enum
{

    private static final DEFAULT $VALUES[];
    public static final DEFAULT ASSERT;
    public static final DEFAULT DEBUG;
    public static final DEFAULT DEFAULT;
    public static final DEFAULT ERROR;
    public static final DEFAULT INFO;
    public static final DEFAULT VERBOSE;
    public static final DEFAULT WARN;
    private int level;

    public static level parse(String s)
    {
        level level1;
        try
        {
            level1 = valueOf(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Log.println(4, "Apptentive", (new StringBuilder("Error parsing unknown Log.Level: ")).append(s).toString());
            return DEFAULT;
        }
        return level1;
    }

    public static DEFAULT valueOf(String s)
    {
        return (DEFAULT)Enum.valueOf(com/apptentive/android/sdk/Log$Level, s);
    }

    public static DEFAULT[] values()
    {
        return (DEFAULT[])$VALUES.clone();
    }

    public final boolean canLog(l_3B_.clone clone)
    {
        return clone.getLevel() >= getLevel();
    }

    public final int getLevel()
    {
        return level;
    }

    static 
    {
        VERBOSE = new <init>("VERBOSE", 0, 2);
        DEBUG = new <init>("DEBUG", 1, 3);
        INFO = new <init>("INFO", 2, 4);
        WARN = new <init>("WARN", 3, 5);
        ERROR = new <init>("ERROR", 4, 6);
        ASSERT = new <init>("ASSERT", 5, 7);
        DEFAULT = new <init>("DEFAULT", 6, INFO.getLevel());
        $VALUES = (new .VALUES[] {
            VERBOSE, DEBUG, INFO, WARN, ERROR, ASSERT, DEFAULT
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        level = j;
    }
}
