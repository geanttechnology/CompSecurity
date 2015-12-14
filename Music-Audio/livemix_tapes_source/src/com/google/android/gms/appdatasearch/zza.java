// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzjf;
import com.google.android.gms.internal.zzjh;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            zzk

public final class zza
{

    public static final com.google.android.gms.common.api.Api.zzc zzOO;
    private static final com.google.android.gms.common.api.Api.zza zzOP;
    public static final Api zzOQ;
    public static final zzk zzOR = new zzjh();

    static 
    {
        zzOO = new com.google.android.gms.common.api.Api.zzc();
        zzOP = new com.google.android.gms.common.api.Api.zza() {

            public volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return zza(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
            }

            public zzjf zza(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return new zzjf(context, looper, zzf, connectioncallbacks, onconnectionfailedlistener);
            }

        };
        zzOQ = new Api("AppDataSearch.LIGHTWEIGHT_API", zzOP, zzOO);
    }
}
