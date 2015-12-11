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
//            zznl, zzod

public class zzns extends zznl
{
    static abstract class zza extends zzlb.zza
    {

        public zza(GoogleApiClient googleapiclient)
        {
            super(Fitness.zzapI, googleapiclient);
        }
    }

    public static class zzb extends com.google.android.gms.common.api.Api.zza
    {

        public com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzl(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzns zzl(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzns(context, looper, zzf, connectioncallbacks, onconnectionfailedlistener);
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
            zzx.zzaa(flag);
            return status;
        }

        zzc(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }


    public zzns(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 58, connectioncallbacks, onconnectionfailedlistener, zzf);
    }

    protected IInterface zzW(IBinder ibinder)
    {
        return zzbs(ibinder);
    }

    protected zzod zzbs(IBinder ibinder)
    {
        return zzod.zza.zzbD(ibinder);
    }

    protected String zzfK()
    {
        return "com.google.android.gms.fitness.SessionsApi";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi";
    }
}
