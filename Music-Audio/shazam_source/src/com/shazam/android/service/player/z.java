// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.player;

import com.rdio.android.sdk.PlayRequest;
import com.rdio.android.sdk.PlayerManager;

// Referenced classes of package com.shazam.android.service.player:
//            a, g

public final class z
    implements a
{

    final PlayerManager a;
    g b;
    int c;
    int d;
    private final String e;

    public z(PlayerManager playermanager, String s)
    {
        b = g.a;
        a = playermanager;
        e = s;
    /* block-local class not found */
    class a {}

        playermanager.addPlayerListener(new a((byte)0));
    }

    public final void a()
    {
        a.play(new PlayRequest(e));
    }

    public final void a(int i)
    {
        c = i;
        a.seekTo(i);
    }

    public final void a(g g1)
    {
        b = g1;
    }

    public final void b()
    {
        a.play();
    }

    public final void c()
    {
        a.pause();
    }

    public final void d()
    {
        a.stop();
    }

    public final void e()
    {
    }

    public final int f()
    {
        return d;
    }

    public final int g()
    {
        return c;
    }

    public final boolean h()
    {
        return a.isPlaying();
    }
}
