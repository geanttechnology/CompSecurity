// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zze;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.internal:
//            zzlp

class eApiClient extends a
{

    final zzlp zzazy;
    final Collection zzazz;

    protected volatile void zza(com.google.android.gms.common.api. )
    {
        zza((zze));
    }

    protected void zza(zze zze1)
    {
        zze1.zza(this, zzazz);
    }

    eApiClient(zzlp zzlp1, GoogleApiClient googleapiclient, Collection collection)
    {
        zzazy = zzlp1;
        zzazz = collection;
        super(googleapiclient, null);
    }
}
