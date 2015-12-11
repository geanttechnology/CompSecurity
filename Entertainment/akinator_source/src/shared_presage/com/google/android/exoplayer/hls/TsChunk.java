// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.hls;

import shared_presage.com.google.android.exoplayer.chunk.Format;
import shared_presage.com.google.android.exoplayer.chunk.MediaChunk;
import shared_presage.com.google.android.exoplayer.extractor.DefaultExtractorInput;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorInput;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.hls:
//            a, HlsExtractorWrapper

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
        isEncrypted = dataSource instanceof a;
    }

    private static DataSource buildDataSource(DataSource datasource, byte abyte0[], byte abyte1[])
    {
        if (abyte0 == null || abyte1 == null)
        {
            return datasource;
        } else
        {
            return new a(datasource, abyte0, abyte1);
        }
    }

    public final long bytesLoaded()
    {
        return (long)bytesLoaded;
    }

    public final void cancelLoad()
    {
        loadCanceled = true;
    }

    public final boolean isLoadCanceled()
    {
        return loadCanceled;
    }

    public final void load()
    {
        Object obj;
        boolean flag1 = false;
        boolean flag;
        if (isEncrypted)
        {
            obj = dataSpec;
            int i;
            if (bytesLoaded != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            obj = Util.getRemainderDataSpec(dataSpec, bytesLoaded);
            flag = false;
        }
        obj = new DefaultExtractorInput(dataSource, ((DataSpec) (obj)).absoluteStreamPosition, dataSource.open(((DataSpec) (obj))));
        i = ((flag1) ? 1 : 0);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        ((ExtractorInput) (obj)).skipFully(bytesLoaded);
        i = ((flag1) ? 1 : 0);
_L1:
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        if (loadCanceled)
        {
            break MISSING_BLOCK_LABEL_119;
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
