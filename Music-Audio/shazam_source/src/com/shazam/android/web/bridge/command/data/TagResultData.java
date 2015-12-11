// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command.data;


public class TagResultData
{

    private String artist;
    private String coverArt;
    private String eventId;
    private String title;
    private String trackId;

    private TagResultData()
    {
    }

    public TagResultData(String s, String s1, String s2, String s3, String s4)
    {
        trackId = s;
        eventId = s1;
        coverArt = s2;
        artist = s3;
        title = s4;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getCoverArt()
    {
        return coverArt;
    }

    public String getEventId()
    {
        return eventId;
    }

    public String getTitle()
    {
        return title;
    }

    public String getTrackId()
    {
        return trackId;
    }
}
