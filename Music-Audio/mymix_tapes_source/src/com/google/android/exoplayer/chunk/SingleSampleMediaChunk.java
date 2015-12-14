// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.DefaultTrackOutput;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.chunk:
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

    public long bytesLoaded()
    {
        return (long)bytesLoaded;
    }

    public void cancelLoad()
    {
        loadCanceled = true;
    }

    public DrmInitData getDrmInitData()
    {
        return sampleDrmInitData;
    }

    public MediaFormat getMediaFormat()
    {
        return sampleFormat;
    }

    public boolean isLoadCanceled()
    {
        return loadCanceled;
    }

    public void load()
        throws IOException, InterruptedException
    {
        DataSpec dataspec;
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
        int i = 0;
_L1:
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        bytesLoaded = bytesLoaded + i;
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
