// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl
    implements Achievements
{
    private static abstract class LoadImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult zzW(Status status)
        {
            return new com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult(this, status) {

                final Status zzQs;
                final LoadImpl zzauy;

                public AchievementBuffer getAchievements()
                {
                    return new AchievementBuffer(DataHolder.zzbp(14));
                }

                public Status getStatus()
                {
                    return zzQs;
                }

                public void release()
                {
                }

            
            {
                zzauy = loadimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzW(status);
        }

        private LoadImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class UpdateImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        private final String zzwj;

        static String zza(UpdateImpl updateimpl)
        {
            return updateimpl.zzwj;
        }

        public com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult zzX(Status status)
        {
            return new com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult(this, status) {

                final Status zzQs;
                final UpdateImpl zzauz;

                public String getAchievementId()
                {
                    return UpdateImpl.zza(zzauz);
                }

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzauz = updateimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzX(status);
        }

        public UpdateImpl(String s, GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
            zzwj = s;
        }
    }


    public AchievementsImpl()
    {
    }

    public Intent getAchievementsIntent(GoogleApiClient googleapiclient)
    {
        return Games.zzd(googleapiclient).zztM();
    }

    public void increment(GoogleApiClient googleapiclient, String s, int i)
    {
        googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s, i) {

            final AchievementsImpl zzauu;
            final String zzauw;
            final int zzaux;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(null, zzauw, zzaux);
            }

            
            {
                zzauu = AchievementsImpl.this;
                zzauw = s1;
                zzaux = i;
                super(s, googleapiclient);
            }
        });
    }

    public PendingResult incrementImmediate(GoogleApiClient googleapiclient, String s, int i)
    {
        return googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s, i) {

            final AchievementsImpl zzauu;
            final String zzauw;
            final int zzaux;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzauw, zzaux);
            }

            
            {
                zzauu = AchievementsImpl.this;
                zzauw = s1;
                zzaux = i;
                super(s, googleapiclient);
            }
        });
    }

    public PendingResult load(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zza(new LoadImpl(googleapiclient, flag) {

            final boolean zzaut;
            final AchievementsImpl zzauu;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzc(this, zzaut);
            }

            
            {
                zzauu = AchievementsImpl.this;
                zzaut = flag;
                super(googleapiclient);
            }
        });
    }

    public void reveal(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s) {

            final AchievementsImpl zzauu;
            final String zzauw;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(null, zzauw);
            }

            
            {
                zzauu = AchievementsImpl.this;
                zzauw = s1;
                super(s, googleapiclient);
            }
        });
    }

    public PendingResult revealImmediate(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s) {

            final AchievementsImpl zzauu;
            final String zzauw;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzauw);
            }

            
            {
                zzauu = AchievementsImpl.this;
                zzauw = s1;
                super(s, googleapiclient);
            }
        });
    }

    public void setSteps(GoogleApiClient googleapiclient, String s, int i)
    {
        googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s, i) {

            final AchievementsImpl zzauu;
            final String zzauw;
            final int zzaux;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(null, zzauw, zzaux);
            }

            
            {
                zzauu = AchievementsImpl.this;
                zzauw = s1;
                zzaux = i;
                super(s, googleapiclient);
            }
        });
    }

    public PendingResult setStepsImmediate(GoogleApiClient googleapiclient, String s, int i)
    {
        return googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s, i) {

            final AchievementsImpl zzauu;
            final String zzauw;
            final int zzaux;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzauw, zzaux);
            }

            
            {
                zzauu = AchievementsImpl.this;
                zzauw = s1;
                zzaux = i;
                super(s, googleapiclient);
            }
        });
    }

    public void unlock(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s) {

            final AchievementsImpl zzauu;
            final String zzauw;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(null, zzauw);
            }

            
            {
                zzauu = AchievementsImpl.this;
                zzauw = s1;
                super(s, googleapiclient);
            }
        });
    }

    public PendingResult unlockImmediate(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s) {

            final AchievementsImpl zzauu;
            final String zzauw;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzauw);
            }

            
            {
                zzauu = AchievementsImpl.this;
                zzauw = s1;
                super(s, googleapiclient);
            }
        });
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/AchievementsImpl$10

/* anonymous class */
    class _cls10 extends LoadImpl
    {

        final String zzWg;
        final boolean zzaut;
        final String zzauv;

        public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        public void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzWg, zzauv, zzaut);
        }
    }

}
