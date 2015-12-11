// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import com.shazam.model.advert.Ad;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            AdFeedCard

public static class 
{

    private Actions actions;
    public Ad ad;
    private final Map beaconData = new HashMap();
    public String id;
    public String sponsorshipText;
    private long timestamp;

    static long a( )
    {
        return .timestamp;
    }

    public static timestamp a()
    {
        return new <init>();
    }

    static Actions b(<init> <init>1)
    {
        return <init>1.actions;
    }

    static String c(actions actions1)
    {
        return actions1.id;
    }

    static Map d(id id1)
    {
        return id1.beaconData;
    }

    static Ad e(beaconData beacondata)
    {
        return beacondata.ad;
    }

    static String f(ad ad1)
    {
        return ad1.sponsorshipText;
    }

    public final AdFeedCard b()
    {
        return new AdFeedCard(this, null);
    }

    public ()
    {
    }
}
