// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl
    implements GamesMetadata
{
    private static abstract class LoadGameInstancesImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult zzac(Status status)
        {
            return new com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult(this, status) {

                final Status zzVb;
                final LoadGameInstancesImpl zzaxl;

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzaxl = loadgameinstancesimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzac(status);
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult zzad(Status status)
        {
            return new com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult(this, status) {

                final Status zzVb;
                final LoadGameSearchSuggestionsImpl zzaxm;

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzaxm = loadgamesearchsuggestionsimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzad(status);
        }
    }

    private static abstract class LoadGamesImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.GamesMetadata.LoadGamesResult zzae(Status status)
        {
            return new com.google.android.gms.games.GamesMetadata.LoadGamesResult(this, status) {

                final Status zzVb;
                final LoadGamesImpl zzaxn;

                public GameBuffer getGames()
                {
                    return new GameBuffer(DataHolder.zzbu(14));
                }

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzaxn = loadgamesimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzae(status);
        }

        private LoadGamesImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public GamesMetadataImpl()
    {
    }

    public Game getCurrentGame(GoogleApiClient googleapiclient)
    {
        return Games.zzc(googleapiclient).zzuA();
    }

    public PendingResult loadGame(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new LoadGamesImpl(googleapiclient) {

            final GamesMetadataImpl zzaxj;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzd(this);
            }

            
            {
                zzaxj = GamesMetadataImpl.this;
                super(googleapiclient);
            }
        });
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/GamesMetadataImpl$2

/* anonymous class */
    class _cls2 extends LoadGameInstancesImpl
    {

        final String zzawT;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzj(this, zzawT);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/GamesMetadataImpl$3

/* anonymous class */
    class _cls3 extends LoadGameSearchSuggestionsImpl
    {

        final String zzaxk;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzk(this, zzaxk);
        }
    }

}
