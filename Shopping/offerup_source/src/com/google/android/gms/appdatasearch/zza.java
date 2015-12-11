// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzju;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            zzk

public final class zza
{

    public static final com.google.android.gms.common.api.Api.zzc zzPT;
    private static final com.google.android.gms.common.api.Api.zza zzPU;
    public static final Api zzPV;
    public static final zzk zzPW = new zzju();

    static 
    {
        zzPT = new com.google.android.gms.common.api.Api.zzc();
        zzPU = new _cls1();
        zzPV = new Api("AppDataSearch.LIGHTWEIGHT_API", zzPU, zzPT);
    }

    private class _cls1 extends com.google.android.gms.common.api.Api.zza
    {

        public final volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zza(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final zzjs zza(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzjs(context, looper, zzf, connectioncallbacks, onconnectionfailedlistener);
        }

        _cls1()
        {
        }
    }

}
