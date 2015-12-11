// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzl, zzf

class nt extends a
{

    final zzf zzaFt;
    final List zzaFu;

    protected volatile void zza(com.google.android.gms.common.api.b b)
    {
        zza((zzl)b);
    }

    protected void zza(zzl zzl1)
    {
        zzl1.zza(zzaFu, this);
    }

    nt(zzf zzf, GoogleApiClient googleapiclient, List list)
    {
        zzaFt = zzf;
        zzaFu = list;
        super(googleapiclient);
    }
}
