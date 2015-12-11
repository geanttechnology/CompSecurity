// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.zzh;

// Referenced classes of package com.google.android.gms.internal:
//            zzqv

public final class zzqu
{

    public static final Api API;
    public static final com.google.android.gms.common.api.Api.zzc zzRk;
    public static final com.google.android.gms.common.api.Api.zza zzRl;
    public static final Scope zzTe = new Scope("profile");
    public static final Scope zzTf = new Scope("email");
    static final com.google.android.gms.common.api.Api.zza zzaUX;
    public static final zzqv zzaUY = new zzh();
    public static final Api zzaiH;
    public static final com.google.android.gms.common.api.Api.zzc zzapF;

    static 
    {
        zzRk = new com.google.android.gms.common.api.Api.zzc();
        zzapF = new com.google.android.gms.common.api.Api.zzc();
        zzRl = new _cls1();
        zzaUX = new _cls2();
        API = new Api("SignIn.API", zzRl, zzRk);
        zzaiH = new Api("SignIn.INTERNAL_API", zzaUX, zzapF);
    }

    private class _cls1 extends com.google.android.gms.common.api.Api.zza
    {

        public final volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zza(context, looper, zzf, (zzqx)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final zzi zza(Context context, Looper looper, zzf zzf, zzqx zzqx1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            if (zzqx1 == null)
            {
                zzqx1 = zzqx.zzaUZ;
            }
            return new zzi(context, looper, true, zzf, zzqx1, connectioncallbacks, onconnectionfailedlistener, Executors.newSingleThreadExecutor());
        }

        _cls1()
        {
        }
    }


    private class _cls2 extends com.google.android.gms.common.api.Api.zza
    {

        public final com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzt(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final zzi zzt(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzi(context, looper, false, zzf, zzqx.zzaUZ, connectioncallbacks, onconnectionfailedlistener, Executors.newSingleThreadExecutor());
        }

        _cls2()
        {
        }
    }

}
