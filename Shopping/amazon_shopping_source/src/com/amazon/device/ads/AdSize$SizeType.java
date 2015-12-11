// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdSize

private static final class  extends Enum
{

    private static final INTERSTITIAL $VALUES[];
    public static final INTERSTITIAL AUTO;
    public static final INTERSTITIAL EXPLICIT;
    public static final INTERSTITIAL INTERSTITIAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/ads/AdSize$SizeType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EXPLICIT = new <init>("EXPLICIT", 0);
        AUTO = new <init>("AUTO", 1);
        INTERSTITIAL = new <init>("INTERSTITIAL", 2);
        $VALUES = (new .VALUES[] {
            EXPLICIT, AUTO, INTERSTITIAL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
