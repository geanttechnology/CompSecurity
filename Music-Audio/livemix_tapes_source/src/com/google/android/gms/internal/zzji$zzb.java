// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzji, zzjj

final class zzQh extends zzQh
{

    private final String zzQh;
    final zzji zzQi;

    protected volatile void zza(com.google.android.gms.common.api.Qh qh)
        throws RemoteException
    {
        zza((zzjj)qh);
    }

    protected void zza(zzjj zzjj1)
        throws RemoteException
    {
        zzjj1.zzb(new zzjk.zza() {

            final zzji.zzb zzQj;

            public void zze(Status status)
                throws RemoteException
            {
                zzQj.zza(status);
            }

            
            {
                zzQj = zzji.zzb.this;
                super();
            }
        }, zzQh);
    }

    protected Result zzb(Status status)
    {
        return zzd(status);
    }

    protected Status zzd(Status status)
    {
        return status;
    }

    public piClient(zzji zzji1, GoogleApiClient googleapiclient, String s)
    {
        zzQi = zzji1;
        super(googleapiclient);
        zzQh = s;
    }
}
