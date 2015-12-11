// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.b.c.a;
import com.shazam.h.i;
import com.shazam.h.j;
import com.shazam.model.authentication.AccessTokenRetrieverListener;
import com.shazam.model.configuration.SpotifyConfiguration;
import com.shazam.model.spotify.SpotifyConnectionState;
import com.shazam.server.response.streaming.spotify.SpotifyTokenExchange;

public final class v
    implements Runnable
{

    String a;
    AccessTokenRetrieverListener b;
    private final i c;
    private final SpotifyConfiguration d;
    private final SpotifyConnectionState e;

    public v(i k, SpotifyConfiguration spotifyconfiguration, SpotifyConnectionState spotifyconnectionstate)
    {
        c = k;
        d = spotifyconfiguration;
        e = spotifyconnectionstate;
    }

    public final void run()
    {
        Object obj = (new com.shazam.h.y.a()).a("code", a).a();
        java.net.URL url = com.shazam.b.c.a.a(d.b());
        try
        {
            obj = (SpotifyTokenExchange)c.b(url, ((com.shazam.h.y) (obj)), com/shazam/server/response/streaming/spotify/SpotifyTokenExchange);
            e.a(((SpotifyTokenExchange) (obj)));
            e.c(((SpotifyTokenExchange) (obj)).refreshToken);
            b.b();
            return;
        }
        catch (j j1)
        {
            b.d();
        }
    }
}
