// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats;

public final class StatsImpl
    implements Stats
{
    private static abstract class LoadsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult zzaD(Status status)
        {
            return new com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult(this, status) {

                final Status zzVb;
                final LoadsImpl zzayI;

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
                zzayI = loadsimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaD(status);
        }

        private LoadsImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public StatsImpl()
    {
    }

    public PendingResult loadPlayerStats(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zza(new LoadsImpl(googleapiclient, flag) {

            final boolean zzawR;
            final StatsImpl zzayH;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zze(this, zzawR);
            }

            
            {
                zzayH = StatsImpl.this;
                zzawR = flag;
                super(googleapiclient);
            }
        });
    }
}
