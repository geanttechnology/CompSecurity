// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzl, LocationRequestInternal, zzd

class nt extends a
{

    final LocationRequest zzaFd;
    final zzd zzaFf;
    final LocationCallback zzaFh;
    final Looper zzaFl;

    protected volatile void zza(com.google.android.gms.common.api.b b)
    {
        zza((zzl)b);
    }

    protected void zza(zzl zzl1)
    {
        class _cls1 extends zzg.zza
        {

            final zzd._cls6 zzaFn;

            public void zza(FusedLocationProviderResult fusedlocationproviderresult)
            {
                zzaFn.zzb(fusedlocationproviderresult.getStatus());
            }

            _cls1()
            {
                zzaFn = zzd._cls6.this;
                super();
            }
        }

        _cls1 _lcls1 = new _cls1();
        zzl1.zza(LocationRequestInternal.zzb(zzaFd), zzaFh, zzaFl, _lcls1);
    }

    nt(zzd zzd, GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationCallback locationcallback, Looper looper)
    {
        zzaFf = zzd;
        zzaFd = locationrequest;
        zzaFh = locationcallback;
        zzaFl = looper;
        super(googleapiclient);
    }
}
