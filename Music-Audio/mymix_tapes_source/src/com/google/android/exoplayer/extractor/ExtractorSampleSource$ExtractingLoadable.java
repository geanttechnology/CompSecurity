// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;

import android.net.Uri;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.extractor:
//            ExtractorSampleSource, PositionHolder, DefaultExtractorInput, Extractor, 
//            ExtractorInput

private static class pendingExtractorSeek
    implements com.google.android.exoplayer.upstream.
{

    private final Allocator allocator;
    private final DataSource dataSource;
    private final dataSource extractorHolder;
    private volatile boolean loadCanceled;
    private boolean pendingExtractorSeek;
    private final PositionHolder positionHolder = new PositionHolder();
    private final int requestedBufferSize;
    private final Uri uri;

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
        int i = 0;
_L4:
        if (i != 0 || loadCanceled)
        {
            break; /* Loop/switch isn't completed */
        }
        long l1;
        long l2;
        l2 = positionHolder.position;
        l1 = dataSource.open(new DataSpec(uri, l2, -1L, null));
        long l;
        l = l1;
        if (l1 != -1L)
        {
            l = l1 + l2;
        }
        DefaultExtractorInput defaultextractorinput = new DefaultExtractorInput(dataSource, l2, l);
        int k = i;
        Extractor extractor = extractorHolder.ectExtractor(defaultextractorinput);
        int j;
        j = i;
        k = i;
        if (!pendingExtractorSeek)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        k = i;
        extractor.seek();
        k = i;
        pendingExtractorSeek = false;
        j = i;
_L2:
        if (j != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k = j;
        if (loadCanceled)
        {
            break; /* Loop/switch isn't completed */
        }
        k = j;
        allocator.blockWhileTotalBytesAllocatedExceeds(requestedBufferSize);
        k = j;
        j = extractor.read(defaultextractorinput, positionHolder);
        if (true) goto _L2; else goto _L1
_L1:
        if (j == 1)
        {
            i = 0;
        } else
        {
            i = j;
            if (defaultextractorinput != null)
            {
                positionHolder.position = defaultextractorinput.getPosition();
                i = j;
            }
        }
        dataSource.close();
        if (true) goto _L4; else goto _L3
        Exception exception;
        exception;
        defaultextractorinput = null;
        break MISSING_BLOCK_LABEL_233;
_L6:
        if (i != 1 && defaultextractorinput != null)
        {
            positionHolder.position = defaultextractorinput.getPosition();
        }
        dataSource.close();
        throw exception;
_L3:
        return;
        exception;
        i = k;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public (Uri uri1, DataSource datasource,  , Allocator allocator1, int i, long l)
    {
        uri = (Uri)Assertions.checkNotNull(uri1);
        dataSource = (DataSource)Assertions.checkNotNull(datasource);
        extractorHolder = (extractorHolder)Assertions.checkNotNull();
        allocator = (Allocator)Assertions.checkNotNull(allocator1);
        requestedBufferSize = i;
        positionHolder.position = l;
        pendingExtractorSeek = true;
    }
}
