// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            fx

public final class go
    implements Requests
{
    private static abstract class a extends com.google.android.gms.games.Games.a
    {

        public com.google.android.gms.games.request.Requests.LoadRequestsResult B(Status status)
        {
            return new com.google.android.gms.games.request.Requests.LoadRequestsResult(this, status) {

                final a In;
                final Status vb;

                public GameRequestBuffer getRequests(int i)
                {
                    return null;
                }

                public Status getStatus()
                {
                    return vb;
                }

                public void release()
                {
                }

            
            {
                In = a1;
                vb = status;
                super();
            }
            };
        }

        public Result d(Status status)
        {
            return B(status);
        }

        private a()
        {
        }

    }

    private static abstract class b extends com.google.android.gms.games.Games.a
    {

        public com.google.android.gms.games.request.Requests.UpdateRequestsResult C(Status status)
        {
            return new com.google.android.gms.games.request.Requests.UpdateRequestsResult(this, status) {

                final b Io;
                final Status vb;

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
                    return vb;
                }

                public void release()
                {
                }

            
            {
                Io = b1;
                vb = status;
                super();
            }
            };
        }

        public Result d(Status status)
        {
            return C(status);
        }

        private b()
        {
        }

    }


    public go()
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
        return googleapiclient.b(new b(list) {

            final String Ij[];
            final go Ik;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.a(this, Ij);
            }

            
            {
                Ik = go.this;
                Ij = as;
                super();
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
        return googleapiclient.b(new b(list) {

            final String Ij[];
            final go Ik;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.b(this, Ij);
            }

            
            {
                Ik = go.this;
                Ij = as;
                super();
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
        return Games.c(googleapiclient).fD();
    }

    public int getMaxLifetimeDays(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).fF();
    }

    public int getMaxPayloadSize(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).fE();
    }

    public Intent getSendIntent(GoogleApiClient googleapiclient, int i, byte abyte0[], int j, Bitmap bitmap, String s)
    {
        return Games.c(googleapiclient).a(i, abyte0, j, bitmap, s);
    }

    public PendingResult loadRequests(GoogleApiClient googleapiclient, int i, int j, int k)
    {
        return googleapiclient.a(new a(i, j, k) {

            final int HP;
            final go Ik;
            final int Il;
            final int Im;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.a(this, Il, Im, HP);
            }

            
            {
                Ik = go.this;
                Il = i;
                Im = j;
                HP = k;
                super();
            }
        });
    }

    public void registerRequestListener(GoogleApiClient googleapiclient, OnRequestReceivedListener onrequestreceivedlistener)
    {
        Games.c(googleapiclient).a(onrequestreceivedlistener);
    }

    public void unregisterRequestListener(GoogleApiClient googleapiclient)
    {
        Games.c(googleapiclient).fx();
    }
}
