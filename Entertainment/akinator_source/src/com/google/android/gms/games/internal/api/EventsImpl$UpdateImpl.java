// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            EventsImpl

private static abstract class <init> extends com.google.android.gms.games.odImpl
{

    public Result zzb(Status status)
    {
        return new Result(status) {

            final Status zzVb;
            final EventsImpl.UpdateImpl zzaxi;

            public Status getStatus()
            {
                return zzVb;
            }

            
            {
                zzaxi = EventsImpl.UpdateImpl.this;
                zzVb = status;
                super();
            }
        };
    }

    private _cls1.zzVb(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    (GoogleApiClient googleapiclient,  )
    {
        this(googleapiclient);
    }
}
