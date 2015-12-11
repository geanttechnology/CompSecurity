// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils

public static final class  extends Enum
{

    private static final BACKGROUND_THREAD $VALUES[];
    public static final BACKGROUND_THREAD BACKGROUND_THREAD;
    public static final BACKGROUND_THREAD MAIN_THREAD;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/ads/ThreadUtils$ExecutionThread, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MAIN_THREAD = new <init>("MAIN_THREAD", 0);
        BACKGROUND_THREAD = new <init>("BACKGROUND_THREAD", 1);
        $VALUES = (new .VALUES[] {
            MAIN_THREAD, BACKGROUND_THREAD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
