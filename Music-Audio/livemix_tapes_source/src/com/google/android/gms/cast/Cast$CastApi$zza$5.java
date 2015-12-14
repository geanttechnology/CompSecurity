// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.cast:
//            Cast

class nt extends nt
{

    final zza zzTd;
    final String zzTe;

    protected void zza(zze zze1)
        throws RemoteException
    {
        try
        {
            zze1.zzb(zzTe, null, this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zze zze1)
        {
            zzaT(2001);
        }
    }

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zze));
    }

    nt(nt nt, GoogleApiClient googleapiclient, String s)
    {
        zzTd = nt;
        zzTe = s;
        super(googleapiclient);
    }
}
