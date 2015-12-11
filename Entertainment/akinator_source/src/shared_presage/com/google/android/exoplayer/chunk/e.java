// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;


// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            ChunkSampleSource

final class e
    implements Runnable
{

    final long a;
    final long b;
    final ChunkSampleSource c;

    e(ChunkSampleSource chunksamplesource, long l, long l1)
    {
        c = chunksamplesource;
        a = l;
        b = l1;
        super();
    }

    public final void run()
    {
        ChunkSampleSource.access$100(c).onUpstreamDiscarded(ChunkSampleSource.access$000(c), c.usToMs(a), c.usToMs(b));
    }
}
