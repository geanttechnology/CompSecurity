// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.lyrics;


// Referenced classes of package com.shazam.model.lyrics:
//            DynamicLyricsData, LyricPlay

public static class 
{

    public String copyright;
    public String coverArt;
    public LyricPlay lyricPlay;
    public long tagTimestamp;
    public String title;
    public String writers;

    public static  a()
    {
        return new <init>();
    }

    static String a(<init> <init>1)
    {
        return <init>1.coverArt;
    }

    static LyricPlay b(coverArt coverart)
    {
        return coverart.lyricPlay;
    }

    static String c(lyricPlay lyricplay)
    {
        return lyricplay.title;
    }

    static long d(title title1)
    {
        return title1.tagTimestamp;
    }

    static String e(tagTimestamp tagtimestamp)
    {
        return tagtimestamp.writers;
    }

    static String f(writers writers1)
    {
        return writers1.copyright;
    }

    public final DynamicLyricsData b()
    {
        return new DynamicLyricsData(this, null);
    }

    public ()
    {
    }
}
