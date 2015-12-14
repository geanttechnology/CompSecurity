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

        public com.google.android.gms.games.request.Requests.LoadRequestSummariesResult zzaw(Status status)
        {
            return new com.google.android.gms.games.request.Requests.LoadRequestSummariesResult(this, status) {

                final Status zzQs;
                final LoadRequestSummariesImpl zzavR;

                public Status getStatus()
                {
                    return zzQs;
                }

                public void release()
                {
                }

            
            {
                zzavR = loadrequestsummariesimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaw(status);
        }
    }

    private static abstract class LoadRequestsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.request.Requests.LoadRequestsResult zzax(Status status)
        {
            return new com.google.android.gms.games.request.Requests.LoadRequestsResult(this, status) {

                final Status zzQs;
                final LoadRequestsImpl zzavS;

                public GameRequestBuffer getRequests(int i)
                {
                    return new GameRequestBuffer(DataHolder.zzbp(zzQs.getStatusCode()));
                }

                public Status getStatus()
                {
                    return zzQs;
                }

                public void release()
                {
                }

            
            {
                zzavS = loadrequestsimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzax(status);
        }

        private LoadRequestsImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class SendRequestImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.request.Requests.SendRequestResult zzay(Status status)
        {
            return new com.google.android.gms.games.request.Requests.SendRequestResult(this, status) {

                final Status zzQs;
                final SendRequestImpl zzavT;

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzavT = sendrequestimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzay(status);
        }
    }

    private static abstract class UpdateRequestsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.request.Requests.UpdateRequestsResult zzaz(Status status)
        {
            return new com.google.android.gms.games.request.Requests.UpdateRequestsResult(this, status) {

                final Status zzQs;
                final UpdateRequestsImpl zzavU;

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
                    return zzQs;
                }

                public void release()
                {
                }

            
            {
                zzavU = updaterequestsimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaz(status);
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

            final String zzavJ[];
            final RequestsImpl zzavK;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this, zzavJ);
            }

            
            {
                zzavK = RequestsImpl.this;
                zzavJ = as;
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

            final String zzavJ[];
            final RequestsImpl zzavK;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzc(this, zzavJ);
            }

            
            {
                zzavK = RequestsImpl.this;
                zzavJ = as;
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
        return Games.zzd(googleapiclient).zztY();
    }

    public int getMaxLifetimeDays(GoogleApiClient googleapiclient)
    {
        return Games.zzd(googleapiclient).zzua();
    }

    public int getMaxPayloadSize(GoogleApiClient googleapiclient)
    {
        return Games.zzd(googleapiclient).zztZ();
    }

    public Intent getSendIntent(GoogleApiClient googleapiclient, int i, byte abyte0[], int j, Bitmap bitmap, String s)
    {
        return Games.zzd(googleapiclient).zza(i, abyte0, j, bitmap, s);
    }

    public PendingResult loadRequests(GoogleApiClient googleapiclient, int i, int j, int k)
    {
        return googleapiclient.zza(new LoadRequestsImpl(googleapiclient, i, j, k) {

            final int zzauQ;
            final RequestsImpl zzavK;
            final int zzavL;
            final int zzavM;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzavL, zzavM, zzauQ);
            }

            
            {
                zzavK = RequestsImpl.this;
                zzavL = i;
                zzavM = j;
                zzauQ = k;
                super(googleapiclient);
            }
        });
    }

    public void registerRequestListener(GoogleApiClient googleapiclient, OnRequestReceivedListener onrequestreceivedlistener)
    {
        GamesClientImpl gamesclientimpl = Games.zzb(googleapiclient, false);
        if (gamesclientimpl != null)
        {
            gamesclientimpl.zzd(googleapiclient.zzp(onrequestreceivedlistener));
        }
    }

    public void unregisterRequestListener(GoogleApiClient googleapiclient)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zztS();
        }
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/RequestsImpl$4

/* anonymous class */
    class _cls4 extends SendRequestImpl
    {

        final String zzauv;
        final String zzavN[];
        final int zzavO;
        final byte zzavP[];
        final int zzavQ;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzauv, zzavN, zzavO, zzavP, zzavQ);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/RequestsImpl$5

/* anonymous class */
    class _cls5 extends SendRequestImpl
    {

        final String zzauv;
        final String zzavN[];
        final int zzavO;
        final byte zzavP[];
        final int zzavQ;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzauv, zzavN, zzavO, zzavP, zzavQ);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/RequestsImpl$6

/* anonymous class */
    class _cls6 extends UpdateRequestsImpl
    {

        final String zzauv;
        final String zzavF;
        final String zzavJ[];

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzauv, zzavF, zzavJ);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/RequestsImpl$7

/* anonymous class */
    class _cls7 extends LoadRequestsImpl
    {

        final int zzauQ;
        final String zzauv;
        final String zzavF;
        final int zzavL;
        final int zzavM;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzauv, zzavF, zzavL, zzavM, zzauQ);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/RequestsImpl$8

/* anonymous class */
    class _cls8 extends LoadRequestSummariesImpl
    {

        final String zzavF;
        final int zzavM;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzf(this, zzavF, zzavM);
        }
    }

}
