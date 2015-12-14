// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;


// Referenced classes of package com.amazon.device.ads.identity:
//            Log

public static final class level extends Enum
{

    private static final WARN $VALUES[];
    public static final WARN DEBUG;
    public static final WARN ERROR;
    public static final WARN INFO;
    public static final WARN VERBOSE;
    public static final WARN WARN;
    private final int level;

    public static level valueOf(String s)
    {
        return (level)Enum.valueOf(com/amazon/device/ads/identity/Log$Level, s);
    }

    public static level[] values()
    {
        return (level[])$VALUES.clone();
    }

    static 
    {
        DEBUG = new <init>("DEBUG", 0, 3);
        ERROR = new <init>("ERROR", 1, 6);
        INFO = new <init>("INFO", 2, 4);
        VERBOSE = new <init>("VERBOSE", 3, 2);
        WARN = new <init>("WARN", 4, 5);
        $VALUES = (new .VALUES[] {
            DEBUG, ERROR, INFO, VERBOSE, WARN
        });
    }


    private (String s, int i, int j)
    {
        super(s, i);
        level = j;
    }
}
