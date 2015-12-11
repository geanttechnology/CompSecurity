// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            LeaderboardsImpl

private static abstract class <init> extends com.google.android.gms.games.adScoresImpl
{

    public com.google.android.gms.games.leaderboard. zzai(Status status)
    {
        return new com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult(status) {

            final Status zzVb;
            final LeaderboardsImpl.LoadScoresImpl zzaxD;

            public Leaderboard getLeaderboard()
            {
                return null;
            }

            public LeaderboardScoreBuffer getScores()
            {
                return new LeaderboardScoreBuffer(DataHolder.zzbu(14));
            }

            public Status getStatus()
            {
                return zzVb;
            }

            public void release()
            {
            }

            
            {
                zzaxD = LeaderboardsImpl.LoadScoresImpl.this;
                zzVb = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzai(status);
    }

    private _cls1.zzVb(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    _cls1.zzVb(GoogleApiClient googleapiclient, _cls1.zzVb zzvb)
    {
        this(googleapiclient);
    }
}
