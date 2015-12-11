// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v4.media.session:
//            PlaybackStateCompat

public static final class j
{

    public long a;
    private final List b;
    private int c;
    private long d;
    private long e;
    private float f;
    private CharSequence g;
    private long h;
    private long i;
    private Bundle j;

    public final j a(int k)
    {
        return a(k, -1L, 0.0F, SystemClock.elapsedRealtime());
    }

    public final a a(int k, long l, float f1, long l1)
    {
        c = k;
        d = l;
        h = l1;
        f = f1;
        return this;
    }

    public final PlaybackStateCompat a()
    {
        return new PlaybackStateCompat(c, d, e, f, a, g, h, b, i, j, (byte)0);
    }

    public ()
    {
        b = new ArrayList();
        i = -1L;
    }

    public i(PlaybackStateCompat playbackstatecompat)
    {
        b = new ArrayList();
        i = -1L;
        c = PlaybackStateCompat.a(playbackstatecompat);
        d = PlaybackStateCompat.b(playbackstatecompat);
        f = PlaybackStateCompat.c(playbackstatecompat);
        h = PlaybackStateCompat.d(playbackstatecompat);
        e = PlaybackStateCompat.e(playbackstatecompat);
        a = PlaybackStateCompat.f(playbackstatecompat);
        g = PlaybackStateCompat.g(playbackstatecompat);
        if (PlaybackStateCompat.h(playbackstatecompat) != null)
        {
            b.addAll(PlaybackStateCompat.h(playbackstatecompat));
        }
        i = PlaybackStateCompat.i(playbackstatecompat);
        j = PlaybackStateCompat.j(playbackstatecompat);
    }
}
