// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.news.card;

import com.shazam.server.response.play.Streams;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.shazam.server.response.news.card:
//            MediaTrack

public class Media
{

    public static final Media EMPTY = new Media(null, null, null, null, null, null);
    public final List artists;
    public final Map stores;
    public final Streams streams;
    public final MediaTrack track;
    public final List tracks;
    public final Map urlParams;

    private Media(Map map, List list, Streams streams1, Map map1, List list1, MediaTrack mediatrack)
    {
        urlParams = map;
        artists = list;
        streams = streams1;
        stores = map1;
        tracks = list1;
        track = mediatrack;
    }

    public List getMediaArtists()
    {
        return artists;
    }

}
