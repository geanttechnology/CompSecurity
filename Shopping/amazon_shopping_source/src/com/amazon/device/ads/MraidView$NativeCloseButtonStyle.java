// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            MraidView

static final class  extends Enum
{

    private static final AD_CONTROLLED $VALUES[];
    public static final AD_CONTROLLED AD_CONTROLLED;
    public static final AD_CONTROLLED ALWAYS_HIDDEN;
    public static final AD_CONTROLLED ALWAYS_VISIBLE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/ads/MraidView$NativeCloseButtonStyle, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ALWAYS_VISIBLE = new <init>("ALWAYS_VISIBLE", 0);
        ALWAYS_HIDDEN = new <init>("ALWAYS_HIDDEN", 1);
        AD_CONTROLLED = new <init>("AD_CONTROLLED", 2);
        $VALUES = (new .VALUES[] {
            ALWAYS_VISIBLE, ALWAYS_HIDDEN, AD_CONTROLLED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
