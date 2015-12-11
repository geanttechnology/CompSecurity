// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor;

import android.net.Uri;
import android.os.SystemClock;
import android.util.SparseArray;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.MediaFormatHolder;
import shared_presage.com.google.android.exoplayer.ParserException;
import shared_presage.com.google.android.exoplayer.SampleHolder;
import shared_presage.com.google.android.exoplayer.SampleSource;
import shared_presage.com.google.android.exoplayer.TrackInfo;
import shared_presage.com.google.android.exoplayer.drm.DrmInitData;
import shared_presage.com.google.android.exoplayer.upstream.Allocator;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;
import shared_presage.com.google.android.exoplayer.upstream.DefaultAllocator;
import shared_presage.com.google.android.exoplayer.upstream.Loader;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor:
//            ExtractorOutput, Extractor, SeekMap, TrackOutput, 
//            PositionHolder, DefaultExtractorInput, ExtractorInput, DefaultTrackOutput

public final class ExtractorSampleSource
    implements SampleSource, shared_presage.com.google.android.exoplayer.SampleSource.SampleSourceReader, ExtractorOutput, shared_presage.com.google.android.exoplayer.upstream.Loader.Callback
{
    public static final class UnrecognizedInputFormatException extends ParserException
    {

        public UnrecognizedInputFormatException(Extractor aextractor[])
        {
            super((new StringBuilder("None of the available extractors (")).append(Util.getCommaDelimitedSimpleClassNames(aextractor)).append(") could read the stream.").toString());
        }
    }

    private static final class a
        implements shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable
    {

        private final Uri a;
        private final DataSource b;
        private final b c;
        private final Allocator d;
        private final int e;
        private final PositionHolder f = new PositionHolder();
        private volatile boolean g;
        private boolean h;

        public final void cancelLoad()
        {
            g = true;
        }

        public final boolean isLoadCanceled()
        {
            return g;
        }

        public final void load()
        {
            int i = 0;
_L4:
            if (i != 0 || g)
            {
                break; /* Loop/switch isn't completed */
            }
            long l1;
            long l2;
            l2 = f.position;
            l1 = b.open(new DataSpec(a, l2, -1L, null));
            long l;
            l = l1;
            if (l1 != -1L)
            {
                l = l1 + l2;
            }
            Object obj = new DefaultExtractorInput(b, l2, l);
            Object obj1;
            obj1 = c.a(((ExtractorInput) (obj)));
            if (h)
            {
                ((Extractor) (obj1)).seek();
                h = false;
            }
_L2:
            if (i != 0)
            {
                break; /* Loop/switch isn't completed */
            }
            int j;
            if (g)
            {
                break; /* Loop/switch isn't completed */
            }
            d.blockWhileTotalBytesAllocatedExceeds(e);
            j = ((Extractor) (obj1)).read(((ExtractorInput) (obj)), f);
            i = j;
            if (true) goto _L2; else goto _L1
_L1:
            if (i == 1)
            {
                i = 0;
            } else
            {
                f.position = ((ExtractorInput) (obj)).getPosition();
            }
            b.close();
            if (true) goto _L4; else goto _L3
            obj;
            obj1 = null;
_L6:
            if (i != 1 && obj1 != null)
            {
                f.position = ((ExtractorInput) (obj1)).getPosition();
            }
            b.close();
            throw obj;
_L3:
            return;
            Exception exception;
            exception;
            Object obj2 = obj;
            obj = exception;
            exception = ((Exception) (obj2));
            continue; /* Loop/switch isn't completed */
            Exception exception1;
            exception1;
            exception = ((Exception) (obj));
            obj = exception1;
            if (true) goto _L6; else goto _L5
_L5:
        }

        public a(Uri uri1, DataSource datasource, b b1, Allocator allocator1, int i, long l)
        {
            a = (Uri)Assertions.checkNotNull(uri1);
            b = (DataSource)Assertions.checkNotNull(datasource);
            c = (b)Assertions.checkNotNull(b1);
            d = (Allocator)Assertions.checkNotNull(allocator1);
            e = i;
            f.position = l;
            h = true;
        }
    }

    private static final class b
    {

        private final Extractor a[];
        private final ExtractorOutput b;
        private Extractor c;

        public final Extractor a(ExtractorInput extractorinput)
        {
            Extractor aextractor[];
            int i;
            int j;
            if (c != null)
            {
                return c;
            }
            aextractor = a;
            j = aextractor.length;
            i = 0;
_L2:
            Extractor extractor;
            if (i >= j)
            {
                break MISSING_BLOCK_LABEL_51;
            }
            extractor = aextractor[i];
            if (!extractor.sniff(extractorinput))
            {
                break MISSING_BLOCK_LABEL_71;
            }
            c = extractor;
            EOFException eofexception;
            if (c == null)
            {
                throw new UnrecognizedInputFormatException(a);
            } else
            {
                c.init(b);
                return c;
            }
            eofexception;
            extractorinput.resetPeekPosition();
            i++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public b(Extractor aextractor[], ExtractorOutput extractoroutput)
        {
            a = aextractor;
            b = extractoroutput;
        }
    }


    private static final List DEFAULT_EXTRACTOR_CLASSES;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_LIVE = 6;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_ON_DEMAND = 3;
    private static final int MIN_RETRY_COUNT_DEFAULT_FOR_MEDIA = -1;
    private static final int NO_RESET_PENDING = -1;
    private final Allocator allocator;
    private IOException currentLoadableException;
    private int currentLoadableExceptionCount;
    private long currentLoadableExceptionTimestamp;
    private final DataSource dataSource;
    private long downstreamPositionUs;
    private volatile DrmInitData drmInitData;
    private int enabledTrackCount;
    private int extractedSampleCount;
    private int extractedSampleCountAtStartOfLoad;
    private final b extractorHolder;
    private boolean havePendingNextSampleUs;
    private long lastSeekPositionUs;
    private a loadable;
    private Loader loader;
    private boolean loadingFinished;
    private long maxTrackDurationUs;
    private final int minLoadableRetryCount;
    private boolean pendingDiscontinuities[];
    private boolean pendingMediaFormat[];
    private long pendingNextSampleUs;
    private long pendingResetPositionUs;
    private boolean prepared;
    private int remainingReleaseCount;
    private final int requestedBufferSize;
    private final SparseArray sampleQueues;
    private long sampleTimeOffsetUs;
    private volatile SeekMap seekMap;
    private boolean trackEnabledStates[];
    private TrackInfo trackInfos[];
    private volatile boolean tracksBuilt;
    private final Uri uri;

    public transient ExtractorSampleSource(Uri uri1, DataSource datasource, int i, int j, Extractor aextractor[])
    {
        ExtractorSampleSource(uri1, datasource, ((Allocator) (new DefaultAllocator(0x10000))), i, j, aextractor);
    }

    public transient ExtractorSampleSource(Uri uri1, DataSource datasource, int i, Extractor aextractor[])
    {
        ExtractorSampleSource(uri1, datasource, ((Allocator) (new DefaultAllocator(0x10000))), i, aextractor);
    }

    public transient ExtractorSampleSource(Uri uri1, DataSource datasource, Allocator allocator1, int i, int j, Extractor aextractor[])
    {
label0:
        {
            Object();
            uri = uri1;
            dataSource = datasource;
            allocator = allocator1;
            requestedBufferSize = i;
            minLoadableRetryCount = j;
            if (aextractor != null)
            {
                uri1 = aextractor;
                if (aextractor.length != 0)
                {
                    break label0;
                }
            }
            datasource = new Extractor[DEFAULT_EXTRACTOR_CLASSES.size()];
            i = 0;
            do
            {
                uri1 = datasource;
                if (i >= datasource.length)
                {
                    break;
                }
                try
                {
                    datasource[i] = (Extractor)((Class)DEFAULT_EXTRACTOR_CLASSES.get(i)).newInstance();
                }
                // Misplaced declaration of an exception variable
                catch (Uri uri1)
                {
                    throw new IllegalStateException("Unexpected error creating default extractor", uri1);
                }
                // Misplaced declaration of an exception variable
                catch (Uri uri1)
                {
                    throw new IllegalStateException("Unexpected error creating default extractor", uri1);
                }
                i++;
            } while (true);
        }
        extractorHolder = new b(uri1, this);
        sampleQueues = new SparseArray();
        pendingResetPositionUs = -1L;
    }

    public transient ExtractorSampleSource(Uri uri1, DataSource datasource, Allocator allocator1, int i, Extractor aextractor[])
    {
        ExtractorSampleSource(uri1, datasource, allocator1, i, -1, aextractor);
    }

    private void clearState()
    {
        for (int i = 0; i < sampleQueues.size(); i++)
        {
            ((c)sampleQueues.valueAt(i)).clear();
        }

        loadable = null;
        currentLoadableException = null;
        currentLoadableExceptionCount = 0;
    }

    private a createLoadableFromPositionUs(long l)
    {
        return new a(uri, dataSource, extractorHolder, allocator, requestedBufferSize, seekMap.getPosition(l));
    }

    private a createLoadableFromStart()
    {
        return new a(uri, dataSource, extractorHolder, allocator, requestedBufferSize, 0L);
    }

    private void discardSamplesForDisabledTracks(long l)
    {
        for (int i = 0; i < trackEnabledStates.length; i++)
        {
            if (!trackEnabledStates[i])
            {
                ((c)sampleQueues.valueAt(i)).discardUntil(l);
            }
        }

    }

    private long getRetryDelayMillis(long l)
    {
        return Math.min((l - 1L) * 1000L, 5000L);
    }

    private boolean haveFormatsForAllTracks()
    {
        for (int i = 0; i < sampleQueues.size(); i++)
        {
            if (!((c)sampleQueues.valueAt(i)).hasFormat())
            {
                return false;
            }
        }

        return true;
    }

    private boolean isCurrentLoadableExceptionFatal()
    {
        return currentLoadableException instanceof UnrecognizedInputFormatException;
    }

    private boolean isPendingReset()
    {
        return pendingResetPositionUs != -1L;
    }

    private void maybeStartLoading()
    {
        int i;
        boolean flag;
        flag = false;
        i = 0;
        if (!loadingFinished && !loader.isLoading()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (currentLoadableException == null) goto _L4; else goto _L3
_L3:
        if (isCurrentLoadableExceptionFatal()) goto _L1; else goto _L5
_L5:
        boolean flag1;
        if (loadable != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        if (SystemClock.elapsedRealtime() - currentLoadableExceptionTimestamp < getRetryDelayMillis(currentLoadableExceptionCount)) goto _L1; else goto _L6
_L6:
        currentLoadableException = null;
        if (prepared) goto _L8; else goto _L7
_L7:
        for (; i < sampleQueues.size(); i++)
        {
            ((c)sampleQueues.valueAt(i)).clear();
        }

        loadable = createLoadableFromStart();
_L9:
        extractedSampleCountAtStartOfLoad = extractedSampleCount;
        loader.startLoading(loadable, this);
        return;
_L8:
        if (!seekMap.isSeekable())
        {
            for (int j = ((flag) ? 1 : 0); j < sampleQueues.size(); j++)
            {
                ((c)sampleQueues.valueAt(j)).clear();
            }

            loadable = createLoadableFromStart();
            pendingNextSampleUs = downstreamPositionUs;
            havePendingNextSampleUs = true;
        }
        if (true) goto _L9; else goto _L4
_L4:
        sampleTimeOffsetUs = 0L;
        havePendingNextSampleUs = false;
        if (!prepared)
        {
            loadable = createLoadableFromStart();
        } else
        {
            Assertions.checkState(isPendingReset());
            if (maxTrackDurationUs != -1L && pendingResetPositionUs >= maxTrackDurationUs)
            {
                loadingFinished = true;
                pendingResetPositionUs = -1L;
                return;
            }
            loadable = createLoadableFromPositionUs(pendingResetPositionUs);
            pendingResetPositionUs = -1L;
        }
        extractedSampleCountAtStartOfLoad = extractedSampleCount;
        loader.startLoading(loadable, this);
        return;
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
        Assertions.checkState(prepared);
        Assertions.checkState(trackEnabledStates[i]);
        downstreamPositionUs = l;
        discardSamplesForDisabledTracks(downstreamPositionUs);
        if (loadingFinished)
        {
            return true;
        }
        maybeStartLoading();
        if (isPendingReset())
        {
            return false;
        }
        return !((c)sampleQueues.valueAt(i)).isEmpty();
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
                if (!loader.isLoading())
                {
                    break label0;
                }
                loader.cancelLoading();
            }
            return;
        }
        clearState();
        allocator.trim(0);
    }

    public final void drmInitData(DrmInitData drminitdata)
    {
        drmInitData = drminitdata;
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
        pendingMediaFormat[i] = true;
        if (enabledTrackCount == 1)
        {
            seekToUs(l);
        }
        pendingDiscontinuities[i] = false;
    }

    public final void endTracks()
    {
        tracksBuilt = true;
    }

    public final long getBufferedPositionUs()
    {
        long l1;
        if (loadingFinished)
        {
            l1 = -3L;
        } else
        {
            if (isPendingReset())
            {
                return pendingResetPositionUs;
            }
            int i = 0;
            long l = 0x8000000000000000L;
            for (; i < sampleQueues.size(); i++)
            {
                l = Math.max(l, ((c)sampleQueues.valueAt(i)).getLargestParsedTimestampUs());
            }

            l1 = l;
            if (l == 0x8000000000000000L)
            {
                return downstreamPositionUs;
            }
        }
        return l1;
    }

    public final int getTrackCount()
    {
        return sampleQueues.size();
    }

    public final TrackInfo getTrackInfo(int i)
    {
        Assertions.checkState(prepared);
        return trackInfos[i];
    }

    public final void maybeThrowError()
    {
        if (currentLoadableException != null)
        {
            if (isCurrentLoadableExceptionFatal())
            {
                throw currentLoadableException;
            }
            int i;
            if (minLoadableRetryCount != -1)
            {
                i = minLoadableRetryCount;
            } else
            if (seekMap != null && !seekMap.isSeekable())
            {
                i = 6;
            } else
            {
                i = 3;
            }
            if (currentLoadableExceptionCount > i)
            {
                throw currentLoadableException;
            }
        }
    }

    public final void onLoadCanceled(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable1)
    {
        if (enabledTrackCount > 0)
        {
            restartFrom(pendingResetPositionUs);
            return;
        } else
        {
            clearState();
            allocator.trim(0);
            return;
        }
    }

    public final void onLoadCompleted(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable1)
    {
        loadingFinished = true;
    }

    public final void onLoadError(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable1, IOException ioexception)
    {
        currentLoadableException = ioexception;
        int i;
        if (extractedSampleCount > extractedSampleCountAtStartOfLoad)
        {
            i = 1;
        } else
        {
            i = currentLoadableExceptionCount + 1;
        }
        currentLoadableExceptionCount = i;
        currentLoadableExceptionTimestamp = SystemClock.elapsedRealtime();
        maybeStartLoading();
    }

    public final boolean prepare(long l)
    {
        boolean flag1 = false;
        boolean flag;
        if (prepared)
        {
            flag = true;
        } else
        {
            if (loader == null)
            {
                loader = new Loader("Loader:ExtractorSampleSource");
            }
            maybeStartLoading();
            flag = flag1;
            if (seekMap != null)
            {
                flag = flag1;
                if (tracksBuilt)
                {
                    flag = flag1;
                    if (haveFormatsForAllTracks())
                    {
                        int j = sampleQueues.size();
                        trackEnabledStates = new boolean[j];
                        pendingDiscontinuities = new boolean[j];
                        pendingMediaFormat = new boolean[j];
                        trackInfos = new TrackInfo[j];
                        maxTrackDurationUs = -1L;
                        for (int i = 0; i < j; i++)
                        {
                            MediaFormat mediaformat = ((c)sampleQueues.valueAt(i)).getFormat();
                            trackInfos[i] = new TrackInfo(mediaformat.mimeType, mediaformat.durationUs);
                            if (mediaformat.durationUs != -1L && mediaformat.durationUs > maxTrackDurationUs)
                            {
                                maxTrackDurationUs = mediaformat.durationUs;
                            }
                        }

                        prepared = true;
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    public final int readData(int i, long l, MediaFormatHolder mediaformatholder, SampleHolder sampleholder, boolean flag)
    {
        downstreamPositionUs = l;
        if (pendingDiscontinuities[i])
        {
            pendingDiscontinuities[i] = false;
            return -5;
        }
        if (flag || isPendingReset())
        {
            return -2;
        }
        c c1 = (c)sampleQueues.valueAt(i);
        if (pendingMediaFormat[i])
        {
            mediaformatholder.format = c1.getFormat();
            mediaformatholder.drmInitData = drmInitData;
            pendingMediaFormat[i] = false;
            return -4;
        }
        if (c1.getSample(sampleholder))
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
            if (havePendingNextSampleUs)
            {
                sampleTimeOffsetUs = pendingNextSampleUs - sampleholder.timeUs;
                havePendingNextSampleUs = false;
            }
            sampleholder.timeUs = sampleholder.timeUs + sampleTimeOffsetUs;
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

    public final void seekMap(SeekMap seekmap)
    {
        seekMap = seekmap;
    }

    public final void seekToUs(long l)
    {
        boolean flag1 = false;
        Assertions.checkState(prepared);
        long l1;
        boolean flag2;
        if (enabledTrackCount > 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        Assertions.checkState(flag2);
        if (!seekMap.isSeekable())
        {
            l = 0L;
        }
        if (isPendingReset())
        {
            l1 = pendingResetPositionUs;
        } else
        {
            l1 = downstreamPositionUs;
        }
        downstreamPositionUs = l;
        lastSeekPositionUs = l;
        if (l1 != l)
        {
            boolean flag;
            int i;
            if (!isPendingReset())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            for (i = 0; flag && i < sampleQueues.size(); i++)
            {
                flag &= ((c)sampleQueues.valueAt(i)).skipToKeyframeBefore(l);
            }

            i = ((flag1) ? 1 : 0);
            if (!flag)
            {
                restartFrom(l);
                i = ((flag1) ? 1 : 0);
            }
            while (i < pendingDiscontinuities.length) 
            {
                pendingDiscontinuities[i] = true;
                i++;
            }
        }
    }

    public final TrackOutput track(int i)
    {
        c c2 = (c)sampleQueues.get(i);
        c c1 = c2;
        if (c2 == null)
        {
            c1 = new c(allocator);
            sampleQueues.put(i, c1);
        }
        return c1;
    }

    static 
    {
        DEFAULT_EXTRACTOR_CLASSES = new ArrayList();
        try
        {
            DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("shared_presage.com.google.android.exoplayer.extractor.webm.WebmExtractor").asSubclass(shared_presage/com/google/android/exoplayer/extractor/Extractor));
        }
        catch (ClassNotFoundException classnotfoundexception5) { }
        try
        {
            DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("shared_presage.com.google.android.exoplayer.extractor.mp4.FragmentedMp4Extractor").asSubclass(shared_presage/com/google/android/exoplayer/extractor/Extractor));
        }
        catch (ClassNotFoundException classnotfoundexception4) { }
        try
        {
            DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("shared_presage.com.google.android.exoplayer.extractor.mp4.Mp4Extractor").asSubclass(shared_presage/com/google/android/exoplayer/extractor/Extractor));
        }
        catch (ClassNotFoundException classnotfoundexception3) { }
        try
        {
            DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("shared_presage.com.google.android.exoplayer.extractor.mp3.Mp3Extractor").asSubclass(shared_presage/com/google/android/exoplayer/extractor/Extractor));
        }
        catch (ClassNotFoundException classnotfoundexception2) { }
        try
        {
            DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("shared_presage.com.google.android.exoplayer.extractor.ts.AdtsExtractor").asSubclass(shared_presage/com/google/android/exoplayer/extractor/Extractor));
        }
        catch (ClassNotFoundException classnotfoundexception1) { }
        try
        {
            DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("shared_presage.com.google.android.exoplayer.extractor.ts.TsExtractor").asSubclass(shared_presage/com/google/android/exoplayer/extractor/Extractor));
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return;
        }
    }


/*
    static int access$008(ExtractorSampleSource extractorsamplesource)
    {
        int i = extractorsamplesource.extractedSampleCount;
        extractorsamplesource.extractedSampleCount = i + 1;
        return i;
    }

*/
}
