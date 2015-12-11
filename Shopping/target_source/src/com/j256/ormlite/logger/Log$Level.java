// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.logger;


// Referenced classes of package com.j256.ormlite.logger:
//            Log

public static final class level extends Enum
{

    private static final FATAL $VALUES[];
    public static final FATAL DEBUG;
    public static final FATAL ERROR;
    public static final FATAL FATAL;
    public static final FATAL INFO;
    public static final FATAL TRACE;
    public static final FATAL WARNING;
    private int level;

    public static level valueOf(String s)
    {
        return (level)Enum.valueOf(com/j256/ormlite/logger/Log$Level, s);
    }

    public static level[] values()
    {
        return (level[])$VALUES.clone();
    }

    public boolean isEnabled(l_3B_.clone clone)
    {
        return level <= clone.level;
    }

    static 
    {
        TRACE = new <init>("TRACE", 0, 1);
        DEBUG = new <init>("DEBUG", 1, 2);
        INFO = new <init>("INFO", 2, 3);
        WARNING = new <init>("WARNING", 3, 4);
        ERROR = new <init>("ERROR", 4, 5);
        FATAL = new <init>("FATAL", 5, 6);
        $VALUES = (new .VALUES[] {
            TRACE, DEBUG, INFO, WARNING, ERROR, FATAL
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        level = j;
    }
}
