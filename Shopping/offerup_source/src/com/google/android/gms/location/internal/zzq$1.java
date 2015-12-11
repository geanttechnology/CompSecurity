// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzl, zzq

class nt extends com.google.android.gms.location.onServices.zza
{

    final LocationSettingsRequest zzaFP;
    final String zzaFQ;
    final zzq zzaFR;

    protected volatile void zza(com.google.android.gms.common.api.b b)
    {
        zza((zzl)b);
    }

    protected void zza(zzl zzl1)
    {
        zzl1.zza(zzaFP, this, zzaFQ);
    }

    public LocationSettingsResult zzaK(Status status)
    {
        return new LocationSettingsResult(status);
    }

    public Result zzb(Status status)
    {
        return zzaK(status);
    }

    nt(zzq zzq, GoogleApiClient googleapiclient, LocationSettingsRequest locationsettingsrequest, String s)
    {
        zzaFR = zzq;
        zzaFP = locationsettingsrequest;
        zzaFQ = s;
        super(googleapiclient);
    }
}
