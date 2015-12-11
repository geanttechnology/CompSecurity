// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zze;

// Referenced classes of package com.google.android.gms.internal:
//            zzlp

class eApiClient extends a
{

    final String zzazA[];
    final zzlp zzazy;

    protected volatile void zza(com.google.android.gms.common.api. )
    {
        zza((zze));
    }

    protected void zza(zze zze1)
    {
        zze1.zzd(this, zzazA);
    }

    eApiClient(zzlp zzlp1, GoogleApiClient googleapiclient, String as[])
    {
        zzazy = zzlp1;
        zzazA = as;
        super(googleapiclient, null);
    }
}
