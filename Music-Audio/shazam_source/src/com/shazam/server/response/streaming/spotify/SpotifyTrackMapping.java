// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.streaming.spotify;


public class SpotifyTrackMapping
{

    public static final SpotifyTrackMapping EMPTY = new SpotifyTrackMapping(null, null);
    public final String trackId;
    public final String uri;

    public SpotifyTrackMapping(String s, String s1)
    {
        trackId = s;
        uri = s1;
    }

}
