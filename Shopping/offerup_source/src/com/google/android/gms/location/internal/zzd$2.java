// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationCallback;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzl, zzd

class nt extends a
{

    final zzd zzaFf;
    final LocationCallback zzaFh;

    protected volatile void zza(com.google.android.gms.common.api.b b)
    {
        zza((zzl)b);
    }

    protected void zza(zzl zzl1)
    {
        class _cls1 extends zzg.zza
        {

            final zzd._cls2 zzaFi;

            public void zza(FusedLocationProviderResult fusedlocationproviderresult)
            {
                zzaFi.zzb(fusedlocationproviderresult.getStatus());
            }

            _cls1()
            {
                zzaFi = zzd._cls2.this;
                super();
            }
        }

        _cls1 _lcls1 = new _cls1();
        zzl1.zza(zzaFh, _lcls1);
    }

    nt(zzd zzd, GoogleApiClient googleapiclient, LocationCallback locationcallback)
    {
        zzaFf = zzd;
        zzaFh = locationcallback;
        super(googleapiclient);
    }
}
