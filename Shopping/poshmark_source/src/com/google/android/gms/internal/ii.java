// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.internal.e;

// Referenced classes of package com.google.android.gms.internal:
//            er

public final class ii
    implements Account
{
    private static abstract class a extends com.google.android.gms.plus.Plus.a
    {

        public Result d(Status status)
        {
            return f(status);
        }

        public Status f(Status status)
        {
            return status;
        }

        a(com.google.android.gms.common.api.Api.b b)
        {
            super(b);
        }
    }


    private final com.google.android.gms.common.api.Api.b Rw;

    public ii(com.google.android.gms.common.api.Api.b b)
    {
        Rw = b;
    }

    private static e a(GoogleApiClient googleapiclient, com.google.android.gms.common.api.Api.b b)
    {
        boolean flag1 = true;
        boolean flag;
        if (googleapiclient != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.b(flag, "GoogleApiClient parameter is required.");
        er.a(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        googleapiclient = (e)googleapiclient.a(b);
        if (googleapiclient != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        er.a(flag, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return googleapiclient;
    }

    public void clearDefaultAccount(GoogleApiClient googleapiclient)
    {
        a(googleapiclient, Rw).clearDefaultAccount();
    }

    public String getAccountName(GoogleApiClient googleapiclient)
    {
        return a(googleapiclient, Rw).getAccountName();
    }

    public PendingResult revokeAccessAndDisconnect(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new a(Rw) {

            final ii Rx;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((e)a1);
            }

            protected void a(e e1)
            {
                e1.k(this);
            }

            
            {
                Rx = ii.this;
                super(b);
            }
        });
    }
}
