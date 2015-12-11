// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzki, zzkk, zzkn

abstract class zzkl extends zzlb.zza
{

    public zzkl(GoogleApiClient googleapiclient)
    {
        super(Auth.zzRE, googleapiclient);
    }

    protected abstract void zza(Context context, zzkk zzkk1);

    protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
    {
        zza((zzki)zzb1);
    }

    protected final void zza(zzki zzki1)
    {
        zza(zzki1.getContext(), (zzkk)zzki1.zzpc());
    }

    protected Result zzb(Status status)
    {
        return zzj(status);
    }

    protected com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult zzj(Status status)
    {
        return new zzkn(status);
    }
}
