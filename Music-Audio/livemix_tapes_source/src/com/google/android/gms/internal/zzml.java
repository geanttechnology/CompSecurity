// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.Fitness;

// Referenced classes of package com.google.android.gms.internal:
//            zzmj, zzmw

public class zzml extends zzmj
{
    static abstract class zza extends com.google.android.gms.common.api.zzc.zza
    {

        public zza(GoogleApiClient googleapiclient)
        {
            super(Fitness.zzand, googleapiclient);
        }
    }

    public static class zzb extends com.google.android.gms.common.api.Api.zza
    {

        public com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzg(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzml zzg(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzml(context, looper, zzf, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzb()
        {
        }
    }

    static abstract class zzc extends zza
    {

        protected Result zzb(Status status)
        {
            return zzd(status);
        }

        protected Status zzd(Status status)
        {
            boolean flag;
            if (!status.isSuccess())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzZ(flag);
            return status;
        }

        zzc(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }


    public zzml(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 60, connectioncallbacks, onconnectionfailedlistener, zzf);
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzbn(ibinder);
    }

    protected zzmw zzbn(IBinder ibinder)
    {
        return zzmw.zza.zzby(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.fitness.ConfigApi";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.fitness.internal.IGoogleFitConfigApi";
    }
}
