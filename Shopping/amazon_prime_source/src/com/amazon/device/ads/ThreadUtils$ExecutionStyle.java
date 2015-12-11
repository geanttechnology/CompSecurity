// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils

public static final class  extends Enum
{

    private static final SCHEDULE $VALUES[];
    public static final SCHEDULE RUN_ASAP;
    public static final SCHEDULE SCHEDULE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/ads/ThreadUtils$ExecutionStyle, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RUN_ASAP = new <init>("RUN_ASAP", 0);
        SCHEDULE = new <init>("SCHEDULE", 1);
        $VALUES = (new .VALUES[] {
            RUN_ASAP, SCHEDULE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
