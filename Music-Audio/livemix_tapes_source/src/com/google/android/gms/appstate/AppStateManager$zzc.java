// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateManager, AppStateBuffer

private static abstract class <init> extends <init>
{

    public Result zzb(Status status)
    {
        return zzi(status);
    }

    public eListResult zzi(Status status)
    {
        return new AppStateManager.StateListResult(status) {

            final Status zzQs;
            final AppStateManager.zzc zzQy;

            public AppStateBuffer getStateBuffer()
            {
                return new AppStateBuffer(null);
            }

            public Status getStatus()
            {
                return zzQs;
            }

            
            {
                zzQy = AppStateManager.zzc.this;
                zzQs = status;
                super();
            }
        };
    }

    public _cls1.zzQs(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }
}
