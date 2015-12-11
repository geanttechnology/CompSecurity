// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;

import java.util.Arrays;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;

// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            Chunk, Format

public abstract class DataChunk extends Chunk
{

    private static final int READ_GRANULARITY = 16384;
    private byte data[];
    private int limit;
    private volatile boolean loadCanceled;

    public DataChunk(DataSource datasource, DataSpec dataspec, int i, int j, Format format, byte abyte0[])
    {
        super(datasource, dataspec, i, j, format);
        data = abyte0;
    }

    private void maybeExpandData()
    {
        if (data == null)
        {
            data = new byte[16384];
        } else
        if (data.length < limit + 16384)
        {
            data = Arrays.copyOf(data, data.length + 16384);
            return;
        }
    }

    public long bytesLoaded()
    {
        return (long)limit;
    }

    public final void cancelLoad()
    {
        loadCanceled = true;
    }

    protected abstract void consume(byte abyte0[], int i);

    public byte[] getDataHolder()
    {
        return data;
    }

    public final boolean isLoadCanceled()
    {
        return loadCanceled;
    }

    public final void load()
    {
        int i = 0;
        dataSource.open(dataSpec);
        limit = 0;
_L2:
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        int j;
        if (loadCanceled)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        maybeExpandData();
        j = dataSource.read(data, limit, 16384);
        i = j;
        if (j == -1) goto _L2; else goto _L1
_L1:
        limit = limit + j;
        i = j;
          goto _L2
        Exception exception;
        exception;
        dataSource.close();
        throw exception;
        if (!loadCanceled)
        {
            consume(data, limit);
        }
        dataSource.close();
        return;
    }
}
