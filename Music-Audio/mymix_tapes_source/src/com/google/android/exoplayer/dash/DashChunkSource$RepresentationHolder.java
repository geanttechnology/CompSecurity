// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer.dash.mpd.Representation;

// Referenced classes of package com.google.android.exoplayer.dash:
//            DashChunkSource, DashSegmentIndex

private static class segmentIndex
{

    public final ChunkExtractorWrapper extractorWrapper;
    public MediaFormat format;
    public final Representation representation;
    public DashSegmentIndex segmentIndex;
    public int segmentNumShift;
    public byte vttHeader[];
    public long vttHeaderOffsetUs;

    public (Representation representation1, ChunkExtractorWrapper chunkextractorwrapper)
    {
        representation = representation1;
        extractorWrapper = chunkextractorwrapper;
        segmentIndex = representation1.getIndex();
    }
}
