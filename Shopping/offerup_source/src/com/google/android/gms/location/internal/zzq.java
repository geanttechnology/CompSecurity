// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsApi;

public class zzq
    implements SettingsApi
{

    public zzq()
    {
    }

    public PendingResult checkLocationSettings(GoogleApiClient googleapiclient, LocationSettingsRequest locationsettingsrequest)
    {
        return zza(googleapiclient, locationsettingsrequest, null);
    }

    public PendingResult zza(GoogleApiClient googleapiclient, LocationSettingsRequest locationsettingsrequest, String s)
    {
        return googleapiclient.zza(new _cls1(googleapiclient, locationsettingsrequest, s));
    }

    private class _cls1 extends com.google.android.gms.location.LocationServices.zza
    {

        final LocationSettingsRequest zzaFP;
        final String zzaFQ;
        final zzq zzaFR;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
        {
            zza((zzl)zzb1);
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

        _cls1(GoogleApiClient googleapiclient, LocationSettingsRequest locationsettingsrequest, String s)
        {
            zzaFR = zzq.this;
            zzaFP = locationsettingsrequest;
            zzaFQ = s;
            super(googleapiclient);
        }
    }

}
