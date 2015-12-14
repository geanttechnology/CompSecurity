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
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplayApi, CastDevice

public final class CastRemoteDisplay
{
    public static final class CastRemoteDisplayOptions
        implements com.google.android.gms.common.api.Api.ApiOptions.HasOptions
    {

        final CastDevice zzTg;
        final CastRemoteDisplaySessionCallbacks zzTw;

        private CastRemoteDisplayOptions(Builder builder)
        {
            zzTg = builder.zzTj;
            zzTw = builder.zzTx;
        }

    }

    public static final class CastRemoteDisplayOptions.Builder
    {

        CastDevice zzTj;
        CastRemoteDisplaySessionCallbacks zzTx;

        public CastRemoteDisplayOptions build()
        {
            return new CastRemoteDisplayOptions(this);
        }

        public CastRemoteDisplayOptions.Builder(CastDevice castdevice, CastRemoteDisplaySessionCallbacks castremotedisplaysessioncallbacks)
        {
            zzx.zzb(castdevice, "CastDevice parameter cannot be null");
            zzTj = castdevice;
            zzTx = castremotedisplaysessioncallbacks;
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
    private static final com.google.android.gms.common.api.Api.zzc zzQf;
    private static final com.google.android.gms.common.api.Api.zza zzQg;

    private CastRemoteDisplay()
    {
    }

    static 
    {
        zzQf = new com.google.android.gms.common.api.Api.zzc();
        zzQg = new com.google.android.gms.common.api.Api.zza() {

            public volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return zza(context, looper, zzf, (CastRemoteDisplayOptions)obj, connectioncallbacks, onconnectionfailedlistener);
            }

            public zzkm zza(Context context, Looper looper, zzf zzf, CastRemoteDisplayOptions castremotedisplayoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return new zzkm(context, looper, zzf, castremotedisplayoptions.zzTg, castremotedisplayoptions.zzTw, connectioncallbacks, onconnectionfailedlistener);
            }

        };
        API = new Api("CastRemoteDisplay.API", zzQg, zzQf);
        CastRemoteDisplayApi = new zzkl(zzQf);
    }
}
