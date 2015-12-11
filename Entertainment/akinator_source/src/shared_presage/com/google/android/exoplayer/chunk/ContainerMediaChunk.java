// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;

import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.drm.DrmInitData;
import shared_presage.com.google.android.exoplayer.extractor.DefaultExtractorInput;
import shared_presage.com.google.android.exoplayer.extractor.DefaultTrackOutput;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorInput;
import shared_presage.com.google.android.exoplayer.extractor.SeekMap;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            BaseMediaChunk, ChunkExtractorWrapper, Format

public class ContainerMediaChunk extends BaseMediaChunk
    implements ChunkExtractorWrapper.SingleTrackOutput
{

    private volatile int bytesLoaded;
    private DrmInitData drmInitData;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private MediaFormat mediaFormat;
    private final long sampleOffsetUs;

    public ContainerMediaChunk(DataSource datasource, DataSpec dataspec, int i, Format format1, long l, long l1, int j, boolean flag, long l2, ChunkExtractorWrapper chunkextractorwrapper, MediaFormat mediaformat, 
            DrmInitData drminitdata, boolean flag1)
    {
        super(datasource, dataspec, i, format1, l, l1, j, flag, flag1);
        extractorWrapper = chunkextractorwrapper;
        sampleOffsetUs = l2;
        mediaFormat = mediaformat;
        drmInitData = drminitdata;
    }

    public final long bytesLoaded()
    {
        return (long)bytesLoaded;
    }

    public final void cancelLoad()
    {
        loadCanceled = true;
    }

    public final void drmInitData(DrmInitData drminitdata)
    {
        drmInitData = drminitdata;
    }

    public final void format(MediaFormat mediaformat)
    {
        mediaFormat = mediaformat;
    }

    public final DrmInitData getDrmInitData()
    {
        return drmInitData;
    }

    public final MediaFormat getMediaFormat()
    {
        return mediaFormat;
    }

    public final boolean isLoadCanceled()
    {
        return loadCanceled;
    }

    public final void load()
    {
        Object obj = Util.getRemainderDataSpec(dataSpec, bytesLoaded);
        obj = new DefaultExtractorInput(dataSource, ((DataSpec) (obj)).absoluteStreamPosition, dataSource.open(((DataSpec) (obj))));
        if (bytesLoaded == 0)
        {
            extractorWrapper.init(this);
        }
        int i = 0;
_L1:
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        if (loadCanceled)
        {
            break MISSING_BLOCK_LABEL_78;
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

    public final int sampleData(ExtractorInput extractorinput, int i, boolean flag)
    {
        return getOutput().sampleData(extractorinput, i, flag);
    }

    public final void sampleData(ParsableByteArray parsablebytearray, int i)
    {
        getOutput().sampleData(parsablebytearray, i);
    }

    public final void sampleMetadata(long l, int i, int j, int k, byte abyte0[])
    {
        getOutput().sampleMetadata(sampleOffsetUs + l, i, j, k, abyte0);
    }

    public final void seekMap(SeekMap seekmap)
    {
    }
}
