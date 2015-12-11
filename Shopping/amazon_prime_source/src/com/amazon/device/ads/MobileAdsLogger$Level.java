// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLogger

public static final class  extends Enum
{

    private static final WARN $VALUES[];
    public static final WARN DEBUG;
    public static final WARN ERROR;
    public static final WARN INFO;
    public static final WARN VERBOSE;
    public static final WARN WARN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/ads/MobileAdsLogger$Level, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DEBUG = new <init>("DEBUG", 0);
        ERROR = new <init>("ERROR", 1);
        INFO = new <init>("INFO", 2);
        VERBOSE = new <init>("VERBOSE", 3);
        WARN = new <init>("WARN", 4);
        $VALUES = (new .VALUES[] {
            DEBUG, ERROR, INFO, VERBOSE, WARN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
