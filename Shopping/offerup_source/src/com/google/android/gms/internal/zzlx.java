// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;

// Referenced classes of package com.google.android.gms.internal:
//            zzlz, zzly

public final class zzlx
{

    public static final Api API;
    public static final com.google.android.gms.common.api.Api.zzc zzRk;
    private static final com.google.android.gms.common.api.Api.zza zzRl;
    public static final zzly zzagw = new zzlz();

    static 
    {
        zzRk = new com.google.android.gms.common.api.Api.zzc();
        zzRl = new _cls1();
        API = new Api("Common.API", zzRl, zzRk);
    }

    private class _cls1 extends com.google.android.gms.common.api.Api.zza
    {

        public final com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zze(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final zzmb zze(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzmb(context, looper, zzf, connectioncallbacks, onconnectionfailedlistener);
        }

        _cls1()
        {
        }
    }

}
