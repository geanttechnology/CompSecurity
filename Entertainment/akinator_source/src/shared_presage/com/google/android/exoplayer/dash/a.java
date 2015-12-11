// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.dash;

import shared_presage.com.google.android.exoplayer.TimeRange;

// Referenced classes of package shared_presage.com.google.android.exoplayer.dash:
//            DashChunkSource

final class a
    implements Runnable
{

    final TimeRange a;
    final DashChunkSource b;

    a(DashChunkSource dashchunksource, TimeRange timerange)
    {
        b = dashchunksource;
        a = timerange;
        super();
    }

    public final void run()
    {
        DashChunkSource.access$000(b).onSeekRangeChanged(a);
    }
}
