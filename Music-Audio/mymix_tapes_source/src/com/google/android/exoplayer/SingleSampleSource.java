// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.upstream.Loader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

// Referenced classes of package com.google.android.exoplayer:
//            SampleSource, TrackInfo, MediaFormat, SampleHolder, 
//            MediaFormatHolder

public final class SingleSampleSource
    implements SampleSource, SampleSource.SampleSourceReader, com.google.android.exoplayer.upstream.Loader.Callback, com.google.android.exoplayer.upstream.Loader.Loadable
{

    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    private static final int INITIAL_SAMPLE_SIZE = 1;
    private IOException currentLoadableException;
    private int currentLoadableExceptionCount;
    private long currentLoadableExceptionTimestamp;
    private final DataSource dataSource;
    private final MediaFormat format;
    private Loader loader;
    private boolean loadingFinished;
    private final int minLoadableRetryCount;
    private boolean pendingSample;
    private byte sampleData[];
    private int sampleSize;
    private final TrackInfo trackInfo;
    private final Uri uri;

    public SingleSampleSource(Uri uri1, DataSource datasource, MediaFormat mediaformat)
    {
        this(uri1, datasource, mediaformat, 3);
    }

    public SingleSampleSource(Uri uri1, DataSource datasource, MediaFormat mediaformat, int i)
    {
        uri = uri1;
        dataSource = datasource;
        format = mediaformat;
        minLoadableRetryCount = i;
        trackInfo = new TrackInfo(mediaformat.mimeType, mediaformat.durationUs);
        sampleData = new byte[1];
    }

    private void clearCurrentLoadableException()
    {
        currentLoadableException = null;
        currentLoadableExceptionCount = 0;
    }

    private long getRetryDelayMillis(long l)
    {
        return Math.min((l - 1L) * 1000L, 5000L);
    }

    private void maybeStartLoading()
    {
        if (!loadingFinished && pendingSample && !loader.isLoading()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (currentLoadableException == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (SystemClock.elapsedRealtime() - currentLoadableExceptionTimestamp < getRetryDelayMillis(currentLoadableExceptionCount))
        {
            continue; /* Loop/switch isn't completed */
        }
        currentLoadableException = null;
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        loader.startLoading(this, this);
        return;
    }

    public void cancelLoad()
    {
    }

    public boolean continueBuffering(int i, long l)
    {
        maybeStartLoading();
        return loadingFinished;
    }

    public void disable(int i)
    {
        pendingSample = false;
    }

    public void enable(int i, long l)
    {
        pendingSample = true;
        clearCurrentLoadableException();
        maybeStartLoading();
    }

    public long getBufferedPositionUs()
    {
        return !loadingFinished ? 0L : -3L;
    }

    public int getTrackCount()
    {
        return 1;
    }

    public TrackInfo getTrackInfo(int i)
    {
        return trackInfo;
    }

    public boolean isLoadCanceled()
    {
        return false;
    }

    public void load()
        throws IOException, InterruptedException
    {
        sampleSize = 0;
        dataSource.open(new DataSpec(uri));
        int i = 0;
_L2:
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        sampleSize = sampleSize + i;
        if (sampleSize == sampleData.length)
        {
            sampleData = Arrays.copyOf(sampleData, sampleData.length * 2);
        }
        i = dataSource.read(sampleData, sampleSize, sampleData.length - sampleSize);
        if (true) goto _L2; else goto _L1
_L1:
        dataSource.close();
        return;
        Exception exception;
        exception;
        dataSource.close();
        throw exception;
    }

    public void maybeThrowError()
        throws IOException
    {
        if (currentLoadableException != null && currentLoadableExceptionCount > minLoadableRetryCount)
        {
            throw currentLoadableException;
        } else
        {
            return;
        }
    }

    public void onLoadCanceled(com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
    }

    public void onLoadCompleted(com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        loadingFinished = true;
        clearCurrentLoadableException();
    }

    public void onLoadError(com.google.android.exoplayer.upstream.Loader.Loadable loadable, IOException ioexception)
    {
        currentLoadableException = ioexception;
        currentLoadableExceptionCount = currentLoadableExceptionCount + 1;
        currentLoadableExceptionTimestamp = SystemClock.elapsedRealtime();
        maybeStartLoading();
    }

    public boolean prepare(long l)
    {
        if (loader == null)
        {
            loader = new Loader((new StringBuilder()).append("Loader:").append(format.mimeType).toString());
        }
        return true;
    }

    public int readData(int i, long l, MediaFormatHolder mediaformatholder, SampleHolder sampleholder, boolean flag)
    {
        if (!flag)
        {
            if (!pendingSample)
            {
                return -1;
            }
            if (loadingFinished)
            {
                sampleholder.timeUs = 0L;
                sampleholder.size = sampleSize;
                sampleholder.flags = 1;
                if (sampleholder.data == null || sampleholder.data.capacity() < sampleSize)
                {
                    sampleholder.replaceBuffer(sampleholder.size);
                }
                sampleholder.data.put(sampleData, 0, sampleSize);
                return -3;
            }
        }
        return -2;
    }

    public SampleSource.SampleSourceReader register()
    {
        return this;
    }

    public void release()
    {
        if (loader != null)
        {
            loader.release();
            loader = null;
        }
    }

    public void seekToUs(long l)
    {
        pendingSample = true;
    }
}
