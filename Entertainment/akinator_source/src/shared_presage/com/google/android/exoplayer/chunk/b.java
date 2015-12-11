// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;


// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            ChunkSampleSource, Format

final class b
    implements Runnable
{

    final long a;
    final int b;
    final int c;
    final Format d;
    final long e;
    final long f;
    final long g;
    final long h;
    final ChunkSampleSource i;

    b(ChunkSampleSource chunksamplesource, long l, int j, int k, Format format, long l1, long l2, long l3, long l4)
    {
        i = chunksamplesource;
        a = l;
        b = j;
        c = k;
        d = format;
        e = l1;
        f = l2;
        g = l3;
        h = l4;
        super();
    }

    public final void run()
    {
        ChunkSampleSource.access$100(i).onLoadCompleted(ChunkSampleSource.access$000(i), a, b, c, d, i.usToMs(e), i.usToMs(f), g, h);
    }
}
