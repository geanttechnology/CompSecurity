// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.model.moments.MomentBuffer;

abstract class piClient extends com.google.android.gms.plus.zza
{

    public Result createFailedResult(Status status)
    {
        return zzaJ(status);
    }

    public com.google.android.gms.plus.oadMomentsResult zzaJ(Status status)
    {
        return new com.google.android.gms.plus.Moments.LoadMomentsResult(status) {

            final Status zzKj;
            final zzlo.zza zzazw;

            public MomentBuffer getMomentBuffer()
            {
                return null;
            }

            public String getNextPageToken()
            {
                return null;
            }

            public Status getStatus()
            {
                return zzKj;
            }

            public String getUpdated()
            {
                return null;
            }

            public void release()
            {
            }

            
            {
                zzazw = zzlo.zza.this;
                zzKj = status;
                super();
            }
        };
    }

    private piClient(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    piClient(GoogleApiClient googleapiclient, piClient piclient)
    {
        this(googleapiclient);
    }
}
