// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.log;


// Referenced classes of package com.amazon.device.analytics.log:
//            Logging

public static final class  extends Enum
{

    private static final OFF $VALUES[];
    public static final OFF DEBUG;
    public static final OFF ERROR;
    public static final OFF INFO;
    public static final OFF OFF;
    public static final OFF VERBOSE;
    public static final OFF WARN;
    public static final OFF WTF;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/analytics/log/Logging$LogLevel, s);
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
        WTF = new <init>("WTF", 5);
        OFF = new <init>("OFF", 6);
        $VALUES = (new .VALUES[] {
            VERBOSE, DEBUG, INFO, WARN, ERROR, WTF, OFF
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
