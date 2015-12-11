// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.stats.PlayerStats;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            StatsImpl

private static abstract class <init> extends com.google.android.gms.games.thodImpl
{

    public com.google.android.gms.games.stats.sResult zzaD(Status status)
    {
        return new com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult(status) {

            final Status zzVb;
            final StatsImpl.LoadsImpl zzayI;

            public PlayerStats getPlayerStats()
            {
                return null;
            }

            public Status getStatus()
            {
                return zzVb;
            }

            public void release()
            {
            }

            
            {
                zzayI = StatsImpl.LoadsImpl.this;
                zzVb = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzaD(status);
    }

    private _cls1.zzVb(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    t>(GoogleApiClient googleapiclient, t> t>)
    {
        this(googleapiclient);
    }
}
