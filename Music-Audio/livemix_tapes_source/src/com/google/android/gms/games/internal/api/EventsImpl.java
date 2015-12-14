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

        public com.google.android.gms.games.event.Events.LoadEventsResult zzac(Status status)
        {
            return new com.google.android.gms.games.event.Events.LoadEventsResult(this, status) {

                final Status zzQs;
                final LoadImpl zzauJ;

                public EventBuffer getEvents()
                {
                    return new EventBuffer(DataHolder.zzbp(14));
                }

                public Status getStatus()
                {
                    return zzQs;
                }

                public void release()
                {
                }

            
            {
                zzauJ = loadimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzac(status);
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

                final Status zzQs;
                final UpdateImpl zzauK;

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzauK = updateimpl;
                zzQs = status;
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
            gamesclientimpl.zzq(s, i);
            return;
        } else
        {
            googleapiclient.zzb(new UpdateImpl(googleapiclient, s, i) {

                final EventsImpl zzauG;
                final String zzauH;
                final int zzauI;

                public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((GamesClientImpl)zzb);
                }

                public void zza(GamesClientImpl gamesclientimpl1)
                {
                    gamesclientimpl1.zzq(zzauH, zzauI);
                }

            
            {
                zzauG = EventsImpl.this;
                zzauH = s;
                zzauI = i;
                super(googleapiclient);
            }
            });
            return;
        }
    }

    public PendingResult load(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zza(new LoadImpl(googleapiclient, flag) {

            final EventsImpl zzauG;
            final boolean zzaut;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzd(this, zzaut);
            }

            
            {
                zzauG = EventsImpl.this;
                zzaut = flag;
                super(googleapiclient);
            }
        });
    }

    public transient PendingResult loadByIds(GoogleApiClient googleapiclient, boolean flag, String as[])
    {
        return googleapiclient.zza(new LoadImpl(googleapiclient, flag, as) {

            final String zzauF[];
            final EventsImpl zzauG;
            final boolean zzaut;

            public volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            public void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzaut, zzauF);
            }

            
            {
                zzauG = EventsImpl.this;
                zzaut = flag;
                zzauF = as;
                super(googleapiclient);
            }
        });
    }
}
