// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzhk, zzhm, zzho

class eApiClient extends a
{

    final zzhk zzUi;

    protected volatile void zza(com.google.android.gms.common.api. )
    {
        zza((zzhm));
    }

    protected void zza(zzhm zzhm1)
    {
        ((zzho)zzhm1.zzlX()).zza(new a(this));
    }

    eApiClient(zzhk zzhk1, GoogleApiClient googleapiclient)
    {
        zzUi = zzhk1;
        super(googleapiclient);
    }
}
