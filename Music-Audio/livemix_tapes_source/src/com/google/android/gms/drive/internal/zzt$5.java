// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzt, CancelPendingActionsRequest, zzbr, zzal

class lient extends a
{

    final zzt zzaiB;
    final List zzaiC;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzt)b);
    }

    protected void zza(zzt zzt1)
        throws RemoteException
    {
        zzt1.zzqF().zza(new CancelPendingActionsRequest(zzaiC), new zzbr(this));
    }

    lient(zzt zzt1, GoogleApiClient googleapiclient, List list)
    {
        zzaiB = zzt1;
        zzaiC = list;
        super(googleapiclient);
    }
}
