// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzrg, zzrh

class eApiClient extends com.google.android.gms.wallet.zzb
{

    final int zzaAy;
    final zzrg zzaYm;
    final String zzaYp;
    final String zzaYq;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzrh));
    }

    protected void zza(zzrh zzrh1)
    {
        zzrh1.zze(zzaYp, zzaYq, zzaAy);
        zza(((com.google.android.gms.common.api.Result) (Status.zzaaD)));
    }

    eApiClient(zzrg zzrg1, GoogleApiClient googleapiclient, String s, String s1, int i)
    {
        zzaYm = zzrg1;
        zzaYp = s;
        zzaYq = s1;
        zzaAy = i;
        super(googleapiclient);
    }
}
