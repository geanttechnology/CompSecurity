// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.dash.mpd;

import shared_presage.com.google.android.exoplayer.dash.DashSegmentIndex;

// Referenced classes of package shared_presage.com.google.android.exoplayer.dash.mpd:
//            RangedUri

final class a
    implements DashSegmentIndex
{

    private final long a;
    private final long b;
    private final RangedUri c;

    public a(long l, long l1, RangedUri rangeduri)
    {
        a = l;
        b = l1;
        c = rangeduri;
    }

    public final long getDurationUs(int i)
    {
        return b;
    }

    public final int getFirstSegmentNum()
    {
        return 0;
    }

    public final int getLastSegmentNum()
    {
        return 0;
    }

    public final int getSegmentNum(long l)
    {
        return 0;
    }

    public final RangedUri getSegmentUrl(int i)
    {
        return c;
    }

    public final long getTimeUs(int i)
    {
        return a;
    }

    public final boolean isExplicit()
    {
        return true;
    }
}
