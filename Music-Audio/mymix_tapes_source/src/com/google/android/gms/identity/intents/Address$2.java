// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zznx;

// Referenced classes of package com.google.android.gms.identity.intents:
//            Address, UserAddressRequest

static final class a extends a
{

    final UserAddressRequest zzaAx;
    final int zzaAy;

    protected volatile void zza(com.google.android.gms.common.api.ess._cls2 _pcls2)
        throws RemoteException
    {
        zza((zznx)_pcls2);
    }

    protected void zza(zznx zznx1)
        throws RemoteException
    {
        zznx1.zza(zzaAx, zzaAy);
        zza(((com.google.android.gms.common.api.Result) (Status.zzaaD)));
    }

    sRequest(GoogleApiClient googleapiclient, UserAddressRequest useraddressrequest, int i)
    {
        zzaAx = useraddressrequest;
        zzaAy = i;
        super(googleapiclient);
    }
}
