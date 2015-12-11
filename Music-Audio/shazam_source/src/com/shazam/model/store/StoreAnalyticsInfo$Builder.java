// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import com.shazam.model.analytics.ScreenOrigin;

// Referenced classes of package com.shazam.model.store:
//            StoreAnalyticsInfo

public static class 
{

    public String beaconKey;
    public String campaign;
    public String cardType;
    public String eventId;
    public String key;
    public ScreenOrigin origin;
    public String screenName;
    public String trackCategory;
    public String trackId;
    public String trackStyle;

    static ScreenOrigin a( )
    {
        return .origin;
    }

    public static origin a()
    {
        return new <init>();
    }

    static String b(<init> <init>1)
    {
        return <init>1.cardType;
    }

    static String c(cardType cardtype)
    {
        return cardtype.eventId;
    }

    static String d(eventId eventid)
    {
        return eventid.trackCategory;
    }

    static String e(trackCategory trackcategory)
    {
        return trackcategory.trackId;
    }

    static String f(trackId trackid)
    {
        return trackid.beaconKey;
    }

    static String g(beaconKey beaconkey)
    {
        return beaconkey.campaign;
    }

    static String h(campaign campaign1)
    {
        return campaign1.key;
    }

    static String i(key key1)
    {
        return key1.screenName;
    }

    static String j(screenName screenname)
    {
        return screenname.trackStyle;
    }

    public final StoreAnalyticsInfo b()
    {
        return new StoreAnalyticsInfo(this, null);
    }

    public ()
    {
    }
}
