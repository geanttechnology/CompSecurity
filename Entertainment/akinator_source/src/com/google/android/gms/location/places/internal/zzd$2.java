// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.zzl;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zzd, zze

class zzaGX extends com.google.android.gms.location.places.c
{

    final zzd zzaGW;
    final String zzaGX[];

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zze)b);
    }

    protected void zza(zze zze1)
        throws RemoteException
    {
        java.util.List list = Arrays.asList(zzaGX);
        zze1.zza(new zzl(this, zze1.getContext()), list);
    }

    (zzd zzd1, com.google.android.gms.common.api.c c, GoogleApiClient googleapiclient, String as[])
    {
        zzaGW = zzd1;
        zzaGX = as;
        super(c, googleapiclient);
    }
}
