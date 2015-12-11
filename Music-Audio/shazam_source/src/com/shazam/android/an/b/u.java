// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import android.os.NetworkOnMainThreadException;
import com.shazam.android.util.p;
import com.shazam.b.c.a;
import com.shazam.h.i;
import com.shazam.h.j;
import com.shazam.model.configuration.SpotifyConfiguration;
import com.shazam.model.spotify.SpotifyConnectionState;
import com.shazam.n.m;
import com.shazam.server.response.streaming.spotify.SpotifyTokenExchange;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.shazam.android.an.b:
//            ae

public final class u
    implements ae
{

    private static final long a;
    private final SpotifyConnectionState b;
    private final SpotifyConfiguration c;
    private final i d;
    private final m e;
    private final p f;

    public u(SpotifyConnectionState spotifyconnectionstate, SpotifyConfiguration spotifyconfiguration, i k, m m1, p p1)
    {
        b = spotifyconnectionstate;
        c = spotifyconfiguration;
        d = k;
        e = m1;
        f = p1;
    }

    public final void a()
    {
        Object obj;
        java.net.URL url;
        if (f.a())
        {
            throw new NetworkOnMainThreadException();
        }
        if (b.h() - a > e.a())
        {
            break MISSING_BLOCK_LABEL_111;
        }
        obj = (new com.shazam.h.y.a()).a("refresh_token", b.i()).a();
        url = com.shazam.b.c.a.a(c.d());
        obj = (SpotifyTokenExchange)d.b(url, ((com.shazam.h.y) (obj)), com/shazam/server/response/streaming/spotify/SpotifyTokenExchange);
        b.a(((SpotifyTokenExchange) (obj)));
        return;
        j j1;
        j1;
    }

    static 
    {
        a = TimeUnit.MINUTES.toMillis(2L);
    }
}
