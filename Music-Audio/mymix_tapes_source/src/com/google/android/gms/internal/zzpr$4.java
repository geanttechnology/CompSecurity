// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zze;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.internal:
//            zzpr

class eApiClient extends a
{

    final zzpr zzaLO;
    final Collection zzaLP;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zze));
    }

    protected void zza(zze zze1)
    {
        zze1.zza(this, zzaLP);
    }

    eApiClient(zzpr zzpr1, GoogleApiClient googleapiclient, Collection collection)
    {
        zzaLO = zzpr1;
        zzaLP = collection;
        super(googleapiclient, null);
    }
}
