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
//            zzt, zzs, zzu, zzam, 
//            zzd

class lient extends zzt
{

    final zzs zzakv;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzu)b);
    }

    protected void zza(zzu zzu1)
        throws RemoteException
    {
        zzu1.zzrm().zze(new zzd(this) {

            final zzt zzaky;
            final zzs._cls5 zzakz;

            public void zzab(boolean flag)
            {
                zzaky.zzb(new BooleanResult(Status.zzabb, flag));
            }

            
            {
                zzakz = zzs._cls5.this;
                zzaky = zzt1;
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

    lient(zzs zzs1, GoogleApiClient googleapiclient)
    {
        zzakv = zzs1;
        super(googleapiclient);
    }
}
