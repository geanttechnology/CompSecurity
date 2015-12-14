// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.request.GameRequestBuffer;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            RequestsImpl

private static abstract class <init> extends com.google.android.gms.games.RequestsImpl
{

    public com.google.android.gms.games.request.Impl zzax(Status status)
    {
        return new com.google.android.gms.games.request.Requests.LoadRequestsResult(status) {

            final Status zzQs;
            final RequestsImpl.LoadRequestsImpl zzavS;

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
                zzavS = RequestsImpl.LoadRequestsImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzax(status);
    }

    private _cls1.zzQs(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    _cls1.zzQs(GoogleApiClient googleapiclient, _cls1.zzQs zzqs)
    {
        this(googleapiclient);
    }
}
