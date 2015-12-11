// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.android.an.b;
import com.shazam.android.an.c;
import com.shazam.h.j;
import com.shazam.model.spotify.SpotifyConnectionState;
import com.shazam.server.response.streaming.spotify.SpotifyPlaylist;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.shazam.android.an.b:
//            h

public final class a
    implements b, Runnable
{

    private final ExecutorService a;
    private final String b;
    private final h c;
    private final SpotifyConnectionState d;
    private c e;

    public a(ExecutorService executorservice, String s, h h1, SpotifyConnectionState spotifyconnectionstate)
    {
        a = executorservice;
        b = s;
        c = h1;
        d = spotifyconnectionstate;
    }

    public final void a(c c1)
    {
        e = c1;
        a.execute(this);
    }

    public final void run()
    {
        SpotifyPlaylist spotifyplaylist = c.a(b);
        d.b(spotifyplaylist.id);
        e.d();
        return;
        Object obj;
        obj;
_L2:
        e.b(((Exception) (obj)).getMessage());
        return;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
