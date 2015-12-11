// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.hls;

import shared_presage.com.google.android.exoplayer.chunk.Format;

// Referenced classes of package shared_presage.com.google.android.exoplayer.hls:
//            HlsSampleSource

final class h
    implements Runnable
{

    final Format a;
    final int b;
    final long c;
    final HlsSampleSource d;

    h(HlsSampleSource hlssamplesource, Format format, int i, long l)
    {
        d = hlssamplesource;
        a = format;
        b = i;
        c = l;
        super();
    }

    public final void run()
    {
        HlsSampleSource.access$100(d).onDownstreamFormatChanged(HlsSampleSource.access$000(d), a, b, d.usToMs(c));
    }
}
