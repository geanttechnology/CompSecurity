// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzaa, zzt, ListParentsRequest, zzal

class ient extends 
{

    final zzaa zzajb;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzt));
    }

    protected void zza(zzt zzt1)
        throws RemoteException
    {
        zzt1.zzqF().zza(new ListParentsRequest(zzajb.zzags), new a(this));
    }

    ient(zzaa zzaa1, GoogleApiClient googleapiclient)
    {
        zzajb = zzaa1;
        super(googleapiclient);
    }
}
