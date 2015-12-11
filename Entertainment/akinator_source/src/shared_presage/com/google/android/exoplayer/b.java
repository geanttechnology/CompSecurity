// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            ExoPlayer, c, d, ExoPlaybackException, 
//            TrackRenderer

final class b
    implements ExoPlayer
{

    private final Handler a = new c(this);
    private final d b;
    private final CopyOnWriteArraySet c = new CopyOnWriteArraySet();
    private final boolean d[];
    private final boolean e[];
    private boolean f;
    private int g;
    private int h;

    public b(int i, int j, int k)
    {
        boolean flag = false;
        super();
        Log.i("ExoPlayerImpl", "Init 1.4.2");
        f = false;
        g = 1;
        d = new boolean[i];
        e = new boolean[i];
        for (i = ((flag) ? 1 : 0); i < e.length; i++)
        {
            e[i] = true;
        }

        b = new d(a, f, e, j, k);
    }

    final void a(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 4: default 36
    //                   1 37
    //                   2 107
    //                   3 157
    //                   4 208;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        boolean aflag[] = (boolean[])message.obj;
        System.arraycopy(aflag, 0, d, 0, aflag.length);
        g = message.arg1;
        message = c.iterator();
        while (message.hasNext()) 
        {
            ((ExoPlayer.Listener)message.next()).onPlayerStateChanged(f, g);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        g = message.arg1;
        message = c.iterator();
        while (message.hasNext()) 
        {
            ((ExoPlayer.Listener)message.next()).onPlayerStateChanged(f, g);
        }
        if (true) goto _L1; else goto _L4
_L4:
        h = h - 1;
        if (h == 0)
        {
            message = c.iterator();
            while (message.hasNext()) 
            {
                ((ExoPlayer.Listener)message.next()).onPlayWhenReadyCommitted();
            }
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        message = (ExoPlaybackException)message.obj;
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) 
        {
            ((ExoPlayer.Listener)iterator.next()).onPlayerError(message);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public final void addListener(ExoPlayer.Listener listener)
    {
        c.add(listener);
    }

    public final void blockingSendMessage(ExoPlayer.ExoPlayerComponent exoplayercomponent, int i, Object obj)
    {
        b.b(exoplayercomponent, i, obj);
    }

    public final int getBufferedPercentage()
    {
        long l = 100L;
        long l1 = getBufferedPosition();
        long l2 = getDuration();
        if (l1 == -1L || l2 == -1L)
        {
            return 0;
        }
        if (l2 != 0L)
        {
            l = (100L * l1) / l2;
        }
        return (int)l;
    }

    public final long getBufferedPosition()
    {
        return b.c();
    }

    public final long getCurrentPosition()
    {
        return b.b();
    }

    public final long getDuration()
    {
        return b.d();
    }

    public final boolean getPlayWhenReady()
    {
        return f;
    }

    public final Looper getPlaybackLooper()
    {
        return b.a();
    }

    public final int getPlaybackState()
    {
        return g;
    }

    public final boolean getRendererEnabled(int i)
    {
        return e[i];
    }

    public final boolean getRendererHasMedia(int i)
    {
        return d[i];
    }

    public final boolean isPlayWhenReadyCommitted()
    {
        return h == 0;
    }

    public final transient void prepare(TrackRenderer atrackrenderer[])
    {
        Arrays.fill(d, false);
        b.a(atrackrenderer);
    }

    public final void release()
    {
        b.f();
        a.removeCallbacksAndMessages(null);
    }

    public final void removeListener(ExoPlayer.Listener listener)
    {
        c.remove(listener);
    }

    public final void seekTo(long l)
    {
        b.a(l);
    }

    public final void sendMessage(ExoPlayer.ExoPlayerComponent exoplayercomponent, int i, Object obj)
    {
        b.a(exoplayercomponent, i, obj);
    }

    public final void setPlayWhenReady(boolean flag)
    {
        if (f != flag)
        {
            f = flag;
            h = h + 1;
            b.a(flag);
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((ExoPlayer.Listener)iterator.next()).onPlayerStateChanged(flag, g)) { }
        }
    }

    public final void setRendererEnabled(int i, boolean flag)
    {
        if (e[i] != flag)
        {
            e[i] = flag;
            b.a(i, flag);
        }
    }

    public final void stop()
    {
        b.e();
    }
}
