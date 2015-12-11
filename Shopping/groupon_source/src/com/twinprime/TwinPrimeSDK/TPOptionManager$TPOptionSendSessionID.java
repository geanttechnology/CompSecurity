// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;


// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPOptionManager

static final class  extends Enum
{

    private static final TPOptionSendSessionID_disable $VALUES[];
    public static final TPOptionSendSessionID_disable TPOptionSendSessionID_disable;
    public static final TPOptionSendSessionID_disable TPOptionSendSessionID_enable;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionSendSessionID, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TPOptionSendSessionID_enable = new <init>("TPOptionSendSessionID_enable", 0);
        TPOptionSendSessionID_disable = new <init>("TPOptionSendSessionID_disable", 1);
        $VALUES = (new .VALUES[] {
            TPOptionSendSessionID_enable, TPOptionSendSessionID_disable
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
