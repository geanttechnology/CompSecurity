// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

// Referenced classes of package com.google.android.gms.internal:
//            fx

public final class gj
    implements Leaderboards
{
    private static abstract class a extends com.google.android.gms.games.Games.a
    {

        public Result d(Status status)
        {
            return w(status);
        }

        public com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult w(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult(this, status) {

                final a Ib;
                final Status vb;

                public LeaderboardBuffer getLeaderboards()
                {
                    return new LeaderboardBuffer(DataHolder.empty(14));
                }

                public Status getStatus()
                {
                    return vb;
                }

                public void release()
                {
                }

            
            {
                Ib = a1;
                vb = status;
                super();
            }
            };
        }

        private a()
        {
        }

    }

    private static abstract class b extends com.google.android.gms.games.Games.a
    {

        public Result d(Status status)
        {
            return x(status);
        }

        public com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult x(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult(this, status) {

                final b Ic;
                final Status vb;

                public LeaderboardScore getScore()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return vb;
                }

            
            {
                Ic = b1;
                vb = status;
                super();
            }
            };
        }

        private b()
        {
        }

    }

    private static abstract class c extends com.google.android.gms.games.Games.a
    {

        public Result d(Status status)
        {
            return y(status);
        }

        public com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult y(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult(this, status) {

                final c Id;
                final Status vb;

                public Leaderboard getLeaderboard()
                {
                    return null;
                }

                public LeaderboardScoreBuffer getScores()
                {
                    return new LeaderboardScoreBuffer(DataHolder.empty(14));
                }

                public Status getStatus()
                {
                    return vb;
                }

                public void release()
                {
                }

            
            {
                Id = c1;
                vb = status;
                super();
            }
            };
        }

        private c()
        {
        }

    }

    protected static abstract class d extends com.google.android.gms.games.Games.a
    {

        public Result d(Status status)
        {
            return z(status);
        }

        public com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult z(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult(this, status) {

                final d Ie;
                final Status vb;

                public ScoreSubmissionData getScoreData()
                {
                    return new ScoreSubmissionData(DataHolder.empty(14));
                }

                public Status getStatus()
                {
                    return vb;
                }

                public void release()
                {
                }

            
            {
                Ie = d1;
                vb = status;
                super();
            }
            };
        }

        protected d()
        {
        }
    }


    public gj()
    {
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).fr();
    }

    public Intent getLeaderboardIntent(GoogleApiClient googleapiclient, String s)
    {
        return Games.c(googleapiclient).au(s);
    }

    public PendingResult loadCurrentPlayerLeaderboardScore(GoogleApiClient googleapiclient, String s, int i, int j)
    {
        return googleapiclient.a(new b(s, i, j) {

            final gj HS;
            final String HT;
            final int HU;
            final int HV;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.a(this, null, HT, HU, HV);
            }

            
            {
                HS = gj.this;
                HT = s;
                HU = i;
                HV = j;
                super();
            }
        });
    }

    public PendingResult loadLeaderboardMetadata(GoogleApiClient googleapiclient, String s, boolean flag)
    {
        return googleapiclient.a(new a(s, flag) {

            final boolean HH;
            final gj HS;
            final String HT;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.a(this, HT, HH);
            }

            
            {
                HS = gj.this;
                HT = s;
                HH = flag;
                super();
            }
        });
    }

    public PendingResult loadLeaderboardMetadata(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.a(new a(flag) {

            final boolean HH;
            final gj HS;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.b(this, HH);
            }

            
            {
                HS = gj.this;
                HH = flag;
                super();
            }
        });
    }

    public PendingResult loadMoreScores(GoogleApiClient googleapiclient, LeaderboardScoreBuffer leaderboardscorebuffer, int i, int j)
    {
        return googleapiclient.a(new c(leaderboardscorebuffer, i, j) {

            final gj HS;
            final int HW;
            final LeaderboardScoreBuffer HX;
            final int HY;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.a(this, HX, HW, HY);
            }

            
            {
                HS = gj.this;
                HX = leaderboardscorebuffer;
                HW = i;
                HY = j;
                super();
            }
        });
    }

    public PendingResult loadPlayerCenteredScores(GoogleApiClient googleapiclient, String s, int i, int j, int k)
    {
        return loadPlayerCenteredScores(googleapiclient, s, i, j, k, false);
    }

    public PendingResult loadPlayerCenteredScores(GoogleApiClient googleapiclient, String s, int i, int j, int k, boolean flag)
    {
        return googleapiclient.a(new c(s, i, j, k, flag) {

            final boolean HH;
            final gj HS;
            final String HT;
            final int HU;
            final int HV;
            final int HW;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.b(this, HT, HU, HV, HW, HH);
            }

            
            {
                HS = gj.this;
                HT = s;
                HU = i;
                HV = j;
                HW = k;
                HH = flag;
                super();
            }
        });
    }

    public PendingResult loadTopScores(GoogleApiClient googleapiclient, String s, int i, int j, int k)
    {
        return loadTopScores(googleapiclient, s, i, j, k, false);
    }

    public PendingResult loadTopScores(GoogleApiClient googleapiclient, String s, int i, int j, int k, boolean flag)
    {
        return googleapiclient.a(new c(s, i, j, k, flag) {

            final boolean HH;
            final gj HS;
            final String HT;
            final int HU;
            final int HV;
            final int HW;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.a(this, HT, HU, HV, HW, HH);
            }

            
            {
                HS = gj.this;
                HT = s;
                HU = i;
                HV = j;
                HW = k;
                HH = flag;
                super();
            }
        });
    }

    public void submitScore(GoogleApiClient googleapiclient, String s, long l)
    {
        submitScore(googleapiclient, s, l, null);
    }

    public void submitScore(GoogleApiClient googleapiclient, String s, long l, String s1)
    {
        Games.c(googleapiclient).a(null, s, l, s1);
    }

    public PendingResult submitScoreImmediate(GoogleApiClient googleapiclient, String s, long l)
    {
        return submitScoreImmediate(googleapiclient, s, l, null);
    }

    public PendingResult submitScoreImmediate(GoogleApiClient googleapiclient, String s, long l, String s1)
    {
        return googleapiclient.b(new d(s, l, s1) {

            final gj HS;
            final String HT;
            final long HZ;
            final String Ia;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.a(this, HT, HZ, Ia);
            }

            
            {
                HS = gj.this;
                HT = s;
                HZ = l;
                Ia = s1;
                super();
            }
        });
    }
}
