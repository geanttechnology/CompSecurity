// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            fl

public final class gb
    implements TurnBasedMultiplayer
{
    private static abstract class a extends com.google.android.gms.games.Games.a
    {

        private final String uS;

        static String a(a a1)
        {
            return a1.uS;
        }

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult C(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult(this, status) {

                final Status jP;
                final a vx;

                public String getMatchId()
                {
                    return a.a(vx);
                }

                public Status getStatus()
                {
                    return jP;
                }

            
            {
                vx = a1;
                jP = status;
                super();
            }
            };
        }

        public Result e(Status status)
        {
            return C(status);
        }

        public a(String s)
        {
            uS = s;
        }
    }

    private static abstract class b extends com.google.android.gms.games.Games.a
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult D(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult(this, status) {

                final Status jP;
                final b vy;

                public TurnBasedMatch getMatch()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return jP;
                }

            
            {
                vy = b1;
                jP = status;
                super();
            }
            };
        }

        public Result e(Status status)
        {
            return D(status);
        }

        private b()
        {
        }

    }

    private static abstract class c extends com.google.android.gms.games.Games.a
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult E(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult(this, status) {

                final Status jP;
                final c vz;

                public TurnBasedMatch getMatch()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return jP;
                }

            
            {
                vz = c1;
                jP = status;
                super();
            }
            };
        }

        public Result e(Status status)
        {
            return E(status);
        }

        private c()
        {
        }

    }

    private static abstract class d extends com.google.android.gms.games.Games.a
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult F(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult(this, status) {

                final Status jP;
                final d vA;

                public TurnBasedMatch getMatch()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return jP;
                }

            
            {
                vA = d1;
                jP = status;
                super();
            }
            };
        }

        public Result e(Status status)
        {
            return F(status);
        }

        private d()
        {
        }

    }

    private static abstract class e extends com.google.android.gms.games.Games.a
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult G(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult(this, status) {

                final Status jP;
                final e vB;

                public LoadMatchesResponse getMatches()
                {
                    return new LoadMatchesResponse(new Bundle());
                }

                public Status getStatus()
                {
                    return jP;
                }

                public void release()
                {
                }

            
            {
                vB = e1;
                jP = status;
                super();
            }
            };
        }

        public Result e(Status status)
        {
            return G(status);
        }

        private e()
        {
        }

    }

    private static abstract class f extends com.google.android.gms.games.Games.a
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult H(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult(this, status) {

                final Status jP;
                final f vC;

                public TurnBasedMatch getMatch()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return jP;
                }

            
            {
                vC = f1;
                jP = status;
                super();
            }
            };
        }

        public Result e(Status status)
        {
            return H(status);
        }

        private f()
        {
        }

    }


    public gb()
    {
    }

    public PendingResult acceptInvitation(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.b(new b(s) {

            final gb vq;
            final String vs;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.e(this, vs);
            }

            
            {
                vq = gb.this;
                vs = s;
                super();
            }
        });
    }

    public PendingResult cancelMatch(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.b(new a(s, s) {

            final gb vq;
            final String vr;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.g(this, vr);
            }

            
            {
                vq = gb.this;
                vr = s1;
                super(s);
            }
        });
    }

    public PendingResult createMatch(GoogleApiClient googleapiclient, TurnBasedMatchConfig turnbasedmatchconfig)
    {
        return googleapiclient.b(new b(turnbasedmatchconfig) {

            final TurnBasedMatchConfig vp;
            final gb vq;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, vp);
            }

            
            {
                vq = gb.this;
                vp = turnbasedmatchconfig;
                super();
            }
        });
    }

    public void declineInvitation(GoogleApiClient googleapiclient, String s)
    {
        Games.j(googleapiclient).j(s, 1);
    }

    public void dismissInvitation(GoogleApiClient googleapiclient, String s)
    {
        Games.j(googleapiclient).i(s, 1);
    }

    public void dismissMatch(GoogleApiClient googleapiclient, String s)
    {
        Games.j(googleapiclient).dismissTurnBasedMatch(s);
    }

    public PendingResult finishMatch(GoogleApiClient googleapiclient, String s)
    {
        return finishMatch(googleapiclient, s, null, (ParticipantResult[])null);
    }

    public PendingResult finishMatch(GoogleApiClient googleapiclient, String s, byte abyte0[], List list)
    {
        if (list == null)
        {
            list = null;
        } else
        {
            list = (ParticipantResult[])list.toArray(new ParticipantResult[list.size()]);
        }
        return finishMatch(googleapiclient, s, abyte0, ((ParticipantResult []) (list)));
    }

    public transient PendingResult finishMatch(GoogleApiClient googleapiclient, String s, byte abyte0[], ParticipantResult aparticipantresult[])
    {
        return googleapiclient.b(new f(s, abyte0, aparticipantresult) {

            final gb vq;
            final String vr;
            final byte vt[];
            final ParticipantResult vv[];

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, vr, vt, vv);
            }

            
            {
                vq = gb.this;
                vr = s;
                vt = abyte0;
                vv = aparticipantresult;
                super();
            }
        });
    }

    public Intent getInboxIntent(GoogleApiClient googleapiclient)
    {
        return Games.j(googleapiclient).getMatchInboxIntent();
    }

    public int getMaxMatchDataSize(GoogleApiClient googleapiclient)
    {
        return Games.j(googleapiclient).getMaxTurnBasedMatchDataSize();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient googleapiclient, int i, int j)
    {
        return Games.j(googleapiclient).getTurnBasedSelectOpponentsIntent(i, j, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient googleapiclient, int i, int j, boolean flag)
    {
        return Games.j(googleapiclient).getTurnBasedSelectOpponentsIntent(i, j, flag);
    }

    public PendingResult leaveMatch(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.b(new c(s) {

            final gb vq;
            final String vr;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.f(this, vr);
            }

            
            {
                vq = gb.this;
                vr = s;
                super();
            }
        });
    }

    public PendingResult leaveMatchDuringTurn(GoogleApiClient googleapiclient, String s, String s1)
    {
        return googleapiclient.b(new c(s, s1) {

            final gb vq;
            final String vr;
            final String vu;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, vr, vu);
            }

            
            {
                vq = gb.this;
                vr = s;
                vu = s1;
                super();
            }
        });
    }

    public PendingResult loadMatch(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.a(new d(s) {

            final gb vq;
            final String vr;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.h(this, vr);
            }

            
            {
                vq = gb.this;
                vr = s;
                super();
            }
        });
    }

    public transient PendingResult loadMatchesByStatus(GoogleApiClient googleapiclient, int ai[])
    {
        return googleapiclient.a(new e(ai) {

            final gb vq;
            final int vw[];

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, vw);
            }

            
            {
                vq = gb.this;
                vw = ai;
                super();
            }
        });
    }

    public void registerMatchUpdateListener(GoogleApiClient googleapiclient, OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
    {
        Games.j(googleapiclient).registerMatchUpdateListener(onturnbasedmatchupdatereceivedlistener);
    }

    public PendingResult rematch(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.b(new b(s) {

            final gb vq;
            final String vr;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.d(this, vr);
            }

            
            {
                vq = gb.this;
                vr = s;
                super();
            }
        });
    }

    public PendingResult takeTurn(GoogleApiClient googleapiclient, String s, byte abyte0[], String s1)
    {
        return takeTurn(googleapiclient, s, abyte0, s1, (ParticipantResult[])null);
    }

    public PendingResult takeTurn(GoogleApiClient googleapiclient, String s, byte abyte0[], String s1, List list)
    {
        if (list == null)
        {
            list = null;
        } else
        {
            list = (ParticipantResult[])list.toArray(new ParticipantResult[list.size()]);
        }
        return takeTurn(googleapiclient, s, abyte0, s1, ((ParticipantResult []) (list)));
    }

    public transient PendingResult takeTurn(GoogleApiClient googleapiclient, String s, byte abyte0[], String s1, ParticipantResult aparticipantresult[])
    {
        return googleapiclient.b(new f(s, abyte0, s1, aparticipantresult) {

            final gb vq;
            final String vr;
            final byte vt[];
            final String vu;
            final ParticipantResult vv[];

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, vr, vt, vu, vv);
            }

            
            {
                vq = gb.this;
                vr = s;
                vt = abyte0;
                vu = s1;
                vv = aparticipantresult;
                super();
            }
        });
    }

    public void unregisterMatchUpdateListener(GoogleApiClient googleapiclient)
    {
        Games.j(googleapiclient).unregisterMatchUpdateListener();
    }
}
