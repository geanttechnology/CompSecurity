// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.log;


// Referenced classes of package com.amazon.insights.core.log:
//            Logger

public static final class  extends Enum
{

    private static final OFF $VALUES[];
    public static final OFF DEBUG;
    public static final OFF ERROR;
    public static final OFF INFO;
    public static final OFF OFF;
    public static final OFF VERBOSE;
    public static final OFF WARN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/insights/core/log/Logger$LogLevel, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        VERBOSE = new <init>("VERBOSE", 0);
        DEBUG = new <init>("DEBUG", 1);
        INFO = new <init>("INFO", 2);
        WARN = new <init>("WARN", 3);
        ERROR = new <init>("ERROR", 4);
        OFF = new <init>("OFF", 5);
        $VALUES = (new .VALUES[] {
            VERBOSE, DEBUG, INFO, WARN, ERROR, OFF
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
