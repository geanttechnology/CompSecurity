// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzjv, zzjw

final class zzRm extends zzRm
{

    private final String zzRm;
    final zzjv zzRn;

    protected volatile void zza(com.google.android.gms.common.api.Rm rm)
        throws RemoteException
    {
        zza((zzjw)rm);
    }

    protected void zza(zzjw zzjw1)
        throws RemoteException
    {
        zzjw1.zzb(new zzjx.zza() {

            final zzjv.zzb zzRo;

            public void zze(Status status)
                throws RemoteException
            {
                zzRo.zzb(status);
            }

            
            {
                zzRo = zzjv.zzb.this;
                super();
            }
        }, zzRm);
    }

    protected Result zzb(Status status)
    {
        return zzd(status);
    }

    protected Status zzd(Status status)
    {
        return status;
    }

    public piClient(zzjv zzjv1, GoogleApiClient googleapiclient, String s)
    {
        zzRn = zzjv1;
        super(googleapiclient);
        zzRm = s;
    }
}
