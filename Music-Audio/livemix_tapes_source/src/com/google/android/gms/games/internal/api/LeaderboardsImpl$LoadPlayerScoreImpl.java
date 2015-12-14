// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.leaderboard.LeaderboardScore;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            LeaderboardsImpl

private static abstract class <init> extends com.google.android.gms.games.yerScoreImpl
{

    public com.google.android.gms.games.leaderboard. zzai(Status status)
    {
        return new com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult(status) {

            final Status zzQs;
            final LeaderboardsImpl.LoadPlayerScoreImpl zzave;

            public LeaderboardScore getScore()
            {
                return null;
            }

            public Status getStatus()
            {
                return zzQs;
            }

            
            {
                zzave = LeaderboardsImpl.LoadPlayerScoreImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzai(status);
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
