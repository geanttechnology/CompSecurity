// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzpw, zzpx

class eApiClient extends c
{

    final zzpw zzaNE;
    final List zzaNF;
    final String zzaNG;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzpx));
    }

    protected void zza(zzpx zzpx1)
        throws RemoteException
    {
        zzpx1.zza(zzaNI, zzaNF, 1, zzaNG);
    }

    eApiClient(zzpw zzpw1, GoogleApiClient googleapiclient, List list, String s)
    {
        zzaNE = zzpw1;
        zzaNF = list;
        zzaNG = s;
        super(googleapiclient);
    }
}
