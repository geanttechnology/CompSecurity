// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.internal.zzd;
import com.google.android.gms.location.internal.zzf;
import com.google.android.gms.location.internal.zzl;
import com.google.android.gms.location.internal.zzq;

// Referenced classes of package com.google.android.gms.location:
//            FusedLocationProviderApi, GeofencingApi, SettingsApi

public class LocationServices
{

    public static final Api API;
    public static final FusedLocationProviderApi FusedLocationApi = new zzd();
    public static final GeofencingApi GeofencingApi = new zzf();
    public static final SettingsApi SettingsApi = new zzq();
    private static final com.google.android.gms.common.api.Api.zzc zzRk;
    private static final com.google.android.gms.common.api.Api.zza zzRl;

    private LocationServices()
    {
    }

    public static zzl zzd(GoogleApiClient googleapiclient)
    {
        boolean flag1 = true;
        boolean flag;
        if (googleapiclient != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "GoogleApiClient parameter is required.");
        googleapiclient = (zzl)googleapiclient.zza(zzRk);
        if (googleapiclient != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return googleapiclient;
    }

    static com.google.android.gms.common.api.Api.zzc zzwu()
    {
        return zzRk;
    }

    static 
    {
        zzRk = new com.google.android.gms.common.api.Api.zzc();
        zzRl = new _cls1();
        API = new Api("LocationServices.API", zzRl, zzRk);
    }

    private class _cls1 extends com.google.android.gms.common.api.Api.zza
    {

        public final com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzm(context, looper, zzf1, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final zzl zzm(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzl(context, looper, connectioncallbacks, onconnectionfailedlistener, "locationServices", zzf1);
        }

        _cls1()
        {
        }
    }

}
