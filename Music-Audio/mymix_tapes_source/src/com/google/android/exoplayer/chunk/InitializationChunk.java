// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.DefaultExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            Chunk, ChunkExtractorWrapper, Format

public final class InitializationChunk extends Chunk
    implements ChunkExtractorWrapper.SingleTrackOutput
{

    private volatile int bytesLoaded;
    private DrmInitData drmInitData;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private MediaFormat mediaFormat;
    private SeekMap seekMap;

    public InitializationChunk(DataSource datasource, DataSpec dataspec, int i, Format format1, ChunkExtractorWrapper chunkextractorwrapper)
    {
        super(datasource, dataspec, 2, i, format1);
        extractorWrapper = chunkextractorwrapper;
    }

    public long bytesLoaded()
    {
        return (long)bytesLoaded;
    }

    public void cancelLoad()
    {
        loadCanceled = true;
    }

    public void drmInitData(DrmInitData drminitdata)
    {
        drmInitData = drminitdata;
    }

    public void format(MediaFormat mediaformat)
    {
        mediaFormat = mediaformat;
    }

    public DrmInitData getDrmInitData()
    {
        return drmInitData;
    }

    public MediaFormat getFormat()
    {
        return mediaFormat;
    }

    public SeekMap getSeekMap()
    {
        return seekMap;
    }

    public boolean hasDrmInitData()
    {
        return drmInitData != null;
    }

    public boolean hasFormat()
    {
        return mediaFormat != null;
    }

    public boolean hasSeekMap()
    {
        return seekMap != null;
    }

    public boolean isLoadCanceled()
    {
        return loadCanceled;
    }

    public void load()
        throws IOException, InterruptedException
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

    public int sampleData(ExtractorInput extractorinput, int i, boolean flag)
        throws IOException, InterruptedException
    {
        throw new IllegalStateException("Unexpected sample data in initialization chunk");
    }

    public void sampleData(ParsableByteArray parsablebytearray, int i)
    {
        throw new IllegalStateException("Unexpected sample data in initialization chunk");
    }

    public void sampleMetadata(long l, int i, int j, int k, byte abyte0[])
    {
        throw new IllegalStateException("Unexpected sample data in initialization chunk");
    }

    public void seekMap(SeekMap seekmap)
    {
        seekMap = seekmap;
    }
}
