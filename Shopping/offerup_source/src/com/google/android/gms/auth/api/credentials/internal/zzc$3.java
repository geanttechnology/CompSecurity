// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.auth.api.credentials.internal:
//            zzd, DeleteRequest, zzh, zzc

class nit> extends zzd
{

    final zzc zzSF;
    final Credential zzSH;

    protected void zza(Context context, zzh zzh1)
    {
        zzh1.zza(new a(this), new DeleteRequest(zzSH));
    }

    protected Result zzb(Status status)
    {
        return zzd(status);
    }

    protected Status zzd(Status status)
    {
        return status;
    }

    Request(zzc zzc, GoogleApiClient googleapiclient, Credential credential)
    {
        zzSF = zzc;
        zzSH = credential;
        super(googleapiclient);
    }
}
