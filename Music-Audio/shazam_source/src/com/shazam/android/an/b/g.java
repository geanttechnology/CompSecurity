// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.android.k.e.t;
import com.shazam.android.k.f;
import com.shazam.b.e.a;
import com.shazam.model.Factory;
import com.shazam.model.configuration.SpotifyConfiguration;
import com.shazam.model.spotify.SpotifyConnectionState;
import com.shazam.server.response.streaming.spotify.SpotifyPlaylistsPager;
import java.util.ArrayList;
import java.util.List;

public final class g
    implements f
{

    private final SpotifyConfiguration a;
    private final SpotifyConnectionState b;
    private final Factory c;
    private final List d = new ArrayList();

    public g(SpotifyConfiguration spotifyconfiguration, SpotifyConnectionState spotifyconnectionstate, Factory factory)
    {
        a = spotifyconfiguration;
        b = spotifyconnectionstate;
        c = factory;
    }

    public final Object a()
    {
        for (Object obj = a.a(b.d()); com.shazam.b.e.a.c(((String) (obj))); obj = ((SpotifyPlaylistsPager) (obj)).nextUrl)
        {
            obj = ((t)c.create(obj)).b();
            d.addAll(((SpotifyPlaylistsPager) (obj)).playlists);
        }

        return d;
    }
}
