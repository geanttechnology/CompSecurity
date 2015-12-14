// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash;

import com.google.android.exoplayer.dash.mpd.RangedUri;
import com.google.android.exoplayer.extractor.ChunkIndex;

// Referenced classes of package com.google.android.exoplayer.dash:
//            DashSegmentIndex

final class DashWrappingSegmentIndex
    implements DashSegmentIndex
{

    private final ChunkIndex chunkIndex;
    private final long startTimeUs;
    private final String uri;

    public DashWrappingSegmentIndex(ChunkIndex chunkindex, String s, long l)
    {
        chunkIndex = chunkindex;
        uri = s;
        startTimeUs = l;
    }

    public long getDurationUs(int i)
    {
        return chunkIndex.durationsUs[i];
    }

    public int getFirstSegmentNum()
    {
        return 0;
    }

    public int getLastSegmentNum()
    {
        return chunkIndex.length - 1;
    }

    public int getSegmentNum(long l)
    {
        return chunkIndex.getChunkIndex(l - startTimeUs);
    }

    public RangedUri getSegmentUrl(int i)
    {
        return new RangedUri(uri, null, chunkIndex.offsets[i], chunkIndex.sizes[i]);
    }

    public long getTimeUs(int i)
    {
        return chunkIndex.timesUs[i] + startTimeUs;
    }

    public boolean isExplicit()
    {
        return true;
    }
}
