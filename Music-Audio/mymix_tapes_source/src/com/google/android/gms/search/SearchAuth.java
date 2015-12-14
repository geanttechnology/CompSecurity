// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.search;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzqb;
import com.google.android.gms.internal.zzqc;

// Referenced classes of package com.google.android.gms.search:
//            SearchAuthApi

public class SearchAuth
{
    public static class StatusCodes
    {

        public static final int AUTH_DISABLED = 10000;
        public static final int AUTH_THROTTLED = 10001;
        public static final int DEVELOPER_ERROR = 10;
        public static final int INTERNAL_ERROR = 8;
        public static final int SUCCESS = 0;

        public StatusCodes()
        {
        }
    }


    public static final Api API;
    public static final SearchAuthApi SearchAuthApi = new zzqc();
    public static final com.google.android.gms.common.api.Api.zzc zzQf;
    private static final com.google.android.gms.common.api.Api.zza zzaNP;

    private SearchAuth()
    {
    }

    static 
    {
        zzaNP = new com.google.android.gms.common.api.Api.zza() {

            public com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return zzs(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
            }

            public zzqb zzs(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return new zzqb(context, connectioncallbacks, onconnectionfailedlistener, zzf);
            }

        };
        zzQf = new com.google.android.gms.common.api.Api.zzc();
        API = new Api("SearchAuth.API", zzaNP, zzQf);
    }
}
