// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.TrackInfo;
import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            ChunkSource, ChunkOperationHolder, Chunk

public final class MultiTrackChunkSource
    implements ChunkSource, com.google.android.exoplayer.ExoPlayer.ExoPlayerComponent
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

    public void continueBuffering(long l)
    {
        selectedSource.continueBuffering(l);
    }

    public void disable(List list)
    {
        selectedSource.disable(list);
        enabled = false;
    }

    public void enable()
    {
        selectedSource.enable();
        enabled = true;
    }

    public void getChunkOperation(List list, long l, long l1, ChunkOperationHolder chunkoperationholder)
    {
        selectedSource.getChunkOperation(list, l, l1, chunkoperationholder);
    }

    public void getMaxVideoDimensions(MediaFormat mediaformat)
    {
        selectedSource.getMaxVideoDimensions(mediaformat);
    }

    public int getTrackCount()
    {
        return allSources.length;
    }

    public TrackInfo getTrackInfo()
    {
        return selectedSource.getTrackInfo();
    }

    public void handleMessage(int i, Object obj)
        throws ExoPlaybackException
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

    public void maybeThrowError()
        throws IOException
    {
        selectedSource.maybeThrowError();
    }

    public void onChunkLoadCompleted(Chunk chunk)
    {
        selectedSource.onChunkLoadCompleted(chunk);
    }

    public void onChunkLoadError(Chunk chunk, Exception exception)
    {
        selectedSource.onChunkLoadError(chunk, exception);
    }
}
