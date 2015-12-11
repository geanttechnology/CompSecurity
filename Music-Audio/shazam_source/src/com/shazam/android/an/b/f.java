// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.b.e.a;
import com.shazam.model.Factory;
import com.shazam.model.configuration.SpotifyConfiguration;
import com.shazam.model.spotify.SpotifyConnectionState;
import com.shazam.server.response.streaming.spotify.SpotifyPlaylistTracksPager;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.shazam.android.an.b:
//            m, y, n

public final class f
    implements m, com.shazam.g.f
{

    private final SpotifyConnectionState a;
    private final SpotifyConfiguration b;
    private final Factory c;
    private n d;
    private final List e = new ArrayList();

    public f(SpotifyConnectionState spotifyconnectionstate, SpotifyConfiguration spotifyconfiguration, Factory factory)
    {
        a = spotifyconnectionstate;
        b = spotifyconfiguration;
        c = factory;
    }

    private void a(String s)
    {
        s = (y)c.create(s);
        s.a(this);
        s.a();
    }

    public final void a(n n1, String s)
    {
        d = n1;
        a(b.a(a.d(), s));
    }

    public final void onDataFailedToLoad()
    {
        d.a();
    }

    public final void onDataFetched(Object obj)
    {
        obj = (SpotifyPlaylistTracksPager)obj;
        e.addAll(((SpotifyPlaylistTracksPager) (obj)).playlistTracks);
        if (com.shazam.b.e.a.c(((SpotifyPlaylistTracksPager) (obj)).nextUrl))
        {
            a(((SpotifyPlaylistTracksPager) (obj)).nextUrl);
            return;
        } else
        {
            d.a(e);
            return;
        }
    }
}
