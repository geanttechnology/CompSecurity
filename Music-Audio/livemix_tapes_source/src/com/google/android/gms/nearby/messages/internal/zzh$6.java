// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            zzh, zzg

class a extends a
{

    final zzh zzaJY;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzg)b);
    }

    protected void zza(zzg zzg1)
        throws RemoteException
    {
        zzg1.zzi(this);
    }

    a(zzh zzh1, GoogleApiClient googleapiclient)
    {
        zzaJY = zzh1;
        super(googleapiclient);
    }
}
