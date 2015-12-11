// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;


// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPOptionManager

static final class  extends Enum
{

    private static final TPOptionHTTPSAcceleration_enable $VALUES[];
    public static final TPOptionHTTPSAcceleration_enable TPOptionHTTPSAcceleration_disable;
    public static final TPOptionHTTPSAcceleration_enable TPOptionHTTPSAcceleration_enable;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionHTTPSAcceleration, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TPOptionHTTPSAcceleration_disable = new <init>("TPOptionHTTPSAcceleration_disable", 0);
        TPOptionHTTPSAcceleration_enable = new <init>("TPOptionHTTPSAcceleration_enable", 1);
        $VALUES = (new .VALUES[] {
            TPOptionHTTPSAcceleration_disable, TPOptionHTTPSAcceleration_enable
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
