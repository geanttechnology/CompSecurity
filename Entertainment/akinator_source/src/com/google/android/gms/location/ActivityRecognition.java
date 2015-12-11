// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.location.internal.zza;
import com.google.android.gms.location.internal.zzl;

// Referenced classes of package com.google.android.gms.location:
//            ActivityRecognitionApi

public class ActivityRecognition
{
    public static abstract class zza extends com.google.android.gms.internal.zzlb.zza
    {

        public zza(GoogleApiClient googleapiclient)
        {
            super(ActivityRecognition.zzwu(), googleapiclient);
        }
    }


    public static final Api API;
    public static final ActivityRecognitionApi ActivityRecognitionApi = new com.google.android.gms.location.internal.zza();
    public static final String CLIENT_NAME = "activity_recognition";
    private static final com.google.android.gms.common.api.Api.zzc zzRk;
    private static final com.google.android.gms.common.api.Api.zza zzRl;

    private ActivityRecognition()
    {
    }

    static com.google.android.gms.common.api.Api.zzc zzwu()
    {
        return zzRk;
    }

    static 
    {
        zzRk = new com.google.android.gms.common.api.Api.zzc();
        zzRl = new com.google.android.gms.common.api.Api.zza() {

            public com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return zzm(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
            }

            public zzl zzm(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return new zzl(context, looper, connectioncallbacks, onconnectionfailedlistener, "activity_recognition");
            }

        };
        API = new Api("ActivityRecognition.API", zzRl, zzRk);
    }
}
