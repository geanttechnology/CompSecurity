// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzl, zzd

class nt extends a
{

    final PendingIntent zzaEY;
    final LocationRequest zzaFd;
    final zzd zzaFf;

    protected volatile void zza(com.google.android.gms.common.api.b b)
    {
        zza((zzl)b);
    }

    protected void zza(zzl zzl1)
    {
        class _cls1 extends zzg.zza
        {

            final zzd._cls7 zzaFo;

            public void zza(FusedLocationProviderResult fusedlocationproviderresult)
            {
                zzaFo.zzb(fusedlocationproviderresult.getStatus());
            }

            _cls1()
            {
                zzaFo = zzd._cls7.this;
                super();
            }
        }

        _cls1 _lcls1 = new _cls1();
        zzl1.zza(zzaFd, zzaEY, _lcls1);
    }

    nt(zzd zzd, GoogleApiClient googleapiclient, LocationRequest locationrequest, PendingIntent pendingintent)
    {
        zzaFf = zzd;
        zzaFd = locationrequest;
        zzaEY = pendingintent;
        super(googleapiclient);
    }
}
