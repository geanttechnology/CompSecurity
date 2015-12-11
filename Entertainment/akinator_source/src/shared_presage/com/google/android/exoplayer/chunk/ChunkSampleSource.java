// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;

import android.os.Handler;
import android.os.SystemClock;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import shared_presage.com.google.android.exoplayer.LoadControl;
import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.MediaFormatHolder;
import shared_presage.com.google.android.exoplayer.SampleHolder;
import shared_presage.com.google.android.exoplayer.SampleSource;
import shared_presage.com.google.android.exoplayer.TrackInfo;
import shared_presage.com.google.android.exoplayer.extractor.DefaultTrackOutput;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;
import shared_presage.com.google.android.exoplayer.upstream.Loader;
import shared_presage.com.google.android.exoplayer.util.Assertions;

// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            ChunkOperationHolder, BaseMediaChunk, Chunk, f, 
//            c, b, d, a, 
//            e, ChunkSource, MediaChunk, Format, 
//            BaseChunkSampleSourceEventListener

public class ChunkSampleSource
    implements SampleSource, shared_presage.com.google.android.exoplayer.SampleSource.SampleSourceReader, shared_presage.com.google.android.exoplayer.upstream.Loader.Callback
{
    public static interface EventListener
        extends BaseChunkSampleSourceEventListener
    {
    }


    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    private static final int NO_RESET_PENDING = -1;
    private static final int STATE_ENABLED = 3;
    private static final int STATE_IDLE = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_PREPARED = 2;
    private final int bufferSizeContribution;
    private final ChunkSource chunkSource;
    private long currentLoadStartTimeMs;
    private IOException currentLoadableException;
    private int currentLoadableExceptionCount;
    private long currentLoadableExceptionTimestamp;
    private final ChunkOperationHolder currentLoadableHolder;
    private Format downstreamFormat;
    private MediaFormat downstreamMediaFormat;
    private long downstreamPositionUs;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private final int eventSourceId;
    private long lastPerformedBufferOperation;
    private long lastSeekPositionUs;
    private final LoadControl loadControl;
    private Loader loader;
    private boolean loadingFinished;
    private final LinkedList mediaChunks;
    private final int minLoadableRetryCount;
    private boolean pendingDiscontinuity;
    private long pendingResetPositionUs;
    private final List readOnlyMediaChunks;
    private final DefaultTrackOutput sampleQueue;
    private int state;

    public ChunkSampleSource(ChunkSource chunksource, LoadControl loadcontrol, int i)
    {
        this(chunksource, loadcontrol, i, null, null, 0);
    }

    public ChunkSampleSource(ChunkSource chunksource, LoadControl loadcontrol, int i, Handler handler, EventListener eventlistener, int j)
    {
        this(chunksource, loadcontrol, i, handler, eventlistener, j, 3);
    }

    public ChunkSampleSource(ChunkSource chunksource, LoadControl loadcontrol, int i, Handler handler, EventListener eventlistener, int j, int k)
    {
        chunkSource = chunksource;
        loadControl = loadcontrol;
        bufferSizeContribution = i;
        eventHandler = handler;
        eventListener = eventlistener;
        eventSourceId = j;
        minLoadableRetryCount = k;
        currentLoadableHolder = new ChunkOperationHolder();
        mediaChunks = new LinkedList();
        readOnlyMediaChunks = Collections.unmodifiableList(mediaChunks);
        sampleQueue = new DefaultTrackOutput(loadcontrol.getAllocator());
        state = 0;
        pendingResetPositionUs = -1L;
    }

    private void clearCurrentLoadable()
    {
        currentLoadableHolder.chunk = null;
        clearCurrentLoadableException();
    }

    private void clearCurrentLoadableException()
    {
        currentLoadableException = null;
        currentLoadableExceptionCount = 0;
    }

    private boolean discardUpstreamMediaChunks(int i)
    {
        if (mediaChunks.size() <= i)
        {
            return false;
        }
        long l = 0L;
        long l1 = ((BaseMediaChunk)mediaChunks.getLast()).endTimeUs;
        BaseMediaChunk basemediachunk = null;
        while (mediaChunks.size() > i) 
        {
            basemediachunk = (BaseMediaChunk)mediaChunks.removeLast();
            l = basemediachunk.startTimeUs;
        }
        sampleQueue.discardUpstreamSamples(basemediachunk.getFirstSampleIndex());
        notifyUpstreamDiscarded(l, l1);
        return true;
    }

    private long getNextLoadPositionUs()
    {
        if (isPendingReset())
        {
            return pendingResetPositionUs;
        }
        BaseMediaChunk basemediachunk = (BaseMediaChunk)mediaChunks.getLast();
        if (basemediachunk.isLastChunk)
        {
            return -1L;
        } else
        {
            return basemediachunk.endTimeUs;
        }
    }

    private long getRetryDelayMillis(long l)
    {
        return Math.min((l - 1L) * 1000L, 5000L);
    }

    private boolean isMediaChunk(Chunk chunk)
    {
        return chunk instanceof BaseMediaChunk;
    }

    private boolean isPendingReset()
    {
        return pendingResetPositionUs != -1L;
    }

    private void maybeStartLoading()
    {
        Chunk chunk = currentLoadableHolder.chunk;
        if (chunk == null)
        {
            return;
        }
        currentLoadStartTimeMs = SystemClock.elapsedRealtime();
        if (isMediaChunk(chunk))
        {
            BaseMediaChunk basemediachunk = (BaseMediaChunk)chunk;
            basemediachunk.init(sampleQueue);
            mediaChunks.add(basemediachunk);
            if (isPendingReset())
            {
                pendingResetPositionUs = -1L;
            }
            notifyLoadStarted(basemediachunk.dataSpec.length, basemediachunk.type, basemediachunk.trigger, basemediachunk.format, basemediachunk.startTimeUs, basemediachunk.endTimeUs);
        } else
        {
            notifyLoadStarted(chunk.dataSpec.length, chunk.type, chunk.trigger, chunk.format, -1L, -1L);
        }
        loader.startLoading(chunk, this);
    }

    private void notifyDownstreamFormatChanged(Format format, int i, long l)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new f(this, format, i, l));
        }
    }

    private void notifyLoadCanceled(long l)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new c(this, l));
        }
    }

    private void notifyLoadCompleted(long l, int i, int j, Format format, long l1, 
            long l2, long l3, long l4)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new b(this, l, i, j, format, l1, l2, l3, l4));
        }
    }

    private void notifyLoadError(IOException ioexception)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new d(this, ioexception));
        }
    }

    private void notifyLoadStarted(long l, int i, int j, Format format, long l1, 
            long l2)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new a(this, l, i, j, format, l1, l2));
        }
    }

    private void notifyUpstreamDiscarded(long l, long l1)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new e(this, l, l1));
        }
    }

    private void restartFrom(long l)
    {
        pendingResetPositionUs = l;
        loadingFinished = false;
        if (loader.isLoading())
        {
            loader.cancelLoading();
            return;
        } else
        {
            sampleQueue.clear();
            mediaChunks.clear();
            clearCurrentLoadable();
            updateLoadControl();
            return;
        }
    }

    private void resumeFromBackOff()
    {
        currentLoadableException = null;
        Chunk chunk = currentLoadableHolder.chunk;
        if (!isMediaChunk(chunk))
        {
            currentLoadableHolder.queueSize = readOnlyMediaChunks.size();
            chunkSource.getChunkOperation(readOnlyMediaChunks, pendingResetPositionUs, downstreamPositionUs, currentLoadableHolder);
            discardUpstreamMediaChunks(currentLoadableHolder.queueSize);
            if (currentLoadableHolder.chunk == chunk)
            {
                loader.startLoading(chunk, this);
                return;
            } else
            {
                notifyLoadCanceled(chunk.bytesLoaded());
                maybeStartLoading();
                return;
            }
        }
        if (chunk == mediaChunks.getFirst())
        {
            loader.startLoading(chunk, this);
            return;
        }
        BaseMediaChunk basemediachunk = (BaseMediaChunk)mediaChunks.removeLast();
        boolean flag;
        if (chunk == basemediachunk)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        currentLoadableHolder.queueSize = readOnlyMediaChunks.size();
        chunkSource.getChunkOperation(readOnlyMediaChunks, pendingResetPositionUs, downstreamPositionUs, currentLoadableHolder);
        mediaChunks.add(basemediachunk);
        if (currentLoadableHolder.chunk == chunk)
        {
            loader.startLoading(chunk, this);
            return;
        } else
        {
            notifyLoadCanceled(chunk.bytesLoaded());
            discardUpstreamMediaChunks(currentLoadableHolder.queueSize);
            clearCurrentLoadableException();
            maybeStartLoading();
            return;
        }
    }

    private void updateLoadControl()
    {
        long l;
        boolean flag1;
        boolean flag2;
        long l1 = SystemClock.elapsedRealtime();
        l = getNextLoadPositionUs();
        boolean flag;
        if (currentLoadableException != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (loader.isLoading() || flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 || (currentLoadableHolder.chunk != null || l == -1L) && l1 - lastPerformedBufferOperation <= 2000L) goto _L2; else goto _L1
_L1:
        lastPerformedBufferOperation = l1;
        currentLoadableHolder.queueSize = readOnlyMediaChunks.size();
        chunkSource.getChunkOperation(readOnlyMediaChunks, pendingResetPositionUs, downstreamPositionUs, currentLoadableHolder);
        flag2 = discardUpstreamMediaChunks(currentLoadableHolder.queueSize);
        if (currentLoadableHolder.chunk != null) goto _L4; else goto _L3
_L3:
        l = -1L;
_L2:
        flag1 = loadControl.update(this, downstreamPositionUs, l, flag1);
        if (!flag) goto _L6; else goto _L5
_L5:
        if (l1 - currentLoadableExceptionTimestamp >= getRetryDelayMillis(currentLoadableExceptionCount))
        {
            resumeFromBackOff();
        }
_L8:
        return;
_L4:
        if (flag2)
        {
            l = getNextLoadPositionUs();
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (loader.isLoading() || !flag1) goto _L8; else goto _L7
_L7:
        maybeStartLoading();
        return;
        if (true) goto _L2; else goto _L9
_L9:
    }

    public boolean continueBuffering(int i, long l)
    {
label0:
        {
            boolean flag1 = false;
            boolean flag;
            if (state == 3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            if (i == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            downstreamPositionUs = l;
            chunkSource.continueBuffering(l);
            updateLoadControl();
            if (!loadingFinished)
            {
                flag = flag1;
                if (sampleQueue.isEmpty())
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public void disable(int i)
    {
        boolean flag1 = true;
        boolean flag;
        if (state == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (i == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        state = 2;
        chunkSource.disable(mediaChunks);
        loadControl.unregister(this);
        if (loader.isLoading())
        {
            loader.cancelLoading();
            return;
        } else
        {
            sampleQueue.clear();
            mediaChunks.clear();
            clearCurrentLoadable();
            loadControl.trimAllocator();
            return;
        }
        Exception exception;
        exception;
        loadControl.unregister(this);
        if (loader.isLoading())
        {
            loader.cancelLoading();
        } else
        {
            sampleQueue.clear();
            mediaChunks.clear();
            clearCurrentLoadable();
            loadControl.trimAllocator();
        }
        throw exception;
    }

    public void enable(int i, long l)
    {
        boolean flag1 = true;
        boolean flag;
        if (state == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (i == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        state = 3;
        chunkSource.enable();
        loadControl.register(this, bufferSizeContribution);
        downstreamFormat = null;
        downstreamMediaFormat = null;
        downstreamPositionUs = l;
        lastSeekPositionUs = l;
        pendingDiscontinuity = false;
        restartFrom(l);
    }

    public long getBufferedPositionUs()
    {
        long l;
        boolean flag;
        if (state == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (isPendingReset())
        {
            l = pendingResetPositionUs;
        } else
        {
            if (loadingFinished)
            {
                return -3L;
            }
            long l1 = sampleQueue.getLargestParsedTimestampUs();
            l = l1;
            if (l1 == 0x8000000000000000L)
            {
                return downstreamPositionUs;
            }
        }
        return l;
    }

    public int getTrackCount()
    {
        boolean flag;
        if (state == 2 || state == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        return 1;
    }

    public TrackInfo getTrackInfo(int i)
    {
        boolean flag1 = true;
        boolean flag;
        if (state == 2 || state == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (i == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        return chunkSource.getTrackInfo();
    }

    public void maybeThrowError()
    {
        if (currentLoadableException != null && currentLoadableExceptionCount > minLoadableRetryCount)
        {
            throw currentLoadableException;
        }
        if (currentLoadableHolder.chunk == null)
        {
            chunkSource.maybeThrowError();
        }
    }

    public void onLoadCanceled(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        notifyLoadCanceled(currentLoadableHolder.chunk.bytesLoaded());
        clearCurrentLoadable();
        if (state == 3)
        {
            restartFrom(pendingResetPositionUs);
            return;
        } else
        {
            sampleQueue.clear();
            mediaChunks.clear();
            clearCurrentLoadable();
            loadControl.trimAllocator();
            return;
        }
    }

    public void onLoadCompleted(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        long l = SystemClock.elapsedRealtime();
        long l1 = l - currentLoadStartTimeMs;
        loadable = currentLoadableHolder.chunk;
        chunkSource.onChunkLoadCompleted(loadable);
        if (isMediaChunk(loadable))
        {
            MediaChunk mediachunk = (MediaChunk)loadable;
            notifyLoadCompleted(loadable.bytesLoaded(), mediachunk.type, mediachunk.trigger, mediachunk.format, mediachunk.startTimeUs, mediachunk.endTimeUs, l, l1);
            loadingFinished = ((BaseMediaChunk)loadable).isLastChunk;
        } else
        {
            notifyLoadCompleted(loadable.bytesLoaded(), ((Chunk) (loadable)).type, ((Chunk) (loadable)).trigger, ((Chunk) (loadable)).format, -1L, -1L, l, l1);
        }
        clearCurrentLoadable();
        updateLoadControl();
    }

    public void onLoadError(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable, IOException ioexception)
    {
        currentLoadableException = ioexception;
        currentLoadableExceptionCount = currentLoadableExceptionCount + 1;
        currentLoadableExceptionTimestamp = SystemClock.elapsedRealtime();
        notifyLoadError(ioexception);
        chunkSource.onChunkLoadError(currentLoadableHolder.chunk, ioexception);
        updateLoadControl();
    }

    protected void onSampleRead(MediaChunk mediachunk, SampleHolder sampleholder)
    {
    }

    public boolean prepare(long l)
    {
        boolean flag;
        if (state == 1 || state == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (state == 2)
        {
            return true;
        } else
        {
            loader = new Loader((new StringBuilder("Loader:")).append(chunkSource.getTrackInfo().mimeType).toString());
            state = 2;
            return true;
        }
    }

    public int readData(int i, long l, MediaFormatHolder mediaformatholder, SampleHolder sampleholder, boolean flag)
    {
        boolean flag1;
        if (state == 3)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        if (i == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        downstreamPositionUs = l;
        if (pendingDiscontinuity)
        {
            pendingDiscontinuity = false;
            return -5;
        }
        if (flag)
        {
            return -2;
        }
        if (isPendingReset())
        {
            return -2;
        }
        BaseMediaChunk basemediachunk;
        if (!sampleQueue.isEmpty())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        for (basemediachunk = (BaseMediaChunk)mediaChunks.getFirst(); i != 0 && mediaChunks.size() > 1 && ((BaseMediaChunk)mediaChunks.get(1)).getFirstSampleIndex() == sampleQueue.getReadIndex(); basemediachunk = (BaseMediaChunk)mediaChunks.getFirst())
        {
            mediaChunks.removeFirst();
        }

        if (downstreamFormat == null || !downstreamFormat.equals(basemediachunk.format))
        {
            notifyDownstreamFormatChanged(basemediachunk.format, basemediachunk.trigger, basemediachunk.startTimeUs);
            downstreamFormat = basemediachunk.format;
        }
        if (i != 0 || basemediachunk.isMediaFormatFinal)
        {
            MediaFormat mediaformat = basemediachunk.getMediaFormat();
            if (!mediaformat.equals(downstreamMediaFormat, true))
            {
                chunkSource.getMaxVideoDimensions(mediaformat);
                mediaformatholder.format = mediaformat;
                mediaformatholder.drmInitData = basemediachunk.getDrmInitData();
                downstreamMediaFormat = mediaformat;
                return -4;
            }
        }
        if (i == 0)
        {
            return !loadingFinished ? -2 : -1;
        }
        if (sampleQueue.getSample(sampleholder))
        {
            int j;
            if (sampleholder.timeUs < lastSeekPositionUs)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            j = sampleholder.flags;
            if (i != 0)
            {
                i = 0x8000000;
            } else
            {
                i = 0;
            }
            sampleholder.flags = i | j;
            onSampleRead(basemediachunk, sampleholder);
            return -3;
        } else
        {
            return -2;
        }
    }

    public shared_presage.com.google.android.exoplayer.SampleSource.SampleSourceReader register()
    {
        boolean flag;
        if (state == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        state = 1;
        return this;
    }

    public void release()
    {
        boolean flag;
        if (state != 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (loader != null)
        {
            loader.release();
            loader = null;
        }
        state = 0;
    }

    public void seekToUs(long l)
    {
        boolean flag1 = false;
        long l1;
        boolean flag2;
        if (state == 3)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        Assertions.checkState(flag2);
        if (isPendingReset())
        {
            l1 = pendingResetPositionUs;
        } else
        {
            l1 = downstreamPositionUs;
        }
        downstreamPositionUs = l;
        lastSeekPositionUs = l;
        if (l1 == l)
        {
            return;
        }
        boolean flag;
        if (!isPendingReset() && sampleQueue.skipToKeyframeBefore(l))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            flag = flag1;
            if (!sampleQueue.isEmpty())
            {
                flag = true;
            }
            for (; flag && mediaChunks.size() > 1 && ((BaseMediaChunk)mediaChunks.get(1)).getFirstSampleIndex() <= sampleQueue.getReadIndex(); mediaChunks.removeFirst()) { }
        } else
        {
            restartFrom(l);
        }
        pendingDiscontinuity = true;
    }

    protected final int usToMs(long l)
    {
        return (int)(l / 1000L);
    }


}
