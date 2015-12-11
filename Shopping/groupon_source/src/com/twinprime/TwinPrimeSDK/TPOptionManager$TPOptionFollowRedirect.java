// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;


// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPOptionManager

static final class  extends Enum
{

    private static final TPOptionFollowRedirect_enable $VALUES[];
    public static final TPOptionFollowRedirect_enable TPOptionFollowRedirect_disable;
    public static final TPOptionFollowRedirect_enable TPOptionFollowRedirect_enable;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionFollowRedirect, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TPOptionFollowRedirect_disable = new <init>("TPOptionFollowRedirect_disable", 0);
        TPOptionFollowRedirect_enable = new <init>("TPOptionFollowRedirect_enable", 1);
        $VALUES = (new .VALUES[] {
            TPOptionFollowRedirect_disable, TPOptionFollowRedirect_enable
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
