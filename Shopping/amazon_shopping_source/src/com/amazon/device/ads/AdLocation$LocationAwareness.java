// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdLocation

private static final class  extends Enum
{

    private static final LOCATION_AWARENESS_DISABLED $VALUES[];
    public static final LOCATION_AWARENESS_DISABLED LOCATION_AWARENESS_DISABLED;
    public static final LOCATION_AWARENESS_DISABLED LOCATION_AWARENESS_NORMAL;
    public static final LOCATION_AWARENESS_DISABLED LOCATION_AWARENESS_TRUNCATED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/ads/AdLocation$LocationAwareness, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LOCATION_AWARENESS_NORMAL = new <init>("LOCATION_AWARENESS_NORMAL", 0);
        LOCATION_AWARENESS_TRUNCATED = new <init>("LOCATION_AWARENESS_TRUNCATED", 1);
        LOCATION_AWARENESS_DISABLED = new <init>("LOCATION_AWARENESS_DISABLED", 2);
        $VALUES = (new .VALUES[] {
            LOCATION_AWARENESS_NORMAL, LOCATION_AWARENESS_TRUNCATED, LOCATION_AWARENESS_DISABLED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
