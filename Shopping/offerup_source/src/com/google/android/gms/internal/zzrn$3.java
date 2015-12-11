// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzro, zzrn

class eApiClient extends com.google.android.gms.wallet.zzb
{

    final int zzaDg;
    final zzrn zzbeu;
    final FullWalletRequest zzbew;

    protected volatile void zza(com.google.android.gms.common.api. )
    {
        zza((zzro));
    }

    protected void zza(zzro zzro1)
    {
        zzro1.zza(zzbew, zzaDg);
        zzb(Status.zzabb);
    }

    eApiClient(zzrn zzrn, GoogleApiClient googleapiclient, FullWalletRequest fullwalletrequest, int i)
    {
        zzbeu = zzrn;
        zzbew = fullwalletrequest;
        zzaDg = i;
        super(googleapiclient);
    }
}
