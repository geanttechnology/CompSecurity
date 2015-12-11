// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzkw, zzkx

class eApiClient extends b
{

    final zzkw zzZP;
    final String zzZQ;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzkx));
    }

    protected void zza(zzkx zzkx1)
        throws RemoteException
    {
        zzkx1.zza(new b.zza(this, zzkx1), zzkw.zzb(zzZP), zzZQ);
    }

    eApiClient(zzkw zzkw1, GoogleApiClient googleapiclient, String s)
    {
        zzZP = zzkw1;
        zzZQ = s;
        super(zzkw1, googleapiclient);
    }
}
