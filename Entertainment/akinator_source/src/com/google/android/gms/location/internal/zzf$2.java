// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzf, zzl

class nt extends a
{

    final zzf zzaFt;
    final PendingIntent zzarN;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzl)b);
    }

    protected void zza(zzl zzl1)
        throws RemoteException
    {
        zzl1.zza(zzarN, this);
    }

    nt(zzf zzf1, GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        zzaFt = zzf1;
        zzarN = pendingintent;
        super(googleapiclient);
    }
}
