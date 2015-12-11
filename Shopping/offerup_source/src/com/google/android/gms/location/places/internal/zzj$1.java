// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.zzl;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zzk, zzj

class zzaHf extends com.google.android.gms.location.places.d
{

    final PlaceFilter zzaHf;
    final zzj zzaHg;

    protected volatile void zza(com.google.android.gms.common.api.b b)
    {
        zza((zzk)b);
    }

    protected void zza(zzk zzk1)
    {
        zzk1.zza(new zzl(this, zzk1.getContext()), zzaHf);
    }

    (zzj zzj, com.google.android.gms.common.api.c c, GoogleApiClient googleapiclient, PlaceFilter placefilter)
    {
        zzaHg = zzj;
        zzaHf = placefilter;
        super(c, googleapiclient);
    }
}
