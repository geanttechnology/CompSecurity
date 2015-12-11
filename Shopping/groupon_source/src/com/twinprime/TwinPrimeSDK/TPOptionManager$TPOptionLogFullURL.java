// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;


// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPOptionManager

static final class  extends Enum
{

    private static final TPOptionLogFullURL_enable $VALUES[];
    public static final TPOptionLogFullURL_enable TPOptionLogFullURL_disable;
    public static final TPOptionLogFullURL_enable TPOptionLogFullURL_enable;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionLogFullURL, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TPOptionLogFullURL_disable = new <init>("TPOptionLogFullURL_disable", 0);
        TPOptionLogFullURL_enable = new <init>("TPOptionLogFullURL_enable", 1);
        $VALUES = (new .VALUES[] {
            TPOptionLogFullURL_disable, TPOptionLogFullURL_enable
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
