// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzl, zzd

class nt extends a
{

    final zzd zzaFf;
    final boolean zzaFj;

    protected volatile void zza(com.google.android.gms.common.api.b b)
    {
        zza((zzl)b);
    }

    protected void zza(zzl zzl1)
    {
        zzl1.zzah(zzaFj);
        zzb(Status.zzabb);
    }

    nt(zzd zzd, GoogleApiClient googleapiclient, boolean flag)
    {
        zzaFf = zzd;
        zzaFj = flag;
        super(googleapiclient);
    }
}
