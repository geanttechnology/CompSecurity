// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.model.moments.MomentBuffer;

// Referenced classes of package com.google.android.gms.internal:
//            zzpq

private static abstract class piClient extends com.google.android.gms.plus.zza
{

    public com.google.android.gms.plus.oadMomentsResult zzaY(Status status)
    {
        return new com.google.android.gms.plus.Moments.LoadMomentsResult(status) {

            final Status zzQs;
            final zzpq.zza zzaLM;

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
                return zzQs;
            }

            public String getUpdated()
            {
                return null;
            }

            public void release()
            {
            }

            
            {
                zzaLM = zzpq.zza.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzaY(status);
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
