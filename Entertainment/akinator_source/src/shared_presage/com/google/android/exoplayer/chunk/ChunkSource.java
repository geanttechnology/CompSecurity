// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;

import java.util.List;
import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.TrackInfo;

// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            ChunkOperationHolder, Chunk

public interface ChunkSource
{

    public abstract void continueBuffering(long l);

    public abstract void disable(List list);

    public abstract void enable();

    public abstract void getChunkOperation(List list, long l, long l1, ChunkOperationHolder chunkoperationholder);

    public abstract void getMaxVideoDimensions(MediaFormat mediaformat);

    public abstract TrackInfo getTrackInfo();

    public abstract void maybeThrowError();

    public abstract void onChunkLoadCompleted(Chunk chunk);

    public abstract void onChunkLoadError(Chunk chunk, Exception exception);
}
