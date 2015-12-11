// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.e;

import com.shazam.android.an.b.ae;
import com.shazam.android.k.f;
import com.shazam.b.c.a;
import com.shazam.h.i;
import com.shazam.h.j;
import com.shazam.h.k;
import com.shazam.model.spotify.SpotifyConnectionState;
import com.shazam.server.response.streaming.spotify.SpotifyPlaylistsPager;

public final class t
    implements f
{

    private final i a;
    private final ae b;
    private final SpotifyConnectionState c;
    private final String d;

    public t(i l, ae ae1, SpotifyConnectionState spotifyconnectionstate, String s)
    {
        a = l;
        b = ae1;
        c = spotifyconnectionstate;
        d = s;
    }

    public final Object a()
    {
        return b();
    }

    public final SpotifyPlaylistsPager b()
    {
        Object obj;
        try
        {
            b.a();
            obj = new com.shazam.h.l.a();
            obj.e = k.a;
            obj.a = com.shazam.b.c.a.a(d);
            obj = ((com.shazam.h.l.a) (obj)).a(c.e()).a();
            obj = (SpotifyPlaylistsPager)a.a(((com.shazam.h.l) (obj)), com/shazam/server/response/streaming/spotify/SpotifyPlaylistsPager);
        }
        catch (j j1)
        {
            throw new com.shazam.android.k.a.a("Could not retrieve Spotify Playlists Pager: ", j1);
        }
        return ((SpotifyPlaylistsPager) (obj));
    }
}
