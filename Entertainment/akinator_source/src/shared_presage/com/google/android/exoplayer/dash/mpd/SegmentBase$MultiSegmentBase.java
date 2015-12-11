// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.dash.mpd;

import java.util.List;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.dash.mpd:
//            SegmentBase, RangedUri, Representation

public static abstract class segmentTimeline extends SegmentBase
{

    final long duration;
    final long periodDurationMs;
    final List segmentTimeline;
    final int startNumber;

    public int getFirstSegmentNum()
    {
        return startNumber;
    }

    public abstract int getLastSegmentNum();

    public final long getSegmentDurationUs(int i)
    {
        if (segmentTimeline != null)
        {
            return (((ement)segmentTimeline.get(i - startNumber)).duration * 0xf4240L) / timescale;
        }
        if (i == getLastSegmentNum())
        {
            return periodDurationMs * 1000L - getSegmentTimeUs(i);
        } else
        {
            return (duration * 0xf4240L) / timescale;
        }
    }

    public int getSegmentNum(long l)
    {
_L2:
        int j;
        while (j <= k) 
        {
            int j1 = (j + k) / 2;
            long l2 = getSegmentTimeUs(j1);
            if (l2 < l)
            {
                j = j1 + 1;
            } else
            if (l2 > l)
            {
                k = j1 - 1;
            } else
            {
                return j1;
            }
        }
        if (j == i1)
        {
            return j;
        } else
        {
            return k;
        }
        int i1 = getFirstSegmentNum();
        int k = getLastSegmentNum();
        if (segmentTimeline == null)
        {
            long l1 = (duration * 0xf4240L) / timescale;
            int i = startNumber;
            i = (int)(l / l1) + i;
            if (i < i1)
            {
                return i1;
            }
            if (k != -1 && i > k)
            {
                return k;
            } else
            {
                return i;
            }
        }
        j = i1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final long getSegmentTimeUs(int i)
    {
        long l;
        if (segmentTimeline != null)
        {
            l = ((ement)segmentTimeline.get(i - startNumber)).startTime - presentationTimeOffset;
        } else
        {
            l = (long)(i - startNumber) * duration;
        }
        return Util.scaleLargeTimestamp(l, 0xf4240L, timescale);
    }

    public abstract RangedUri getSegmentUrl(Representation representation, int i);

    public boolean isExplicit()
    {
        return segmentTimeline != null;
    }

    public ement(RangedUri rangeduri, long l, long l1, long l2, 
            int i, long l3, List list)
    {
        super(rangeduri, l, l1);
        periodDurationMs = l2;
        startNumber = i;
        duration = l3;
        segmentTimeline = list;
    }
}
