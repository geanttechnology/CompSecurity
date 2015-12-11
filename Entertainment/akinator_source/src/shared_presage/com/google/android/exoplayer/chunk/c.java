// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;


// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            ChunkSampleSource

final class c
    implements Runnable
{

    final long a;
    final ChunkSampleSource b;

    c(ChunkSampleSource chunksamplesource, long l)
    {
        b = chunksamplesource;
        a = l;
        super();
    }

    public final void run()
    {
        ChunkSampleSource.access$100(b).onLoadCanceled(ChunkSampleSource.access$000(b), a);
    }
}
