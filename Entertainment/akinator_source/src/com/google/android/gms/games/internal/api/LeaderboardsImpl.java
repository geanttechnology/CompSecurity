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

        public com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult zzag(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult(this, status) {

                final Status zzVb;
                final LoadMetadataImpl zzaxB;

                public LeaderboardBuffer getLeaderboards()
                {
                    return new LeaderboardBuffer(DataHolder.zzbu(14));
                }

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzaxB = loadmetadataimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzag(status);
        }

        private LoadMetadataImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LoadPlayerScoreImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult zzah(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult(this, status) {

                final Status zzVb;
                final LoadPlayerScoreImpl zzaxC;

                public LeaderboardScore getScore()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzaxC = loadplayerscoreimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzah(status);
        }

        private LoadPlayerScoreImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LoadScoresImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult zzai(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult(this, status) {

                final Status zzVb;
                final LoadScoresImpl zzaxD;

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
                zzaxD = loadscoresimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzai(status);
        }

        private LoadScoresImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    protected static abstract class SubmitScoreImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult zzaj(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult(this, status) {

                final Status zzVb;
                final SubmitScoreImpl zzaxE;

                public ScoreSubmissionData getScoreData()
                {
                    return new ScoreSubmissionData(DataHolder.zzbu(14));
                }

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzaxE = submitscoreimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaj(status);
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
        return Games.zzc(googleapiclient).zzuB();
    }

    public Intent getLeaderboardIntent(GoogleApiClient googleapiclient, String s)
    {
        return getLeaderboardIntent(googleapiclient, s, -1);
    }

    public Intent getLeaderboardIntent(GoogleApiClient googleapiclient, String s, int i)
    {
        return getLeaderboardIntent(googleapiclient, s, i, -1);
    }

    public Intent getLeaderboardIntent(GoogleApiClient googleapiclient, String s, int i, int j)
    {
        return Games.zzc(googleapiclient).zzl(s, i, j);
    }

    public PendingResult loadCurrentPlayerLeaderboardScore(GoogleApiClient googleapiclient, String s, int i, int j)
    {
        return googleapiclient.zza(new LoadPlayerScoreImpl(googleapiclient, s, i, j) {

            final LeaderboardsImpl zzaxs;
            final String zzaxt;
            final int zzaxu;
            final int zzaxv;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, null, zzaxt, zzaxu, zzaxv);
            }

            
            {
                zzaxs = LeaderboardsImpl.this;
                zzaxt = s;
                zzaxu = i;
                zzaxv = j;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadLeaderboardMetadata(GoogleApiClient googleapiclient, String s, boolean flag)
    {
        return googleapiclient.zza(new LoadMetadataImpl(googleapiclient, s, flag) {

            final boolean zzawR;
            final LeaderboardsImpl zzaxs;
            final String zzaxt;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzaxt, zzawR);
            }

            
            {
                zzaxs = LeaderboardsImpl.this;
                zzaxt = s;
                zzawR = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadLeaderboardMetadata(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zza(new LoadMetadataImpl(googleapiclient, flag) {

            final boolean zzawR;
            final LeaderboardsImpl zzaxs;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzawR);
            }

            
            {
                zzaxs = LeaderboardsImpl.this;
                zzawR = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadMoreScores(GoogleApiClient googleapiclient, LeaderboardScoreBuffer leaderboardscorebuffer, int i, int j)
    {
        return googleapiclient.zza(new LoadScoresImpl(googleapiclient, leaderboardscorebuffer, i, j) {

            final LeaderboardsImpl zzaxs;
            final int zzaxw;
            final LeaderboardScoreBuffer zzaxx;
            final int zzaxy;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzaxx, zzaxw, zzaxy);
            }

            
            {
                zzaxs = LeaderboardsImpl.this;
                zzaxx = leaderboardscorebuffer;
                zzaxw = i;
                zzaxy = j;
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

            final boolean zzawR;
            final LeaderboardsImpl zzaxs;
            final String zzaxt;
            final int zzaxu;
            final int zzaxv;
            final int zzaxw;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzaxt, zzaxu, zzaxv, zzaxw, zzawR);
            }

            
            {
                zzaxs = LeaderboardsImpl.this;
                zzaxt = s;
                zzaxu = i;
                zzaxv = j;
                zzaxw = k;
                zzawR = flag;
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

            final boolean zzawR;
            final LeaderboardsImpl zzaxs;
            final String zzaxt;
            final int zzaxu;
            final int zzaxv;
            final int zzaxw;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzaxt, zzaxu, zzaxv, zzaxw, zzawR);
            }

            
            {
                zzaxs = LeaderboardsImpl.this;
                zzaxt = s;
                zzaxu = i;
                zzaxv = j;
                zzaxw = k;
                zzawR = flag;
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
        GamesLog.zzy("LeaderboardsImpl", "service died");
        return;
    }

    public PendingResult submitScoreImmediate(GoogleApiClient googleapiclient, String s, long l)
    {
        return submitScoreImmediate(googleapiclient, s, l, null);
    }

    public PendingResult submitScoreImmediate(GoogleApiClient googleapiclient, String s, long l, String s1)
    {
        return googleapiclient.zzb(new SubmitScoreImpl(googleapiclient, s, l, s1) {

            final String zzaxA;
            final LeaderboardsImpl zzaxs;
            final String zzaxt;
            final long zzaxz;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzaxt, zzaxz, zzaxA);
            }

            
            {
                zzaxs = LeaderboardsImpl.this;
                zzaxt = s;
                zzaxz = l;
                zzaxA = s1;
                super(googleapiclient);
            }
        });
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/LeaderboardsImpl$10

/* anonymous class */
    class _cls10 extends LoadScoresImpl
    {

        final boolean zzawR;
        final String zzawT;
        final String zzaxt;
        final int zzaxu;
        final int zzaxv;
        final int zzaxw;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzawT, zzaxt, zzaxu, zzaxv, zzaxw, zzawR);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/LeaderboardsImpl$11

/* anonymous class */
    class _cls11 extends LoadScoresImpl
    {

        final boolean zzawR;
        final String zzawT;
        final String zzaxt;
        final int zzaxu;
        final int zzaxv;
        final int zzaxw;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzawT, zzaxt, zzaxu, zzaxv, zzaxw, zzawR);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/LeaderboardsImpl$8

/* anonymous class */
    class _cls8 extends LoadMetadataImpl
    {

        final boolean zzawR;
        final String zzawT;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzc(this, zzawT, zzawR);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/LeaderboardsImpl$9

/* anonymous class */
    class _cls9 extends LoadMetadataImpl
    {

        final boolean zzawR;
        final String zzawT;
        final String zzaxt;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzawT, zzaxt, zzawR);
        }
    }

}
