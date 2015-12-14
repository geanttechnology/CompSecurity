// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.util.Util;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
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
        int i;
        int j;
        int k;
        int j1;
        int k1;
        j1 = getFirstSegmentNum();
        k = j1;
        k1 = getLastSegmentNum();
        i = k1;
        j = k;
        if (segmentTimeline != null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        long l1 = (duration * 0xf4240L) / timescale;
        j = startNumber + (int)(l / l1);
        if (j >= k) goto _L2; else goto _L1
_L1:
        i = k;
_L4:
        return i;
_L2:
        i = j;
        if (k1 == -1) goto _L4; else goto _L3
_L3:
        i = j;
        if (j <= k1) goto _L4; else goto _L5
_L5:
        return k1;
        while (j <= i) 
        {
            int i1 = (j + i) / 2;
            long l2 = getSegmentTimeUs(i1);
            if (l2 < l)
            {
                j = i1 + 1;
            } else
            if (l2 > l)
            {
                i = i1 - 1;
            } else
            {
                return i1;
            }
        }
        if (j != j1)
        {
            j = i;
        }
        return j;
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
