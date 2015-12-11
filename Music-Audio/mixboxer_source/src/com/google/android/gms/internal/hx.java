// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;

// Referenced classes of package com.google.android.gms.internal:
//            eg, hs

public final class hx
    implements Account
{
    private static abstract class a extends com.google.android.gms.plus.Plus.a
    {

        public Result e(Status status)
        {
            return g(status);
        }

        public Status g(Status status)
        {
            return status;
        }

        a(com.google.android.gms.common.api.Api.b b)
        {
            super(b);
        }
    }


    private final com.google.android.gms.common.api.Api.b Ea;

    public hx(com.google.android.gms.common.api.Api.b b)
    {
        Ea = b;
    }

    private static hs a(GoogleApiClient googleapiclient, com.google.android.gms.common.api.Api.b b)
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
        eg.b(flag, "GoogleApiClient parameter is required.");
        eg.a(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        googleapiclient = (hs)googleapiclient.a(b);
        if (googleapiclient != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        eg.a(flag, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return googleapiclient;
    }

    public void clearDefaultAccount(GoogleApiClient googleapiclient)
    {
        a(googleapiclient, Ea).clearDefaultAccount();
    }

    public String getAccountName(GoogleApiClient googleapiclient)
    {
        return a(googleapiclient, Ea).getAccountName();
    }

    public PendingResult revokeAccessAndDisconnect(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new a(Ea) {

            final hx Eb;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((hs)a1);
            }

            protected void a(hs hs1)
            {
                hs1.l(this);
            }

            
            {
                Eb = hx.this;
                super(b);
            }
        });
    }
}
