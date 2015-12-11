// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;


// Referenced classes of package com.ebay.mobile.activities:
//            MyEbayLandingActivity

public static final class value extends Enum
    implements value
{

    private static final LOST $VALUES[];
    public static final LOST ALL;
    public static final LOST BIDS;
    public static final LOST LOST;
    public static final LOST OFFERS;
    public static final LOST WON;
    private final int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/ebay/mobile/activities/MyEbayLandingActivity$BuyingTarget, s);
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
        BIDS = new <init>("BIDS", 1, 1);
        OFFERS = new <init>("OFFERS", 2, 2);
        WON = new <init>("WON", 3, 3);
        LOST = new <init>("LOST", 4, 4);
        $VALUES = (new .VALUES[] {
            ALL, BIDS, OFFERS, WON, LOST
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
