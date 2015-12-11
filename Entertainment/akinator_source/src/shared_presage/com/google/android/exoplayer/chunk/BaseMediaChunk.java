// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;

import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.drm.DrmInitData;
import shared_presage.com.google.android.exoplayer.extractor.DefaultTrackOutput;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;

// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            MediaChunk, Format

public abstract class BaseMediaChunk extends MediaChunk
{

    private int firstSampleIndex;
    public final boolean isMediaFormatFinal;
    private DefaultTrackOutput output;

    public BaseMediaChunk(DataSource datasource, DataSpec dataspec, int i, Format format, long l, long l1, int j, boolean flag, boolean flag1)
    {
        super(datasource, dataspec, i, format, l, l1, j, flag);
        isMediaFormatFinal = flag1;
    }

    public abstract DrmInitData getDrmInitData();

    public final int getFirstSampleIndex()
    {
        return firstSampleIndex;
    }

    public abstract MediaFormat getMediaFormat();

    protected final DefaultTrackOutput getOutput()
    {
        return output;
    }

    public void init(DefaultTrackOutput defaulttrackoutput)
    {
        output = defaulttrackoutput;
        firstSampleIndex = defaulttrackoutput.getWriteIndex();
    }
}
