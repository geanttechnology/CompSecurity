// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import java.util.List;

public final class TurnBasedMultiplayerImpl
    implements TurnBasedMultiplayer
{
    private static abstract class CancelMatchImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        private final String zzwj;

        static String zza(CancelMatchImpl cancelmatchimpl)
        {
            return cancelmatchimpl.zzwj;
        }

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult zzaF(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult(this, status) {

                final Status zzQs;
                final CancelMatchImpl zzaws;

                public String getMatchId()
                {
                    return CancelMatchImpl.zza(zzaws);
                }

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzaws = cancelmatchimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaF(status);
        }

        public CancelMatchImpl(String s, GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
            zzwj = s;
        }
    }

    private static abstract class InitiateMatchImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult zzaG(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult(this, status) {

                final Status zzQs;
                final InitiateMatchImpl zzawt;

                public TurnBasedMatch getMatch()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzawt = initiatematchimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaG(status);
        }

        private InitiateMatchImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LeaveMatchImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult zzaH(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult(this, status) {

                final Status zzQs;
                final LeaveMatchImpl zzawu;

                public TurnBasedMatch getMatch()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzawu = leavematchimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaH(status);
        }

        private LeaveMatchImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LoadMatchImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult zzaI(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult(this, status) {

                final Status zzQs;
                final LoadMatchImpl zzawv;

                public TurnBasedMatch getMatch()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzawv = loadmatchimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaI(status);
        }

        private LoadMatchImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LoadMatchesImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult zzaJ(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult(this, status) {

                final Status zzQs;
                final LoadMatchesImpl zzaww;

                public LoadMatchesResponse getMatches()
                {
                    return new LoadMatchesResponse(new Bundle());
                }

                public Status getStatus()
                {
                    return zzQs;
                }

                public void release()
                {
                }

            
            {
                zzaww = loadmatchesimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaJ(status);
        }

        private LoadMatchesImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class UpdateMatchImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult zzaK(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult(this, status) {

                final Status zzQs;
                final UpdateMatchImpl zzawx;

                public TurnBasedMatch getMatch()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzawx = updatematchimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaK(status);
        }

        private UpdateMatchImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public TurnBasedMultiplayerImpl()
    {
    }

    public PendingResult acceptInvitation(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new InitiateMatchImpl(googleapiclient, s) {

            final String zzauS;
            final TurnBasedMultiplayerImpl zzawl;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzd(this, zzauS);
            }

            
            {
                zzawl = TurnBasedMultiplayerImpl.this;
                zzauS = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult cancelMatch(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new CancelMatchImpl(s, googleapiclient, s) {

            final TurnBasedMultiplayerImpl zzawl;
            final String zzawm;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzf(this, zzawm);
            }

            
            {
                zzawl = TurnBasedMultiplayerImpl.this;
                zzawm = s1;
                super(s, googleapiclient);
            }
        });
    }

    public PendingResult createMatch(GoogleApiClient googleapiclient, TurnBasedMatchConfig turnbasedmatchconfig)
    {
        return googleapiclient.zzb(new InitiateMatchImpl(googleapiclient, turnbasedmatchconfig) {

            final TurnBasedMatchConfig zzawk;
            final TurnBasedMultiplayerImpl zzawl;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzawk);
            }

            
            {
                zzawl = TurnBasedMultiplayerImpl.this;
                zzawk = turnbasedmatchconfig;
                super(googleapiclient);
            }
        });
    }

    public void declineInvitation(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzs(s, 1);
        }
    }

    public void dismissInvitation(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzr(s, 1);
        }
    }

    public void dismissMatch(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzcX(s);
        }
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
        return googleapiclient.zzb(new UpdateMatchImpl(googleapiclient, s, abyte0, aparticipantresult) {

            final TurnBasedMultiplayerImpl zzawl;
            final String zzawm;
            final byte zzawp[];
            final ParticipantResult zzawr[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzawm, zzawp, zzawr);
            }

            
            {
                zzawl = TurnBasedMultiplayerImpl.this;
                zzawm = s;
                zzawp = abyte0;
                zzawr = aparticipantresult;
                super(googleapiclient);
            }
        });
    }

    public Intent getInboxIntent(GoogleApiClient googleapiclient)
    {
        return Games.zzd(googleapiclient).zztN();
    }

    public int getMaxMatchDataSize(GoogleApiClient googleapiclient)
    {
        return Games.zzd(googleapiclient).zztX();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient googleapiclient, int i, int j)
    {
        return Games.zzd(googleapiclient).zzb(i, j, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient googleapiclient, int i, int j, boolean flag)
    {
        return Games.zzd(googleapiclient).zzb(i, j, flag);
    }

    public PendingResult leaveMatch(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new LeaveMatchImpl(googleapiclient, s) {

            final TurnBasedMultiplayerImpl zzawl;
            final String zzawm;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zze(this, zzawm);
            }

            
            {
                zzawl = TurnBasedMultiplayerImpl.this;
                zzawm = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult leaveMatchDuringTurn(GoogleApiClient googleapiclient, String s, String s1)
    {
        return googleapiclient.zzb(new LeaveMatchImpl(googleapiclient, s, s1) {

            final TurnBasedMultiplayerImpl zzawl;
            final String zzawm;
            final String zzawq;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzawm, zzawq);
            }

            
            {
                zzawl = TurnBasedMultiplayerImpl.this;
                zzawm = s;
                zzawq = s1;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadMatch(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new LoadMatchImpl(googleapiclient, s) {

            final TurnBasedMultiplayerImpl zzawl;
            final String zzawm;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzg(this, zzawm);
            }

            
            {
                zzawl = TurnBasedMultiplayerImpl.this;
                zzawm = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadMatchesByStatus(GoogleApiClient googleapiclient, int i, int ai[])
    {
        return googleapiclient.zza(new LoadMatchesImpl(googleapiclient, i, ai) {

            final TurnBasedMultiplayerImpl zzawl;
            final int zzawn;
            final int zzawo[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzawn, zzawo);
            }

            
            {
                zzawl = TurnBasedMultiplayerImpl.this;
                zzawn = i;
                zzawo = ai;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadMatchesByStatus(GoogleApiClient googleapiclient, int ai[])
    {
        return loadMatchesByStatus(googleapiclient, 0, ai);
    }

    public void registerMatchUpdateListener(GoogleApiClient googleapiclient, OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
    {
        GamesClientImpl gamesclientimpl = Games.zzb(googleapiclient, false);
        if (gamesclientimpl != null)
        {
            gamesclientimpl.zzb(googleapiclient.zzp(onturnbasedmatchupdatereceivedlistener));
        }
    }

    public PendingResult rematch(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new InitiateMatchImpl(googleapiclient, s) {

            final TurnBasedMultiplayerImpl zzawl;
            final String zzawm;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzc(this, zzawm);
            }

            
            {
                zzawl = TurnBasedMultiplayerImpl.this;
                zzawm = s;
                super(googleapiclient);
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
        return googleapiclient.zzb(new UpdateMatchImpl(googleapiclient, s, abyte0, s1, aparticipantresult) {

            final TurnBasedMultiplayerImpl zzawl;
            final String zzawm;
            final byte zzawp[];
            final String zzawq;
            final ParticipantResult zzawr[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzawm, zzawp, zzawq, zzawr);
            }

            
            {
                zzawl = TurnBasedMultiplayerImpl.this;
                zzawm = s;
                zzawp = abyte0;
                zzawq = s1;
                zzawr = aparticipantresult;
                super(googleapiclient);
            }
        });
    }

    public void unregisterMatchUpdateListener(GoogleApiClient googleapiclient)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zztQ();
        }
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/TurnBasedMultiplayerImpl$11

/* anonymous class */
    class _cls11 extends InitiateMatchImpl
    {

        final String zzauv;
        final String zzawm;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzc(this, zzauv, zzawm);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/TurnBasedMultiplayerImpl$12

/* anonymous class */
    class _cls12 extends InitiateMatchImpl
    {

        final String zzauv;
        final String zzawm;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzd(this, zzauv, zzawm);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/TurnBasedMultiplayerImpl$13

/* anonymous class */
    class _cls13 extends LoadMatchesImpl
    {

        final String zzauv;
        final int zzawn;
        final int zzawo[];

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzauv, zzawn, zzawo);
        }
    }

}
