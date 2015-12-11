// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.zzf;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zze, zzd

class zzaHa extends com.google.android.gms.location.places.b
{

    final zzd zzaGW;
    final String zzaHa;

    protected volatile void zza(com.google.android.gms.common.api.b b)
    {
        zza((zze)b);
    }

    protected void zza(zze zze1)
    {
        zze1.zza(new zzf(this), zzaHa);
    }

    (zzd zzd, com.google.android.gms.common.api.c c, GoogleApiClient googleapiclient, String s)
    {
        zzaGW = zzd;
        zzaHa = s;
        super(c, googleapiclient);
    }
}
