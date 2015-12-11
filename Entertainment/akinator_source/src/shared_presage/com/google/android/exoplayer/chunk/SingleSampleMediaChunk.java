// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;

import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.drm.DrmInitData;
import shared_presage.com.google.android.exoplayer.extractor.DefaultTrackOutput;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            BaseMediaChunk, Format

public final class SingleSampleMediaChunk extends BaseMediaChunk
{

    private volatile int bytesLoaded;
    private final byte headerData[];
    private volatile boolean loadCanceled;
    private final DrmInitData sampleDrmInitData;
    private final MediaFormat sampleFormat;
    private boolean writtenHeader;

    public SingleSampleMediaChunk(DataSource datasource, DataSpec dataspec, int i, Format format, long l, long l1, int j, boolean flag, MediaFormat mediaformat, DrmInitData drminitdata, byte abyte0[])
    {
        super(datasource, dataspec, i, format, l, l1, j, flag, true);
        sampleFormat = mediaformat;
        sampleDrmInitData = drminitdata;
        headerData = abyte0;
    }

    public final long bytesLoaded()
    {
        return (long)bytesLoaded;
    }

    public final void cancelLoad()
    {
        loadCanceled = true;
    }

    public final DrmInitData getDrmInitData()
    {
        return sampleDrmInitData;
    }

    public final MediaFormat getMediaFormat()
    {
        return sampleFormat;
    }

    public final boolean isLoadCanceled()
    {
        return loadCanceled;
    }

    public final void load()
    {
        DataSpec dataspec;
        int i;
        i = 0;
        if (!writtenHeader)
        {
            if (headerData != null)
            {
                getOutput().sampleData(new ParsableByteArray(headerData), headerData.length);
            }
            writtenHeader = true;
        }
        dataspec = Util.getRemainderDataSpec(dataSpec, bytesLoaded);
        dataSource.open(dataspec);
_L1:
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        bytesLoaded = i + bytesLoaded;
        i = getOutput().sampleData(dataSource, 0x7fffffff, true);
          goto _L1
        int j = bytesLoaded;
        i = j;
        if (headerData != null)
        {
            i = j + headerData.length;
        }
        getOutput().sampleMetadata(startTimeUs, 1, i, 0, null);
        dataSource.close();
        return;
        Exception exception;
        exception;
        dataSource.close();
        throw exception;
    }
}
