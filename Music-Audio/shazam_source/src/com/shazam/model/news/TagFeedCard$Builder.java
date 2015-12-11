// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            TagFeedCard, TrackInfoCard

public static class 
{

    public Actions actions;
    public String authorId;
    public String authorImageUrl;
    public String authorName;
    private final Map beaconData = new HashMap();
    public String event;
    public String id;
    public long timestamp;
    public TrackInfoCard trackInfoCard;
    public Map urlParams;

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

    static String e(beaconData beacondata)
    {
        return beacondata.authorName;
    }

    static String f(authorName authorname)
    {
        return authorname.authorImageUrl;
    }

    static String g(authorImageUrl authorimageurl)
    {
        return authorimageurl.event;
    }

    static Map h(event event1)
    {
        return event1.urlParams;
    }

    static TrackInfoCard i(urlParams urlparams)
    {
        return urlparams.trackInfoCard;
    }

    static String j(trackInfoCard trackinfocard)
    {
        return trackinfocard.authorId;
    }

    public final authorId a(Map map)
    {
        beaconData.clear();
        beaconData.putAll(map);
        return this;
    }

    public final TagFeedCard b()
    {
        return new TagFeedCard(this);
    }

    public ()
    {
    }
}
