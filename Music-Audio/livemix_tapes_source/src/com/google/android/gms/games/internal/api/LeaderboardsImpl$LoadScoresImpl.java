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

    public com.google.android.gms.games.leaderboard. zzaj(Status status)
    {
        return new com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult(status) {

            final Status zzQs;
            final LeaderboardsImpl.LoadScoresImpl zzavf;

            public Leaderboard getLeaderboard()
            {
                return null;
            }

            public LeaderboardScoreBuffer getScores()
            {
                return new LeaderboardScoreBuffer(DataHolder.zzbp(14));
            }

            public Status getStatus()
            {
                return zzQs;
            }

            public void release()
            {
            }

            
            {
                zzavf = LeaderboardsImpl.LoadScoresImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzaj(status);
    }

    private _cls1.zzQs(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    _cls1.zzQs(GoogleApiClient googleapiclient, _cls1.zzQs zzqs)
    {
        this(googleapiclient);
    }
}
