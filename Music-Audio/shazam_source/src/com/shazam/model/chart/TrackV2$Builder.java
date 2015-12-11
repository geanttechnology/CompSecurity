// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.chart;

import com.shazam.model.player.ProviderPlaybackIds;
import com.shazam.model.preview.PreviewViewData;
import com.shazam.model.store.Stores;
import com.shazam.server.response.play.Streams;

// Referenced classes of package com.shazam.model.chart:
//            TrackV2

public static class 
{

    public String artist;
    public String coverArtUrl;
    public String key;
    public PreviewViewData previewViewData;
    public ProviderPlaybackIds providerPlaybackIds;
    public Stores stores;
    public Streams streams;
    public String title;

    public static  a()
    {
        return new <init>();
    }

    static String a(<init> <init>1)
    {
        return <init>1.title;
    }

    static String b(title title1)
    {
        return title1.artist;
    }

    static String c(artist artist1)
    {
        return artist1.coverArtUrl;
    }

    static String d(coverArtUrl coverarturl)
    {
        return coverarturl.key;
    }

    static ProviderPlaybackIds e(key key1)
    {
        return key1.providerPlaybackIds;
    }

    static Stores f(providerPlaybackIds providerplaybackids)
    {
        return providerplaybackids.stores;
    }

    static PreviewViewData g(stores stores1)
    {
        return stores1.previewViewData;
    }

    static Streams h(previewViewData previewviewdata)
    {
        return previewviewdata.streams;
    }

    public ()
    {
    }
}
