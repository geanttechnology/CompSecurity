// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.dash;

import shared_presage.com.google.android.exoplayer.dash.mpd.RangedUri;
import shared_presage.com.google.android.exoplayer.extractor.ChunkIndex;

// Referenced classes of package shared_presage.com.google.android.exoplayer.dash:
//            DashSegmentIndex

final class b
    implements DashSegmentIndex
{

    private final ChunkIndex a;
    private final String b;
    private final long c;

    public b(ChunkIndex chunkindex, String s, long l)
    {
        a = chunkindex;
        b = s;
        c = l;
    }

    public final long getDurationUs(int i)
    {
        return a.durationsUs[i];
    }

    public final int getFirstSegmentNum()
    {
        return 0;
    }

    public final int getLastSegmentNum()
    {
        return a.length - 1;
    }

    public final int getSegmentNum(long l)
    {
        return a.getChunkIndex(l - c);
    }

    public final RangedUri getSegmentUrl(int i)
    {
        return new RangedUri(b, null, a.offsets[i], a.sizes[i]);
    }

    public final long getTimeUs(int i)
    {
        return a.timesUs[i] + c;
    }

    public final boolean isExplicit()
    {
        return true;
    }
}
