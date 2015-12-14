// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzjn;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateManager

static final class b extends b
{

    final int zzQt;

    protected volatile void zza(com.google.android.gms.common.api.<init> <init>1)
        throws RemoteException
    {
        zza((zzjn)<init>1);
    }

    protected void zza(zzjn zzjn1)
        throws RemoteException
    {
        zzjn1.zza(this, zzQt);
    }

    public Result zzb(Status status)
    {
        return zzh(status);
    }

    public ateDeletedResult zzh(Status status)
    {
        return new AppStateManager.StateDeletedResult(status) {

            final Status zzQs;
            final AppStateManager._cls5 zzQv;

            public int getStateKey()
            {
                return zzQv.zzQt;
            }

            public Status getStatus()
            {
                return zzQs;
            }

            
            {
                zzQv = AppStateManager._cls5.this;
                zzQs = status;
                super();
            }
        };
    }

    _cls1.zzQs(GoogleApiClient googleapiclient, int i)
    {
        zzQt = i;
        super(googleapiclient);
    }
}
