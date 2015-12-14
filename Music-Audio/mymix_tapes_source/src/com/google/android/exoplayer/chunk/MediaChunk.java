// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Assertions;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            Chunk, Format

public abstract class MediaChunk extends Chunk
{

    public final int chunkIndex;
    public final long endTimeUs;
    public final boolean isLastChunk;
    public final long startTimeUs;

    public MediaChunk(DataSource datasource, DataSpec dataspec, int i, Format format, long l, long l1, int j, boolean flag)
    {
        super(datasource, dataspec, 1, i, format);
        Assertions.checkNotNull(format);
        startTimeUs = l;
        endTimeUs = l1;
        chunkIndex = j;
        isLastChunk = flag;
    }
}
