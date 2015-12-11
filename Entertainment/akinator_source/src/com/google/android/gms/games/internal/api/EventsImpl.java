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
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl
    implements Events
{
    private static abstract class LoadImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.event.Events.LoadEventsResult zzab(Status status)
        {
            return new com.google.android.gms.games.event.Events.LoadEventsResult(this, status) {

                final Status zzVb;
                final LoadImpl zzaxh;

                public EventBuffer getEvents()
                {
                    return new EventBuffer(DataHolder.zzbu(14));
                }

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzaxh = loadimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzab(status);
        }

        private LoadImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class UpdateImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public Result zzb(Status status)
        {
            return new Result(this, status) {

                final Status zzVb;
                final UpdateImpl zzaxi;

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzaxi = updateimpl;
                zzVb = status;
                super();
            }
            };
        }

        private UpdateImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public EventsImpl()
    {
    }

    public void increment(GoogleApiClient googleapiclient, String s, int i)
    {
        GamesClientImpl gamesclientimpl = Games.zzc(googleapiclient, false);
        if (gamesclientimpl == null)
        {
            return;
        }
        if (gamesclientimpl.isConnected())
        {
            gamesclientimpl.zzp(s, i);
            return;
        } else
        {
            googleapiclient.zzb(new UpdateImpl(googleapiclient, s, i) {

                final EventsImpl zzaxe;
                final String zzaxf;
                final int zzaxg;

                public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((GamesClientImpl)zzb);
                }

                public void zza(GamesClientImpl gamesclientimpl1)
                {
                    gamesclientimpl1.zzp(zzaxf, zzaxg);
                }

            
            {
                zzaxe = EventsImpl.this;
                zzaxf = s;
                zzaxg = i;
                super(googleapiclient);
            }
            });
            return;
        }
    }

    public PendingResult load(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zza(new LoadImpl(googleapiclient, flag) {

            final boolean zzawR;
            final EventsImpl zzaxe;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzd(this, zzawR);
            }

            
            {
                zzaxe = EventsImpl.this;
                zzawR = flag;
                super(googleapiclient);
            }
        });
    }

    public transient PendingResult loadByIds(GoogleApiClient googleapiclient, boolean flag, String as[])
    {
        return googleapiclient.zza(new LoadImpl(googleapiclient, flag, as) {

            final boolean zzawR;
            final String zzaxd[];
            final EventsImpl zzaxe;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzawR, zzaxd);
            }

            
            {
                zzaxe = EventsImpl.this;
                zzawR = flag;
                zzaxd = as;
                super(googleapiclient);
            }
        });
    }
}
