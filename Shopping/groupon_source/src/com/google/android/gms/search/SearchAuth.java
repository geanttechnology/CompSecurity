// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.search;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzpp;

// Referenced classes of package com.google.android.gms.search:
//            SearchAuthApi

public class SearchAuth
{

    public static final Api API;
    public static final SearchAuthApi SearchAuthApi = new zzpp();
    public static final com.google.android.gms.common.api.Api.ClientKey zzNX;
    private static final com.google.android.gms.common.api.Api.zza zzaJH;

    static 
    {
        zzaJH = new com.google.android.gms.common.api.Api.zza() {

            public int getPriority()
            {
                return 0x7fffffff;
            }

            public com.google.android.gms.common.api.Api.Client zza(Context context, Looper looper, zze zze, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return zzu(context, looper, zze, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
            }

            public zzpo zzu(Context context, Looper looper, zze zze, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return new zzpo(context, connectioncallbacks, onconnectionfailedlistener, zze);
            }

        };
        zzNX = new com.google.android.gms.common.api.Api.ClientKey();
        API = new Api("SearchAuth.API", zzaJH, zzNX, new Scope[0]);
    }
}
