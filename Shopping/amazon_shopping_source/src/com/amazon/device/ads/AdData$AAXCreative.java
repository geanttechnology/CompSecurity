// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Set;

// Referenced classes of package com.amazon.device.ads:
//            AdData

protected static final class id extends Enum
{

    private static final INTERSTITIAL $VALUES[];
    public static final INTERSTITIAL HTML;
    public static final INTERSTITIAL INTERSTITIAL;
    public static final INTERSTITIAL MRAID1;
    private final int id;

    static id getCreative(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1007: 
            return HTML;

        case 1016: 
            return MRAID1;

        case 1008: 
            return INTERSTITIAL;
        }
    }

    static INTERSTITIAL getTopCreative(Set set)
    {
        INTERSTITIAL interstitial = null;
        if (set.contains(MRAID1))
        {
            interstitial = MRAID1;
        } else
        if (set.contains(HTML))
        {
            return HTML;
        }
        return interstitial;
    }

    public static HTML valueOf(String s)
    {
        return (HTML)Enum.valueOf(com/amazon/device/ads/AdData$AAXCreative, s);
    }

    public static HTML[] values()
    {
        return (HTML[])$VALUES.clone();
    }

    public int getId()
    {
        return id;
    }

    static 
    {
        HTML = new <init>("HTML", 0, 1007);
        MRAID1 = new <init>("MRAID1", 1, 1016);
        INTERSTITIAL = new <init>("INTERSTITIAL", 2, 1008);
        $VALUES = (new .VALUES[] {
            HTML, MRAID1, INTERSTITIAL
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        id = j;
    }
}
