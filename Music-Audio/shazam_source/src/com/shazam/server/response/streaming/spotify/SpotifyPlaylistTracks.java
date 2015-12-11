// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.streaming.spotify;


public class SpotifyPlaylistTracks
{

    public static final SpotifyPlaylistTracks EMPTY = new SpotifyPlaylistTracks(null, 0);
    public final int total;
    public final String url;

    private SpotifyPlaylistTracks(String s, int i)
    {
        url = s;
        total = i;
    }

}
