// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzt, zzaa

private abstract class nt extends zzt
{

    final zzaa zzall;

    protected com.google.android.gms.drive.erencesApi.FileUploadPreferencesResult zzF(Status status)
    {
        return new <init>(zzall, status, null, null);
    }

    protected Result zzb(Status status)
    {
        return zzF(status);
    }

    public nt(zzaa zzaa1, GoogleApiClient googleapiclient)
    {
        zzall = zzaa1;
        super(googleapiclient);
    }
}
