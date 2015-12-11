// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;


// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPOptionManager

static final class  extends Enum
{

    private static final TPOptionPerformanceLog_disable $VALUES[];
    public static final TPOptionPerformanceLog_disable TPOptionPerformanceLog_disable;
    public static final TPOptionPerformanceLog_disable TPOptionPerformanceLog_enable;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionPerformanceLog, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TPOptionPerformanceLog_enable = new <init>("TPOptionPerformanceLog_enable", 0);
        TPOptionPerformanceLog_disable = new <init>("TPOptionPerformanceLog_disable", 1);
        $VALUES = (new .VALUES[] {
            TPOptionPerformanceLog_enable, TPOptionPerformanceLog_disable
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
