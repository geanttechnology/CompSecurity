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

        private final String zzwN;

        static String zza(CancelMatchImpl cancelmatchimpl)
        {
            return cancelmatchimpl.zzwN;
        }

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult zzaE(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult(this, status) {

                final Status zzVb;
                final CancelMatchImpl zzayR;

                public String getMatchId()
                {
                    return CancelMatchImpl.zza(zzayR);
                }

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzayR = cancelmatchimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaE(status);
        }

        public CancelMatchImpl(String s, GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
            zzwN = s;
        }
    }

    private static abstract class InitiateMatchImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult zzaF(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult(this, status) {

                final Status zzVb;
                final InitiateMatchImpl zzayS;

                public TurnBasedMatch getMatch()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzayS = initiatematchimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaF(status);
        }

        private InitiateMatchImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LeaveMatchImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult zzaG(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult(this, status) {

                final Status zzVb;
                final LeaveMatchImpl zzayT;

                public TurnBasedMatch getMatch()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzayT = leavematchimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaG(status);
        }

        private LeaveMatchImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LoadMatchImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult zzaH(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult(this, status) {

                final Status zzVb;
                final LoadMatchImpl zzayU;

                public TurnBasedMatch getMatch()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzayU = loadmatchimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaH(status);
        }

        private LoadMatchImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LoadMatchesImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult zzaI(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult(this, status) {

                final Status zzVb;
                final LoadMatchesImpl zzayV;

                public LoadMatchesResponse getMatches()
                {
                    return new LoadMatchesResponse(new Bundle());
                }

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzayV = loadmatchesimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaI(status);
        }

        private LoadMatchesImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class UpdateMatchImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult zzaJ(Status status)
        {
            return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult(this, status) {

                final Status zzVb;
                final UpdateMatchImpl zzayW;

                public TurnBasedMatch getMatch()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzayW = updatematchimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaJ(status);
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

            final String zzaxq;
            final TurnBasedMultiplayerImpl zzayK;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzd(this, zzaxq);
            }

            
            {
                zzayK = TurnBasedMultiplayerImpl.this;
                zzaxq = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult cancelMatch(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new CancelMatchImpl(s, googleapiclient, s) {

            final TurnBasedMultiplayerImpl zzayK;
            final String zzayL;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzf(this, zzayL);
            }

            
            {
                zzayK = TurnBasedMultiplayerImpl.this;
                zzayL = s1;
                super(s, googleapiclient);
            }
        });
    }

    public PendingResult createMatch(GoogleApiClient googleapiclient, TurnBasedMatchConfig turnbasedmatchconfig)
    {
        return googleapiclient.zzb(new InitiateMatchImpl(googleapiclient, turnbasedmatchconfig) {

            final TurnBasedMatchConfig zzayJ;
            final TurnBasedMultiplayerImpl zzayK;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzayJ);
            }

            
            {
                zzayK = TurnBasedMultiplayerImpl.this;
                zzayJ = turnbasedmatchconfig;
                super(googleapiclient);
            }
        });
    }

    public void declineInvitation(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzr(s, 1);
        }
    }

    public void dismissInvitation(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzq(s, 1);
        }
    }

    public void dismissMatch(GoogleApiClient googleapiclient, String s)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzcW(s);
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

            final TurnBasedMultiplayerImpl zzayK;
            final String zzayL;
            final byte zzayO[];
            final ParticipantResult zzayQ[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzayL, zzayO, zzayQ);
            }

            
            {
                zzayK = TurnBasedMultiplayerImpl.this;
                zzayL = s;
                zzayO = abyte0;
                zzayQ = aparticipantresult;
                super(googleapiclient);
            }
        });
    }

    public Intent getInboxIntent(GoogleApiClient googleapiclient)
    {
        return Games.zzc(googleapiclient).zzuD();
    }

    public int getMaxMatchDataSize(GoogleApiClient googleapiclient)
    {
        return Games.zzc(googleapiclient).zzuN();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient googleapiclient, int i, int j)
    {
        return Games.zzc(googleapiclient).zzb(i, j, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient googleapiclient, int i, int j, boolean flag)
    {
        return Games.zzc(googleapiclient).zzb(i, j, flag);
    }

    public PendingResult leaveMatch(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new LeaveMatchImpl(googleapiclient, s) {

            final TurnBasedMultiplayerImpl zzayK;
            final String zzayL;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zze(this, zzayL);
            }

            
            {
                zzayK = TurnBasedMultiplayerImpl.this;
                zzayL = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult leaveMatchDuringTurn(GoogleApiClient googleapiclient, String s, String s1)
    {
        return googleapiclient.zzb(new LeaveMatchImpl(googleapiclient, s, s1) {

            final TurnBasedMultiplayerImpl zzayK;
            final String zzayL;
            final String zzayP;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzayL, zzayP);
            }

            
            {
                zzayK = TurnBasedMultiplayerImpl.this;
                zzayL = s;
                zzayP = s1;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadMatch(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new LoadMatchImpl(googleapiclient, s) {

            final TurnBasedMultiplayerImpl zzayK;
            final String zzayL;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzg(this, zzayL);
            }

            
            {
                zzayK = TurnBasedMultiplayerImpl.this;
                zzayL = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadMatchesByStatus(GoogleApiClient googleapiclient, int i, int ai[])
    {
        return googleapiclient.zza(new LoadMatchesImpl(googleapiclient, i, ai) {

            final TurnBasedMultiplayerImpl zzayK;
            final int zzayM;
            final int zzayN[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzayM, zzayN);
            }

            
            {
                zzayK = TurnBasedMultiplayerImpl.this;
                zzayM = i;
                zzayN = ai;
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
            gamesclientimpl.zzb(googleapiclient.zzo(onturnbasedmatchupdatereceivedlistener));
        }
    }

    public PendingResult rematch(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new InitiateMatchImpl(googleapiclient, s) {

            final TurnBasedMultiplayerImpl zzayK;
            final String zzayL;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzc(this, zzayL);
            }

            
            {
                zzayK = TurnBasedMultiplayerImpl.this;
                zzayL = s;
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

            final TurnBasedMultiplayerImpl zzayK;
            final String zzayL;
            final byte zzayO[];
            final String zzayP;
            final ParticipantResult zzayQ[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzayL, zzayO, zzayP, zzayQ);
            }

            
            {
                zzayK = TurnBasedMultiplayerImpl.this;
                zzayL = s;
                zzayO = abyte0;
                zzayP = s1;
                zzayQ = aparticipantresult;
                super(googleapiclient);
            }
        });
    }

    public void unregisterMatchUpdateListener(GoogleApiClient googleapiclient)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzuG();
        }
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/TurnBasedMultiplayerImpl$11

/* anonymous class */
    class _cls11 extends InitiateMatchImpl
    {

        final String zzawT;
        final String zzayL;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzc(this, zzawT, zzayL);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/TurnBasedMultiplayerImpl$12

/* anonymous class */
    class _cls12 extends InitiateMatchImpl
    {

        final String zzawT;
        final String zzayL;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzd(this, zzawT, zzayL);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/TurnBasedMultiplayerImpl$13

/* anonymous class */
    class _cls13 extends LoadMatchesImpl
    {

        final String zzawT;
        final int zzayM;
        final int zzayN[];

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzawT, zzayM, zzayN);
        }
    }

}
