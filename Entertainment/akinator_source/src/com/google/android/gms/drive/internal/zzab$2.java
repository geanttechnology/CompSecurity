// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzab, zzu, ListParentsRequest, zzam

class ient extends 
{

    final zzab zzalp;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzu));
    }

    protected void zza(zzu zzu1)
        throws RemoteException
    {
        zzu1.zzrm().zza(new ListParentsRequest(zzalp.zzaiA), new a(this));
    }

    ient(zzab zzab1, GoogleApiClient googleapiclient)
    {
        zzalp = zzab1;
        super(googleapiclient);
    }
}
