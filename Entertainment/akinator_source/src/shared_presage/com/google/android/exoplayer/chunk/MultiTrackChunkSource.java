// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;

import java.util.List;
import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.TrackInfo;
import shared_presage.com.google.android.exoplayer.util.Assertions;

// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            ChunkSource, ChunkOperationHolder, Chunk

public final class MultiTrackChunkSource
    implements shared_presage.com.google.android.exoplayer.ExoPlayer.ExoPlayerComponent, ChunkSource
{

    public static final int MSG_SELECT_TRACK = 1;
    private final ChunkSource allSources[];
    private boolean enabled;
    private ChunkSource selectedSource;

    public MultiTrackChunkSource(List list)
    {
        this(toChunkSourceArray(list));
    }

    public transient MultiTrackChunkSource(ChunkSource achunksource[])
    {
        allSources = achunksource;
        selectedSource = achunksource[0];
    }

    private static ChunkSource[] toChunkSourceArray(List list)
    {
        ChunkSource achunksource[] = new ChunkSource[list.size()];
        list.toArray(achunksource);
        return achunksource;
    }

    public final void continueBuffering(long l)
    {
        selectedSource.continueBuffering(l);
    }

    public final void disable(List list)
    {
        selectedSource.disable(list);
        enabled = false;
    }

    public final void enable()
    {
        selectedSource.enable();
        enabled = true;
    }

    public final void getChunkOperation(List list, long l, long l1, ChunkOperationHolder chunkoperationholder)
    {
        selectedSource.getChunkOperation(list, l, l1, chunkoperationholder);
    }

    public final void getMaxVideoDimensions(MediaFormat mediaformat)
    {
        selectedSource.getMaxVideoDimensions(mediaformat);
    }

    public final int getTrackCount()
    {
        return allSources.length;
    }

    public final TrackInfo getTrackInfo()
    {
        return selectedSource.getTrackInfo();
    }

    public final void handleMessage(int i, Object obj)
    {
        boolean flag;
        if (!enabled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (i == 1)
        {
            selectedSource = allSources[((Integer)obj).intValue()];
        }
    }

    public final void maybeThrowError()
    {
        selectedSource.maybeThrowError();
    }

    public final void onChunkLoadCompleted(Chunk chunk)
    {
        selectedSource.onChunkLoadCompleted(chunk);
    }

    public final void onChunkLoadError(Chunk chunk, Exception exception)
    {
        selectedSource.onChunkLoadError(chunk, exception);
    }
}
