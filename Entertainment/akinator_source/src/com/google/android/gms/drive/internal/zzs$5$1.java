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
//            zzd, zzt, zzs, zzu, 
//            zzam

class t> extends zzd
{

    final zzt zzaky;
    final  zzakz;

    public void zzab(boolean flag)
    {
        zzaky.zzb(new BooleanResult(Status.zzabb, flag));
    }

    ent(ent ent, zzt zzt1)
    {
        zzakz = ent;
        zzaky = zzt1;
        super();
    }

    // Unreferenced inner class com/google/android/gms/drive/internal/zzs$5

/* anonymous class */
    class zzs._cls5 extends zzt
    {

        final zzs zzakv;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzu)zzb1);
        }

        protected void zza(zzu zzu1)
            throws RemoteException
        {
            zzu1.zzrm().zze(new zzs._cls5._cls1(this, this));
        }

        protected Result zzb(Status status)
        {
            return zzz(status);
        }

        protected BooleanResult zzz(Status status)
        {
            return new BooleanResult(status, false);
        }

            
            {
                zzakv = zzs1;
                super(googleapiclient);
            }
    }

}
