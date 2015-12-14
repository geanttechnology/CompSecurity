// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.dash.DashSegmentIndex;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            RangedUri

final class DashSingleSegmentIndex
    implements DashSegmentIndex
{

    private final long durationUs;
    private final long startTimeUs;
    private final RangedUri uri;

    public DashSingleSegmentIndex(long l, long l1, RangedUri rangeduri)
    {
        startTimeUs = l;
        durationUs = l1;
        uri = rangeduri;
    }

    public long getDurationUs(int i)
    {
        return durationUs;
    }

    public int getFirstSegmentNum()
    {
        return 0;
    }

    public int getLastSegmentNum()
    {
        return 0;
    }

    public int getSegmentNum(long l)
    {
        return 0;
    }

    public RangedUri getSegmentUrl(int i)
    {
        return uri;
    }

    public long getTimeUs(int i)
    {
        return startTimeUs;
    }

    public boolean isExplicit()
    {
        return true;
    }
}
