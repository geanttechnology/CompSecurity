// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.dash.mpd;

import shared_presage.com.google.android.exoplayer.chunk.Format;
import shared_presage.com.google.android.exoplayer.dash.DashSegmentIndex;

// Referenced classes of package shared_presage.com.google.android.exoplayer.dash.mpd:
//            Representation, RangedUri

public static class segmentBase extends Representation
    implements DashSegmentIndex
{

    private final segmentBase segmentBase;

    public long getDurationUs(int i)
    {
        return segmentBase.ationUs(i);
    }

    public int getFirstSegmentNum()
    {
        return segmentBase.ntNum();
    }

    public DashSegmentIndex getIndex()
    {
        return this;
    }

    public RangedUri getIndexUri()
    {
        return null;
    }

    public int getLastSegmentNum()
    {
        return segmentBase.tNum();
    }

    public int getSegmentNum(long l)
    {
        return segmentBase.(l - periodStartMs * 1000L);
    }

    public RangedUri getSegmentUrl(int i)
    {
        return segmentBase.(this, i);
    }

    public long getTimeUs(int i)
    {
        return segmentBase.eUs(i) + periodStartMs * 1000L;
    }

    public boolean isExplicit()
    {
        return segmentBase.segmentBase();
    }

    public (long l, long l1, String s, long l2, 
            Format format,  )
    {
        super(l, l1, s, l2, format, , null);
        segmentBase = ;
    }
}
