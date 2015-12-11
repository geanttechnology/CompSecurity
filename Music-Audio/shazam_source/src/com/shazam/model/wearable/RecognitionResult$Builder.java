// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.wearable;

import com.shazam.model.lyrics.DynamicLyricsData;

// Referenced classes of package com.shazam.model.wearable:
//            RecognitionResult

public static class _cls9
{

    public String artistName;
    public String coverArt;
    public DynamicLyricsData dynamicLyricsData;
    public String trackTitle;

    public static _cls9 a()
    {
        return new <init>();
    }

    static String a(<init> <init>1)
    {
        return <init>1.coverArt;
    }

    static String b(coverArt coverart)
    {
        return coverart.artistName;
    }

    static String c(artistName artistname)
    {
        return artistname.trackTitle;
    }

    static DynamicLyricsData d(trackTitle tracktitle)
    {
        return tracktitle.dynamicLyricsData;
    }

    public _cls9()
    {
    }
}
