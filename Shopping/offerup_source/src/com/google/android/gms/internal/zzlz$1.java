// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzmb, zzmd, zzlz

class eApiClient extends a
{

    final zzlz zzagx;

    protected volatile void zza(com.google.android.gms.common.api. )
    {
        zza((zzmb));
    }

    protected void zza(zzmb zzmb1)
    {
        ((zzmd)zzmb1.zzpc()).zza(new a(this));
    }

    eApiClient(zzlz zzlz, GoogleApiClient googleapiclient)
    {
        zzagx = zzlz;
        super(googleapiclient);
    }
}
