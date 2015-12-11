// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl
    implements Requests
{
    private static abstract class LoadRequestSummariesImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.request.Requests.LoadRequestSummariesResult zzav(Status status)
        {
            return new com.google.android.gms.games.request.Requests.LoadRequestSummariesResult(this, status) {

                final Status zzVb;
                final LoadRequestSummariesImpl zzayp;

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzayp = loadrequestsummariesimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzav(status);
        }
    }

    private static abstract class LoadRequestsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.request.Requests.LoadRequestsResult zzaw(Status status)
        {
            return new com.google.android.gms.games.request.Requests.LoadRequestsResult(this, status) {

                final Status zzVb;
                final LoadRequestsImpl zzayq;

                public GameRequestBuffer getRequests(int i)
                {
                    return new GameRequestBuffer(DataHolder.zzbu(zzVb.getStatusCode()));
                }

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzayq = loadrequestsimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaw(status);
        }

        private LoadRequestsImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class SendRequestImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.request.Requests.SendRequestResult zzax(Status status)
        {
            return new com.google.android.gms.games.request.Requests.SendRequestResult(this, status) {

                final Status zzVb;
                final SendRequestImpl zzayr;

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzayr = sendrequestimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzax(status);
        }
    }

    private static abstract class UpdateRequestsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.request.Requests.UpdateRequestsResult zzay(Status status)
        {
            return new com.google.android.gms.games.request.Requests.UpdateRequestsResult(this, status) {

                final Status zzVb;
                final UpdateRequestsImpl zzays;

                public Set getRequestIds()
                {
                    return null;
                }

                public int getRequestOutcome(String s)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Unknown request ID ").append(s).toString());
                }

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzays = updaterequestsimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzay(status);
        }

        private UpdateRequestsImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public RequestsImpl()
    {
    }

    public PendingResult acceptRequest(GoogleApiClient googleapiclient, String s)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(s);
        return acceptRequests(googleapiclient, arraylist);
    }

    public PendingResult acceptRequests(GoogleApiClient googleapiclient, List list)
    {
        if (list == null)
        {
            list = null;
        } else
        {
            list = (String[])list.toArray(new String[list.size()]);
        }
        return googleapiclient.zzb(new UpdateRequestsImpl(googleapiclient, list) {

            final String zzayh[];
            final RequestsImpl zzayi;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzayh);
            }

            
            {
                zzayi = RequestsImpl.this;
                zzayh = as;
                super(googleapiclient);
            }
        });
    }

    public PendingResult dismissRequest(GoogleApiClient googleapiclient, String s)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(s);
        return dismissRequests(googleapiclient, arraylist);
    }

    public PendingResult dismissRequests(GoogleApiClient googleapiclient, List list)
    {
        if (list == null)
        {
            list = null;
        } else
        {
            list = (String[])list.toArray(new String[list.size()]);
        }
        return googleapiclient.zzb(new UpdateRequestsImpl(googleapiclient, list) {

            final String zzayh[];
            final RequestsImpl zzayi;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzc(this, zzayh);
            }

            
            {
                zzayi = RequestsImpl.this;
                zzayh = as;
                super(googleapiclient);
            }
        });
    }

    public ArrayList getGameRequestsFromBundle(Bundle bundle)
    {
        if (bundle == null || !bundle.containsKey("requests"))
        {
            return new ArrayList();
        }
        bundle = (ArrayList)bundle.get("requests");
        ArrayList arraylist = new ArrayList();
        int j = bundle.size();
        for (int i = 0; i < j; i++)
        {
            arraylist.add((GameRequest)bundle.get(i));
        }

        return arraylist;
    }

    public ArrayList getGameRequestsFromInboxResponse(Intent intent)
    {
        if (intent == null)
        {
            return new ArrayList();
        } else
        {
            return getGameRequestsFromBundle(intent.getExtras());
        }
    }

    public Intent getInboxIntent(GoogleApiClient googleapiclient)
    {
        return Games.zzc(googleapiclient).zzuO();
    }

    public int getMaxLifetimeDays(GoogleApiClient googleapiclient)
    {
        return Games.zzc(googleapiclient).zzuQ();
    }

    public int getMaxPayloadSize(GoogleApiClient googleapiclient)
    {
        return Games.zzc(googleapiclient).zzuP();
    }

    public Intent getSendIntent(GoogleApiClient googleapiclient, int i, byte abyte0[], int j, Bitmap bitmap, String s)
    {
        return Games.zzc(googleapiclient).zza(i, abyte0, j, bitmap, s);
    }

    public PendingResult loadRequests(GoogleApiClient googleapiclient, int i, int j, int k)
    {
        return googleapiclient.zza(new LoadRequestsImpl(googleapiclient, i, j, k) {

            final int zzaxo;
            final RequestsImpl zzayi;
            final int zzayj;
            final int zzayk;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzayj, zzayk, zzaxo);
            }

            
            {
                zzayi = RequestsImpl.this;
                zzayj = i;
                zzayk = j;
                zzaxo = k;
                super(googleapiclient);
            }
        });
    }

    public void registerRequestListener(GoogleApiClient googleapiclient, OnRequestReceivedListener onrequestreceivedlistener)
    {
        GamesClientImpl gamesclientimpl = Games.zzb(googleapiclient, false);
        if (gamesclientimpl != null)
        {
            gamesclientimpl.zzd(googleapiclient.zzo(onrequestreceivedlistener));
        }
    }

    public void unregisterRequestListener(GoogleApiClient googleapiclient)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzuI();
        }
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/RequestsImpl$4

/* anonymous class */
    class _cls4 extends SendRequestImpl
    {

        final String zzawT;
        final String zzayl[];
        final int zzaym;
        final byte zzayn[];
        final int zzayo;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzawT, zzayl, zzaym, zzayn, zzayo);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/RequestsImpl$5

/* anonymous class */
    class _cls5 extends SendRequestImpl
    {

        final String zzawT;
        final String zzayl[];
        final int zzaym;
        final byte zzayn[];
        final int zzayo;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzawT, zzayl, zzaym, zzayn, zzayo);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/RequestsImpl$6

/* anonymous class */
    class _cls6 extends UpdateRequestsImpl
    {

        final String zzawT;
        final String zzayd;
        final String zzayh[];

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzawT, zzayd, zzayh);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/RequestsImpl$7

/* anonymous class */
    class _cls7 extends LoadRequestsImpl
    {

        final String zzawT;
        final int zzaxo;
        final String zzayd;
        final int zzayj;
        final int zzayk;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzawT, zzayd, zzayj, zzayk, zzaxo);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/RequestsImpl$8

/* anonymous class */
    class _cls8 extends LoadRequestSummariesImpl
    {

        final String zzayd;
        final int zzayk;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzf(this, zzayd, zzayk);
        }
    }

}
