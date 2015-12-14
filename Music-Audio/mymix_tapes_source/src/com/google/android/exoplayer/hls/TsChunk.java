// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.chunk.MediaChunk;
import com.google.android.exoplayer.extractor.DefaultExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.hls:
//            Aes128DataSource, HlsExtractorWrapper

public final class TsChunk extends MediaChunk
{

    private int bytesLoaded;
    public final HlsExtractorWrapper extractorWrapper;
    private final boolean isEncrypted;
    private volatile boolean loadCanceled;

    public TsChunk(DataSource datasource, DataSpec dataspec, int i, Format format, long l, long l1, int j, boolean flag, HlsExtractorWrapper hlsextractorwrapper, byte abyte0[], byte abyte1[])
    {
        super(buildDataSource(datasource, abyte0, abyte1), dataspec, i, format, l, l1, j, flag);
        extractorWrapper = hlsextractorwrapper;
        isEncrypted = dataSource instanceof Aes128DataSource;
    }

    private static DataSource buildDataSource(DataSource datasource, byte abyte0[], byte abyte1[])
    {
        if (abyte0 == null || abyte1 == null)
        {
            return datasource;
        } else
        {
            return new Aes128DataSource(datasource, abyte0, abyte1);
        }
    }

    public long bytesLoaded()
    {
        return (long)bytesLoaded;
    }

    public void cancelLoad()
    {
        loadCanceled = true;
    }

    public boolean isLoadCanceled()
    {
        return loadCanceled;
    }

    public void load()
        throws IOException, InterruptedException
    {
        Object obj;
        int i;
        if (isEncrypted)
        {
            obj = dataSpec;
            if (bytesLoaded != 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        {
            obj = Util.getRemainderDataSpec(dataSpec, bytesLoaded);
            i = 0;
        }
        obj = new DefaultExtractorInput(dataSource, ((DataSpec) (obj)).absoluteStreamPosition, dataSource.open(((DataSpec) (obj))));
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        ((ExtractorInput) (obj)).skipFully(bytesLoaded);
        i = 0;
_L1:
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        if (loadCanceled)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        i = extractorWrapper.read(((ExtractorInput) (obj)));
          goto _L1
        bytesLoaded = (int)(((ExtractorInput) (obj)).getPosition() - dataSpec.absoluteStreamPosition);
        dataSource.close();
        return;
        Exception exception1;
        exception1;
        bytesLoaded = (int)(((ExtractorInput) (obj)).getPosition() - dataSpec.absoluteStreamPosition);
        throw exception1;
        Exception exception;
        exception;
        dataSource.close();
        throw exception;
    }
}
