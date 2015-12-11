// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
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
//            fl

public final class fw
    implements Leaderboards
{
    private static abstract class a extends com.google.android.gms.games.Games.a
    {

        public Result e(Status status)
        {
            return x(status);
        }

        public com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult x(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult(this, status) {

                final Status jP;
                final a vh;

                public LeaderboardBuffer getLeaderboards()
                {
                    return new LeaderboardBuffer(DataHolder.empty(14));
                }

                public Status getStatus()
                {
                    return jP;
                }

                public void release()
                {
                }

            
            {
                vh = a1;
                jP = status;
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

        public Result e(Status status)
        {
            return y(status);
        }

        public com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult y(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult(this, status) {

                final Status jP;
                final b vi;

                public LeaderboardScore getScore()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return jP;
                }

            
            {
                vi = b1;
                jP = status;
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

        public Result e(Status status)
        {
            return z(status);
        }

        public com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult z(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult(this, status) {

                final Status jP;
                final c vj;

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
                    return jP;
                }

                public void release()
                {
                }

            
            {
                vj = c1;
                jP = status;
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

        public com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult A(Status status)
        {
            return new com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult(this, status) {

                final Status jP;
                final d vk;

                public ScoreSubmissionData getScoreData()
                {
                    return new ScoreSubmissionData(DataHolder.empty(14));
                }

                public Status getStatus()
                {
                    return jP;
                }

                public void release()
                {
                }

            
            {
                vk = d1;
                jP = status;
                super();
            }
            };
        }

        public Result e(Status status)
        {
            return A(status);
        }

        protected d()
        {
        }
    }


    public fw()
    {
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient googleapiclient)
    {
        return Games.j(googleapiclient).getAllLeaderboardsIntent();
    }

    public Intent getLeaderboardIntent(GoogleApiClient googleapiclient, String s)
    {
        return Games.j(googleapiclient).getLeaderboardIntent(s);
    }

    public PendingResult loadCurrentPlayerLeaderboardScore(GoogleApiClient googleapiclient, String s, int i, int j)
    {
        return googleapiclient.a(new b(s, i, j) {

            final fw uY;
            final String uZ;
            final int va;
            final int vb;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, null, uZ, va, vb);
            }

            
            {
                uY = fw.this;
                uZ = s;
                va = i;
                vb = j;
                super();
            }
        });
    }

    public PendingResult loadLeaderboardMetadata(GoogleApiClient googleapiclient, String s, boolean flag)
    {
        return googleapiclient.a(new a(s, flag) {

            final boolean uN;
            final fw uY;
            final String uZ;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, uZ, uN);
            }

            
            {
                uY = fw.this;
                uZ = s;
                uN = flag;
                super();
            }
        });
    }

    public PendingResult loadLeaderboardMetadata(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.a(new a(flag) {

            final boolean uN;
            final fw uY;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, uN);
            }

            
            {
                uY = fw.this;
                uN = flag;
                super();
            }
        });
    }

    public PendingResult loadMoreScores(GoogleApiClient googleapiclient, LeaderboardScoreBuffer leaderboardscorebuffer, int i, int j)
    {
        return googleapiclient.a(new c(leaderboardscorebuffer, i, j) {

            final fw uY;
            final int vc;
            final LeaderboardScoreBuffer vd;
            final int ve;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, vd, vc, ve);
            }

            
            {
                uY = fw.this;
                vd = leaderboardscorebuffer;
                vc = i;
                ve = j;
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

            final boolean uN;
            final fw uY;
            final String uZ;
            final int va;
            final int vb;
            final int vc;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.b(this, uZ, va, vb, vc, uN);
            }

            
            {
                uY = fw.this;
                uZ = s;
                va = i;
                vb = j;
                vc = k;
                uN = flag;
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

            final boolean uN;
            final fw uY;
            final String uZ;
            final int va;
            final int vb;
            final int vc;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, uZ, va, vb, vc, uN);
            }

            
            {
                uY = fw.this;
                uZ = s;
                va = i;
                vb = j;
                vc = k;
                uN = flag;
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
        Games.j(googleapiclient).a(null, s, l, s1);
    }

    public PendingResult submitScoreImmediate(GoogleApiClient googleapiclient, String s, long l)
    {
        return submitScoreImmediate(googleapiclient, s, l, null);
    }

    public PendingResult submitScoreImmediate(GoogleApiClient googleapiclient, String s, long l, String s1)
    {
        return googleapiclient.b(new d(s, l, s1) {

            final fw uY;
            final String uZ;
            final long vf;
            final String vg;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, uZ, vf, vg);
            }

            
            {
                uY = fw.this;
                uZ = s;
                vf = l;
                vg = s1;
                super();
            }
        });
    }
}
