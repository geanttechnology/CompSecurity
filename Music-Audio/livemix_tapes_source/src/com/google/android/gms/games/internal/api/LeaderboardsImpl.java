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
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class LeaderboardsImpl
    implements Leaderboards
{
    private static abstract class LoadMetadataImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult zzah(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult(this, status) {

                final Status zzQs;
                final LoadMetadataImpl zzavd;

                public LeaderboardBuffer getLeaderboards()
                {
                    return new LeaderboardBuffer(DataHolder.zzbp(14));
                }

                public Status getStatus()
                {
                    return zzQs;
                }

                public void release()
                {
                }

            
            {
                zzavd = loadmetadataimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzah(status);
        }

        private LoadMetadataImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LoadPlayerScoreImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult zzai(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult(this, status) {

                final Status zzQs;
                final LoadPlayerScoreImpl zzave;

                public LeaderboardScore getScore()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzave = loadplayerscoreimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzai(status);
        }

        private LoadPlayerScoreImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LoadScoresImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult zzaj(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult(this, status) {

                final Status zzQs;
                final LoadScoresImpl zzavf;

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
                zzavf = loadscoresimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaj(status);
        }

        private LoadScoresImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    protected static abstract class SubmitScoreImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult zzak(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult(this, status) {

                final Status zzQs;
                final SubmitScoreImpl zzavg;

                public ScoreSubmissionData getScoreData()
                {
                    return new ScoreSubmissionData(DataHolder.zzbp(14));
                }

                public Status getStatus()
                {
                    return zzQs;
                }

                public void release()
                {
                }

            
            {
                zzavg = submitscoreimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzak(status);
        }

        protected SubmitScoreImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }


    public LeaderboardsImpl()
    {
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient googleapiclient)
    {
        return Games.zzd(googleapiclient).zztL();
    }

    public Intent getLeaderboardIntent(GoogleApiClient googleapiclient, String s)
    {
        return getLeaderboardIntent(googleapiclient, s, -1);
    }

    public Intent getLeaderboardIntent(GoogleApiClient googleapiclient, String s, int i)
    {
        return Games.zzd(googleapiclient).zzp(s, i);
    }

    public PendingResult loadCurrentPlayerLeaderboardScore(GoogleApiClient googleapiclient, String s, int i, int j)
    {
        return googleapiclient.zza(new LoadPlayerScoreImpl(googleapiclient, s, i, j) {

            final LeaderboardsImpl zzauU;
            final String zzauV;
            final int zzauW;
            final int zzauX;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, null, zzauV, zzauW, zzauX);
            }

            
            {
                zzauU = LeaderboardsImpl.this;
                zzauV = s;
                zzauW = i;
                zzauX = j;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadLeaderboardMetadata(GoogleApiClient googleapiclient, String s, boolean flag)
    {
        return googleapiclient.zza(new LoadMetadataImpl(googleapiclient, s, flag) {

            final LeaderboardsImpl zzauU;
            final String zzauV;
            final boolean zzaut;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzauV, zzaut);
            }

            
            {
                zzauU = LeaderboardsImpl.this;
                zzauV = s;
                zzaut = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadLeaderboardMetadata(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zza(new LoadMetadataImpl(googleapiclient, flag) {

            final LeaderboardsImpl zzauU;
            final boolean zzaut;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzaut);
            }

            
            {
                zzauU = LeaderboardsImpl.this;
                zzaut = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadMoreScores(GoogleApiClient googleapiclient, LeaderboardScoreBuffer leaderboardscorebuffer, int i, int j)
    {
        return googleapiclient.zza(new LoadScoresImpl(googleapiclient, leaderboardscorebuffer, i, j) {

            final LeaderboardsImpl zzauU;
            final int zzauY;
            final LeaderboardScoreBuffer zzauZ;
            final int zzava;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzauZ, zzauY, zzava);
            }

            
            {
                zzauU = LeaderboardsImpl.this;
                zzauZ = leaderboardscorebuffer;
                zzauY = i;
                zzava = j;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadPlayerCenteredScores(GoogleApiClient googleapiclient, String s, int i, int j, int k)
    {
        return loadPlayerCenteredScores(googleapiclient, s, i, j, k, false);
    }

    public PendingResult loadPlayerCenteredScores(GoogleApiClient googleapiclient, String s, int i, int j, int k, boolean flag)
    {
        return googleapiclient.zza(new LoadScoresImpl(googleapiclient, s, i, j, k, flag) {

            final LeaderboardsImpl zzauU;
            final String zzauV;
            final int zzauW;
            final int zzauX;
            final int zzauY;
            final boolean zzaut;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzauV, zzauW, zzauX, zzauY, zzaut);
            }

            
            {
                zzauU = LeaderboardsImpl.this;
                zzauV = s;
                zzauW = i;
                zzauX = j;
                zzauY = k;
                zzaut = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadTopScores(GoogleApiClient googleapiclient, String s, int i, int j, int k)
    {
        return loadTopScores(googleapiclient, s, i, j, k, false);
    }

    public PendingResult loadTopScores(GoogleApiClient googleapiclient, String s, int i, int j, int k, boolean flag)
    {
        return googleapiclient.zza(new LoadScoresImpl(googleapiclient, s, i, j, k, flag) {

            final LeaderboardsImpl zzauU;
            final String zzauV;
            final int zzauW;
            final int zzauX;
            final int zzauY;
            final boolean zzaut;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzauV, zzauW, zzauX, zzauY, zzaut);
            }

            
            {
                zzauU = LeaderboardsImpl.this;
                zzauV = s;
                zzauW = i;
                zzauX = j;
                zzauY = k;
                zzaut = flag;
                super(googleapiclient);
            }
        });
    }

    public void submitScore(GoogleApiClient googleapiclient, String s, long l)
    {
        submitScore(googleapiclient, s, l, null);
    }

    public void submitScore(GoogleApiClient googleapiclient, String s, long l, String s1)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        googleapiclient.zza(null, s, l, s1);
        return;
        googleapiclient;
        GamesLog.zzw("LeaderboardsImpl", "service died");
        return;
    }

    public PendingResult submitScoreImmediate(GoogleApiClient googleapiclient, String s, long l)
    {
        return submitScoreImmediate(googleapiclient, s, l, null);
    }

    public PendingResult submitScoreImmediate(GoogleApiClient googleapiclient, String s, long l, String s1)
    {
        return googleapiclient.zzb(new SubmitScoreImpl(googleapiclient, s, l, s1) {

            final LeaderboardsImpl zzauU;
            final String zzauV;
            final long zzavb;
            final String zzavc;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzauV, zzavb, zzavc);
            }

            
            {
                zzauU = LeaderboardsImpl.this;
                zzauV = s;
                zzavb = l;
                zzavc = s1;
                super(googleapiclient);
            }
        });
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/LeaderboardsImpl$10

/* anonymous class */
    class _cls10 extends LoadScoresImpl
    {

        final String zzauV;
        final int zzauW;
        final int zzauX;
        final int zzauY;
        final boolean zzaut;
        final String zzauv;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzauv, zzauV, zzauW, zzauX, zzauY, zzaut);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/LeaderboardsImpl$11

/* anonymous class */
    class _cls11 extends LoadScoresImpl
    {

        final String zzauV;
        final int zzauW;
        final int zzauX;
        final int zzauY;
        final boolean zzaut;
        final String zzauv;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzauv, zzauV, zzauW, zzauX, zzauY, zzaut);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/LeaderboardsImpl$8

/* anonymous class */
    class _cls8 extends LoadMetadataImpl
    {

        final boolean zzaut;
        final String zzauv;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzc(this, zzauv, zzaut);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/LeaderboardsImpl$9

/* anonymous class */
    class _cls9 extends LoadMetadataImpl
    {

        final String zzauV;
        final boolean zzaut;
        final String zzauv;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzauv, zzauV, zzaut);
        }
    }

}
