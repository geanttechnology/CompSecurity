// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.internal.zze;

// Referenced classes of package com.google.android.gms.internal:
//            zzlo

class eApiClient extends b
{

    final zzlo zzazp;
    final String zzazv;

    protected volatile void zza(com.google.android.gms.common.api. )
    {
        zza((zze));
    }

    protected void zza(zze zze1)
    {
        zze1.zzdp(zzazv);
        setResult(Status.zzQU);
    }

    eApiClient(zzlo zzlo1, GoogleApiClient googleapiclient, String s)
    {
        zzazp = zzlo1;
        zzazv = s;
        super(googleapiclient, null);
    }
}
