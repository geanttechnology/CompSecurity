// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            ChartFeedCard, FeedCard

public static class 
{

    public Actions actions;
    private final Map beaconData = new HashMap();
    public boolean hideHeader;
    public String id;
    public long timestamp;
    public String title;
    public List tracks;
    public String url;

    static long a( )
    {
        return .timestamp;
    }

    public static timestamp a()
    {
        return new <init>();
    }

    public static <init> a(ChartFeedCard chartfeedcard)
    {
        <init> <init>1 = new <init>();
        <init>1.id = ((FeedCard) (chartfeedcard)).id;
        <init>1.actions = chartfeedcard.c();
        <init>1.timestamp = ((FeedCard) (chartfeedcard)).timestamp;
        <init>1.title = chartfeedcard.title;
        <init>1.url = chartfeedcard.url;
        <init>1.tracks = chartfeedcard.tracks;
        <init>1.hideHeader = chartfeedcard.hideHeader;
        return <init>1.a(chartfeedcard.d());
    }

    static Actions b(a a1)
    {
        return a1.actions;
    }

    static String c(actions actions1)
    {
        return actions1.id;
    }

    static Map d(id id1)
    {
        return id1.beaconData;
    }

    static String e(beaconData beacondata)
    {
        return beacondata.title;
    }

    static String f(title title1)
    {
        return title1.url;
    }

    static List g(url url1)
    {
        return url1.tracks;
    }

    static boolean h(tracks tracks1)
    {
        return tracks1.hideHeader;
    }

    public final hideHeader a(Map map)
    {
        beaconData.clear();
        beaconData.putAll(map);
        return this;
    }

    public final ChartFeedCard b()
    {
        return new ChartFeedCard(this, null);
    }

    public ()
    {
    }
}
