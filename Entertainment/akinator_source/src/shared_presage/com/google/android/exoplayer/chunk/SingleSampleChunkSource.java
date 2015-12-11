// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;

import java.util.List;
import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.TrackInfo;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;

// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            ChunkSource, Format, SingleSampleMediaChunk, ChunkOperationHolder, 
//            Chunk

public final class SingleSampleChunkSource
    implements ChunkSource
{

    private final DataSource dataSource;
    private final DataSpec dataSpec;
    private final long durationUs;
    private final Format format;
    private final MediaFormat mediaFormat;
    private final TrackInfo trackInfo;

    public SingleSampleChunkSource(DataSource datasource, DataSpec dataspec, Format format1, long l, MediaFormat mediaformat)
    {
        dataSource = datasource;
        dataSpec = dataspec;
        format = format1;
        durationUs = l;
        mediaFormat = mediaformat;
        trackInfo = new TrackInfo(format1.mimeType, l);
    }

    private SingleSampleMediaChunk initChunk()
    {
        return new SingleSampleMediaChunk(dataSource, dataSpec, 0, format, 0L, durationUs, 0, true, mediaFormat, null, null);
    }

    public final void continueBuffering(long l)
    {
    }

    public final void disable(List list)
    {
    }

    public final void enable()
    {
    }

    public final void getChunkOperation(List list, long l, long l1, ChunkOperationHolder chunkoperationholder)
    {
        if (!list.isEmpty())
        {
            return;
        } else
        {
            chunkoperationholder.chunk = initChunk();
            return;
        }
    }

    public final void getMaxVideoDimensions(MediaFormat mediaformat)
    {
    }

    public final TrackInfo getTrackInfo()
    {
        return trackInfo;
    }

    public final void maybeThrowError()
    {
    }

    public final void onChunkLoadCompleted(Chunk chunk)
    {
    }

    public final void onChunkLoadError(Chunk chunk, Exception exception)
    {
    }
}
