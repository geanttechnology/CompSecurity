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
//            zzmj, zzmv

public class zzmk extends zzmj
{
    static abstract class zza extends com.google.android.gms.common.api.zzc.zza
    {

        public zza(GoogleApiClient googleapiclient)
        {
            super(Fitness.zzanc, googleapiclient);
        }
    }

    public static class zzb extends com.google.android.gms.common.api.Api.zza
    {

        public com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzf(context, looper, zzf1, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzmk zzf(Context context, Looper looper, zzf zzf1, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzmk(context, looper, zzf1, connectioncallbacks, onconnectionfailedlistener);
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


    public zzmk(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 59, connectioncallbacks, onconnectionfailedlistener, zzf);
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzbm(ibinder);
    }

    protected zzmv zzbm(IBinder ibinder)
    {
        return zzmv.zza.zzbx(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.fitness.BleApi";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.fitness.internal.IGoogleFitBleApi";
    }
}
