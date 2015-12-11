// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.search;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzqt;

// Referenced classes of package com.google.android.gms.search:
//            SearchAuthApi

public class SearchAuth
{

    public static final Api API;
    public static final SearchAuthApi SearchAuthApi = new zzqt();
    public static final com.google.android.gms.common.api.Api.zzc zzRk;
    private static final com.google.android.gms.common.api.Api.zza zzaUP;

    private SearchAuth()
    {
    }

    static 
    {
        zzaUP = new _cls1();
        zzRk = new com.google.android.gms.common.api.Api.zzc();
        API = new Api("SearchAuth.API", zzaUP, zzRk);
    }

    private class _cls1 extends com.google.android.gms.common.api.Api.zza
    {

        public final com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzs(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final zzqs zzs(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzqs(context, connectioncallbacks, onconnectionfailedlistener, zzf);
        }

        _cls1()
        {
        }
    }

}
