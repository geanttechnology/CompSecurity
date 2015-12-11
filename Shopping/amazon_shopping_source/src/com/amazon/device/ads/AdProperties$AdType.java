// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdProperties

public static final class adTypeMetricTag extends Enum
{

    private static final INTERSTITIAL $VALUES[];
    public static final INTERSTITIAL IMAGE_BANNER;
    public static final INTERSTITIAL INTERSTITIAL;
    public static final INTERSTITIAL MRAID_1;
    public static final INTERSTITIAL MRAID_2;
    private final String adTypeMetricTag;
    private final String type;

    public static adTypeMetricTag valueOf(String s)
    {
        return (adTypeMetricTag)Enum.valueOf(com/amazon/device/ads/AdProperties$AdType, s);
    }

    public static adTypeMetricTag[] values()
    {
        return (adTypeMetricTag[])$VALUES.clone();
    }

    String getAdTypeMetricTag()
    {
        return adTypeMetricTag;
    }

    public String toString()
    {
        return type;
    }

    static 
    {
        IMAGE_BANNER = new <init>("IMAGE_BANNER", 0, "Image Banner");
        MRAID_1 = new <init>("MRAID_1", 1, "MRAID 1.0");
        MRAID_2 = new <init>("MRAID_2", 2, "MRAID 2.0");
        INTERSTITIAL = new <init>("INTERSTITIAL", 3, "Interstitial", "i");
        $VALUES = (new .VALUES[] {
            IMAGE_BANNER, MRAID_1, MRAID_2, INTERSTITIAL
        });
    }

    private (String s, int i, String s1)
    {
        this(s, i, s1, null);
    }

    private <init>(String s, int i, String s1, String s2)
    {
        super(s, i);
        type = s1;
        adTypeMetricTag = s2;
    }
}
