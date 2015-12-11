// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.hls;

import android.os.Handler;
import android.os.SystemClock;
import java.io.IOException;
import java.util.LinkedList;
import shared_presage.com.google.android.exoplayer.LoadControl;
import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.MediaFormatHolder;
import shared_presage.com.google.android.exoplayer.SampleHolder;
import shared_presage.com.google.android.exoplayer.SampleSource;
import shared_presage.com.google.android.exoplayer.TrackInfo;
import shared_presage.com.google.android.exoplayer.chunk.BaseChunkSampleSourceEventListener;
import shared_presage.com.google.android.exoplayer.chunk.Chunk;
import shared_presage.com.google.android.exoplayer.chunk.Format;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;
import shared_presage.com.google.android.exoplayer.upstream.Loader;
import shared_presage.com.google.android.exoplayer.util.Assertions;

// Referenced classes of package shared_presage.com.google.android.exoplayer.hls:
//            HlsExtractorWrapper, TsChunk, HlsChunkSource, h, 
//            f, e, g, d

public final class HlsSampleSource
    implements SampleSource, shared_presage.com.google.android.exoplayer.SampleSource.SampleSourceReader, shared_presage.com.google.android.exoplayer.upstream.Loader.Callback
{
    public static interface EventListener
        extends BaseChunkSampleSourceEventListener
    {
    }


    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    private static final int NO_RESET_PENDING = -1;
    private final int bufferSizeContribution;
    private final HlsChunkSource chunkSource;
    private long currentLoadStartTimeMs;
    private Chunk currentLoadable;
    private IOException currentLoadableException;
    private int currentLoadableExceptionCount;
    private long currentLoadableExceptionTimestamp;
    private TsChunk currentTsLoadable;
    private Format downstreamFormat;
    private MediaFormat downstreamMediaFormats[];
    private long downstreamPositionUs;
    private int enabledTrackCount;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private final int eventSourceId;
    private final LinkedList extractors;
    private long lastSeekPositionUs;
    private final LoadControl loadControl;
    private boolean loadControlRegistered;
    private Loader loader;
    private boolean loadingFinished;
    private final int minLoadableRetryCount;
    private boolean pendingDiscontinuities[];
    private long pendingResetPositionUs;
    private boolean prepared;
    private TsChunk previousTsLoadable;
    private int remainingReleaseCount;
    private int trackCount;
    private boolean trackEnabledStates[];
    private TrackInfo trackInfos[];

    public HlsSampleSource(HlsChunkSource hlschunksource, LoadControl loadcontrol, int i)
    {
        this(hlschunksource, loadcontrol, i, null, null, 0);
    }

    public HlsSampleSource(HlsChunkSource hlschunksource, LoadControl loadcontrol, int i, Handler handler, EventListener eventlistener, int j)
    {
        this(hlschunksource, loadcontrol, i, handler, eventlistener, j, 3);
    }

    public HlsSampleSource(HlsChunkSource hlschunksource, LoadControl loadcontrol, int i, Handler handler, EventListener eventlistener, int j, int k)
    {
        chunkSource = hlschunksource;
        loadControl = loadcontrol;
        bufferSizeContribution = i;
        minLoadableRetryCount = k;
        eventHandler = handler;
        eventListener = eventlistener;
        eventSourceId = j;
        pendingResetPositionUs = -1L;
        extractors = new LinkedList();
    }

    private void clearCurrentLoadable()
    {
        currentTsLoadable = null;
        currentLoadable = null;
        currentLoadableException = null;
        currentLoadableExceptionCount = 0;
    }

    private void clearState()
    {
        for (int i = 0; i < extractors.size(); i++)
        {
            ((HlsExtractorWrapper)extractors.get(i)).clear();
        }

        extractors.clear();
        clearCurrentLoadable();
        previousTsLoadable = null;
    }

    private void discardSamplesForDisabledTracks(HlsExtractorWrapper hlsextractorwrapper, long l)
    {
        if (hlsextractorwrapper.isPrepared())
        {
            int i = 0;
            while (i < trackEnabledStates.length) 
            {
                if (!trackEnabledStates[i])
                {
                    hlsextractorwrapper.discardUntil(i, l);
                }
                i++;
            }
        }
    }

    private HlsExtractorWrapper getCurrentExtractor()
    {
        HlsExtractorWrapper hlsextractorwrapper;
        for (hlsextractorwrapper = (HlsExtractorWrapper)extractors.getFirst(); extractors.size() > 1 && !haveSamplesForEnabledTracks(hlsextractorwrapper); hlsextractorwrapper = (HlsExtractorWrapper)extractors.getFirst())
        {
            ((HlsExtractorWrapper)extractors.removeFirst()).clear();
        }

        return hlsextractorwrapper;
    }

    private long getNextLoadPositionUs()
    {
        long l = -1L;
        if (!isPendingReset()) goto _L2; else goto _L1
_L1:
        l = pendingResetPositionUs;
_L4:
        return l;
_L2:
        if (currentTsLoadable == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (currentTsLoadable.isLastChunk) goto _L4; else goto _L3
_L3:
        return currentTsLoadable.endTimeUs;
        if (previousTsLoadable.isLastChunk) goto _L4; else goto _L5
_L5:
        return previousTsLoadable.endTimeUs;
    }

    private long getRetryDelayMillis(long l)
    {
        return Math.min((l - 1L) * 1000L, 5000L);
    }

    private boolean haveSamplesForEnabledTracks(HlsExtractorWrapper hlsextractorwrapper)
    {
        if (hlsextractorwrapper.isPrepared())
        {
            int i = 0;
            while (i < trackEnabledStates.length) 
            {
                if (trackEnabledStates[i] && hlsextractorwrapper.hasSamples(i))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    private boolean isPendingReset()
    {
        return pendingResetPositionUs != -1L;
    }

    private boolean isTsChunk(Chunk chunk)
    {
        return chunk instanceof TsChunk;
    }

    private void maybeStartLoading()
    {
        long l = SystemClock.elapsedRealtime();
        long l1 = getNextLoadPositionUs();
        boolean flag;
        boolean flag1;
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
        flag1 = loadControl.update(this, downstreamPositionUs, l1, flag1);
        if (flag)
        {
            if (l - currentLoadableExceptionTimestamp >= getRetryDelayMillis(currentLoadableExceptionCount))
            {
                currentLoadableException = null;
                loader.startLoading(currentLoadable, this);
            }
        } else
        if (!loader.isLoading() && flag1)
        {
            Chunk chunk = chunkSource.getChunkOperation(previousTsLoadable, pendingResetPositionUs, downstreamPositionUs);
            if (chunk != null)
            {
                currentLoadStartTimeMs = l;
                currentLoadable = chunk;
                if (isTsChunk(currentLoadable))
                {
                    TsChunk tschunk = (TsChunk)currentLoadable;
                    if (isPendingReset())
                    {
                        pendingResetPositionUs = -1L;
                    }
                    HlsExtractorWrapper hlsextractorwrapper = tschunk.extractorWrapper;
                    if (extractors.isEmpty() || extractors.getLast() != hlsextractorwrapper)
                    {
                        hlsextractorwrapper.init(loadControl.getAllocator());
                        extractors.addLast(hlsextractorwrapper);
                    }
                    notifyLoadStarted(tschunk.dataSpec.length, tschunk.type, tschunk.trigger, tschunk.format, tschunk.startTimeUs, tschunk.endTimeUs);
                    currentTsLoadable = tschunk;
                } else
                {
                    notifyLoadStarted(currentLoadable.dataSpec.length, currentLoadable.type, currentLoadable.trigger, currentLoadable.format, -1L, -1L);
                }
                loader.startLoading(currentLoadable, this);
                return;
            }
        }
    }

    private void notifyDownstreamFormatChanged(Format format, int i, long l)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new h(this, format, i, l));
        }
    }

    private void notifyLoadCanceled(long l)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new f(this, l));
        }
    }

    private void notifyLoadCompleted(long l, int i, int j, Format format, long l1, 
            long l2, long l3, long l4)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new e(this, l, i, j, format, l1, l2, l3, l4));
        }
    }

    private void notifyLoadError(IOException ioexception)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new g(this, ioexception));
        }
    }

    private void notifyLoadStarted(long l, int i, int j, Format format, long l1, 
            long l2)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new d(this, l, i, j, format, l1, l2));
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
            clearState();
            maybeStartLoading();
            return;
        }
    }

    public final boolean continueBuffering(int i, long l)
    {
        boolean flag1;
        flag1 = false;
        Assertions.checkState(prepared);
        Assertions.checkState(trackEnabledStates[i]);
        downstreamPositionUs = l;
        if (!extractors.isEmpty())
        {
            discardSamplesForDisabledTracks(getCurrentExtractor(), downstreamPositionUs);
        }
        if (!loadingFinished) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        maybeStartLoading();
        flag = flag1;
        if (isPendingReset()) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (extractors.isEmpty()) goto _L4; else goto _L5
_L5:
        int j = 0;
_L8:
        flag = flag1;
        if (j >= extractors.size()) goto _L4; else goto _L6
_L6:
        HlsExtractorWrapper hlsextractorwrapper;
        hlsextractorwrapper = (HlsExtractorWrapper)extractors.get(j);
        flag = flag1;
        if (!hlsextractorwrapper.isPrepared()) goto _L4; else goto _L7
_L7:
        if (hlsextractorwrapper.hasSamples(i))
        {
            return true;
        }
        j++;
          goto _L8
    }

    public final void disable(int i)
    {
label0:
        {
            Assertions.checkState(prepared);
            Assertions.checkState(trackEnabledStates[i]);
            enabledTrackCount = enabledTrackCount - 1;
            trackEnabledStates[i] = false;
            if (enabledTrackCount == 0)
            {
                downstreamPositionUs = 0x8000000000000000L;
                if (loadControlRegistered)
                {
                    loadControl.unregister(this);
                    loadControlRegistered = false;
                }
                if (!loader.isLoading())
                {
                    break label0;
                }
                loader.cancelLoading();
            }
            return;
        }
        clearState();
        loadControl.trimAllocator();
    }

    public final void enable(int i, long l)
    {
        Assertions.checkState(prepared);
        boolean flag;
        if (!trackEnabledStates[i])
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        enabledTrackCount = enabledTrackCount + 1;
        trackEnabledStates[i] = true;
        downstreamMediaFormats[i] = null;
        downstreamFormat = null;
        if (!loadControlRegistered)
        {
            loadControl.register(this, bufferSizeContribution);
            loadControlRegistered = true;
        }
        if (enabledTrackCount == 1)
        {
            seekToUs(l);
        }
        pendingDiscontinuities[i] = false;
    }

    public final long getBufferedPositionUs()
    {
        Assertions.checkState(prepared);
        long l;
        boolean flag;
        if (enabledTrackCount > 0)
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
            long l1 = ((HlsExtractorWrapper)extractors.getLast()).getLargestParsedTimestampUs();
            l = l1;
            if (l1 == 0x8000000000000000L)
            {
                return downstreamPositionUs;
            }
        }
        return l;
    }

    public final int getTrackCount()
    {
        Assertions.checkState(prepared);
        return trackCount;
    }

    public final TrackInfo getTrackInfo(int i)
    {
        Assertions.checkState(prepared);
        return trackInfos[i];
    }

    public final void maybeThrowError()
    {
        if (currentLoadableException != null && currentLoadableExceptionCount > minLoadableRetryCount)
        {
            throw currentLoadableException;
        } else
        {
            return;
        }
    }

    public final void onLoadCanceled(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        notifyLoadCanceled(currentLoadable.bytesLoaded());
        if (enabledTrackCount > 0)
        {
            restartFrom(pendingResetPositionUs);
            return;
        } else
        {
            clearState();
            loadControl.trimAllocator();
            return;
        }
    }

    public final void onLoadCompleted(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        boolean flag1 = true;
        long l;
        long l1;
        boolean flag;
        if (loadable == currentLoadable)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        l = SystemClock.elapsedRealtime();
        l1 = l - currentLoadStartTimeMs;
        chunkSource.onChunkLoadCompleted(currentLoadable);
        if (isTsChunk(currentLoadable))
        {
            if (currentLoadable == currentTsLoadable)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            loadingFinished = currentTsLoadable.isLastChunk;
            previousTsLoadable = currentTsLoadable;
            notifyLoadCompleted(currentLoadable.bytesLoaded(), currentTsLoadable.type, currentTsLoadable.trigger, currentTsLoadable.format, currentTsLoadable.startTimeUs, currentTsLoadable.endTimeUs, l, l1);
        } else
        {
            notifyLoadCompleted(currentLoadable.bytesLoaded(), currentLoadable.type, currentLoadable.trigger, currentLoadable.format, -1L, -1L, l, l1);
        }
        clearCurrentLoadable();
        if (enabledTrackCount > 0 || !prepared)
        {
            maybeStartLoading();
        }
    }

    public final void onLoadError(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable, IOException ioexception)
    {
        if (chunkSource.onChunkLoadError(currentLoadable, ioexception))
        {
            if (previousTsLoadable == null && !isPendingReset())
            {
                pendingResetPositionUs = lastSeekPositionUs;
            }
            clearCurrentLoadable();
        } else
        {
            currentLoadableException = ioexception;
            currentLoadableExceptionCount = currentLoadableExceptionCount + 1;
            currentLoadableExceptionTimestamp = SystemClock.elapsedRealtime();
        }
        notifyLoadError(ioexception);
        maybeStartLoading();
    }

    public final boolean prepare(long l)
    {
        int i = 0;
        if (prepared)
        {
            return true;
        }
        if (!extractors.isEmpty())
        {
            HlsExtractorWrapper hlsextractorwrapper = getCurrentExtractor();
            if (hlsextractorwrapper.isPrepared())
            {
                trackCount = hlsextractorwrapper.getTrackCount();
                trackEnabledStates = new boolean[trackCount];
                pendingDiscontinuities = new boolean[trackCount];
                downstreamMediaFormats = new MediaFormat[trackCount];
                trackInfos = new TrackInfo[trackCount];
                for (; i < trackCount; i++)
                {
                    MediaFormat mediaformat = hlsextractorwrapper.getMediaFormat(i);
                    trackInfos[i] = new TrackInfo(mediaformat.mimeType, chunkSource.getDurationUs());
                }

                prepared = true;
                return true;
            }
        }
        if (loader == null)
        {
            loader = new Loader("Loader:HLS");
        }
        if (!loadControlRegistered)
        {
            loadControl.register(this, bufferSizeContribution);
            loadControlRegistered = true;
        }
        if (!loader.isLoading())
        {
            pendingResetPositionUs = l;
            downstreamPositionUs = l;
        }
        maybeStartLoading();
        return false;
    }

    public final int readData(int i, long l, MediaFormatHolder mediaformatholder, SampleHolder sampleholder, boolean flag)
    {
        boolean flag1 = false;
        Assertions.checkState(prepared);
        downstreamPositionUs = l;
        if (pendingDiscontinuities[i])
        {
            pendingDiscontinuities[i] = false;
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
        Object obj = getCurrentExtractor();
        if (!((HlsExtractorWrapper) (obj)).isPrepared())
        {
            return -2;
        }
        if (downstreamFormat == null || !downstreamFormat.equals(((HlsExtractorWrapper) (obj)).format))
        {
            notifyDownstreamFormatChanged(((HlsExtractorWrapper) (obj)).format, ((HlsExtractorWrapper) (obj)).trigger, ((HlsExtractorWrapper) (obj)).startTimeUs);
            downstreamFormat = ((HlsExtractorWrapper) (obj)).format;
        }
        if (extractors.size() > 1)
        {
            ((HlsExtractorWrapper) (obj)).configureSpliceTo((HlsExtractorWrapper)extractors.get(1));
        }
        for (int j = 0; extractors.size() > j + 1 && !((HlsExtractorWrapper) (obj)).hasSamples(i);)
        {
            obj = extractors;
            j++;
            obj = (HlsExtractorWrapper)((LinkedList) (obj)).get(j);
            if (!((HlsExtractorWrapper) (obj)).isPrepared())
            {
                return -2;
            }
        }

        MediaFormat mediaformat = ((HlsExtractorWrapper) (obj)).getMediaFormat(i);
        if (mediaformat != null && !mediaformat.equals(downstreamMediaFormats[i], true))
        {
            chunkSource.getMaxVideoDimensions(mediaformat);
            mediaformatholder.format = mediaformat;
            downstreamMediaFormats[i] = mediaformat;
            return -4;
        }
        if (((HlsExtractorWrapper) (obj)).getSample(i, sampleholder))
        {
            int k;
            int i1;
            if (sampleholder.timeUs < lastSeekPositionUs)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            i1 = sampleholder.flags;
            k = ((flag1) ? 1 : 0);
            if (i != 0)
            {
                k = 0x8000000;
            }
            sampleholder.flags = i1 | k;
            return -3;
        }
        return !loadingFinished ? -2 : -1;
    }

    public final shared_presage.com.google.android.exoplayer.SampleSource.SampleSourceReader register()
    {
        remainingReleaseCount = remainingReleaseCount + 1;
        return this;
    }

    public final void release()
    {
        int i;
        boolean flag;
        if (remainingReleaseCount > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        i = remainingReleaseCount - 1;
        remainingReleaseCount = i;
        if (i == 0 && loader != null)
        {
            loader.release();
            loader = null;
        }
    }

    public final void seekToUs(long l)
    {
        int i = 0;
        Assertions.checkState(prepared);
        long l1;
        boolean flag;
        if (enabledTrackCount > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
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
        downstreamPositionUs = l;
        for (; i < pendingDiscontinuities.length; i++)
        {
            pendingDiscontinuities[i] = true;
        }

        restartFrom(l);
    }

    final int usToMs(long l)
    {
        return (int)(l / 1000L);
    }


}
