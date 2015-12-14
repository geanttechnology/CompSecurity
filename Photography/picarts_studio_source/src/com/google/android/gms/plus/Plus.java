// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqi;
import com.google.android.gms.plus.internal.zze;

// Referenced classes of package com.google.android.gms.plus:
//            Account, Moments, People, zzb, 
//            zza

public final class Plus
{

    public static final Api API;
    public static final Account AccountApi = new zzqe();
    public static final Moments MomentsApi = new zzqh();
    public static final People PeopleApi = new zzqi();
    public static final Scope SCOPE_PLUS_LOGIN = new Scope("https://www.googleapis.com/auth/plus.login");
    public static final Scope SCOPE_PLUS_PROFILE = new Scope("https://www.googleapis.com/auth/plus.me");
    public static final com.google.android.gms.common.api.Api.zzc zzRk;
    static final com.google.android.gms.common.api.Api.zza zzRl;
    public static final zzb zzaSc = new zzqg();
    public static final zza zzaSd = new zzqf();

    private Plus()
    {
    }

    public static zze zzf(GoogleApiClient googleapiclient, boolean flag)
    {
        boolean flag1;
        if (googleapiclient != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        zzx.zzb(flag1, "GoogleApiClient parameter is required.");
        zzx.zza(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        zzx.zza(googleapiclient.zza(API), "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        flag1 = googleapiclient.hasConnectedApi(API);
        if (flag && !flag1)
        {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
        if (flag1)
        {
            return (zze)googleapiclient.zza(zzRk);
        } else
        {
            return null;
        }
    }

    static 
    {
        zzRk = new com.google.android.gms.common.api.Api.zzc();
        zzRl = new _cls1();
        API = new Api("Plus.API", zzRl, zzRk);
    }

    /* member class not found */
    class _cls1 {}

}
