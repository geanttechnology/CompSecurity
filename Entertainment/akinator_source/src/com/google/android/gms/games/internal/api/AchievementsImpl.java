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

        public com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult zzV(Status status)
        {
            return new com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult(this, status) {

                final Status zzVb;
                final LoadImpl zzawW;

                public AchievementBuffer getAchievements()
                {
                    return new AchievementBuffer(DataHolder.zzbu(14));
                }

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzawW = loadimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzV(status);
        }

        private LoadImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class UpdateImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        private final String zzwN;

        static String zza(UpdateImpl updateimpl)
        {
            return updateimpl.zzwN;
        }

        public com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult zzW(Status status)
        {
            return new com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult(this, status) {

                final Status zzVb;
                final UpdateImpl zzawX;

                public String getAchievementId()
                {
                    return UpdateImpl.zza(zzawX);
                }

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzawX = updateimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzW(status);
        }

        public UpdateImpl(String s, GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
            zzwN = s;
        }
    }


    public AchievementsImpl()
    {
    }

    public Intent getAchievementsIntent(GoogleApiClient googleapiclient)
    {
        return Games.zzc(googleapiclient).zzuC();
    }

    public void increment(GoogleApiClient googleapiclient, String s, int i)
    {
        googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s, i) {

            final AchievementsImpl zzawS;
            final String zzawU;
            final int zzawV;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(null, zzawU, zzawV);
            }

            
            {
                zzawS = AchievementsImpl.this;
                zzawU = s1;
                zzawV = i;
                super(s, googleapiclient);
            }
        });
    }

    public PendingResult incrementImmediate(GoogleApiClient googleapiclient, String s, int i)
    {
        return googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s, i) {

            final AchievementsImpl zzawS;
            final String zzawU;
            final int zzawV;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzawU, zzawV);
            }

            
            {
                zzawS = AchievementsImpl.this;
                zzawU = s1;
                zzawV = i;
                super(s, googleapiclient);
            }
        });
    }

    public PendingResult load(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zza(new LoadImpl(googleapiclient, flag) {

            final boolean zzawR;
            final AchievementsImpl zzawS;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzc(this, zzawR);
            }

            
            {
                zzawS = AchievementsImpl.this;
                zzawR = flag;
                super(googleapiclient);
            }
        });
    }

    public void reveal(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s) {

            final AchievementsImpl zzawS;
            final String zzawU;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(null, zzawU);
            }

            
            {
                zzawS = AchievementsImpl.this;
                zzawU = s1;
                super(s, googleapiclient);
            }
        });
    }

    public PendingResult revealImmediate(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s) {

            final AchievementsImpl zzawS;
            final String zzawU;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzawU);
            }

            
            {
                zzawS = AchievementsImpl.this;
                zzawU = s1;
                super(s, googleapiclient);
            }
        });
    }

    public void setSteps(GoogleApiClient googleapiclient, String s, int i)
    {
        googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s, i) {

            final AchievementsImpl zzawS;
            final String zzawU;
            final int zzawV;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(null, zzawU, zzawV);
            }

            
            {
                zzawS = AchievementsImpl.this;
                zzawU = s1;
                zzawV = i;
                super(s, googleapiclient);
            }
        });
    }

    public PendingResult setStepsImmediate(GoogleApiClient googleapiclient, String s, int i)
    {
        return googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s, i) {

            final AchievementsImpl zzawS;
            final String zzawU;
            final int zzawV;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzawU, zzawV);
            }

            
            {
                zzawS = AchievementsImpl.this;
                zzawU = s1;
                zzawV = i;
                super(s, googleapiclient);
            }
        });
    }

    public void unlock(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s) {

            final AchievementsImpl zzawS;
            final String zzawU;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(null, zzawU);
            }

            
            {
                zzawS = AchievementsImpl.this;
                zzawU = s1;
                super(s, googleapiclient);
            }
        });
    }

    public PendingResult unlockImmediate(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new UpdateImpl(s, googleapiclient, s) {

            final AchievementsImpl zzawS;
            final String zzawU;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzawU);
            }

            
            {
                zzawS = AchievementsImpl.this;
                zzawU = s1;
                super(s, googleapiclient);
            }
        });
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/AchievementsImpl$10

/* anonymous class */
    class _cls10 extends LoadImpl
    {

        final String zzXY;
        final boolean zzawR;
        final String zzawT;

        public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        public void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzXY, zzawT, zzawR);
        }
    }

}
