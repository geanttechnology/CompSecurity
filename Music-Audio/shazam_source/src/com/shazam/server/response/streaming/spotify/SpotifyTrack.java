// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.streaming.spotify;


public class SpotifyTrack
{

    public static final SpotifyTrack EMPTY = new SpotifyTrack(null);
    public final String uri;

    private SpotifyTrack(String s)
    {
        uri = s;
    }

}
