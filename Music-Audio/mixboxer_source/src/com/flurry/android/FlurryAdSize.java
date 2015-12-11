// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            AdSpaceLayout

public final class FlurryAdSize extends Enum
{

    public static final FlurryAdSize BANNER_BOTTOM;
    public static final FlurryAdSize BANNER_TOP;
    public static final FlurryAdSize FULLSCREEN;
    private static final FlurryAdSize dP[];
    private int dO;

    private FlurryAdSize(String s, int i, int j)
    {
        super(s, i);
        dO = j;
    }

    static FlurryAdSize a(AdSpaceLayout adspacelayout)
    {
        String s = adspacelayout.getFormat().toString();
        adspacelayout = adspacelayout.getAlignment().toString().split("-");
        if (s.equals("takeover"))
        {
            return FULLSCREEN;
        }
        if (adspacelayout[0].equals("b"))
        {
            return BANNER_BOTTOM;
        } else
        {
            return BANNER_TOP;
        }
    }

    public static FlurryAdSize valueOf(String s)
    {
        return (FlurryAdSize)Enum.valueOf(com/flurry/android/FlurryAdSize, s);
    }

    public static FlurryAdSize[] values()
    {
        return (FlurryAdSize[])dP.clone();
    }

    final int getValue()
    {
        return dO;
    }

    static 
    {
        BANNER_TOP = new FlurryAdSize("BANNER_TOP", 0, 1);
        BANNER_BOTTOM = new FlurryAdSize("BANNER_BOTTOM", 1, 2);
        FULLSCREEN = new FlurryAdSize("FULLSCREEN", 2, 3);
        dP = (new FlurryAdSize[] {
            BANNER_TOP, BANNER_BOTTOM, FULLSCREEN
        });
    }
}
