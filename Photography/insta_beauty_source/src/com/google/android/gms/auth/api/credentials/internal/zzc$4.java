// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.auth.api.credentials.internal:
//            zzd, ICredentialsService, zzc

class nit> extends zzd
{

    final zzc zzPd;

    protected Result createFailedResult(Status status)
    {
        return zzb(status);
    }

    protected void zza(Context context, ICredentialsService icredentialsservice)
    {
        icredentialsservice.performDisableAutoSignInOperation(new a(this));
    }

    protected Status zzb(Status status)
    {
        return status;
    }

    ntialsService(zzc zzc, GoogleApiClient googleapiclient)
    {
        zzPd = zzc;
        super(googleapiclient);
    }
}
