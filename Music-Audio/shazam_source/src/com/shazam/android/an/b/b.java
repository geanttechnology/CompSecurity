// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.android.an.g;
import com.shazam.android.an.h;
import com.shazam.model.spotify.SpotifyConnectionState;
import java.util.List;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.shazam.android.an.b:
//            o, h

public final class b
    implements g
{

    private final ExecutorService a;
    private final SpotifyConnectionState b;
    private final com.shazam.android.an.b.h c;

    public b(ExecutorService executorservice, SpotifyConnectionState spotifyconnectionstate, com.shazam.android.an.b.h h)
    {
        a = executorservice;
        b = spotifyconnectionstate;
        c = h;
    }

    public final void a(String s, List list, h h)
    {
        a.execute(new o(c, s, list, h));
    }

    public final void a(List list, h h)
    {
        a(b.f(), list, h);
    }
}
