// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.server.response.streaming.spotify.SpotifyPlaylist;
import com.shazam.server.response.streaming.spotify.SpotifyPlaylistTracksPager;
import com.shazam.server.response.streaming.spotify.SpotifyUser;
import java.util.List;

public interface h
{

    public abstract SpotifyPlaylist a(String s);

    public abstract SpotifyUser a();

    public abstract void a(String s, List list);

    public abstract SpotifyPlaylistTracksPager b(String s);
}
