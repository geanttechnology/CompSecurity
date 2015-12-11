// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import com.shazam.model.follow.FollowData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            ArtistJustJoinedFeedCard

public static class 
{

    public Actions actions;
    public final Map beaconData = new HashMap();
    public String body;
    public FollowData followData;
    public String headline;
    public String id;
    public String imageUrl;
    public long timestamp;
    public final List tracks = new ArrayList();

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
        return beacondata.headline;
    }

    static String f(headline headline1)
    {
        return headline1.body;
    }

    static String g(body body1)
    {
        return body1.imageUrl;
    }

    static List h(imageUrl imageurl)
    {
        return imageurl.tracks;
    }

    static FollowData i(tracks tracks1)
    {
        return tracks1.followData;
    }

    public ()
    {
    }
}
