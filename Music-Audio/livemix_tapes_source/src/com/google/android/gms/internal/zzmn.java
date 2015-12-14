// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;

// Referenced classes of package com.google.android.gms.internal:
//            zzmj, zzmy

public class zzmn extends zzmj
{
    public static class zza extends com.google.android.gms.common.api.Api.zza
    {

        public com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzi(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzmn zzi(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzmn(context, looper, zzf, connectioncallbacks, onconnectionfailedlistener);
        }

        public zza()
        {
        }
    }


    public zzmn(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 61, connectioncallbacks, onconnectionfailedlistener, zzf);
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzbp(ibinder);
    }

    protected zzmy zzbp(IBinder ibinder)
    {
        return zzmy.zza.zzbA(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.fitness.InternalApi";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.fitness.internal.IGoogleFitInternalApi";
    }
}
