// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzl, zza

class nt extends a
{

    final long zzaEX;
    final PendingIntent zzaEY;
    final zza zzaEZ;

    protected volatile void zza(com.google.android.gms.common.api.b b)
    {
        zza((zzl)b);
    }

    protected void zza(zzl zzl1)
    {
        zzl1.zza(zzaEX, zzaEY);
        zzb(Status.zzabb);
    }

    nt(zza zza1, GoogleApiClient googleapiclient, long l, PendingIntent pendingintent)
    {
        zzaEZ = zza1;
        zzaEX = l;
        zzaEY = pendingintent;
        super(googleapiclient);
    }
}
