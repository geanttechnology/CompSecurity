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

        public com.google.android.gms.games.Players.LoadPlayersResult zzap(Status status)
        {
            return new com.google.android.gms.games.Players.LoadPlayersResult(this, status) {

                final Status zzQs;
                final LoadPlayersImpl zzavw;

                public PlayerBuffer getPlayers()
                {
                    return new PlayerBuffer(DataHolder.zzbp(14));
                }

                public Status getStatus()
                {
                    return zzQs;
                }

                public void release()
                {
                }

            
            {
                zzavw = loadplayersimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzap(status);
        }

        private LoadPlayersImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LoadProfileSettingsResultImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        protected com.google.android.gms.games.Players.LoadProfileSettingsResult zzaq(Status status)
        {
            return new com.google.android.gms.games.Players.LoadProfileSettingsResult(this, status) {

                final Status zzQs;
                final LoadProfileSettingsResultImpl zzavx;

                public Status getStatus()
                {
                    return zzQs;
                }

                public boolean isProfileVisible()
                {
                    return true;
                }

                public boolean isVisibilityExplicitlySet()
                {
                    return false;
                }

            
            {
                zzavx = loadprofilesettingsresultimpl;
                zzQs = status;
                super();
            }
            };
        }

        protected Result zzb(Status status)
        {
            return zzaq(status);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.Players.LoadXpForGameCategoriesResult zzar(Status status)
        {
            return new com.google.android.gms.games.Players.LoadXpForGameCategoriesResult(this, status) {

                final Status zzQs;
                final LoadXpForGameCategoriesResultImpl zzavy;

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzavy = loadxpforgamecategoriesresultimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzar(status);
        }
    }

    private static abstract class LoadXpStreamResultImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.Players.LoadXpStreamResult zzas(Status status)
        {
            return new com.google.android.gms.games.Players.LoadXpStreamResult(this, status) {

                final Status zzQs;
                final LoadXpStreamResultImpl zzavz;

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzavz = loadxpstreamresultimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzas(status);
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
        return Games.zzd(googleapiclient).zza(new PlayerEntity(player));
    }

    public Player getCurrentPlayer(GoogleApiClient googleapiclient)
    {
        return Games.zzd(googleapiclient).zztJ();
    }

    public String getCurrentPlayerId(GoogleApiClient googleapiclient)
    {
        return Games.zzd(googleapiclient).zztI();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient googleapiclient)
    {
        return Games.zzd(googleapiclient).zztT();
    }

    public PendingResult loadConnectedPlayers(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zza(new LoadPlayersImpl(googleapiclient, flag) {

            final boolean zzaut;
            final PlayersImpl zzavp;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzaut);
            }

            
            {
                zzavp = PlayersImpl.this;
                zzaut = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadInvitablePlayers(GoogleApiClient googleapiclient, int i, boolean flag)
    {
        return googleapiclient.zza(new LoadPlayersImpl(googleapiclient, i, flag) {

            final boolean zzaut;
            final PlayersImpl zzavp;
            final int zzavq;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzavq, false, zzaut);
            }

            
            {
                zzavp = PlayersImpl.this;
                zzavq = i;
                zzaut = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadMoreInvitablePlayers(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.zza(new LoadPlayersImpl(googleapiclient, i) {

            final PlayersImpl zzavp;
            final int zzavq;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzavq, true, false);
            }

            
            {
                zzavp = PlayersImpl.this;
                zzavq = i;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.zza(new LoadPlayersImpl(googleapiclient, i) {

            final PlayersImpl zzavp;
            final int zzavq;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, "played_with", zzavq, true, false);
            }

            
            {
                zzavp = PlayersImpl.this;
                zzavq = i;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadPlayer(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new LoadPlayersImpl(googleapiclient, s) {

            final String zzWg;
            final PlayersImpl zzavp;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzWg, false);
            }

            
            {
                zzavp = PlayersImpl.this;
                zzWg = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadPlayer(GoogleApiClient googleapiclient, String s, boolean flag)
    {
        return googleapiclient.zza(new LoadPlayersImpl(googleapiclient, s, flag) {

            final String zzWg;
            final boolean zzaut;
            final PlayersImpl zzavp;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzWg, zzaut);
            }

            
            {
                zzavp = PlayersImpl.this;
                zzWg = s;
                zzaut = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadRecentlyPlayedWithPlayers(GoogleApiClient googleapiclient, int i, boolean flag)
    {
        return googleapiclient.zza(new LoadPlayersImpl(googleapiclient, i, flag) {

            final boolean zzaut;
            final PlayersImpl zzavp;
            final int zzavq;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, "played_with", zzavq, false, zzaut);
            }

            
            {
                zzavp = PlayersImpl.this;
                zzavq = i;
                zzaut = flag;
                super(googleapiclient);
            }
        });
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$10

/* anonymous class */
    class _cls10 extends LoadPlayersImpl
    {

        final String zzauv;
        final int zzavq;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, "nearby", zzauv, zzavq, true, false);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$11

/* anonymous class */
    class _cls11 extends LoadPlayersImpl
    {

        final boolean zzaut;
        final String zzauv;
        final int zzavq;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, "played_with", zzauv, zzavq, false, zzaut);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$12

/* anonymous class */
    class _cls12 extends LoadPlayersImpl
    {

        final String zzauv;
        final int zzavq;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, "played_with", zzauv, zzavq, true, false);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$13

/* anonymous class */
    class _cls13 extends LoadPlayersImpl
    {

        final boolean zzaut;
        final int zzavq;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzavq, false, zzaut);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$14

/* anonymous class */
    class _cls14 extends LoadPlayersImpl
    {

        final int zzavq;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzavq, true, false);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$15

/* anonymous class */
    class _cls15 extends LoadPlayersImpl
    {

        final boolean zzaut;
        final int zzavq;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzc(this, zzavq, false, zzaut);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$16

/* anonymous class */
    class _cls16 extends LoadPlayersImpl
    {

        final int zzavq;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzc(this, zzavq, true, false);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$17

/* anonymous class */
    class _cls17 extends LoadPlayersImpl
    {

        final boolean zzaut;
        final int zzavq;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzd(this, zzavq, false, zzaut);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$18

/* anonymous class */
    class _cls18 extends LoadPlayersImpl
    {

        final int zzavq;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzd(this, zzavq, true, false);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$19

/* anonymous class */
    class _cls19 extends LoadPlayersImpl
    {

        final String zzauM;
        final boolean zzaut;
        final int zzavq;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzauM, zzavq, false, zzaut);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$20

/* anonymous class */
    class _cls20 extends LoadPlayersImpl
    {

        final String zzauM;
        final int zzavq;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzauM, zzavq, true, false);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$21

/* anonymous class */
    class _cls21 extends LoadPlayersImpl
    {

        final boolean zzaut;
        final String zzavh;
        final int zzavq;
        final String zzavr;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzavr, zzavh, zzavq, false, zzaut);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$22

/* anonymous class */
    class _cls22 extends LoadPlayersImpl
    {

        final String zzavh;
        final int zzavq;
        final String zzavr;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzb(this, zzavr, zzavh, zzavq, true, false);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$23

/* anonymous class */
    class _cls23 extends LoadXpForGameCategoriesResultImpl
    {

        final String zzavs;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzl(this, zzavs);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$24

/* anonymous class */
    class _cls24 extends LoadXpStreamResultImpl
    {

        final String zzavs;
        final int zzavt;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzc(this, zzavs, zzavt);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$25

/* anonymous class */
    class _cls25 extends LoadXpStreamResultImpl
    {

        final String zzavs;
        final int zzavt;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzd(this, zzavs, zzavt);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$26

/* anonymous class */
    class _cls26 extends LoadProfileSettingsResultImpl
    {

        final boolean zzaut;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzg(this, zzaut);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$27

/* anonymous class */
    class _cls27 extends UpdateProfileSettingsResultImpl
    {

        final boolean zzavu;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzh(this, zzavu);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$3

/* anonymous class */
    class _cls3 extends LoadPlayersImpl
    {

        final String zzavv[];

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzavv);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/PlayersImpl$9

/* anonymous class */
    class _cls9 extends LoadPlayersImpl
    {

        final String zzauv;
        final int zzavq;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, "nearby", zzauv, zzavq, false, false);
        }
    }

}
