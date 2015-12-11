// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;


// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPOptionManager

static final class  extends Enum
{

    private static final TPOptionCache_enable $VALUES[];
    public static final TPOptionCache_enable TPOptionCache_disable;
    public static final TPOptionCache_enable TPOptionCache_enable;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionCache, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TPOptionCache_disable = new <init>("TPOptionCache_disable", 0);
        TPOptionCache_enable = new <init>("TPOptionCache_enable", 1);
        $VALUES = (new .VALUES[] {
            TPOptionCache_disable, TPOptionCache_enable
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
