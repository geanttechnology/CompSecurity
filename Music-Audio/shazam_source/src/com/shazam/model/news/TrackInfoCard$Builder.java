// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.details.InteractiveInfo;

// Referenced classes of package com.shazam.model.news:
//            TrackInfoCard

public static class 
{

    public String coverArtUrl;
    public String id;
    public InteractiveInfo interactiveInfo;
    public String trackArtist;
    public String trackKey;
    public String trackTitle;

    static InteractiveInfo a( )
    {
        return .interactiveInfo;
    }

    public static interactiveInfo a()
    {
        return new <init>();
    }

    static String b(<init> <init>1)
    {
        return <init>1.trackArtist;
    }

    static String c(trackArtist trackartist)
    {
        return trackartist.trackTitle;
    }

    static String d(trackTitle tracktitle)
    {
        return tracktitle.coverArtUrl;
    }

    static String e(coverArtUrl coverarturl)
    {
        return coverarturl.trackKey;
    }

    static String f(trackKey trackkey)
    {
        return trackkey.id;
    }

    public final TrackInfoCard b()
    {
        return new TrackInfoCard(this, null);
    }

    public ()
    {
    }
}
