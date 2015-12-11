// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;


// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            ChunkSampleSource, Format

final class f
    implements Runnable
{

    final Format a;
    final int b;
    final long c;
    final ChunkSampleSource d;

    f(ChunkSampleSource chunksamplesource, Format format, int i, long l)
    {
        d = chunksamplesource;
        a = format;
        b = i;
        c = l;
        super();
    }

    public final void run()
    {
        ChunkSampleSource.access$100(d).onDownstreamFormatChanged(ChunkSampleSource.access$000(d), a, b, d.usToMs(c));
    }
}
