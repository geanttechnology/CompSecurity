// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.moments.Moment;

// Referenced classes of package com.google.android.gms.internal:
//            zzlo

class eApiClient extends c
{

    final zzlo zzazp;
    final Moment zzazu;

    protected volatile void zza(com.google.android.gms.common.api. )
    {
        zza((zze));
    }

    protected void zza(zze zze1)
    {
        zze1.zza(this, zzazu);
    }

    eApiClient(zzlo zzlo1, GoogleApiClient googleapiclient, Moment moment)
    {
        zzazp = zzlo1;
        zzazu = moment;
        super(googleapiclient, null);
    }
}
