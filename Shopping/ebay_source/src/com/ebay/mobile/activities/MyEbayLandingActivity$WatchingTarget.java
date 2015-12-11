// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;


// Referenced classes of package com.ebay.mobile.activities:
//            MyEbayLandingActivity

public static final class value extends Enum
    implements value
{

    private static final ENDED $VALUES[];
    public static final ENDED ACTIVE;
    public static final ENDED ALL;
    public static final ENDED ENDED;
    private final int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/ebay/mobile/activities/MyEbayLandingActivity$WatchingTarget, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    public int getTargetList()
    {
        return value;
    }

    static 
    {
        ALL = new <init>("ALL", 0, 0);
        ACTIVE = new <init>("ACTIVE", 1, 1);
        ENDED = new <init>("ENDED", 2, 2);
        $VALUES = (new .VALUES[] {
            ALL, ACTIVE, ENDED
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
