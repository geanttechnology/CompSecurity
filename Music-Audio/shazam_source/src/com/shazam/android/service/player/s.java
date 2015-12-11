// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.player;

import com.shazam.android.activities.streaming.b;
import com.shazam.b.a.e;
import com.shazam.i.b.ai.b.f;
import com.shazam.i.b.an.a.c;
import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.player.PlaylistItem;

// Referenced classes of package com.shazam.android.service.player:
//            d, q, p, g

public final class s
{

    private final p a;
    private final q b[];

    public s(g g)
    {
        com.shazam.android.service.player.f f1 = c.a(g, c.a(f.b(), new w.a(), "Rdio", b.a), PlaybackProvider.RDIO);
        com.shazam.android.service.player.f f2 = c.a(g, new d(), PlaybackProvider.PREVIEW);
        g = c.a(g, c.a(f.a(), new x.a(), "Spotify", b.b), PlaybackProvider.SPOTIFY);
        a = f2;
        b = (new q[] {
            q.a(com.shazam.i.b.aj.b.b(), f1), q.a(com.shazam.i.b.aj.b.c(), g), q.a(new com.shazam.android.ao.c(), f2)
        });
    }

    public final p a(PlaylistItem playlistitem)
    {
        q aq[] = b;
        int j = aq.length;
        for (int i = 0; i < j; i++)
        {
            q q1 = aq[i];
            if (q1.a.apply(playlistitem))
            {
                return q1.b;
            }
        }

        return a;
    }
}
