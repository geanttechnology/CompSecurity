// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;


// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            ChunkSampleSource, Format

final class a
    implements Runnable
{

    final long a;
    final int b;
    final int c;
    final Format d;
    final long e;
    final long f;
    final ChunkSampleSource g;

    a(ChunkSampleSource chunksamplesource, long l, int i, int j, Format format, long l1, long l2)
    {
        g = chunksamplesource;
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
        ChunkSampleSource.access$100(g).onLoadStarted(ChunkSampleSource.access$000(g), a, b, c, d, g.usToMs(e), g.usToMs(f));
    }
}
