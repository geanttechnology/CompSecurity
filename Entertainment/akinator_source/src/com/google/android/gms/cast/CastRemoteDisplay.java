// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzkw;
import com.google.android.gms.internal.zzkx;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplayApi, CastDevice

public final class CastRemoteDisplay
{
    public static final class CastRemoteDisplayOptions
        implements com.google.android.gms.common.api.Api.ApiOptions.HasOptions
    {

        final CastDevice zzUV;
        final CastRemoteDisplaySessionCallbacks zzVm;

        private CastRemoteDisplayOptions(Builder builder)
        {
            zzUV = builder.zzUY;
            zzVm = builder.zzVn;
        }

    }

    public static final class CastRemoteDisplayOptions.Builder
    {

        CastDevice zzUY;
        CastRemoteDisplaySessionCallbacks zzVn;

        public CastRemoteDisplayOptions build()
        {
            return new CastRemoteDisplayOptions(this);
        }

        public CastRemoteDisplayOptions.Builder(CastDevice castdevice, CastRemoteDisplaySessionCallbacks castremotedisplaysessioncallbacks)
        {
            zzx.zzb(castdevice, "CastDevice parameter cannot be null");
            zzUY = castdevice;
            zzVn = castremotedisplaysessioncallbacks;
        }
    }

    public static interface CastRemoteDisplaySessionCallbacks
    {

        public abstract void onRemoteDisplayEnded(Status status);
    }

    public static interface CastRemoteDisplaySessionResult
        extends Result
    {

        public abstract Display getPresentationDisplay();
    }


    public static final Api API;
    public static final CastRemoteDisplayApi CastRemoteDisplayApi;
    private static final com.google.android.gms.common.api.Api.zzc zzRk;
    private static final com.google.android.gms.common.api.Api.zza zzRl;

    private CastRemoteDisplay()
    {
    }

    static 
    {
        zzRk = new com.google.android.gms.common.api.Api.zzc();
        zzRl = new com.google.android.gms.common.api.Api.zza() {

            public volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return zza(context, looper, zzf, (CastRemoteDisplayOptions)obj, connectioncallbacks, onconnectionfailedlistener);
            }

            public zzkx zza(Context context, Looper looper, zzf zzf, CastRemoteDisplayOptions castremotedisplayoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return new zzkx(context, looper, zzf, castremotedisplayoptions.zzUV, castremotedisplayoptions.zzVm, connectioncallbacks, onconnectionfailedlistener);
            }

        };
        API = new Api("CastRemoteDisplay.API", zzRl, zzRk);
        CastRemoteDisplayApi = new zzkw(zzRk);
    }
}
