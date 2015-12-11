// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzl, zzd

class nt extends a
{

    final zzd zzaFf;
    final Location zzaFk;

    protected volatile void zza(com.google.android.gms.common.api.b b)
    {
        zza((zzl)b);
    }

    protected void zza(zzl zzl1)
    {
        zzl1.zzc(zzaFk);
        zzb(Status.zzabb);
    }

    nt(zzd zzd, GoogleApiClient googleapiclient, Location location)
    {
        zzaFf = zzd;
        zzaFk = location;
        super(googleapiclient);
    }
}
