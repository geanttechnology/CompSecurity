// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            LeaderboardScoreBufferHeader, LeaderboardScoreRef, LeaderboardScore

public final class LeaderboardScoreBuffer extends AbstractDataBuffer
{

    private final LeaderboardScoreBufferHeader zzaxx;

    public LeaderboardScoreBuffer(DataHolder dataholder)
    {
        super(dataholder);
        zzaxx = new LeaderboardScoreBufferHeader(dataholder.zznP());
    }

    public LeaderboardScore get(int i)
    {
        return new LeaderboardScoreRef(zzYX, i);
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    public LeaderboardScoreBufferHeader zzuR()
    {
        return zzaxx;
    }
}
