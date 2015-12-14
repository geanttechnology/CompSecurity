// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.stats.Stats;

public final class StatsImpl
    implements Stats
{
    private static abstract class LoadsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult zzaE(Status status)
        {
            return new com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult(this, status) {

                final Status zzQs;
                final LoadsImpl zzawj;

                public Status getStatus()
                {
                    return zzQs;
                }

                public void release()
                {
                }

            
            {
                zzawj = loadsimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaE(status);
        }
    }


    public StatsImpl()
    {
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/StatsImpl$1

/* anonymous class */
    class _cls1 extends LoadsImpl
    {

        final boolean zzaut;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zze(this, zzaut);
        }
    }

}
