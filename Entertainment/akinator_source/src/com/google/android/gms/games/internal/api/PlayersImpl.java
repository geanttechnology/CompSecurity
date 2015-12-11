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
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl
    implements Players
{
    private static abstract class LoadPlayersImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.Players.LoadPlayersResult zzao(Status status)
        {
            return new com.google.android.gms.games.Players.LoadPlayersResult(this, status) {

                final Status zzVb;
                final LoadPlayersImpl zzaxU;

                public PlayerBuffer getPlayers()
                {
                    return new PlayerBuffer(DataHolder.zzbu(14));
                }

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzaxU = loadplayersimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzao(status);
        }

        private LoadPlayersImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LoadProfileSettingsResultImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        protected com.google.android.gms.games.Players.LoadProfileSettingsResult zzap(Status status)
        {
            return new com.google.android.gms.games.Players.LoadProfileSettingsResult(this, status) {

                final Status zzVb;
                final LoadProfileSettingsResultImpl zzaxV;

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzaxV = loadprofilesettingsresultimpl;
                zzVb = status;
                super();
            }
            };
        }

        protected Result zzb(Status status)
        {
            return zzap(status);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.Players.LoadXpForGameCategoriesResult zzaq(Status status)
        {
            return new com.google.android.gms.games.Players.LoadXpForGameCategoriesResult(this, status) {

                final Status zzVb;
                final LoadXpForGameCategoriesResultImpl zzaxW;

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzaxW = loadxpforgamecategoriesresultimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaq(status);
        }
    }

    private static abstract class LoadXpStreamResultImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.Players.LoadXpStreamResult zzar(Status status)
        {
            return new com.google.android.gms.games.Players.LoadXpStreamResult(this, status) {

                final Status zzVb;
                final LoadXpStreamResultImpl zzaxX;

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzaxX = loadxpstreamresultimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzar(status);
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        protected Result zzb(Status status)
        {
            return zzd(status);
        }

        protected Status zzd(Status status)
        {
            return status;
        }
    }


    public PlayersImpl()
    {
    }

    public Intent getCompareProfileIntent(GoogleApiClient googleapiclient, Player player)
    {
        return Games.zzc(googleapiclient).zza(new PlayerEntity(player));
    }

    public Player getCurrentPlayer(GoogleApiClient googleapiclient)
    {
        return Games.zzc(googleapiclient).zzuz();
    }

    public String getCurrentPlayerId(GoogleApiClient googleapiclient)
    {
        return Games.zzc(googleapiclient).zzuy();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient googleapiclient)
    {
        return Games.zzc(googleapiclient).zzuJ();
    }

    public PendingResult loadConnectedPlayers(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zza(new LoadPlayersImpl(googleapiclient, flag) {

            final boolean zzawR;
            final PlayersImpl zzaxN;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzawR);
            }

            
            {
                zzaxN = PlayersImpl.this;
                zzawR = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadInvitablePlayers(GoogleApiClient googleapiclient, int i, boolean flag)
    {
        return googleapiclient.zza(new LoadPlayersImpl(googleapiclient, i, flag) {

            final boolean zzawR;
            final PlayersImpl zzaxN;
            final int zzaxO;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzaxO, false, zzawR);
            }

            
            {
                zzaxN = PlayersImpl.this;
                zzaxO = i;
                zzawR = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadMoreInvitablePlayers(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.zza(new LoadPlayersImpl(googleapiclient, i) {

            final PlayersImpl zzaxN;
            final int zzaxO;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzaxO, true, false);
            }

            
            {
                zzaxN = PlayersImpl.this;
                zzaxO = i;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.zza(new LoadPlayersImpl(googleapiclient, i) {

            final PlayersImpl zzaxN;
            final int zzaxO;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, "played_with", zzaxO, true, false);
            }

            
            {
                zzaxN = PlayersImpl.this;
                zzaxO = i;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadPlayer(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new LoadPlayersImpl(googleapiclient, s) {

            final String zzXY;
            final PlayersImpl zzaxN;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzXY, false);
            }

            
            {
                zzaxN = PlayersImpl.this;
                zzXY = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadPlayer(GoogleApiClient googleapiclient, String s, boolean flag)
    {
        return googleapiclient.zza(new LoadPlayersImpl(googleapiclient, s, flag) {

            final String zzXY;
            final boolean zzawR;
            final PlayersImpl zzaxN;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzXY, zzawR);
            }

            
            {
                zzaxN = PlayersImpl.this;
                zzXY = s;
                zzawR = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadRecentlyPlayedWithPlayers(GoogleApiClient googleapiclient, int i, boolean flag)
    {
        return googleapiclient.zza(new LoadPlayersImpl(googleapiclient, i, flag) {

            final boolean zzawR;
            final PlayersImpl zzaxN;
            final int zzaxO;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, "played_with", zzaxO, false, zzawR);
            }

            
            {
                zzaxN = PlayersImpl.this;
                zzaxO = i;
                zzawR = flag;
                super(googleapiclient);
            }
        });
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$10

/* anonymous class */
    class _cls10 extends LoadPlayersImpl
    {

        final String zzawT;
        final int zzaxO;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, "nearby", zzawT, zzaxO, true, false);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$11

/* anonymous class */
    class _cls11 extends LoadPlayersImpl
    {

        final boolean zzawR;
        final String zzawT;
        final int zzaxO;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, "played_with", zzawT, zzaxO, false, zzawR);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$12

/* anonymous class */
    class _cls12 extends LoadPlayersImpl
    {

        final String zzawT;
        final int zzaxO;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, "played_with", zzawT, zzaxO, true, false);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$13

/* anonymous class */
    class _cls13 extends LoadPlayersImpl
    {

        final boolean zzawR;
        final int zzaxO;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzaxO, false, zzawR);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$14

/* anonymous class */
    class _cls14 extends LoadPlayersImpl
    {

        final int zzaxO;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzaxO, true, false);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$15

/* anonymous class */
    class _cls15 extends LoadPlayersImpl
    {

        final boolean zzawR;
        final int zzaxO;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzc(this, zzaxO, false, zzawR);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$16

/* anonymous class */
    class _cls16 extends LoadPlayersImpl
    {

        final int zzaxO;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzc(this, zzaxO, true, false);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$17

/* anonymous class */
    class _cls17 extends LoadPlayersImpl
    {

        final boolean zzawR;
        final int zzaxO;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzd(this, zzaxO, false, zzawR);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$18

/* anonymous class */
    class _cls18 extends LoadPlayersImpl
    {

        final int zzaxO;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzd(this, zzaxO, true, false);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$19

/* anonymous class */
    class _cls19 extends LoadPlayersImpl
    {

        final boolean zzawR;
        final int zzaxO;
        final String zzaxk;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzaxk, zzaxO, false, zzawR);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$20

/* anonymous class */
    class _cls20 extends LoadPlayersImpl
    {

        final int zzaxO;
        final String zzaxk;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzaxk, zzaxO, true, false);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$21

/* anonymous class */
    class _cls21 extends LoadPlayersImpl
    {

        final boolean zzawR;
        final String zzaxF;
        final int zzaxO;
        final String zzaxP;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzaxP, zzaxF, zzaxO, false, zzawR);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$22

/* anonymous class */
    class _cls22 extends LoadPlayersImpl
    {

        final String zzaxF;
        final int zzaxO;
        final String zzaxP;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzaxP, zzaxF, zzaxO, true, false);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$23

/* anonymous class */
    class _cls23 extends LoadXpForGameCategoriesResultImpl
    {

        final String zzaxQ;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzl(this, zzaxQ);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$24

/* anonymous class */
    class _cls24 extends LoadXpStreamResultImpl
    {

        final String zzaxQ;
        final int zzaxR;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzc(this, zzaxQ, zzaxR);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$25

/* anonymous class */
    class _cls25 extends LoadXpStreamResultImpl
    {

        final String zzaxQ;
        final int zzaxR;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzd(this, zzaxQ, zzaxR);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$26

/* anonymous class */
    class _cls26 extends LoadProfileSettingsResultImpl
    {

        final boolean zzawR;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzg(this, zzawR);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$27

/* anonymous class */
    class _cls27 extends UpdateProfileSettingsResultImpl
    {

        final boolean zzaxS;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzh(this, zzaxS);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$3

/* anonymous class */
    class _cls3 extends LoadPlayersImpl
    {

        final String zzaxT[];

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzaxT);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$9

/* anonymous class */
    class _cls9 extends LoadPlayersImpl
    {

        final String zzawT;
        final int zzaxO;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, "nearby", zzawT, zzaxO, false, false);
        }
    }

}
