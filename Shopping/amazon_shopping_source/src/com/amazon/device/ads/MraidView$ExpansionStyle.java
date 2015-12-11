// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            MraidView

static final class  extends Enum
{

    private static final DISABLED $VALUES[];
    public static final DISABLED DISABLED;
    public static final DISABLED ENABLED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/ads/MraidView$ExpansionStyle, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ENABLED = new <init>("ENABLED", 0);
        DISABLED = new <init>("DISABLED", 1);
        $VALUES = (new .VALUES[] {
            ENABLED, DISABLED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
