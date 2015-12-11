// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzavD extends zzavD
    implements com.google.android.gms.games.leaderboard.vD
{

    private final LeaderboardBuffer zzavD;

    public LeaderboardBuffer getLeaderboards()
    {
        return zzavD;
    }

    Y(DataHolder dataholder)
    {
        super(dataholder);
        zzavD = new LeaderboardBuffer(dataholder);
    }
}
