// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzs, zzr, zzt, zzal, 
//            zzd

class lient extends zzs
{

    final zzr zzaii;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzt)b);
    }

    protected void zza(zzt zzt1)
        throws RemoteException
    {
        zzt1.zzqF().zze(new zzd(this) {

            final zzs zzail;
            final zzr._cls5 zzaim;

            public void zzaa(boolean flag)
            {
                zzail.zza(new BooleanResult(Status.zzaaD, flag));
            }

            
            {
                zzaim = zzr._cls5.this;
                zzail = zzs1;
                super();
            }
        });
    }

    protected Result zzb(Status status)
    {
        return zzz(status);
    }

    protected BooleanResult zzz(Status status)
    {
        return new BooleanResult(status, false);
    }

    lient(zzr zzr1, GoogleApiClient googleapiclient)
    {
        zzaii = zzr1;
        super(googleapiclient);
    }
}
