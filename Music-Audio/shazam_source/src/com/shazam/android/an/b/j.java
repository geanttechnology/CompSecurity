// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import android.content.Context;
import com.shazam.f.d;
import com.shazam.model.spotify.SpotifyConnectionState;
import com.spotify.sdk.android.player.Config;
import com.spotify.sdk.android.player.Player;
import com.spotify.sdk.android.player.Spotify;
import java.util.concurrent.Semaphore;

// Referenced classes of package com.shazam.android.an.b:
//            k

public final class j
    implements k
{
    private final class a
        implements com.spotify.sdk.android.player.Player.InitializationObserver
    {

        final j a;

        public final void onError(Throwable throwable)
        {
            a.b = throwable;
            a.a.release();
        }

        public final void onInitialized(Player player)
        {
            a.a.release();
        }

        private a()
        {
            a = j.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    final Semaphore a = new Semaphore(0);
    Throwable b;
    private Object c;
    private final Context d;
    private final SpotifyConnectionState e;
    private Player f;

    public j(Context context, SpotifyConnectionState spotifyconnectionstate)
    {
        d = context;
        e = spotifyconnectionstate;
    }

    private Player c()
    {
        if (c == null)
        {
            c = new Object();
        }
        Object obj = new Config(d, e.c(), "f87c03896d274ecf9d80f86e942202e1");
        try
        {
            obj = Spotify.getPlayer(((Config) (obj)), c, new a((byte)0));
        }
        catch (Throwable throwable)
        {
            d();
            throw new d("Could not initialise Spotify Player", throwable);
        }
        return ((Player) (obj));
    }

    private void d()
    {
        c = null;
        b = null;
        f = null;
        a.drainPermits();
    }

    public final Player a()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = f;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        Throwable throwable;
        obj = c();
        a.acquire();
        throwable = b;
        if (throwable == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        try
        {
            d();
            throw new d("Error initializing spotify player", throwable);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            this;
        }
        d();
        throw new d("Could not acquire semaphore while getting spotify player", ((Throwable) (obj)));
        throw obj;
        f = ((Player) (obj));
        obj = f;
        this;
        JVM INSTR monitorexit ;
        return ((Player) (obj));
    }

    public final void b()
    {
        if (c != null)
        {
            Spotify.destroyPlayer(c);
        }
        d();
    }
}
