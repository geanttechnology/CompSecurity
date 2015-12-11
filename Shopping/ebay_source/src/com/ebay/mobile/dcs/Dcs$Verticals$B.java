// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import com.ebay.nautilus.domain.dcs.DcsPropBoolean;
import com.ebay.nautilus.domain.dcs.DcsState;

// Referenced classes of package com.ebay.mobile.dcs:
//            Dcs

public static final class defaultValue extends Enum
    implements DcsPropBoolean
{

    private static final rtmCardStyle $VALUES[];
    public static final rtmCardStyle buyingOverview;
    public static final rtmCardStyle collections;
    public static final rtmCardStyle deals;
    public static final rtmCardStyle events;
    public static final rtmCardStyle following;
    public static final rtmCardStyle lockedPortraitOnPhone;
    public static final rtmCardStyle notifications;
    public static final rtmCardStyle rateThisApp;
    public static final rtmCardStyle recentlyViewedItems;
    public static final rtmCardStyle rtmCardStyle;
    public static final rtmCardStyle sellingOverview;
    public static final rtmCardStyle trendingTopics;
    public static final rtmCardStyle valet;
    public static final rtmCardStyle watchedItems;
    private final Object defaultValue;
    private final String key;

    public static Boolean valueOf(String s)
    {
        return (Boolean)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Verticals$B, s);
    }

    public static Boolean[] values()
    {
        return (Boolean[])$VALUES.clone();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        return defaultValue;
    }

    public String key()
    {
        return key;
    }

    static 
    {
        buyingOverview = new <init>("buyingOverview", 0);
        sellingOverview = new <init>("sellingOverview", 1);
        notifications = new <init>("notifications", 2);
        recentlyViewedItems = new <init>("recentlyViewedItems", 3);
        following = new <init>("following", 4);
        watchedItems = new <init>("watchedItems", 5);
        lockedPortraitOnPhone = new <init>("lockedPortraitOnPhone", 6, true);
        deals = new <init>("deals", 7);
        events = new <init>("events", 8);
        collections = new <init>("collections", 9);
        trendingTopics = new <init>("trendingTopics", 10);
        valet = new <init>("valet", 11);
        rateThisApp = new <init>("rateThisApp", 12);
        rtmCardStyle = new <init>("rtmCardStyle", 13);
        $VALUES = (new .VALUES[] {
            buyingOverview, sellingOverview, notifications, recentlyViewedItems, following, watchedItems, lockedPortraitOnPhone, deals, events, collections, 
            trendingTopics, valet, rateThisApp, rtmCardStyle
        });
    }

    private e(String s, int i)
    {
        super(s, i);
        key = (new StringBuilder()).append("verticals.").append(name()).toString();
        defaultValue = Boolean.FALSE;
    }

    private defaultValue(String s, int i, String s1)
    {
        super(s, i);
        key = (new StringBuilder()).append("verticals.").append(name()).toString();
        defaultValue = s1;
    }

    private defaultValue(String s, int i, boolean flag)
    {
        super(s, i);
        key = (new StringBuilder()).append("verticals.").append(name()).toString();
        defaultValue = Boolean.valueOf(flag);
    }
}
