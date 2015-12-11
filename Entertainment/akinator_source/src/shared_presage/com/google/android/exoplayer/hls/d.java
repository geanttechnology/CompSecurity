// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.hls;

import shared_presage.com.google.android.exoplayer.chunk.Format;

// Referenced classes of package shared_presage.com.google.android.exoplayer.hls:
//            HlsSampleSource

final class d
    implements Runnable
{

    final long a;
    final int b;
    final int c;
    final Format d;
    final long e;
    final long f;
    final HlsSampleSource g;

    d(HlsSampleSource hlssamplesource, long l, int i, int j, Format format, long l1, long l2)
    {
        g = hlssamplesource;
        a = l;
        b = i;
        c = j;
        d = format;
        e = l1;
        f = l2;
        super();
    }

    public final void run()
    {
        HlsSampleSource.access$100(g).onLoadStarted(HlsSampleSource.access$000(g), a, b, c, d, g.usToMs(e), g.usToMs(f));
    }
}
