// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzl, zzf

class nt extends a
{

    final zzf zzaFt;
    final PendingIntent zzarN;

    protected volatile void zza(com.google.android.gms.common.api.b b)
    {
        zza((zzl)b);
    }

    protected void zza(zzl zzl1)
    {
        zzl1.zza(zzarN, this);
    }

    nt(zzf zzf, GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        zzaFt = zzf;
        zzarN = pendingintent;
        super(googleapiclient);
    }
}
