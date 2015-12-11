// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.zzl;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zzj, zzk

class zzaHh extends com.google.android.gms.location.places.f
{

    final zzj zzaHg;
    final PlaceReport zzaHh;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzk)b);
    }

    protected void zza(zzk zzk1)
        throws RemoteException
    {
        zzk1.zza(new zzl(this), zzaHh);
    }

    (zzj zzj1, com.google.android.gms.common.api.c c, GoogleApiClient googleapiclient, PlaceReport placereport)
    {
        zzaHg = zzj1;
        zzaHh = placereport;
        super(c, googleapiclient);
    }
}
