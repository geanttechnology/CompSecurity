// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdRenderer

protected static final class  extends Enum
{

    private static final EXPANDED $VALUES[];
    public static final EXPANDED EXPANDED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/ads/AdRenderer$AdState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EXPANDED = new <init>("EXPANDED", 0);
        $VALUES = (new .VALUES[] {
            EXPANDED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
