// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appinvite;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjj;

// Referenced classes of package com.google.android.gms.appinvite:
//            AppInviteApi

public final class AppInvite
{

    public static final Api API;
    public static final AppInviteApi AppInviteApi = new zzji();
    public static final com.google.android.gms.common.api.Api.zzc zzQf;
    private static final com.google.android.gms.common.api.Api.zza zzQg;

    private AppInvite()
    {
    }

    static 
    {
        zzQf = new com.google.android.gms.common.api.Api.zzc();
        zzQg = new com.google.android.gms.common.api.Api.zza() {

            public com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return zzb(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
            }

            public zzjj zzb(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return new zzjj(context, looper, connectioncallbacks, onconnectionfailedlistener, zzf);
            }

        };
        API = new Api("AppInvite.API", zzQg, zzQf);
    }
}
