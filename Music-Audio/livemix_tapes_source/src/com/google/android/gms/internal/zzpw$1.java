// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzpw, zzpx

class eApiClient extends b
{

    final byte zzaND[];
    final zzpw zzaNE;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzpx));
    }

    protected void zza(zzpx zzpx1)
        throws RemoteException
    {
        zzpx1.zza(zzaNI, zzaND);
    }

    eApiClient(zzpw zzpw1, GoogleApiClient googleapiclient, byte abyte0[])
    {
        zzaNE = zzpw1;
        zzaND = abyte0;
        super(googleapiclient);
    }
}
