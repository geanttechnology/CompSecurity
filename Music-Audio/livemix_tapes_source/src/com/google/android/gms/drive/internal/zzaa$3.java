// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzaa, zzt, SetResourceParentsRequest, zzbr, 
//            zzal

class ient extends 
{

    final zzaa zzajb;
    final List zzajc;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzt));
    }

    protected void zza(zzt zzt1)
        throws RemoteException
    {
        zzt1.zzqF().zza(new SetResourceParentsRequest(zzajb.zzags, zzajc), new zzbr(this));
    }

    ient(zzaa zzaa1, GoogleApiClient googleapiclient, List list)
    {
        zzajb = zzaa1;
        zzajc = list;
        super(googleapiclient);
    }
}
