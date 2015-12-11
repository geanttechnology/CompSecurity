// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;


// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPOptionManager

static final class I extends Enum
{

    private static final TPOptionHTTPAcceleration_enable $VALUES[];
    public static final TPOptionHTTPAcceleration_enable TPOptionHTTPAcceleration_disable;
    public static final TPOptionHTTPAcceleration_enable TPOptionHTTPAcceleration_enable;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionHTTPAcceleration, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        TPOptionHTTPAcceleration_disable = new <init>("TPOptionHTTPAcceleration_disable", 0);
        TPOptionHTTPAcceleration_enable = new <init>("TPOptionHTTPAcceleration_enable", 1);
        $VALUES = (new .VALUES[] {
            TPOptionHTTPAcceleration_disable, TPOptionHTTPAcceleration_enable
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
