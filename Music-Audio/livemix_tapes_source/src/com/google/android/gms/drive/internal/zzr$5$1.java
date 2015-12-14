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
//            zzd, zzs, zzr, zzt, 
//            zzal

class t> extends zzd
{

    final zzs zzail;
    final  zzaim;

    public void zzaa(boolean flag)
    {
        zzail.zza(new BooleanResult(Status.zzaaD, flag));
    }

    ent(ent ent, zzs zzs1)
    {
        zzaim = ent;
        zzail = zzs1;
        super();
    }

    // Unreferenced inner class com/google/android/gms/drive/internal/zzr$5

/* anonymous class */
    class zzr._cls5 extends zzs
    {

        final zzr zzaii;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzt)zzb1);
        }

        protected void zza(zzt zzt1)
            throws RemoteException
        {
            zzt1.zzqF().zze(new zzr._cls5._cls1(this, this));
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
                zzaii = zzr1;
                super(googleapiclient);
            }
    }

}
