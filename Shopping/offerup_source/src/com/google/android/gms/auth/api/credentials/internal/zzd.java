// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.auth.api.credentials.internal:
//            zze, zzh

abstract class zzd extends com.google.android.gms.internal.zzlb.zza
{

    zzd(GoogleApiClient googleapiclient)
    {
        super(Auth.zzRF, googleapiclient);
    }

    protected abstract void zza(Context context, zzh zzh1);

    protected final void zza(zze zze1)
    {
        zza(zze1.getContext(), (zzh)zze1.zzpc());
    }

    protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
    {
        zza((zze)zzb);
    }
}
